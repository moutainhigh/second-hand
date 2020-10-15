package com.example.order.center.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.order.center.dao.SecondEvaluateFileMapper;
import com.example.order.center.dao.SecondEvaluateMapper;
import com.example.order.center.dao.SecondOrderDetailMapper;
import com.example.order.center.dao.SecondUserMapper;
import com.example.order.center.manual.Evaluate;
import com.example.order.center.manual.goods;
import com.example.order.center.model.*;
import com.second.utils.response.handler.ResponseEntity;
import com.second.utils.response.handler.ResponseUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shihao
 * @Title: EvaluateController
 * @ProjectName Second-order-center
 * @Description: 评价
 * @date Created in
 * @Version: $
 */
@RestController
@Api
@RequestMapping("/Evaluate")
@CrossOrigin
public class EvaluateController {
    //详情
    @Autowired
    private SecondOrderDetailMapper secondOrderDetailMapper;
    //评价
    @Autowired
    private SecondEvaluateMapper secondEvaluateMapper;
    //评价图
    @Autowired
    private SecondEvaluateFileMapper secondEvaluateFileMapper;
    //用户
    @Autowired
    private SecondUserMapper secondUserMapper;
    @ApiOperation(value = "添加评价", notes = "添加评价")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "userId", value = "用户id", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "storeId", value = "店铺id", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "orderDetails", value = "订单详情id", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "files", value = "评价图", required = true, type = "List<String>"),
            @ApiImplicitParam(paramType = "query", name = "evaluate", value = "评价内容", required = true, type = "String"),
            @ApiImplicitParam(paramType = "query", name = "parentEvaluateId", value = "父级评价id", required = true, type = "Integer"),
    })
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    @RequestMapping(value = "/addEvaluate", method = RequestMethod.POST)
    public ResponseEntity<JSONObject> addEvaluate(Integer userId,
                                                Integer storeId,
                                                Integer orderDetails,
                                                String evaluate,
                                                Integer parentEvaluateId,
                                                List<String> files)
            throws JSONException {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
        SecondOrderDetail secondOrderDetail = secondOrderDetailMapper.selectByPrimaryKey(orderDetails);
        SecondEvaluate secondEvaluate = new SecondEvaluate();
        secondEvaluate.setGoodsId(secondOrderDetail.getGoodsId());//物品id
        secondEvaluate.setUserId(userId);
        secondEvaluate.setOrderDetailId(orderDetails);//详情id,防止后续购物车
        secondEvaluate.setParentEvaluateId(parentEvaluateId);
        secondEvaluate.setEvaluate(evaluate);
        secondEvaluate.setCreateTime(LocalDateTime.now());
        secondEvaluate.setModifyTime(LocalDateTime.now());
        secondEvaluate.setIsDeleted((short) 0);
        secondEvaluateMapper.insertSelective(secondEvaluate);
        //
        for (String file : files){
            SecondEvaluateFile secondEvaluateFile = new SecondEvaluateFile();
            secondEvaluateFile.setEvaluateId(secondEvaluate.getId());
            secondEvaluateFile.setFile(file);
            secondEvaluateFile.setCreateTime(LocalDateTime.now());
            secondEvaluateFile.setModifyTime(LocalDateTime.now());
            secondEvaluateFile.setIsDeleted((short) 0);
        }
        return builder.body(ResponseUtils.getResponseBody(0));
    }

    @ApiOperation(value = "查询评价", notes = "查询评价")

    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    @RequestMapping(value = "/selectEvaluate", method = RequestMethod.GET)
    public ResponseEntity<JSONObject> selectEvaluate(Integer userId,
                                                  Integer storeId,
                                                Integer goodsId)
            throws JSONException {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
        SecondEvaluateExample secondEvaluateExample = new SecondEvaluateExample();
        SecondEvaluateExample.Criteria criteria = secondEvaluateExample.createCriteria().andIsDeletedEqualTo((short) 0);
        if (userId!=null&&goodsId==null){
            criteria.andUserIdEqualTo(userId);
        }
        if (userId==null&&goodsId!=null){
            criteria.andGoodsIdEqualTo(goodsId);
        }
        List<SecondEvaluate> secondEvaluates =
        secondEvaluateMapper.selectByExampleWithBLOBs(secondEvaluateExample);
        List<Evaluate> evaluates = new ArrayList<>();
        secondEvaluates.forEach(secondEvaluate -> {
            Evaluate evaluate = new Evaluate();
            evaluate.setEvaluateId(secondEvaluate.getId());
            evaluate.setUserId(secondEvaluate.getUserId());
            SecondUser secondUser = secondUserMapper.selectByPrimaryKey(secondEvaluate.getUserId());
            evaluate.setUserFile(secondUser.getFile());
            evaluate.setNickName(secondUser.getNickName());
            evaluate.setGoodsId(secondEvaluate.getGoodsId());
            evaluate.setOrderdetailId(secondEvaluate.getOrderDetailId());
            evaluate.setEvaluate(secondEvaluate.getEvaluate());
            evaluate.setCreateTime(secondEvaluate.getCreateTime());
            //评价图
            SecondEvaluateFileExample secondEvaluateFileExample = new SecondEvaluateFileExample();
            secondEvaluateFileExample.createCriteria().andEvaluateIdEqualTo(secondEvaluate.getId())
                    .andIsDeletedEqualTo((short) 0);
            List<SecondEvaluateFile> secondEvaluateFiles =
                    secondEvaluateFileMapper.selectByExample(secondEvaluateFileExample);
            List<String> files = new ArrayList<>();
            secondEvaluateFiles.forEach(secondEvaluateFile -> {
                files.add(secondEvaluateFile.getFile());
            });
            evaluate.setEvaluateFiles(files);
            evaluates.add(evaluate);
        });
            return builder.body(ResponseUtils.getResponseBody(evaluates));
    }
}
