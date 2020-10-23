package com.example.product.center.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.example.product.center.dao.*;
import com.example.product.center.manual.Address.AddressList;
import com.example.product.center.manual.Authentication;
import com.example.product.center.manual.ProductEnum;
import com.example.product.center.manual.ProductList;
import com.example.product.center.manual.WantEnum;
import com.example.product.center.model.*;
import com.example.product.center.service.AddressService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.second.common.service.FileMangeService;
import com.second.utils.response.handler.ResponseEntity;
import com.second.utils.response.handler.ResponseUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author shihao
 * @Title: SecondProductController
 * @ProjectName Second-order-center
 * @Description:
 * @date Created in
 * @Version: $
 */
@RestController
@Api
@RequestMapping("/SecondProduct")
@CrossOrigin
public class SecondProductController {
    @Autowired
    private SecondOrderDetailMapper secondOrderDetailMapper;
    @Resource
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private SecondProductMapper secondProductMapper;
    //物品
    @Autowired
    private SecondGoodsMapper secondGoodsMapper;
    //图片
    @Autowired
    private SecondProductPictrueMapper secondProductPictrueMapper;
    //标签
    @Autowired
    private SecondProductLabelMapper secondProductLabelMapper;
    @Autowired
    private SecondLabelMapper secondLabelMapper;
    //店铺
    @Autowired
    private SecondStoreMapper secondStoreMapper;
    //用户
    @Autowired
    private SecondUserMapper secondUserMapper;
    //学校
    @Autowired
    private SecondCollegesMapper secondCollegesMapper;
    //学校城市
    @Autowired
    private SecondCityMapper secondCityMapper;
    //学生认证
    @Autowired
    private SecondAuthenticationMapper secondAuthenticationMapper;
    //文件
    @Autowired
    private SecondFileMapper secondFileMapper;
    //商品地址
    @Autowired
    private SecondProductAddressMapper secondProductAddressMapper;
    //店铺地址
    @Autowired
    private SecondStoreAddressMapper secondStoreAddressMapper;
    //子站点和店铺
    @Autowired
    private SecondUserSonMapper secondUserSonMapper;
    //子站点
    @Autowired
    private SecondSonMapper secondSonMapper;
    //商品的浏览收藏点赞想要
    @Autowired
    private SecondProductWantMapper secondProductWantMapper;
    //地图获取ip
    @Autowired
    private AddressService addressService;
    //分类
    @Autowired
    private SecondCategoryMapper secondCategoryMapper;

    @RequestMapping(path = "/addProduct", method = RequestMethod.POST)
    @ApiOperation(value = "用户添加商品", notes = "用户添加商品")
    @ApiImplicitParams({
//            @ApiImplicitParam(paramType = "query", name = "file", value = "文件id", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "productName", value = "商品名称", required = true, type = "String"),
            @ApiImplicitParam(paramType = "query", name = "productDesc", value = "商品描述", required = true, type = "String"),
            @ApiImplicitParam(paramType = "query", name = "showType", value = "商品展示类型,卡券,普通商品", required = true, type = "String"),
            @ApiImplicitParam(paramType = "query", name = "addressId", value = "地址id", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "isPutaway", value = "是否上架", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "categoryId", value = "类目id", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "storeId", value = "店铺id", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "sellPrice", value = "售卖价格", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "linePrice", value = "划线价格", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "goodsResp", value = "库存", required = true, type = "Integer"),
//            @ApiImplicitParam(paramType = "query", name = "labelIds", value = "标签id", required = true, type = "Integer"),
    })
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public ResponseEntity<JSONObject> addProduct(
            @RequestParam(value = "productName", required = false) String productName,
            @RequestParam(value = "productDesc", required = false) String productDesc,
            @RequestParam(value = "showType", required = false) String showType,
            @RequestParam(value = "file", required = false) String[] file,
            @RequestParam(value = "file1", required = false) String file1,
            @RequestParam(value = "addressId", required = false) Integer addressId,
            @RequestParam(value = "isPutaway", required = false) Integer isPutaway,
            @RequestParam(value = "categoryId", required = false) Integer categoryId,
            @RequestParam(value = "sellPrice", required = false) Integer sellPrice,
            @RequestParam(value = "linePrice", required = false) Integer linePrice,
            @RequestParam(value = "goodsResp", required = false) Integer goodsResp,
            @RequestParam(value = "labelIds", required = false) Integer[] labelIds,
            @RequestParam(value = "storeId", required = false) Integer storeId,
            HttpServletResponse response

    ) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
        //地址
        SecondStore secondStore = secondStoreMapper.selectByPrimaryKey(storeId);
        if (!secondStore.getSecondStatus().equals(Authentication.State.PASS.getState())){
            response.sendError(HttpStatus.FORBIDDEN.value(), "没有认证");
            return builder.body(ResponseUtils.getResponseBody(1));
        }
        if (secondStore.getStoreType().equals(Authentication.StoreType.STORE.getState())) {
            SecondStoreAddressExample secondStoreAddressExample = new SecondStoreAddressExample();
            secondStoreAddressExample.createCriteria().andIsDeletedEqualTo((short) 0)
                    .andStoreIdEqualTo(storeId);
            List<SecondStoreAddress> secondStoreAddresses =
                    secondStoreAddressMapper.selectByExample(secondStoreAddressExample);
            addressId = secondStoreAddresses.get(0).getId();
        }
        //
        SecondProduct secondProduct = new SecondProduct();
        secondProduct.setProductState(ProductEnum.ProductState.SELL.getState());
        secondProduct.setProductType(ProductEnum.Relation.GENERAL.getState());//普通商品
        secondProduct.setShowType(ProductEnum.ShowType.getState(showType).getState());//普通商品展示
        secondProduct.setAddressId(addressId);//地址
        secondProduct.setCategoryId(categoryId);//类目
        secondProduct.setProductName(productName);//商品名称
        secondProduct.setProductDesc(productDesc);//商品描述
        secondProduct.setIsPutaway(ProductEnum.IsPutaway.getState(isPutaway).getState());//是否上架
        secondProduct.setStoreId(storeId);
        secondProduct.setIsDeleted((short) 0);
        secondProduct.setCreateTime(LocalDateTime.now());
        secondProduct.setModifyTime(LocalDateTime.now());
        secondProduct.setFile(file1);
        secondProductMapper.insertSelective(secondProduct);
        //删除redis数据保证数据一致
//        deleted(String.valueOf(categoryId)+"ProductCategory");
//        SecondUserSonExample secondUserSonExample = new SecondUserSonExample();
//        secondUserSonExample.createCriteria().andStoreIdEqualTo(storeId)
//                .andIsDeletedEqualTo((byte) 0);
//        List<SecondUserSon> secondUserSons =
//                secondUserSonMapper.selectByExample(secondUserSonExample);
//        deleted(String.valueOf(secondUserSons.get(0).getSonId())+"ProductSon");
        deleted(String.valueOf(secondProduct.getId()) + "detail");
        //
        SecondStoreAddress secondStoreAddress = secondStoreAddressMapper.selectByPrimaryKey(addressId);
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
        secondGoods.setSellPrice(sellPrice);
        secondGoods.setLinePrice(linePrice);
        secondGoods.setGoodsResp(goodsResp);
        secondGoods.setIsDeleted((short) 0);
        secondGoods.setCreateTime(LocalDateTime.now());
        secondGoods.setModifyTime(LocalDateTime.now());
        secondGoodsMapper.insertSelective(secondGoods);
        //商品图片
        if (file.length != 0) {
            for (String fie : file) {
                SecondProductPictrue secondProductPictrue = new SecondProductPictrue();
                secondProductPictrue.setProductId(secondProduct.getId());
                secondProductPictrue.setFile(fie);
                secondProductPictrue.setCreateTime(LocalDateTime.now());
                secondProductPictrue.setModifyTime(LocalDateTime.now());
                secondProductPictrue.setIsDeleted((short) 0);
                secondProductPictrueMapper.insertSelective(secondProductPictrue);
            }
        }
        //标签
        if (labelIds != null) {
            for (Integer labelId : labelIds) {
                SecondProductLabel secondProductLabel = new SecondProductLabel();
                secondProductLabel.setProductId(secondProduct.getId());
                secondProductLabel.setLabelId(labelId);
                secondProductLabel.setCreateTime(LocalDateTime.now());
                secondProductLabel.setModifyTime(LocalDateTime.now());
                secondProductLabel.setIsDeleted((short) 0);
                secondProductLabelMapper.insertSelective(secondProductLabel);
            }
        }
        return builder.body(ResponseUtils.getResponseBody(0));
    }

    @RequestMapping(path = "/updateProduct", method = RequestMethod.POST)
    @ApiOperation(value = "修改商品", notes = "修改商品")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "productId", value = "商品id", required = false, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "productName", value = "商品名称", required = false, type = "String"),
            @ApiImplicitParam(paramType = "query", name = "productDesc", value = "商品描述", required = false, type = "String"),
            @ApiImplicitParam(paramType = "query", name = "showType", value = "商品展示类型,卡券,普通商品", required = false, type = "String"),
            @ApiImplicitParam(paramType = "query", name = "addressId", value = "地址id", required = false, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "isPutaway", value = "是否上架", required = false, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "categoryId", value = "类目id", required = false, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "storeId", value = "店铺id", required = false, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "sellPrice", value = "售卖价格", required = false, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "linePrice", value = "划线价格", required = false, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "goodsResp", value = "库存", required = false, type = "Integer"),
//            @ApiImplicitParam(paramType = "query", name = "labelIds", value = "标签id", required = true, type = "Integer"),
    })
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public ResponseEntity<JSONObject> updateProduct(
            @RequestParam(value = "productName", required = false) String productName,
            @RequestParam(value = "productDesc", required = false) String productDesc,
            @RequestParam(value = "showType", required = false) String showType,
            @RequestParam(value = "file1", required = false) String file1,
            @RequestParam(value = "addressId", required = false) Integer addressId,
            @RequestParam(value = "isPutaway", required = false) Integer isPutaway,
            @RequestParam(value = "categoryId", required = false) Integer categoryId,
            @RequestParam(value = "sellPrice", required = false) Integer sellPrice,
            @RequestParam(value = "linePrice", required = false) Integer linePrice,
            @RequestParam(value = "goodsResp", required = false) Integer goodsResp,
            @RequestParam(value = "labelIds", required = false) Integer[] labelIds,
            @RequestParam(value = "storeId", required = false) Integer storeId,
            @RequestParam(value = "file", required = false) String[] file,
            @RequestParam(value = "productId", required = false) Integer productId

    ) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
        System.out.println(file1+":file1");
//        if (file1 != null) {
//            if (secondProductMapper.selectByPrimaryKey(productId).getFile() != null&& !secondProductMapper.selectByPrimaryKey(productId).getFile().equals(file1)) {
//                fileDelete2(secondProductMapper.selectByPrimaryKey(productId).getFile());
//            }
//        }
        SecondProduct secondProduct = new SecondProduct();
        secondProduct.setId(productId);
        secondProduct.setProductType(ProductEnum.Relation.GENERAL.getState());//普通商品
        secondProduct.setShowType(ProductEnum.ShowType.getState(showType).getState());//普通商品展示
        secondProduct.setAddressId(addressId);//地址
        secondProduct.setCategoryId(categoryId);//类目
        secondProduct.setProductName(productName);//商品名称
        secondProduct.setProductDesc(productDesc);//商品描述
        secondProduct.setIsPutaway(ProductEnum.IsPutaway.getState(isPutaway).getState());//是否上架
        secondProduct.setStoreId(storeId);
        secondProduct.setIsDeleted((short) 0);
        secondProduct.setModifyTime(LocalDateTime.now());
        secondProduct.setFile(file1);
        secondProductMapper.updateByPrimaryKeySelective(secondProduct);
        SecondProduct secondProduct1 =
                secondProductMapper.selectByPrimaryKey(secondProduct.getId());
//        System.out.println(secondProduct);
        //删除redis数据保证数据一致
        System.out.println(secondProduct.getId());
        System.out.println(secondProduct1.getCategoryId());
//        if (secondProduct1.getCategoryId()!=null){
//            deleted(String.valueOf(secondProduct1.getCategoryId())+"ProductCategory");
//        }
        SecondUserSonExample secondUserSonExample = new SecondUserSonExample();
        secondUserSonExample.createCriteria().andStoreIdEqualTo(secondProduct1.getStoreId())
                .andIsDeletedEqualTo((byte) 0);
        List<SecondUserSon> secondUserSons =
                secondUserSonMapper.selectByExample(secondUserSonExample);
//        if (secondUserSons.size()!=0){
//            deleted(String.valueOf(secondUserSons.get(0).getSonId())+"ProductSon");
//        }
        deleted(String.valueOf(secondProduct1.getId()) + "detail");
        //地址
        SecondStoreAddress secondStoreAddress = secondStoreAddressMapper.selectByPrimaryKey(addressId);
        if (secondStoreAddress != null) {
            SecondProductAddress secondProductAddress = new SecondProductAddress();
//        secondProductAddress.setProductId(secondProduct.getId());
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
            SecondProductAddressExample secondProductAddressExample = new SecondProductAddressExample();
            secondProductAddressExample.createCriteria().andProductIdEqualTo(productId);
            secondProductAddressMapper.updateByExampleSelective(secondProductAddress, secondProductAddressExample);
        }

        //物品
        SecondGoodsExample secondGoodsExample = new SecondGoodsExample();
        secondGoodsExample.createCriteria().andIsDeletedEqualTo((short) 0)
                .andProductIdEqualTo(productId);
        SecondGoods secondGoods = new SecondGoods();
        secondGoods.setSellPrice(sellPrice);
        secondGoods.setLinePrice(linePrice);
        secondGoods.setGoodsResp(goodsResp);
        secondGoods.setModifyTime(LocalDateTime.now());
        secondGoodsMapper.updateByExampleSelective(secondGoods, secondGoodsExample);
        //商品图片
        if (file.length != 0) {
            for (String fie : file) {
                SecondProductPictrue secondProductPictrue = new SecondProductPictrue();
                secondProductPictrue.setProductId(secondProduct.getId());
                secondProductPictrue.setFile(fie);
                secondProductPictrue.setCreateTime(LocalDateTime.now());
                secondProductPictrue.setModifyTime(LocalDateTime.now());
                secondProductPictrue.setIsDeleted((short) 0);
                secondProductPictrueMapper.insertSelective(secondProductPictrue);
            }
        }
        //标签
        if (labelIds != null) {
            for (Integer labelId : labelIds) {
                SecondProductLabelExample secondProductLabelExample = new SecondProductLabelExample();
                secondProductLabelExample.createCriteria().andProductIdEqualTo(productId)
                        .andIsDeletedEqualTo((short) 0)
                        .andLabelIdEqualTo(labelId);
                SecondProductLabel secondProductLabel = new SecondProductLabel();
                secondProductLabel.setProductId(secondProduct.getId());
                secondProductLabel.setLabelId(labelId);
                secondProductLabel.setModifyTime(LocalDateTime.now());
                secondProductLabelMapper.updateByExampleSelective(secondProductLabel, secondProductLabelExample);
            }
        }
        return builder.body(ResponseUtils.getResponseBody(0));
    }

    @RequestMapping(path = "/deleteProduct", method = RequestMethod.POST)
    @ApiOperation(value = "删除商品", notes = "删除商品")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "productId", value = "商品id", required = true, type = "Integer"),
    })
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public ResponseEntity<JSONObject> deleteProduct(
            @RequestParam(value = "productId", required = false) Integer productId
    ) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
        //删除redis数据保证数据一致
        SecondProduct secondProduct1 = secondProductMapper.selectByPrimaryKey(productId);
        deleted(String.valueOf(secondProduct1.getCategoryId()) + "ProductCategory");
        SecondUserSonExample secondUserSonExample = new SecondUserSonExample();
        secondUserSonExample.createCriteria().andStoreIdEqualTo(secondProduct1.getStoreId())
                .andIsDeletedEqualTo((byte) 0);
        List<SecondUserSon> secondUserSons =
                secondUserSonMapper.selectByExample(secondUserSonExample);
        if (secondUserSons.size() != 0) {
            deleted(String.valueOf(secondUserSons.get(0).getSonId()) + "ProductSon");
        }
        deleted(String.valueOf(secondProduct1.getId()) + "detail");
        //
        SecondProduct secondProduct = new SecondProduct();
        secondProduct.setId(productId);
        secondProduct.setIsDeleted((short) 1);
        secondProductMapper.updateByPrimaryKeySelective(secondProduct);
        return builder.body(ResponseUtils.getResponseBody(0));
    }

    @ApiOperation(value = "获取商品列表", notes = "获取商品列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "sonId", value = "子站点id", required = false, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "categoryId", value = "类目id", required = false, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "storeId", value = "店铺id", required = false, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "isSon", value = "是否是子站点查询 0是", required = false, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "showType", value = "商品类型", required = false, type = "String"),
            @ApiImplicitParam(paramType = "query", name = "product", value = "搜索的内容", required = false, type = "String"),
            @ApiImplicitParam(paramType = "query", name = "putaway", value = "上下架 0上架的 1下架的 全部不填", required = false, type = "String"),
            @ApiImplicitParam(paramType = "query", name = "price", value = "价格筛选 0升序 1降序", required = false, type = "Integer"),
    })
    @RequestMapping(value = "/selectProduct", method = RequestMethod.GET)
    public ResponseEntity<JSONObject> selectProduct(
            Integer pageNum, Integer pageSize,
            @RequestParam(name = "sonId", required = false) Integer sonId,
            @RequestParam(name = "storeId", required = false) Integer storeId,
            @RequestParam(name = "showType", required = false) String showType,
            @RequestParam(name = "product", required = false) String product,
            @RequestParam(name = "isSon", required = false) Integer isSon,
            @RequestParam(name = "categoryId", required = false) Integer categoryId,
            @RequestParam(name = "price", required = false) Integer price,
            @RequestParam(name = "putaway", required = false) Integer putaway
    )
            throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder(HttpStatus.OK);
        //商品列表
        SecondProductExample secondProductExample = new SecondProductExample();
        SecondProductExample.Criteria criteria = secondProductExample.createCriteria().andIsDeletedEqualTo((short) 0)
                .andIsPutawayEqualTo(ProductEnum.IsPutaway.PUTAWAY.getState())
                .andProductTypeEqualTo(ProductEnum.Relation.GENERAL.getState())
                .andProductStateEqualTo(ProductEnum.ProductState.SELL.getState())
                .andShowTypeEqualTo(ProductEnum.ShowType.getState(showType).getState());
//筛选类目
        if (categoryId != null) {
            criteria.andCategoryIdEqualTo(categoryId);
        }
        //筛选店铺
        if (storeId != null) {
            criteria.andStoreIdEqualTo(storeId);
        }
        //搜索筛选
        if (product!=null){
//            SecondProductExample.Criteria criteria1 =criteria;
            criteria.andProductNameLike("%" + product + "%");
        }
        //上下架筛选
        if (putaway!=null){
            criteria.andIsPutawayEqualTo(putaway);
        }
        List<ProductList> productLists = new ArrayList<>();

        List<SecondProduct> secondProducts = secondProductMapper.selectByExampleWithBLOBs(secondProductExample);
        System.out.println(secondProducts);
        secondProducts.forEach(secondProduct1 -> {
//            for(SecondProduct secondProduct1 : secondProducts){
            //物品
            SecondUserSonExample secondUserSonExample = new SecondUserSonExample();
            secondUserSonExample.createCriteria().andStoreIdEqualTo(secondProduct1.getStoreId())
                    .andIsDeletedEqualTo((byte) 0);
            List<SecondUserSon> secondUserSons =
                    secondUserSonMapper.selectByExample(secondUserSonExample);
            //站点
            SecondSon secondSon = new SecondSon();
            if (secondUserSons.size() != 0) {
                secondSon = secondSonMapper.selectByPrimaryKey(secondUserSons.get(0).getSonId());
            }
            ProductList productList = new ProductList();
            if (secondProduct1.getCategoryId()!=null){
                SecondCategory secondCategory = secondCategoryMapper.selectByPrimaryKey(secondProduct1.getCategoryId());
                productList.setProductCategory(secondCategory.getSecondName());
            }
            //商品状态
            productList.setProductState(secondProduct1.getProductState());
            //列表图
            productList.setFile(secondProduct1.getFile());
            //wuping
            SecondGoodsExample secondGoodsExample = new SecondGoodsExample();
            secondGoodsExample.createCriteria()
                    .andProductIdEqualTo(secondProduct1.getId())
                    .andIsDeletedEqualTo((short) 0);
            List<SecondGoods> secondGoods =
                    secondGoodsMapper.selectByExample(secondGoodsExample);
            productList.setPrice(secondGoods.get(0).getSellPrice());
            productList.setGoodsId(secondGoods.get(0).getId());
            if (secondSon.getId() != null) {
                productList.setSonId(secondSon.getId());
            } else {
                productList.setSonId(0);
            }
            //收藏
            SecondProductWantExample secondProductWantExample = new SecondProductWantExample();
            secondProductWantExample.createCriteria().andProductIdEqualTo(secondProduct1.getId())
                    .andTypeEqualTo(WantEnum.Relation.COLLECT.getState())
                    .andIsDeletedEqualTo((short) 0);
            List<SecondProductWant> secondProductWants =
                    secondProductWantMapper.selectByExample(secondProductWantExample);
            productList.setCollect(secondProductWants.size());
            //点赞
            secondProductWantExample.clear();
            secondProductWantExample.createCriteria()
                    .andTypeEqualTo(WantEnum.Relation.PRAISE.getState())
                    .andProductIdEqualTo(secondProduct1.getId())
                    .andIsDeletedEqualTo((short) 0);
            secondProductWants = secondProductWantMapper.selectByExample(secondProductWantExample);
            productList.setPraise(secondProductWants.size());
            //浏览
            secondProductWantExample.clear();
            secondProductWantExample.createCriteria()
                    .andTypeEqualTo(WantEnum.Relation.LOOK.getState())
                    .andProductIdEqualTo(secondProduct1.getId())
                    .andIsDeletedEqualTo((short) 0);
            secondProductWants = secondProductWantMapper.selectByExample(secondProductWantExample);
            productList.setLook(secondProductWants.size());
            //想要
            secondProductWantExample.clear();
            secondProductWantExample.createCriteria()
                    .andTypeEqualTo(WantEnum.Relation.WANT.getState())
                    .andProductIdEqualTo(secondProduct1.getId())
                    .andIsDeletedEqualTo((short) 0);
            secondProductWants = secondProductWantMapper.selectByExample(secondProductWantExample);
            productList.setWant(secondProductWants.size());


            productList.setId(secondProduct1.getId());//商品id
            productList.setProductName(secondProduct1.getProductName());//商品名称
            productList.setProductDesc(secondProduct1.getProductDesc());//描述
            productList.setProductType(secondProduct1.getProductType());//商品类型
            productList.setShowType(secondProduct1.getShowType());//展示类型
            productList.setIsPutaway(secondProduct1.getIsPutaway());//是否上架
            productList.setCreateTime(secondProduct1.getCreateTime());//商品创建时间
            /**
             * 商品图片
             */
            SecondProductPictrueExample secondProductPictrueExample = new SecondProductPictrueExample();
            secondProductPictrueExample.createCriteria().andIsDeletedEqualTo((short) 0)
                    .andProductIdEqualTo(secondProduct1.getId());
            List<SecondProductPictrue> secondProductPictrues =
                    secondProductPictrueMapper.selectByExample(secondProductPictrueExample);
            if (secondProductPictrues.size() != 0) {
                List<String> files = new ArrayList<>();
                secondProductPictrues.forEach(secondProductPictrue -> {
                    files.add(secondProductPictrue.getFile());
                });
                productList.setFiles(files);
            }
            /**
             * 店铺
             */
            SecondStore secondStore = secondStoreMapper.selectByPrimaryKey(secondProduct1.getStoreId());
            productList.setStoreId(secondStore.getId());//店铺id
            productList.setStoreType(secondStore.getStoreType());//店铺类型
            productList.setStoreName(secondStore.getStoreName());//店铺名称
            productList.setConcernCount(secondStore.getConcernCount());//店铺关注人数
            productList.setSecondStatus(secondStore.getSecondStatus());//店铺状态
            productList.setIsStoreDeleted(secondStore.getIsDeleted());//
            /**
             * 用户
             */
            SecondUser secondUser = secondUserMapper.selectByPrimaryKey(secondStore.getUserId());
            productList.setUserId(secondStore.getUserId());
            productList.setNickName(secondUser.getNickName());
            productList.setIsAuthentication(secondUser.getIsAuthentication());
            productList.setUserFile(secondUser.getFile());
            /**
             * 地址
             */
            SecondProductAddressExample secondProductAddressExample = new SecondProductAddressExample();
            secondProductAddressExample.createCriteria().andProductIdEqualTo(secondProduct1.getId())
                    .andIsDeletedEqualTo((short) 0);
            List<SecondProductAddress> secondProductAddresss = secondProductAddressMapper.selectByExample(secondProductAddressExample);
            if (secondProductAddresss.size() != 0) {
                productList.setAddressId(secondProduct1.getAddressId());
                productList.setProvince(secondProductAddresss.get(0).getSecondProvince());//省
                productList.setCity(secondProductAddresss.get(0).getSecondCity());//市
                productList.setConty(secondProductAddresss.get(0).getSecondConty());//区/县
                productList.setAddressDetail(secondProductAddresss.get(0).getSecondAddressDetail());//地址详情
                if (secondProductAddresss.get(0).getLongitude() != null && secondProductAddresss.get(0).getLatitude() != null) {
                    productList.setLatitude(secondProductAddresss.get(0).getLatitude());//纬度
                    productList.setLongitude(secondProductAddresss.get(0).getLongitude());//经度
                }
//                else {
//                    String add =
//                            secondProductAddress.getSecondProvince() + secondProductAddress.getSecondCity()
//                                    + secondProductAddress.getSecondConty() + secondProductAddress.getSecondAddressDetail();
//                    JSONObject a = addressService.getIngAndLat(add);
//                    System.out.println(a);
//                    AddressList list = JSON.parseObject(String.valueOf(a), new TypeReference<AddressList>() {
//                    });
//                    if (list!=null){
//                        if (list.getResult().size()!=0){
//                            if (list.getResult().get(0).getLocation().size()!=0){
//                                productList.setLongitude(list.getResult().get(0).getLocation().get(0).getLng());
//                            }
//                        }
//                        if (list.getResult().size()!=0){
//                            if (list.getResult().get(0).getLocation().size()!=0){
//                                productList.setLatitude(list.getResult().get(0).getLocation().get(0).getLat());
//                            }
//                        }
//
//                    }
//                }


                productList.setPhone(secondProductAddresss.get(0).getPhoneNumber());//电话
                productList.setAddressDesc(secondProductAddresss.get(0).getSecondDesc());//描述
            }
            /**
             * 订单
             */
            SecondOrderDetailExample secondOrderDetailExample = new SecondOrderDetailExample();
            secondOrderDetailExample.createCriteria().andGoodsIdEqualTo(secondGoods.get(0).getId());
            List<SecondOrderDetail> secondOrderDetails =
            secondOrderDetailMapper.selectByExample(secondOrderDetailExample);
            productList.setSellNumber(secondOrderDetails.size());
            /**
             * 学校
             * 根据用户id查询认证
             */
            SecondAuthenticationExample secondAuthenticationExample = new SecondAuthenticationExample();
            secondAuthenticationExample.createCriteria().andUserIdEqualTo(secondUser.getId())
                    .andAuthenticationStateEqualTo(Authentication.State.PASS.getState())
                    .andIsDeletedEqualTo((byte) 0);
            List<SecondAuthentication> secondAuthentications =
                    secondAuthenticationMapper.selectByExample(secondAuthenticationExample);
            if (secondAuthentications.size() != 0) {
                SecondColleges secondColleges =
                        secondCollegesMapper.selectByPrimaryKey(secondAuthentications.get(0).getCollegesId());
                productList.setColleges(secondColleges.getName());
                productList.setRecord(secondColleges.getRecord());
            }
            /**
             * 标签 根据商品id获取商品标签
             */
            SecondProductLabelExample secondProductLabelExample = new SecondProductLabelExample();
            secondProductLabelExample.createCriteria().andIsDeletedEqualTo((short) 0)
                    .andProductIdEqualTo(secondProduct1.getId());
            List<SecondProductLabel> secondProductLabels =
                    secondProductLabelMapper.selectByExample(secondProductLabelExample);
            if (secondProductLabels.size() != 0) {
                List<String> files = new ArrayList<>();
                secondProductLabels.forEach(secondProductLabel -> {
                    SecondLabel secondLabel = secondLabelMapper.selectByPrimaryKey(secondProductLabel.getLabelId());
                    files.add(secondLabel.getLabelName());
                });
                productList.setLabelName(files);
            }
            productLists.add(productList);
        });
        List<ProductList> productLists1 = new ArrayList<>();
        productLists1 = productLists.stream().filter(a -> a.getIsStoreDeleted() == 0 && a.getSecondStatus() == 0)
                .collect(Collectors.toList());
if (price!=null && price==1){
    productLists1 = productLists1.stream()
            .sorted(Comparator.comparing(ProductList::getPrice).reversed()).collect(Collectors.toList());
}else if (price!=null && price==0){
    productLists1 = productLists1.stream()
            .sorted(Comparator.comparing(ProductList::getPrice)).collect(Collectors.toList());
}

//        String json = JSONObject.toJSONString(productLists1);
        /**
         * 筛选认证子站点学校2公里商品
         */
        if (sonId != null && isSon == null) {
            SecondSon secondSon = secondSonMapper.selectByPrimaryKey(sonId);
            SecondColleges secondColleges = secondCollegesMapper.selectByPrimaryKey(secondSon.getCollegoryId());
            SecondCityExample secondCityExample = new SecondCityExample();
            secondCityExample.createCriteria().andCityIdEqualTo(secondColleges.getCityId());
            List<SecondCity> secondCity = secondCityMapper.selectByExample(secondCityExample);
            String address = secondCity.get(0).getName() + secondColleges.getName();
            JSONObject a = addressService.getIngAndLat(address);
            AddressList list = JSON.parseObject(String.valueOf(a), new TypeReference<AddressList>() {
            });
            System.out.println(list.getResult().get(0).getLocation());
            String lat = list.getResult().get(0).getLocation().get(0).getLat();
            String lng = list.getResult().get(0).getLocation().get(0).getLng();
            double distance = 2;
            productLists1 =
                    productLists1.stream()
                            .filter(s -> getDistance(Double.parseDouble(s.getLatitude()), Double.parseDouble(s.getLongitude()), Double.parseDouble(lat), Double.parseDouble(lng)) < distance)
                            .collect(Collectors.toList());
        }
        if (sonId != null && isSon == 0) {
            productLists1 =
                    productLists1.stream().filter(s-> s.getSonId().equals(sonId)).collect(Collectors.toList());
        }

//        int total = productLists1.size();
//        if (pageNum == null) {
//            pageNum = 1;
//        }
//        if (pageSize == null) {
//            pageSize = total;
//        }
//        Page<Object> pages = PageHelper.startPage(pageNum, pageSize);
//
//        pages.setTotal(total);
//        int startIndex = (pageNum - 1) * pageSize;
//        int endIndex = Math.min(startIndex + pageSize, total);
//        pages.addAll(productLists1.subList(startIndex, endIndex));
//        PageInfo pageInfo = new PageInfo<>(pages);
        return builder.body(ResponseUtils.getResponseBody(productLists1));
    }

    public ResponseEntity<JSONObject> fileDelete2(String file) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder(HttpStatus.OK);
        String str1 = file.substring(0, file.indexOf("="));
        String str2 = file.substring(str1.length() + 1, file.length());

        SecondFile fileDesc = secondFileMapper.selectByPrimaryKey(Integer.valueOf(str2));
        FileMangeService fileManageService = new FileMangeService();
        if (fileDesc != null) {
            fileManageService.deleteFile(fileDesc.getGroupName(), fileDesc.getRemoteFilename());
        }
        secondFileMapper.deleteByPrimaryKey(Integer.valueOf(str2));
        return builder.body(ResponseUtils.getResponseBody(Integer.valueOf(str2)));
    }

    @ApiOperation(value = "删除商品详情图", notes = "删除商品详情图")
    @RequestMapping(value = "/fileDeleteProduct", method = RequestMethod.POST)
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public ResponseEntity<JSONObject> fileDeleteProduct(String file, Integer productId) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder(HttpStatus.OK);
        SecondProductPictrueExample secondProductPictrueExample = new SecondProductPictrueExample();
        secondProductPictrueExample.createCriteria().andProductIdEqualTo(productId)
                .andIsDeletedEqualTo((short) 0)
                .andFileEqualTo(file);
        SecondProductPictrue secondProductPictrue = new SecondProductPictrue();
        secondProductPictrue.setIsDeleted((short) 1);
        secondProductPictrueMapper.updateByExampleSelective(secondProductPictrue, secondProductPictrueExample);
        fileDelete2(file);
        return builder.body(ResponseUtils.getResponseBody(0));
    }

    /**
     * 商品详情
     */
    @ApiOperation(value = "获取商品详情", notes = "获取商品详情")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "productId", value = "商品id", required = false, type = "Integer"),
    })
    @RequestMapping(value = "/selectProductDetail", method = RequestMethod.GET)
    public ResponseEntity<JSONObject> selectProductDetail(
            @RequestParam(name = "productId", required = false) Integer productId
    )
            throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder(HttpStatus.OK);
        Object productString = redisTemplate.opsForValue().get(String.valueOf(productId) + "detail");
        if (productString != null) {
            System.out.println("走redis");
            List<ProductList> list = JSON.parseObject(String.valueOf(productString), new TypeReference<List<ProductList>>() {
            });
            return builder.body(ResponseUtils.getResponseBody(list));
        } else {
            //商品列表
            List<SecondProduct> secondProducts = new ArrayList<>();
            SecondProductExample secondProductExample = new SecondProductExample();
            secondProductExample.createCriteria().andIsDeletedEqualTo((short) 0)
                    .andIdEqualTo(productId);
            secondProducts = secondProductMapper.selectByExampleWithBLOBs(secondProductExample);
            List<ProductList> productLists = new ArrayList<>();
            secondProducts.forEach(secondProduct -> {
                SecondUserSonExample secondUserSonExample = new SecondUserSonExample();
                secondUserSonExample.createCriteria().andStoreIdEqualTo(secondProduct.getStoreId())
                        .andIsDeletedEqualTo((byte) 0);
                List<SecondUserSon> secondUserSons =
                        secondUserSonMapper.selectByExample(secondUserSonExample);
                //站点
                SecondSon secondSon = new SecondSon();
                if (secondUserSons.size() != 0) {
                    secondSon = secondSonMapper.selectByPrimaryKey(secondUserSons.get(0).getSonId());
                }
                ProductList productList = new ProductList();
                if (secondSon.getId() != null) {
                    productList.setSonId(secondSon.getId());
                } else {
                    productList.setSonId(0);
                }
                //物品
                SecondGoodsExample secondGoodsExample = new SecondGoodsExample();
                secondGoodsExample.createCriteria()
                        .andProductIdEqualTo(secondProduct.getId())
                        .andIsDeletedEqualTo((short) 0);
                List<SecondGoods> secondGoods =
                        secondGoodsMapper.selectByExample(secondGoodsExample);
                productList.setPrice(secondGoods.get(0).getSellPrice());
                productList.setGoodsId(secondGoods.get(0).getId());
                //收藏
                SecondProductWantExample secondProductWantExample = new SecondProductWantExample();
                secondProductWantExample.createCriteria().andProductIdEqualTo(secondProduct.getId())
                        .andTypeEqualTo(WantEnum.Relation.COLLECT.getState())
                        .andIsDeletedEqualTo((short) 0);
                List<SecondProductWant> secondProductWants =
                        secondProductWantMapper.selectByExample(secondProductWantExample);
                productList.setCollect(secondProductWants.size());
                //点赞
                secondProductWantExample.clear();
                secondProductWantExample.createCriteria()
                        .andTypeEqualTo(WantEnum.Relation.PRAISE.getState())
                        .andProductIdEqualTo(secondProduct.getId())
                        .andIsDeletedEqualTo((short) 0);
                secondProductWants = secondProductWantMapper.selectByExample(secondProductWantExample);
                productList.setPraise(secondProductWants.size());
                //浏览
                secondProductWantExample.clear();
                secondProductWantExample.createCriteria()
                        .andTypeEqualTo(WantEnum.Relation.LOOK.getState())
                        .andProductIdEqualTo(secondProduct.getId())
                        .andIsDeletedEqualTo((short) 0);
                secondProductWants = secondProductWantMapper.selectByExample(secondProductWantExample);
                productList.setLook(secondProductWants.size());
                //想要
                secondProductWantExample.clear();
                secondProductWantExample.createCriteria()
                        .andTypeEqualTo(WantEnum.Relation.WANT.getState())
                        .andProductIdEqualTo(secondProduct.getId())
                        .andIsDeletedEqualTo((short) 0);
                secondProductWants = secondProductWantMapper.selectByExample(secondProductWantExample);
                productList.setWant(secondProductWants.size());


                productList.setId(secondProduct.getId());//商品id
                productList.setProductName(secondProduct.getProductName());//商品名称
                productList.setProductDesc(secondProduct.getProductDesc());//描述
                productList.setProductType(secondProduct.getProductType());//商品类型
                productList.setShowType(secondProduct.getShowType());//展示类型
                productList.setIsPutaway(secondProduct.getIsPutaway());//是否上架
                productList.setCreateTime(secondProduct.getCreateTime());//商品创建时间
                /**
                 * 商品图片
                 */
                SecondProductPictrueExample secondProductPictrueExample = new SecondProductPictrueExample();
                secondProductPictrueExample.createCriteria().andIsDeletedEqualTo((short) 0)
                        .andProductIdEqualTo(secondProduct.getId());
                List<SecondProductPictrue> secondProductPictrues =
                        secondProductPictrueMapper.selectByExample(secondProductPictrueExample);
                if (secondProductPictrues.size() != 0) {
                    List<String> files = new ArrayList<>();
                    secondProductPictrues.forEach(secondProductPictrue -> {
                        files.add(secondProductPictrue.getFile());
                    });
                    productList.setFiles(files);
                }
                /**
                 * 店铺
                 */
                SecondStore secondStore = secondStoreMapper.selectByPrimaryKey(secondProduct.getStoreId());
                productList.setStoreId(secondProduct.getStoreId());//店铺id
                productList.setStoreType(secondStore.getStoreType());//店铺类型
                productList.setStoreName(secondStore.getStoreName());//店铺名称
                productList.setConcernCount(secondStore.getConcernCount());//店铺关注人数
                productList.setSecondStatus(secondStore.getSecondStatus());//店铺状态
                productList.setIsStoreDeleted(secondStore.getIsDeleted());//
                /**
                 * 用户
                 */
                SecondUser secondUser = secondUserMapper.selectByPrimaryKey(secondStore.getUserId());
                productList.setUserId(secondStore.getUserId());
                productList.setNickName(secondUser.getNickName());
                productList.setIsAuthentication(secondUser.getIsAuthentication());
                productList.setUserFile(secondUser.getFile());
                /**
                 * 地址
                 */
                SecondProductAddressExample secondProductAddressExample = new SecondProductAddressExample();
                secondProductAddressExample.createCriteria().andProductIdEqualTo(secondProduct.getId())
                        .andIsDeletedEqualTo((short) 0);
                List<SecondProductAddress> secondProductAddresss = secondProductAddressMapper.selectByExample(secondProductAddressExample);
                if (secondProductAddresss.size() != 0) {
                    productList.setAddressId(secondProduct.getAddressId());
                    productList.setProvince(secondProductAddresss.get(0).getSecondProvince());//省
                    productList.setCity(secondProductAddresss.get(0).getSecondCity());//市
                    productList.setConty(secondProductAddresss.get(0).getSecondConty());//区/县
                    productList.setAddressDetail(secondProductAddresss.get(0).getSecondAddressDetail());//地址详情
                    productList.setLongitude(secondProductAddresss.get(0).getLongitude());//经度
                    productList.setLatitude(secondProductAddresss.get(0).getLatitude());//纬度
                    productList.setPhone(secondProductAddresss.get(0).getPhoneNumber());//电话
                    productList.setAddressDesc(secondProductAddresss.get(0).getSecondDesc());//描述
                }

                /**
                 * 学校
                 * 根据用户id查询认证
                 */
                SecondAuthenticationExample secondAuthenticationExample = new SecondAuthenticationExample();
                secondAuthenticationExample.createCriteria().andUserIdEqualTo(secondUser.getId())
                        .andAuthenticationStateEqualTo(Authentication.State.PASS.getState())
                        .andIsDeletedEqualTo((byte) 0);
                List<SecondAuthentication> secondAuthentications =
                        secondAuthenticationMapper.selectByExample(secondAuthenticationExample);
                if (secondAuthentications.size() != 0) {
                    SecondColleges secondColleges =
                            secondCollegesMapper.selectByPrimaryKey(secondAuthentications.get(0).getCollegesId());
                    productList.setColleges(secondColleges.getName());
                    productList.setRecord(secondColleges.getRecord());
                }
                /**
                 * 标签 根据商品id获取商品标签
                 */
                SecondProductLabelExample secondProductLabelExample = new SecondProductLabelExample();
                secondProductLabelExample.createCriteria().andIsDeletedEqualTo((short) 0)
                        .andProductIdEqualTo(secondProduct.getId());
                List<SecondProductLabel> secondProductLabels =
                        secondProductLabelMapper.selectByExample(secondProductLabelExample);
                if (secondProductLabels.size() != 0) {
                    List<String> files = new ArrayList<>();
                    secondProductLabels.forEach(secondProductLabel -> {
                        SecondLabel secondLabel = secondLabelMapper.selectByPrimaryKey(secondProductLabel.getLabelId());
                        files.add(secondLabel.getLabelName());
                    });
                    productList.setLabelName(files);
                }
                productLists.add(productList);
            });
            List<ProductList> productLists1 =
                    productLists.stream().filter(a -> a.getIsStoreDeleted() == 0 && a.getSecondStatus() == 0)
                            .collect(Collectors.toList());
            String besnString = JSONObject.toJSONString(productLists1);
            redisTemplate.opsForValue().set(String.valueOf(productId) + "detail", besnString);
            return builder.body(ResponseUtils.getResponseBody(productLists1));
        }
    }

    @RequestMapping(path = "/deleted", method = RequestMethod.POST)
    @ApiOperation(value = "删除redis", notes = "删除redis")
    public void deleted(
            @RequestParam(name = "key", required = false) String key
    ) {
        //String.valueOf(productId)+"detail" 商品详情key
        //String.valueOf(sonId)+"ProductSon" 子站点商品列表
        //String.valueOf(categoryId)+"ProductCategory" 分类商品列表
        redisTemplate.delete(key);
    }

    /**
     * 上下架宝贝
     */
    @ApiOperation(value = "上下架宝贝", notes = "上下架宝贝")
    @RequestMapping(value = "/IsPutaway", method = RequestMethod.POST)
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public ResponseEntity<JSONObject> IsPutaway(Integer[] productsId, Integer isPutaway) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder(HttpStatus.OK);
        for (Integer productId : productsId) {
            SecondProduct secondProduct = new SecondProduct();
            secondProduct.setId(productId);
            secondProduct.setIsPutaway(isPutaway);
            secondProduct.setModifyTime(LocalDateTime.now());
            secondProductMapper.updateByPrimaryKeySelective(secondProduct);
        }
        return builder.body(ResponseUtils.getResponseBody(0));
    }
    //
    //每隔2秒执行一次
//    @Scheduled(fixedRate = 2000)
//    public void testTasks() {
//        System.out.println("定时任务执行时间：");
//    }
    /**
     * 通过经纬度获取距离(单位：米)
     *
     * @param lat1 维度
     * @param lng1 经度
     * @param lat2
     * @param lng2
     * @return 距离
     */
    private static double EARTH_RADIUS = 6378.137;

    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    public static double getDistance(Double lat1, Double lng1, Double lat2,
                                     Double lng2) {
        if (lat1==0||lng1==0||lat2==0||lng2==0){
            return 3;
        }
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
                + Math.cos(radLat1) * Math.cos(radLat2)
                * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000d) / 10000d;
//        s = s * 1000;//单位m

//        System.out.println(s);//单位公里
        return s;
    }
}
