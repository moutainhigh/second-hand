package com.example.product.center.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.product.center.dao.*;
import com.example.product.center.manual.IntegralEnum;
import com.example.product.center.manual.IntegralList;
import com.example.product.center.manual.ProductEnum;
import com.example.product.center.model.*;
import com.second.utils.response.handler.ResponseEntity;
import com.second.utils.response.handler.ResponseUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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
    @ApiOperation(value = "添加积分商品", notes = "添加积分商品")
    @RequestMapping(value = "/addIntegralProduct", method = RequestMethod.POST)
    public ResponseEntity<JSONObject> addIntegralProduct(
            @RequestParam(value = "productName", required = false) String productName,
            @RequestParam(value = "file1", required = false) String file1,
            @RequestParam(value = "type", required = false) String type,
            @RequestParam(value = "sellPrice", required = false) Integer sellPrice,
            @RequestParam(value = "storeId", required = false) Integer storeId,
            @RequestParam(value = "limit", required = false) Integer limit,
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
            addProduct(secondIntegral.getId(),storeId,quantity,sellPrice);
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
        return "0";
    }
    /**
     * 创建积分换购商品
     */
    public String addProduct(Integer secondIntegralId,Integer StoreId,Integer goodsResp,Integer money){
        //创建商品
        SecondProduct secondProduct = new SecondProduct();
        secondProduct.setProductType(ProductEnum.Relation.INTEGRAL.getState());//积分商品
        secondProduct.setShowType(ProductEnum.ShowType.COUPON.getState());//卡券
        secondProduct.setStoreId(StoreId);
        secondProduct.setIsPutaway(ProductEnum.IsPutaway.PUTAWAY.getState());
        secondProduct.setCreateTime(LocalDateTime.now());
        secondProduct.setModifyTime(LocalDateTime.now());
        secondProduct.setIsDeleted((short) 0);
        secondProductMapper.insertSelective(secondProduct);
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
                integralList.setStoreId(secondProduct.getStoreId());
                integralList.setProductId(secondProduct.getId());
                SecondStore secondStore = secondStoreMapper.selectByPrimaryKey(secondProduct.getStoreId());
                integralList.setStoreName(secondStore.getStoreName());
                integralList.setAddress(secondStore.getSecondAddress());
                integralList.setCreateTime(secondStore.getCreateTime());

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
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "integralId", value = "积分商品id", required = true, type = "Integer"),
    })
    public ResponseEntity<JSONObject> deleteIntegralProduct(
            @RequestParam(value = "integralId", required = false) Integer integralId
    ) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder(HttpStatus.OK);
       SecondIntegral secondIntegral = new SecondIntegral();
        secondIntegral.setIsDeleted((byte) 1);
        secondIntegral.setModifyDate(LocalDateTime.now());
        secondIntegralMapper.updateByPrimaryKeySelective(secondIntegral);
        return builder.body(ResponseUtils.getResponseBody(0));
    }
}