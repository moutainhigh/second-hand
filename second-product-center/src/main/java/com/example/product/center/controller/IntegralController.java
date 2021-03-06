package com.example.product.center.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.example.product.center.dao.*;
import com.example.product.center.manual.*;
import com.example.product.center.manual.Address.AddressList;
import com.example.product.center.model.*;
import com.example.product.center.service.AddressService;
import com.example.product.center.service.IntegralQuantityService;
import com.google.zxing.common.BitMatrix;
import com.second.common.utils.PageTool;
import com.second.common.utils.QRCodeUtils;
import com.second.utils.response.handler.ResponseEntity;
import com.second.utils.response.handler.ResponseUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import com.google.zxing.client.j2se.MatrixToImageWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author shihao
 * @Title: IntegralController
 * @ProjectName Second-order-center
 * @Description: 积分
 * @date Created in
 * @Version: $
 */
@RestController
@Api
@RequestMapping("/Integral")
@CrossOrigin
public class IntegralController {
    //积分
    @Autowired
    private SecondIntegralMapper secondIntegralMapper;
    //积分策略
    @Autowired
    private SecondIntegralStrategyMapper secondIntegralStrategyMapper;
    //换购记录
    @Autowired
    private SecondIntegralRecordMapper secondIntegralRecordMapper;
    //商品
    @Autowired
    private SecondProductMapper secondProductMapper;
//物品
    @Autowired
    private SecondGoodsMapper secondGoodsMapper;
    //店铺
    @Autowired
    private SecondStoreMapper secondStoreMapper;
    //扣减积分库存
    @Autowired
    private IntegralQuantityService integralQuantityService;
    //免手续费额度
    @Autowired
    private SecondWithdrawalExemptMapper secondWithdrawalExemptMapper;
    //余额
    @Autowired
    private SecondStoreBalanceMapper secondStoreBalanceMapper;
    //余额明细
    @Autowired
    private SecondStoreBalanceDetailMapper secondStoreBalanceDetailMapper;
    @Resource
    private RedisTemplate<String, Object> redisTemplate;
    //授权
    @Autowired
    private SecondAuthMapper secondAuthMapper;

    @Autowired
    private SecondUserMapper secondUserMapper;
    //地址
    @Autowired
    private SecondStoreAddressMapper secondStoreAddressMapper;
    //商品地址
    @Autowired
    private SecondProductAddressMapper secondProductAddressMapper;
    //地图获取ip
    @Autowired
    private AddressService addressService;
    @ApiOperation(value = "添加积分商品", notes = "添加积分商品")
    @RequestMapping(value = "/addIntegralProduct", method = RequestMethod.POST)
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public ResponseEntity<JSONObject> addIntegralProduct(
            @RequestParam(value = "productName", required = false) String productName,
            @RequestParam(value = "file1", required = false) String file1,
            @RequestParam(value = "type", required = false) String type,
            @RequestParam(value = "sellPrice", required = false) Integer sellPrice,
            @RequestParam(value = "storeId", required = false) Integer storeId,
            @RequestParam(value = "limit", required = false) Integer limit,
            @RequestParam(value = "productDesc", required = false) String productDesc,
            @RequestParam(value = "quantity", required = false) Integer quantity
    ) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder(HttpStatus.OK);
        SecondIntegral secondIntegral = new SecondIntegral();
        secondIntegral.setIntegralName(productName);
        secondIntegral.setIntegralNeed(sellPrice);
        secondIntegral.setIntegralType(IntegralEnum.Relation.getState(type).getState());
        secondIntegral.setQuantity(quantity);
        secondIntegral.setInetgralFile(file1);
        secondIntegral.setCreateDate(LocalDateTime.now());
        secondIntegral.setModifyDate(LocalDateTime.now());
        secondIntegral.setIsDeleted((byte) 0);
        secondIntegralMapper.insertSelective(secondIntegral);
        if (IntegralEnum.Relation.getState(type).getState().equals(IntegralEnum.Relation.WITHDRAW.getState())){
            addWithdraw(secondIntegral.getId(),limit);
        }
        else if (IntegralEnum.Relation.getState(type).getState().equals(IntegralEnum.Relation.PRODUCT.getState())){
            addProduct(secondIntegral.getId(),storeId,quantity,sellPrice,productDesc);
        }
        return builder.body(ResponseUtils.getResponseBody(0));
    }

    /**
     * 创建积分换购提现资质
     * @return
     */
    public String addWithdraw(Integer secondIntegralId,Integer money){
        SecondIntegralStrategy secondIntegralStrategy = new SecondIntegralStrategy();
        secondIntegralStrategy.setIntegralId(secondIntegralId);
        secondIntegralStrategy.setExemptCommission(money);
        secondIntegralStrategy.setCreateDate(LocalDateTime.now());
        secondIntegralStrategy.setModifyDate(LocalDateTime.now());
        secondIntegralStrategy.setIsDeleted((byte) 0);
        secondIntegralStrategyMapper.insertSelective(secondIntegralStrategy);
        return "0";
    }
    /**
     * 创建积分换购商品
     */
    public String addProduct(Integer secondIntegralId,Integer StoreId,Integer goodsResp,Integer money,String productDesc){
        //创建商品
        SecondStoreAddressExample secondStoreAddressExample = new SecondStoreAddressExample();
        secondStoreAddressExample.createCriteria().andIsDeletedEqualTo((short) 0)
                .andStoreIdEqualTo(StoreId);
        List<SecondStoreAddress> secondStoreAddresses =
                secondStoreAddressMapper.selectByExample(secondStoreAddressExample);
//商品
        SecondProduct secondProduct = new SecondProduct();
        secondProduct.setAddressId(secondStoreAddresses.get(0).getId());
        secondProduct.setProductState(ProductEnum.ProductState.SELL.getState());
        secondProduct.setProductDesc(productDesc);
        secondProduct.setProductType(ProductEnum.Relation.INTEGRAL.getState());//积分商品
        secondProduct.setShowType(ProductEnum.ShowType.COUPON.getState());//卡券
        secondProduct.setStoreId(StoreId);
        secondProduct.setIsPutaway(ProductEnum.IsPutaway.PUTAWAY.getState());
        secondProduct.setCreateTime(LocalDateTime.now());
        secondProduct.setModifyTime(LocalDateTime.now());
        secondProduct.setIsDeleted((short) 0);
        secondProductMapper.insertSelective(secondProduct);
        //地址
        SecondStoreAddress secondStoreAddress = secondStoreAddressMapper.selectByPrimaryKey(secondStoreAddresses.get(0).getId());
        SecondProductAddress secondProductAddress = new SecondProductAddress();
        secondProductAddress.setProductId(secondProduct.getId());
        secondProductAddress.setSecondProvince(secondStoreAddress.getSecondProvince());
        secondProductAddress.setSecondCity(secondStoreAddress.getSecondCity());
        secondProductAddress.setSecondConty(secondStoreAddress.getSecondConty());
        secondProductAddress.setSecondAddressDetail(secondStoreAddress.getSecondAddressDetail());
        if(secondStoreAddress.getLongitude()==null&&secondStoreAddress.getLatitude()==null){
            String add =
                    secondStoreAddress.getSecondProvince() + secondStoreAddress.getSecondCity()
                            + secondStoreAddress.getSecondConty() + secondStoreAddress.getSecondAddressDetail();
            JSONObject a = addressService.getIngAndLat(add);
            AddressList list = JSON.parseObject(String.valueOf(a), new TypeReference<AddressList>() {
            });
            secondProductAddress.setLongitude(list.getResult().get(0).getLocation().get(0).getLng());
            secondProductAddress.setLatitude(list.getResult().get(0).getLocation().get(0).getLat());
        } else {
            secondProductAddress.setLongitude(secondStoreAddress.getLongitude());
            secondProductAddress.setLatitude(secondStoreAddress.getLatitude());
        }
        secondProductAddress.setContact(secondStoreAddress.getContact());
        secondProductAddress.setPhoneNumber(secondStoreAddress.getPhoneNumber());
        secondProductAddress.setSecondDesc(secondStoreAddress.getSecondDesc());
        secondProductAddress.setCreateTime(LocalDateTime.now());
        secondProductAddress.setModifyTime(LocalDateTime.now());
        secondProductAddress.setIsDeleted((short) 0);
        secondProductAddressMapper.insertSelective(secondProductAddress);
        //物品
        SecondGoods secondGoods = new SecondGoods();
        secondGoods.setProductId(secondProduct.getId());
        secondGoods.setSellPrice(money);
        secondGoods.setGoodsResp(goodsResp);//库存
        secondGoods.setIsDeleted((short) 0);
        secondGoods.setCreateTime(LocalDateTime.now());
        secondGoods.setModifyTime(LocalDateTime.now());
        secondGoodsMapper.insertSelective(secondGoods);

        SecondIntegralStrategy secondIntegralStrategy = new SecondIntegralStrategy();
        secondIntegralStrategy.setProductId(secondProduct.getId());
        secondIntegralStrategy.setIntegralId(secondIntegralId);
        secondIntegralStrategy.setCreateDate(LocalDateTime.now());
        secondIntegralStrategy.setModifyDate(LocalDateTime.now());
        secondIntegralStrategy.setIsDeleted((byte) 0);
        secondIntegralStrategyMapper.insertSelective(secondIntegralStrategy);
        return "0";
    }

    @ApiOperation(value = "查询积分商品", notes = "查询积分商品")
    @RequestMapping(value = "/selectIntegralProduct", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "IntegralType", value = "类型", required = true, type = "String"),
    })
    public ResponseEntity<JSONObject> selectIntegralProduct(
            @RequestParam(value = "IntegralType", required = false) String IntegralType
    ) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder(HttpStatus.OK);
        SecondIntegralExample secondIntegralExample = new SecondIntegralExample();
        secondIntegralExample.createCriteria().andIsDeletedEqualTo((byte) 0);
        List<SecondIntegral> secondIntegrals =
        secondIntegralMapper.selectByExample(secondIntegralExample);
        List<IntegralList> integralLists = new ArrayList<>();
        secondIntegrals.forEach(secondIntegral -> {
            IntegralList integralList = new IntegralList();
            integralList.setId(secondIntegral.getId());
            integralList.setIntegralName(secondIntegral.getIntegralName());
            integralList.setIntegralType(secondIntegral.getIntegralType());
            integralList.setIntegralNeed(secondIntegral.getIntegralNeed());
            integralList.setInetgralFile(secondIntegral.getInetgralFile());
            integralList.setIntegralQuantity(secondIntegral.getQuantity());
            //积分换购策略
            SecondIntegralStrategyExample secondIntegralStrategyExample = new SecondIntegralStrategyExample();
            secondIntegralStrategyExample.createCriteria().andIntegralIdEqualTo(secondIntegral.getId());
            List<SecondIntegralStrategy> secondIntegralStrategies = secondIntegralStrategyMapper.selectByExample(secondIntegralStrategyExample);
            if (secondIntegral.getIntegralType().equals(IntegralEnum.Relation.PRODUCT.getState())){
                SecondProduct secondProduct =
                secondProductMapper.selectByPrimaryKey(secondIntegralStrategies.get(0).getProductId());
                integralList.setProductDesc(secondProduct.getProductDesc());
                integralList.setStoreId(secondProduct.getStoreId());
                integralList.setProductId(secondProduct.getId());
                SecondStore secondStore = secondStoreMapper.selectByPrimaryKey(secondProduct.getStoreId());
                integralList.setStoreName(secondStore.getStoreName());
                integralList.setAddress(secondStore.getSecondAddress());
                integralList.setCreateTime(secondIntegral.getCreateDate());

            }
            if (secondIntegral.getIntegralType().equals(IntegralEnum.Relation.WITHDRAW.getState())){
                integralList.setExemptCommission(secondIntegralStrategies.get(0).getExemptCommission());
            }
            integralLists.add(integralList);
        });
        List<IntegralList> secondIntegrals1 =
        integralLists.stream().filter(a->a.getIntegralType().equals(IntegralEnum.Relation.getState(IntegralType).getState()))
                .collect(Collectors.toList());
        return builder.body(ResponseUtils.getResponseBody(secondIntegrals1));
    }

    @ApiOperation(value = "删除积分商品", notes = "删除积分商品")
    @RequestMapping(value = "/deleteIntegralProduct", method = RequestMethod.POST)
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "integralId", value = "积分商品id", required = true, type = "Integer"),
    })
    public ResponseEntity<JSONObject> deleteIntegralProduct(
            @RequestParam(value = "integralId", required = false) Integer integralId
    ) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder(HttpStatus.OK);
       SecondIntegral secondIntegral = new SecondIntegral();
        secondIntegral.setId(integralId);
        secondIntegral.setIsDeleted((byte) 1);
        secondIntegral.setModifyDate(LocalDateTime.now());
        secondIntegralMapper.updateByPrimaryKeySelective(secondIntegral);
        return builder.body(ResponseUtils.getResponseBody(0));
    }
    /**
     * 用户换购积分商品
     */
    @ApiOperation(value = "用户换购积分商品", notes = "用户换购积分商品")
    @RequestMapping(value = "/redemption", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "integralId", value = "积分商品id", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "userId", value = "用户id", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "storeId", value = "店铺id", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "quantity", value = "兑换数量", required = true, type = "Integer"),
    })
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public ResponseEntity<JSONObject> redemption(
            @RequestParam(value = "integralId", required = false) Integer integralId,
            @RequestParam(value = "storeId", required = false) Integer storeId,
            @RequestParam(value = "quantity", required = false) Integer quantity,
            @RequestParam(value = "userId", required = false) Integer userId,
            HttpServletResponse response
    ) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder(HttpStatus.OK);
        SecondIntegral secondIntegral = new SecondIntegral();
            secondIntegral = secondIntegralMapper.selectByPrimaryKey(integralId);
            if (secondIntegral.getQuantity()<quantity) {
                response.sendError(HttpStatus.FORBIDDEN.value(), "库存不足");
                return builder.body(ResponseUtils.getResponseBody("库存不足"));
            }


            //积分余额
            /**
             * 扣减积分
             */
            SecondStoreBalanceExample secondStoreBalanceExample = new SecondStoreBalanceExample();
            secondStoreBalanceExample.createCriteria().andUserIdEqualTo(userId)
                    .andStoreIdEqualTo(storeId).andIsDeletedEqualTo((short) 0)
                    .andBalanceTypeEqualTo(BanlaceEnum.Relation.INTEGRAL.getState());
            List<SecondStoreBalance> secondStoreBalances =
                    secondStoreBalanceMapper.selectByExample(secondStoreBalanceExample);
            if (secondStoreBalances.size()==0){
                SecondStoreBalance secondStoreBalance = new SecondStoreBalance();
                secondStoreBalance.setBalanceType(BanlaceEnum.Relation.INTEGRAL.getState());
                secondStoreBalance.setUserId(userId);
                secondStoreBalance.setStoreId(storeId);
                secondStoreBalance.setSecondBalance(0);
                secondStoreBalance.setCreateTime(LocalDateTime.now());
                secondStoreBalance.setModifyTime(LocalDateTime.now());
                secondStoreBalance.setIsDeleted((short) 0);
                secondStoreBalanceMapper.insertSelective(secondStoreBalance);
                response.sendError(HttpStatus.FORBIDDEN.value(), "积分不足");
                return builder.body(ResponseUtils.getResponseBody("积分不足"));
            } else {
                Integer b =
                        integralQuantityService.updateBalance(BanlaceEnum.Relation.INTEGRAL.getState()
                                ,secondIntegral.getIntegralNeed()*quantity,userId,storeId
                        );
                System.out.println(b);
                if (b<1){
                    response.sendError(HttpStatus.FORBIDDEN.value(), "积分不足");
                    return builder.body(ResponseUtils.getResponseBody("积分不足"));
                }
            }

            //积分换购提现免手续费额度
            if (secondIntegral.getIntegralType().equals(IntegralEnum.Relation.PRODUCT.getState())){
                product(integralId,userId,storeId);
            } else if (secondIntegral.getIntegralType().equals(IntegralEnum.Relation.WITHDRAW.getState())){
                withdraw(integralId,userId,storeId);
            }
        //扣减库存
        Integer a=  integralQuantityService.updateQuantity(integralId,quantity);
        if (a<1){
            integralQuantityService.addBalance(BanlaceEnum.Relation.INTEGRAL.getState()
                    ,secondIntegral.getIntegralNeed()*quantity,userId,storeId);
            response.sendError(HttpStatus.FORBIDDEN.value(), "库存不足");
            return builder.body(ResponseUtils.getResponseBody("库存不足"));
        }
        /**
         * 记录积分
         */
        SecondStoreBalanceDetail secondStoreBalanceDetail = new SecondStoreBalanceDetail();
        secondStoreBalanceDetail.setPayName("积分兑换");
        secondStoreBalanceDetail.setUserId(userId);
        secondStoreBalanceDetail.setStoreId(storeId);
        secondStoreBalanceDetail.setAmount(-secondIntegral.getIntegralNeed()*quantity);
        secondStoreBalanceDetail.setDetailType(BanlaceEnum.Relation.INTEGRAL.getState());
        secondStoreBalanceDetail.setIncomeExpenses(BanlaceEnum.incomeExpenses.PAY.getState());
        secondStoreBalanceDetail.setCreateTime(LocalDateTime.now());
        secondStoreBalanceDetail.setModifyTime(LocalDateTime.now());
        secondStoreBalanceDetail.setIsDeleted((short) 0);
        secondStoreBalanceDetailMapper.insertSelective(secondStoreBalanceDetail);
        return builder.body(ResponseUtils.getResponseBody(0));
    }
    //积分兑换商品
    private void withdraw(Integer integralId,Integer userId,Integer storeId){
        SecondIntegralRecord secondIntegralRecord = new SecondIntegralRecord();
        secondIntegralRecord.setIntegralId(integralId);
        secondIntegralRecord.setStoreId(storeId);
        secondIntegralRecord.setUserId(userId);
        secondIntegralRecord.setIntegralType(IntegralEnum.Relation.WITHDRAW.getState());
        secondIntegralRecord.setIntegralState(IntegralEnum.State.USE.getState());
        secondIntegralRecord.setCreateDate(LocalDateTime.now());
        secondIntegralRecord.setModifyDate(LocalDateTime.now());
        secondIntegralRecord.setIsDeleted((byte) 0);
        secondIntegralRecordMapper.insertSelective(secondIntegralRecord);
        /**
         * 添加免手续费额度
         */
        SecondWithdrawalExemptExample secondWithdrawalExemptExample = new SecondWithdrawalExemptExample();
        secondWithdrawalExemptExample.createCriteria().andIsDeletedEqualTo((byte) 0)
                .andUserIdEqualTo(userId).andStoreIdEqualTo(storeId);
        List<SecondWithdrawalExempt> secondWithdrawalExempts =
                secondWithdrawalExemptMapper.selectByExample(secondWithdrawalExemptExample);
        //查询卡券的额度
        SecondIntegralStrategyExample secondIntegralStrategyExample = new SecondIntegralStrategyExample();
        secondIntegralStrategyExample.createCriteria().andIntegralIdEqualTo(integralId)
                .andIsDeletedEqualTo((byte) 0);
        List<SecondIntegralStrategy> secondIntegralStrategies =
        secondIntegralStrategyMapper.selectByExample(secondIntegralStrategyExample);
        if (secondWithdrawalExempts.size()==0){
            SecondWithdrawalExempt secondWithdrawalExempt = new SecondWithdrawalExempt();
            secondWithdrawalExempt.setUserId(userId);
            secondWithdrawalExempt.setStoreId(storeId);
            secondWithdrawalExempt.setExemptCommission(secondIntegralStrategies.get(0).getExemptCommission());
            secondWithdrawalExempt.setCreateDate(LocalDateTime.now());
            secondWithdrawalExempt.setModifyDate(LocalDateTime.now());
            secondWithdrawalExempt.setIsDeleted((byte) 0);
            secondWithdrawalExemptMapper.insertSelective(secondWithdrawalExempt);
        } else {
            integralQuantityService.updateExemptCommission(secondIntegralStrategies.get(0).getExemptCommission(),userId,storeId);
        }
    }
    //提现商品
    private void product(Integer integralId,Integer userId,Integer storeId){
        SecondIntegralRecord secondIntegralRecord = new SecondIntegralRecord();
        secondIntegralRecord.setIntegralId(integralId);
        secondIntegralRecord.setStoreId(storeId);
        secondIntegralRecord.setUserId(userId);
        secondIntegralRecord.setIntegralType(IntegralEnum.Relation.PRODUCT.getState());
        secondIntegralRecord.setIntegralState(IntegralEnum.State.NOUSE.getState());
        secondIntegralRecord.setCreateDate(LocalDateTime.now());
        secondIntegralRecord.setModifyDate(LocalDateTime.now());
        secondIntegralRecord.setIsDeleted((byte) 0);
        secondIntegralRecordMapper.insertSelective(secondIntegralRecord);
    }
    /**
     * 商品二维码
     */
    /**
     * 生成二维码
     */
    @GetMapping(value = "/activity/create/activity-code")
    @ApiOperation("生成活动详情二维码")
    public void getCode(HttpServletResponse response, String type , Integer IntegralRecordId) throws Exception {
        redisTemplate.opsForValue().set(String.valueOf(IntegralRecordId), IntegralRecordId);
        redisTemplate.expire(String.valueOf(IntegralRecordId),300 , TimeUnit.SECONDS);
        //16位
        String key = "MIGfMA0GCSqGSIb3";
        //字符串
        String orderId123 = String.valueOf(IntegralRecordId);
        //加密
        String encrypt = PageTool.encrypt(orderId123, key);
        response.setContentType("image/jpg");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        OutputStream stream = response.getOutputStream();
        //type是1，生成活动详情、报名的二维码，type是2，生成活动签到的二维码
        Map<String,Object> map = new HashMap<>();
        map.put("siwei",encrypt + "思维创造");
        map.put("siweiType",IntegralEnum.Code.getState(type).getState());
        List<Map<String,Object>> list = new ArrayList<>();
        list.add(map);
        String str1 = JSON.toJSONString(list);
        System.out.println(str1);
        //            //获取一个二维码图片
        BitMatrix bitMatrix = QRCodeUtils.createCode(str1);
        //以流的形式输出到前端
        MatrixToImageWriter.writeToStream(bitMatrix, "jpg", stream);
    }

    @ApiOperation(value = "积分商品二维码核销", notes = "积分商品二维码核销")
    @RequestMapping(value = "/code", method = RequestMethod.POST)
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public ResponseEntity<JSONObject> code(
            @RequestParam(value = "IntegralRecordCode", required = false) String IntegralRecordCode,
            @RequestParam(value = "userId", required = false) Integer userId,
            HttpServletResponse response
    ) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder(HttpStatus.OK);
        String key = "MIGfMA0GCSqGSIb3";
        String IntegralRecord = String.valueOf(IntegralRecordCode).replace("思维创造", "");
        String decrypt = PageTool.decrypt(IntegralRecord, key);
        Integer IntegralRecordId=Integer.valueOf(decrypt);

        if (redisTemplate.opsForValue().get(decrypt) == null){
            response.sendError(HttpStatus.FORBIDDEN.value(), "二维码已失效");
            return builder.body(ResponseUtils.getResponseBody("二维码已失效"));
        }
        SecondIntegralRecord secondIntegralRecord = secondIntegralRecordMapper.selectByPrimaryKey(IntegralRecordId);
        if (secondIntegralRecord.getIntegralState().equals(IntegralEnum.State.USE.getState())){
            response.sendError(HttpStatus.FORBIDDEN.value(), "已经被核销");
            return builder.body(ResponseUtils.getResponseBody("已经被核销"));
        }
        SecondIntegralStrategyExample secondIntegralStrategyExample = new SecondIntegralStrategyExample();
        secondIntegralStrategyExample.createCriteria()
                .andIntegralIdEqualTo(secondIntegralRecord.getIntegralId());
        List<SecondIntegralStrategy> secondIntegralStrategies =
                secondIntegralStrategyMapper.selectByExample(secondIntegralStrategyExample);

        SecondProduct secondProduct = secondProductMapper.selectByPrimaryKey(secondIntegralStrategies.get(0).getProductId());
        SecondAuthExample secondAuthExample = new SecondAuthExample();
        secondAuthExample.createCriteria().andUserIdEqualTo(userId)
                .andLoginTypeEqualTo(Authentication.LoginType.STOREWX.getState())
                .andStoreIdEqualTo(secondProduct.getStoreId())
                .andIsDeletedEqualTo((byte) 0)
                .andAuthStatusEqualTo((byte) 0);
        List<SecondAuth> secondAuths =
        secondAuthMapper.selectByExample(secondAuthExample);
        if (secondAuths.size()==0){
            response.sendError(HttpStatus.FORBIDDEN.value(), "您不是核销员");
            return builder.body(ResponseUtils.getResponseBody("您不是核销员"));
        }
        secondIntegralRecord.setIntegralState(IntegralEnum.State.USE.getState());
        secondIntegralRecord.setModifyDate(LocalDateTime.now());
        secondIntegralRecordMapper.updateByPrimaryKeySelective(secondIntegralRecord);
        redisTemplate.delete(decrypt);
        return builder.body(ResponseUtils.getResponseBody(0));
    }
    @ApiOperation(value = "修改积分商品", notes = "修改积分商品")
    @RequestMapping(value = "/updateIntegralProduct", method = RequestMethod.POST)
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public ResponseEntity<JSONObject> updateIntegralProduct(

            @RequestParam(value = "productName", required = false) String productName,
            @RequestParam(value = "integralId", required = false) Integer integralId,
            @RequestParam(value = "productId", required = false) Integer productId,
            @RequestParam(value = "file1", required = false) String file1,
            @RequestParam(value = "type", required = false) String type,
            @RequestParam(value = "sellPrice", required = false) Integer sellPrice,
            @RequestParam(value = "storeId", required = false) Integer storeId,
            @RequestParam(value = "limit", required = false) Integer limit,
            @RequestParam(value = "productDesc", required = false) String productDesc,
            @RequestParam(value = "quantity", required = false) Integer quantity
    ) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder(HttpStatus.OK);
        SecondIntegral secondIntegral = new SecondIntegral();
        secondIntegral.setId(integralId);
        secondIntegral.setIntegralName(productName);
        secondIntegral.setIntegralNeed(sellPrice);
        secondIntegral.setIntegralType(IntegralEnum.Relation.getState(type).getState());
        secondIntegral.setQuantity(quantity);
        secondIntegral.setInetgralFile(file1);
        secondIntegral.setModifyDate(LocalDateTime.now());
        secondIntegral.setIsDeleted((byte) 0);
        secondIntegralMapper.updateByPrimaryKeySelective(secondIntegral);
        if (IntegralEnum.Relation.getState(type).getState().equals(IntegralEnum.Relation.WITHDRAW.getState())){
            updateWithdraw(secondIntegral.getId(),limit);
        }
        else if (IntegralEnum.Relation.getState(type).getState().equals(IntegralEnum.Relation.PRODUCT.getState())){
            updateProduct(secondIntegral.getId(),storeId,quantity,sellPrice,productDesc,productId);
        }
        return builder.body(ResponseUtils.getResponseBody(0));
    }
    /**
     * 修改积分换购提现资质
     * @return
     */
    public String updateWithdraw(Integer secondIntegralId,
                                 Integer money){
        SecondIntegralStrategyExample secondIntegralStrategyExample = new SecondIntegralStrategyExample();
        secondIntegralStrategyExample.createCriteria().andIntegralIdEqualTo(secondIntegralId)
                .andIsDeletedEqualTo((byte) 0);
        SecondIntegralStrategy secondIntegralStrategy = new SecondIntegralStrategy();
        secondIntegralStrategy.setExemptCommission(money);
        secondIntegralStrategy.setModifyDate(LocalDateTime.now());
        secondIntegralStrategy.setIsDeleted((byte) 0);
        secondIntegralStrategyMapper.updateByExampleSelective(secondIntegralStrategy,secondIntegralStrategyExample);
        return "0";
    }
    /**
     * 修改积分换购商品
     */
    public String updateProduct(Integer secondIntegralId,
                                Integer StoreId,
                                Integer goodsResp,
                                Integer money,
                                String productDesc,
                                Integer productId){
        //创建商品
        SecondProduct secondProduct = new SecondProduct();
        secondProduct.setId(productId);
        secondProduct.setProductDesc(productDesc);
        secondProduct.setProductType(ProductEnum.Relation.INTEGRAL.getState());//积分商品
        secondProduct.setShowType(ProductEnum.ShowType.COUPON.getState());//卡券
        secondProduct.setStoreId(StoreId);
        secondProduct.setIsPutaway(ProductEnum.IsPutaway.PUTAWAY.getState());
        secondProduct.setModifyTime(LocalDateTime.now());
        secondProduct.setIsDeleted((short) 0);
        secondProductMapper.updateByPrimaryKeySelective(secondProduct);
        //物品
        SecondGoodsExample secondGoodsExample = new SecondGoodsExample();
        secondGoodsExample.createCriteria().andProductIdEqualTo(productId)
                .andIsDeletedEqualTo((short) 0);
        SecondGoods secondGoods = new SecondGoods();
        secondGoods.setSellPrice(money);
        secondGoods.setGoodsResp(goodsResp);//库存
        secondGoods.setIsDeleted((short) 0);
        secondGoods.setModifyTime(LocalDateTime.now());
        secondGoodsMapper.updateByExampleSelective(secondGoods,secondGoodsExample);

        SecondIntegralStrategyExample secondIntegralStrategyExample = new SecondIntegralStrategyExample();
        secondIntegralStrategyExample.createCriteria().andIntegralIdEqualTo(secondIntegralId)
                .andProductIdEqualTo(productId)
                .andIsDeletedEqualTo((byte) 0);
        SecondIntegralStrategy secondIntegralStrategy = new SecondIntegralStrategy();
        secondIntegralStrategy.setProductId(secondProduct.getId());
        secondIntegralStrategy.setIntegralId(secondIntegralId);
        secondIntegralStrategy.setModifyDate(LocalDateTime.now());
        secondIntegralStrategy.setIsDeleted((byte) 0);
        secondIntegralStrategyMapper.updateByExampleSelective(secondIntegralStrategy,secondIntegralStrategyExample);
        return "0";
    }
    @ApiOperation(value = "查询积分换购记录", notes = "查询积分换购记录")
    @RequestMapping(value = "/selectIntegralRecord", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "IntegralType", value = "类型", required = true, type = "String"),
            @ApiImplicitParam(paramType = "query", name = "state", value = "状态", required = true, type = "String"),
    })
    public ResponseEntity<JSONObject> selectIntegralRecord(
            @RequestParam(value = "IntegralType", required = false) String IntegralType,
            @RequestParam(value = "userId", required = false) Integer userId,
            @RequestParam(value = "storeId", required = false) Integer storeId,
            @RequestParam(value = "state", required = false) String state
    ) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder(HttpStatus.OK);
        SecondIntegralRecordExample secondIntegralRecordExample = new SecondIntegralRecordExample();
        SecondIntegralRecordExample.Criteria criteria = secondIntegralRecordExample.createCriteria()
                .andIsDeletedEqualTo((byte) 0);
        if (userId!=null&&storeId!=null){
            criteria.andUserIdEqualTo(userId).andStoreIdEqualTo(storeId);
        }
        if (state!=null){
            criteria.andIntegralStateEqualTo(state);
        }
        if (IntegralType!=null){
            criteria.andIntegralTypeEqualTo(IntegralType);
        }
        List<SecondIntegralRecord> secondIntegralRecords =
        secondIntegralRecordMapper.selectByExample(secondIntegralRecordExample);
        List<IntegralRecordList> integralRecordLists = new ArrayList<>();
        secondIntegralRecords.forEach(secondIntegralRecord -> {
            IntegralRecordList integralRecordList = new IntegralRecordList();
            SecondIntegralStrategyExample secondIntegralStrategyExample1 = new SecondIntegralStrategyExample();
            secondIntegralStrategyExample1.createCriteria().andIsDeletedEqualTo((byte) 0)
                    .andIntegralIdEqualTo(secondIntegralRecord.getIntegralId());
            List<SecondIntegralStrategy> secondIntegralStrategies1 =
                    secondIntegralStrategyMapper.selectByExample(secondIntegralStrategyExample1);
            if (secondIntegralStrategies1.get(0).getProductId()!=null){
                SecondProduct secondProduct = secondProductMapper.selectByPrimaryKey(secondIntegralStrategies1.get(0).getProductId());
                SecondStore secondStore = secondStoreMapper.selectByPrimaryKey(secondProduct.getStoreId());
                integralRecordList.setStoreName(secondStore.getStoreName());
                integralRecordList.setAddress(secondStore.getSecondAddress());
            }
            integralRecordList.setIntegralType(secondIntegralRecord.getIntegralType());
            integralRecordList.setRecordId(secondIntegralRecord.getId());
            integralRecordList.setUserId(secondIntegralRecord.getUserId());
            SecondUser secondUser = secondUserMapper.selectByPrimaryKey(secondIntegralRecord.getUserId());
            integralRecordList.setUserName(secondUser.getNickName());
            integralRecordList.setStoreId(secondIntegralRecord.getStoreId());
            integralRecordList.setIntegralId(secondIntegralRecord.getIntegralId());
            integralRecordList.setIntegralState(secondIntegralRecord.getIntegralState());
            integralRecordList.setCreateTime(secondIntegralRecord.getCreateDate());
            SecondIntegral secondIntegral = secondIntegralMapper.selectByPrimaryKey(secondIntegralRecord.getIntegralId());
            integralRecordList.setIntegralName(secondIntegral.getIntegralName());
            integralRecordList.setIntegralNeed(secondIntegral.getIntegralNeed());
            integralRecordList.setIntegralFile(secondIntegral.getInetgralFile());
            SecondIntegralStrategyExample secondIntegralStrategyExample = new SecondIntegralStrategyExample();
            secondIntegralStrategyExample.createCriteria().andIntegralIdEqualTo(secondIntegralRecord.getIntegralId())
                    .andIsDeletedEqualTo((byte) 0);
            List<SecondIntegralStrategy> secondIntegralStrategies =
                    secondIntegralStrategyMapper.selectByExample(secondIntegralStrategyExample);
            if (secondIntegralRecord.getIntegralType().equals(IntegralEnum.Relation.PRODUCT.getState())){
                integralRecordList.setProductId(secondIntegralStrategies.get(0).getProductId());
//                SecondProduct secondProduct = secondProductMapper.selectByPrimaryKey(secondIntegralStrategies.get(0).getProductId());
//                integralRecordList.setProductName();
            } else if (secondIntegralRecord.getIntegralType().equals(IntegralEnum.Relation.WITHDRAW.getState())){
                integralRecordList.setExemptCommission(secondIntegralStrategies.get(0).getExemptCommission());
            }
            integralRecordLists.add(integralRecordList);
        });
        return builder.body(ResponseUtils.getResponseBody(integralRecordLists));
    }
}
