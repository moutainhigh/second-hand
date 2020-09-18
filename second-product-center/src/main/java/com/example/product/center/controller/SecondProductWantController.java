package com.example.product.center.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.product.center.dao.SecondProductWantMapper;
import com.example.product.center.manual.WantEnum;
import com.example.product.center.model.SecondProductWant;
import com.example.product.center.model.SecondProductWantExample;
import com.second.utils.response.handler.ResponseEntity;
import com.second.utils.response.handler.ResponseUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
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
     * 查询是否收藏了该商品
     */
    @RequestMapping(path = "/selectProductCollect", method = RequestMethod.POST)
    @ApiOperation(value = "查询是否收藏了该商品", notes = "查询是否收藏了该商品,0关注,1没")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "productId", value = "商品id", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "userId", value = "用户id", required = true, type = "Integer"),
    })
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public ResponseEntity<JSONObject> selectProductCollect(
            @RequestParam(value = "productId", required = false) Integer productId,
            @RequestParam(value = "userId", required = false) Integer userId
    ) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
        Object is = redisTemplate.opsForValue().get(userId.toString()+productId.toString()+"Collect");
        if (is!=null){
            System.out.println("走redis");
            return builder.body(ResponseUtils.getResponseBody(is));
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
                return builder.body(ResponseUtils.getResponseBody(0));
            } else {
                redisTemplate.opsForValue().set(userId.toString()+productId.toString()+"Collect",1);
                return builder.body(ResponseUtils.getResponseBody(1));
            }
        }
    }
}
