package com.example.product.center.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.product.center.dao.SecondGoodsMapper;
import com.example.product.center.dao.SecondProductMapper;
import com.example.product.center.dao.SecondProductWantMapper;
import com.example.product.center.manual.WantEnum;
import com.example.product.center.manual.WantProductList;
import com.example.product.center.model.*;
import com.example.product.center.service.Impl.WantProductServiceImpl;
import com.example.product.center.service.WantProductService;
import com.second.utils.response.handler.ResponseEntity;
import com.second.utils.response.handler.ResponseUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shihao
 * @Title: SecondProductWantController
 * @ProjectName Second-order-center
 * @Description: 商品点赞浏览想要
 * @date Created in
 * @Version: $
 */
@RestController
@Api
@RequestMapping("/SecondProductWant")
@CrossOrigin
public class SecondProductWantController {
    @Autowired
    private SecondProductWantMapper secondProductWantMapper;
    @Resource
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private SecondProductMapper secondProductMapper;
    @Autowired
    private SecondGoodsMapper secondGoodsMapper;
    //点赞查询
    @Autowired
    private WantProductService wantProductService;

    @RequestMapping(path = "/addProduct", method = RequestMethod.POST)
    @ApiOperation(value = "商品操作", notes = "商品操作")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "productId", value = "商品id", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "userId", value = "用户id", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "type", value = "操作类型", required = true, type = "String"),
    })
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public ResponseEntity<JSONObject> addProduct(
            @RequestParam(value = "productId", required = false) Integer productId,
            @RequestParam(value = "type", required = false) String type,
            @RequestParam(value = "userId", required = false) Integer userId
    ) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
        SecondProductWantExample secondProductWantExample = new SecondProductWantExample();
        secondProductWantExample.createCriteria()
                .andProductIdEqualTo(productId)
                .andIsDeletedEqualTo((short) 0)
                .andTypeEqualTo(WantEnum.Relation.getState(type).getState())
                .andUserIdEqualTo(userId);
        List<SecondProductWant> secondProductWants =
                secondProductWantMapper.selectByExample(secondProductWantExample);
        if (secondProductWants.size()==0){
            SecondProductWant secondProductWant = new SecondProductWant();
            secondProductWant.setUserId(userId);
            secondProductWant.setProductId(productId);
            secondProductWant.setType(WantEnum.Relation.getState(type).getState());
            secondProductWant.setCreateTime(LocalDateTime.now());
            secondProductWant.setModifyTime(LocalDateTime.now());
            secondProductWant.setIsDeleted((short) 0);
            secondProductWantMapper.insertSelective(secondProductWant);
        } else {
            SecondProductWant secondProductWant = secondProductWants.get(0);
            secondProductWant.setModifyTime(LocalDateTime.now());
            secondProductWantMapper.updateByPrimaryKeySelective(secondProductWant);
        }
        return builder.body(ResponseUtils.getResponseBody(0));
    }
    @RequestMapping(path = "/deleteProduct", method = RequestMethod.POST)
    @ApiOperation(value = "取消商品操作", notes = "取消商品操作")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "productId", value = "商品id", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "userId", value = "用户id", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "type", value = "操作类型", required = true, type = "String"),
    })
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public ResponseEntity<JSONObject> deleteProduct(
            @RequestParam(value = "productId", required = false) Integer productId,
            @RequestParam(value = "type", required = false) String type,
            @RequestParam(value = "userId", required = false) Integer userId
    ) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
        SecondProductWantExample secondProductWantExample = new SecondProductWantExample();
        secondProductWantExample.createCriteria()
                .andIsDeletedEqualTo((short) 0)
                .andProductIdEqualTo(productId)
                .andTypeEqualTo(WantEnum.Relation.getState(type).getState())
                .andUserIdEqualTo(userId);
        List<SecondProductWant> secondProductWants =
                secondProductWantMapper.selectByExample(secondProductWantExample);
        if (secondProductWants.size()!=0){
            SecondProductWant secondProductWant = secondProductWants.get(0);
            secondProductWant.setModifyTime(LocalDateTime.now());
            secondProductWant.setIsDeleted((short) 1);
            secondProductWantMapper.updateByPrimaryKeySelective(secondProductWant);
        }
        return builder.body(ResponseUtils.getResponseBody(0));
    }
    /**
     * 收藏和取消收藏
     */
    @RequestMapping(path = "/addProductCollect", method = RequestMethod.GET)
    @ApiOperation(value = "收藏和取消收藏", notes = "收藏和取消收藏")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "productId", value = "商品id", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "userId", value = "用户id", required = true, type = "Integer"),
    })
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public ResponseEntity<JSONObject> addProductCollect(
            @RequestParam(value = "productId", required = false) Integer productId,
            @RequestParam(value = "userId", required = false) Integer userId
    ) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
        SecondProductWantExample secondProductWantExample = new SecondProductWantExample();
        secondProductWantExample.createCriteria()
                .andProductIdEqualTo(productId)
//                .andIsDeletedEqualTo((short) 0)
                .andTypeEqualTo(WantEnum.Relation.COLLECT.getState())
                .andUserIdEqualTo(userId);
        List<SecondProductWant> secondProductWants =
                secondProductWantMapper.selectByExample(secondProductWantExample);
        if (secondProductWants.size()==0){
            SecondProductWant secondProductWant = new SecondProductWant();
            secondProductWant.setUserId(userId);
            secondProductWant.setProductId(productId);
            secondProductWant.setType(WantEnum.Relation.COLLECT.getState());
            secondProductWant.setCreateTime(LocalDateTime.now());
            secondProductWant.setModifyTime(LocalDateTime.now());
            secondProductWant.setIsDeleted((short) 0);
            secondProductWantMapper.insertSelective(secondProductWant);
            //添加收藏
            redisTemplate.opsForValue().set(userId.toString()+productId.toString()+"Collect",0);
            return builder.body(ResponseUtils.getResponseBody(0));
        } else {
            if (secondProductWants.get(0).getIsDeleted()==0){
                SecondProductWant secondProductWant = secondProductWants.get(0);
                secondProductWant.setModifyTime(LocalDateTime.now());
                secondProductWant.setIsDeleted((short) 1);
                //取消收藏
                redisTemplate.opsForValue().set(userId.toString()+productId.toString()+"Collect",1);
                secondProductWantMapper.updateByPrimaryKeySelective(secondProductWant);
                return builder.body(ResponseUtils.getResponseBody(0));
            } else if (secondProductWants.get(0).getIsDeleted()==1){
                SecondProductWant secondProductWant = secondProductWants.get(0);
                secondProductWant.setIsDeleted((short) 0);
                secondProductWant.setModifyTime(LocalDateTime.now());
                //添加收藏
                redisTemplate.opsForValue().set(userId.toString()+productId.toString()+"Collect",0);
                secondProductWantMapper.updateByPrimaryKeySelective(secondProductWant);
                return builder.body(ResponseUtils.getResponseBody(0));
            }
        }
        return builder.body(ResponseUtils.getResponseBody(0));
    }
    /**
     * 收藏商品列表
     */
    @RequestMapping(path = "/selectProductCollect", method = RequestMethod.GET)
    @ApiOperation(value = "收藏，浏览,商品列表", notes = "收藏商品列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "userId", value = "用户id", required = true, type = "Integer"),
    })
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public ResponseEntity<JSONObject> selectProductCollect(
            @RequestParam(value = "userId", required = false) Integer userId,
            String type
    ) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
        SecondProductWantExample secondProductWantExample = new SecondProductWantExample();
        secondProductWantExample.createCriteria().andTypeEqualTo(type)
                .andIsDeletedEqualTo((short) 0)
                .andUserIdEqualTo(userId);
        secondProductWantExample.setOrderByClause("create_Time desc");
        List<WantProductList> wantProductLists = new ArrayList<>();
        List<SecondProductWant> secondProductWants =
        secondProductWantMapper.selectByExample(secondProductWantExample);
        secondProductWants.forEach(secondProductWant -> {
            WantProductList wantProductList = new WantProductList();
            wantProductList.setProductId(secondProductWant.getProductId());
            SecondProduct secondProduct = secondProductMapper.selectByPrimaryKey(secondProductWant.getProductId());
            wantProductList.setProductFile(secondProduct.getFile());
            wantProductList.setProductName(secondProduct.getProductName());
            wantProductList.setProductState(secondProduct.getProductState());
            SecondGoodsExample secondGoodsExample = new SecondGoodsExample();
            secondGoodsExample.createCriteria().andProductIdEqualTo(secondProductWant.getProductId())
                    .andIsDeletedEqualTo((short) 0);
            List<SecondGoods> secondGoods = secondGoodsMapper.selectByExample(secondGoodsExample);
            wantProductList.setPrice(secondGoods.get(0).getSellPrice());
            wantProductList.setIsWant(selectProductCollect(secondProductWant.getProductId(),userId));
            //想要数量
            secondProductWantExample.clear();
            secondProductWantExample.createCriteria().andUserIdEqualTo(userId)
                    .andIsDeletedEqualTo((short) 0)
                    .andTypeEqualTo(WantEnum.Relation.WANT.getState());
            List<SecondProductWant> secondProductWantList =
            secondProductWantMapper.selectByExample(secondProductWantExample);
            wantProductList.setWantNumber(secondProductWantList.size());
            wantProductLists.add(wantProductList);
        });
        return builder.body(ResponseUtils.getResponseBody(wantProductLists));
    }
    /**
     * 查询是否收藏了该商品
     */
    @RequestMapping(path = "/selectProductCollect", method = RequestMethod.POST)
    @ApiOperation(value = "查询是否收藏了该商品", notes = "查询是否收藏了该商品,0关注,1没")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "productId", value = "商品id", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "userId", value = "用户id", required = true, type = "Integer"),
    })
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public Integer selectProductCollect(
            @RequestParam(value = "productId", required = false) Integer productId,
            @RequestParam(value = "userId", required = false) Integer userId
    ){
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
        Object is = redisTemplate.opsForValue().get(userId.toString()+productId.toString()+"Collect");
        if (is!=null){
            System.out.println("走redis");
            return (Integer) is;
        }else {
            SecondProductWantExample secondProductWantExample = new SecondProductWantExample();
            secondProductWantExample.createCriteria()
                    .andProductIdEqualTo(productId)
                    .andIsDeletedEqualTo((short) 0)
                    .andTypeEqualTo(WantEnum.Relation.COLLECT.getState())
                    .andUserIdEqualTo(userId);
            List<SecondProductWant> secondProductWants =
                    secondProductWantMapper.selectByExample(secondProductWantExample);
            if (secondProductWants.size()!=0){
                redisTemplate.opsForValue().set(userId.toString()+productId.toString()+"Collect",0);
                return 0;
            } else {
                redisTemplate.opsForValue().set(userId.toString()+productId.toString()+"Collect",1);
                return 1;
            }
        }
    }
    /**
     * 查询今天是否点赞了商品
     */
    @RequestMapping(path = "/selectProductPraise", method = RequestMethod.GET)
    @ApiOperation(value = "查询今天是否点赞了商品", notes = "查询是否收藏了该商品,0没,1点了")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "productId", value = "商品id", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "userId", value = "用户id", required = true, type = "Integer"),
    })
    public ResponseEntity<JSONObject> selectProductPraise(
            @RequestParam(value = "productId", required = false) Integer productId,
            @RequestParam(value = "userId", required = false) Integer userId
    ) throws JSONException {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
        Integer a;
        List<SecondProductWant> secondProductWants =
        wantProductService.selectProductPraise(userId,WantEnum.Relation.PRAISE.getState(),productId);
        if (secondProductWants.size()!=0){
            a=1;
        }else {
            a=0;
        }
        return builder.body(ResponseUtils.getResponseBody(a));
    }

    /**
     * 点赞和取消点赞
     */
    @RequestMapping(path = "/addProductPraise", method = RequestMethod.GET)
    @ApiOperation(value = "点赞和取消点赞", notes = "点赞和取消点赞")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "productId", value = "商品id", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "userId", value = "用户id", required = true, type = "Integer"),
    })
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public ResponseEntity<JSONObject> addProductPraise(
            @RequestParam(value = "productId", required = false) Integer productId,
            @RequestParam(value = "userId", required = false) Integer userId
    ) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
        List<SecondProductWant> secondProductWants =
                wantProductService.selectProductPraise1(userId,WantEnum.Relation.PRAISE.getState(),productId);
        if (secondProductWants.size()==0){
            SecondProductWant secondProductWant = new SecondProductWant();
            secondProductWant.setUserId(userId);
            secondProductWant.setProductId(productId);
            secondProductWant.setType(WantEnum.Relation.PRAISE.getState());
            secondProductWant.setCreateTime(LocalDateTime.now());
            secondProductWant.setModifyTime(LocalDateTime.now());
            secondProductWant.setIsDeleted((short) 0);
            secondProductWantMapper.insertSelective(secondProductWant);
            //添加点赞
            redisTemplate.opsForValue().set(userId.toString()+productId.toString()+"Praise",0);
            return builder.body(ResponseUtils.getResponseBody(0));
        } else {
            if (secondProductWants.get(0).getIsDeleted()==0){
                SecondProductWant secondProductWant = secondProductWants.get(0);
                secondProductWant.setModifyTime(LocalDateTime.now());
                secondProductWant.setIsDeleted((short) 1);
                //取消点赞
                redisTemplate.opsForValue().set(userId.toString()+productId.toString()+"Praise",1);
                secondProductWantMapper.updateByPrimaryKeySelective(secondProductWant);
                return builder.body(ResponseUtils.getResponseBody(0));
            } else if (secondProductWants.get(0).getIsDeleted()==1){
                SecondProductWant secondProductWant = secondProductWants.get(0);
                secondProductWant.setIsDeleted((short) 0);
                secondProductWant.setModifyTime(LocalDateTime.now());
                //添加点赞
                redisTemplate.opsForValue().set(userId.toString()+productId.toString()+"Praise",0);
                secondProductWantMapper.updateByPrimaryKeySelective(secondProductWant);
                return builder.body(ResponseUtils.getResponseBody(0));
            }
        }
        return builder.body(ResponseUtils.getResponseBody(0));
    }
}
