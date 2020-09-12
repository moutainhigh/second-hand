package com.example.product.center.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.product.center.dao.*;
import com.example.product.center.manual.IntegralEnum;
import com.example.product.center.manual.ProductEnum;
import com.example.product.center.model.*;
import com.second.utils.response.handler.ResponseEntity;
import com.second.utils.response.handler.ResponseUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

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
}
