package com.example.product.center.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.product.center.dao.*;
import com.example.product.center.manual.Authentication;
import com.example.product.center.manual.ProductEnum;
import com.example.product.center.manual.ProductList;
import com.example.product.center.model.*;
import com.second.common.service.FileMangeService;
import com.second.utils.response.handler.ResponseEntity;
import com.second.utils.response.handler.ResponseUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
    //地址
    @Autowired
    private SecondStoreAddressMapper secondUserAddressMapper;
    //学校
    @Autowired
    private SecondCollegesMapper secondCollegesMapper;
    //学生认证
    @Autowired
    private SecondAuthenticationMapper secondAuthenticationMapper;
    //文件
    @Autowired
    private SecondFileMapper secondFileMapper;
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
            @RequestParam(value = "storeId", required = false) Integer storeId

    ) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
        SecondProduct secondProduct = new SecondProduct();
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
        if (file.length!=0){
            for (String fie : file){
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
        if (labelIds.length!=0){
            for (Integer labelId : labelIds){
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
            @ApiImplicitParam(paramType = "query", name = "productId", value = "商品id", required = true, type = "Integer"),
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

        if (file1!=null){
            fileDelete2(secondProductMapper.selectByPrimaryKey(productId).getFile());
        }
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
        //物品
        SecondGoodsExample secondGoodsExample = new SecondGoodsExample();
        secondGoodsExample.createCriteria().andIsDeletedEqualTo((short) 0)
                .andProductIdEqualTo(productId);
        SecondGoods secondGoods = new SecondGoods();
        secondGoods.setSellPrice(sellPrice);
        secondGoods.setLinePrice(linePrice);
        secondGoods.setGoodsResp(goodsResp);
        secondGoods.setModifyTime(LocalDateTime.now());
        secondGoodsMapper.updateByExampleSelective(secondGoods,secondGoodsExample);
        //商品图片
        if (file.length!=0){
            for (String fie : file){
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
        if (labelIds.length!=0){
            for (Integer labelId : labelIds){
                SecondProductLabelExample secondProductLabelExample = new SecondProductLabelExample();
                secondProductLabelExample.createCriteria().andProductIdEqualTo(productId)
                        .andIsDeletedEqualTo((short) 0)
                        .andLabelIdEqualTo(labelId);
                SecondProductLabel secondProductLabel = new SecondProductLabel();
                secondProductLabel.setProductId(secondProduct.getId());
                secondProductLabel.setLabelId(labelId);
                secondProductLabel.setModifyTime(LocalDateTime.now());
                secondProductLabelMapper.updateByExampleSelective(secondProductLabel,secondProductLabelExample);
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
        SecondProduct secondProduct = new SecondProduct();
        secondProduct.setId(productId);
        secondProduct.setIsDeleted((short) 0);
        secondProductMapper.updateByPrimaryKeySelective(secondProduct);
        return builder.body(ResponseUtils.getResponseBody(0));
    }
    @ApiOperation(value = "获取商品", notes = "获取商品")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "parentCategoryId", value = "上级的类目id", required = false, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "levelId", value = "类目级别", required = false, type = "Integer")})
    @RequestMapping(value = "/selectProduct", method = RequestMethod.GET)
    public ResponseEntity<JSONObject> selectProduct(
            @RequestParam(name = "parentCategoryId", required = false) Integer parentCategoryId,
            @RequestParam(name = "levelId", required = false) Integer levelId
    )
            throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder(HttpStatus.OK);
        //商品列表
        List<SecondProduct> secondProducts = new ArrayList<>();
        SecondProductExample secondProductExample = new SecondProductExample();
        secondProductExample.createCriteria().andIsDeletedEqualTo((short) 0)
                .andIsPutawayEqualTo(ProductEnum.IsPutaway.PUTAWAY.getState())
                .andProductTypeEqualTo(ProductEnum.Relation.GENERAL.getState());
        secondProducts = secondProductMapper.selectByExample(secondProductExample);
        List<ProductList> productLists = new ArrayList<>();
        secondProducts.forEach(secondProduct -> {
            ProductList productList = new ProductList();
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
            if (secondProductPictrues.size()!=0){
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
            productList.setStoreId(secondProduct.getId());//店铺id
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
            SecondStoreAddress secondUserAddress = secondUserAddressMapper.selectByPrimaryKey(secondProduct.getAddressId());
            productList.setAddressId(secondProduct.getAddressId());
            productList.setProvince(secondUserAddress.getSecondProvince());//省
            productList.setCity(secondUserAddress.getSecondCity());//市
            productList.setConty(secondUserAddress.getSecondConty());//区/县
            productList.setAddressDetail(secondUserAddress.getSecondAddressDetail());//地址详情
            productList.setLongitude(secondUserAddress.getLongitude());//经度
            productList.setLatitude(secondUserAddress.getLatitude());//纬度
            productList.setPhone(secondUserAddress.getContact());//电话
            productList.setAddressDesc(secondUserAddress.getSecondDesc());//描述
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
            if (secondAuthentications.size()!=0){
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
            if (secondProductLabels.size() != 0){
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
        productLists1 = productLists.stream().filter(a->a.getIsStoreDeleted()==0&&a.getSecondStatus()==0)
                .collect(Collectors.toList());
        return builder.body(ResponseUtils.getResponseBody(productLists1));
    }
    public ResponseEntity<JSONObject> fileDelete2(String file) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder(HttpStatus.OK);
        String str1=file.substring(0, file.indexOf("="));
        String str2=file.substring(str1.length()+1, file.length());

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
    public ResponseEntity<JSONObject> fileDeleteProduct(String file,Integer productId) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder(HttpStatus.OK);
        SecondProductPictrueExample secondProductPictrueExample = new SecondProductPictrueExample();
        secondProductPictrueExample.createCriteria().andProductIdEqualTo(productId)
                .andIsDeletedEqualTo((short) 0)
                .andFileEqualTo(file);
        SecondProductPictrue secondProductPictrue = new SecondProductPictrue();
        secondProductPictrue.setIsDeleted((short) 1);
        secondProductPictrueMapper.updateByExampleSelective(secondProductPictrue,secondProductPictrueExample);
        fileDelete2(file);
        return builder.body(ResponseUtils.getResponseBody(0));
    }
}
