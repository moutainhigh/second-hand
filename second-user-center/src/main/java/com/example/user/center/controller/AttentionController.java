package com.example.user.center.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.user.center.dao.SecondAttentionMapper;
import com.example.user.center.dao.SecondUserMapper;
import com.example.user.center.manual.Attention;
import com.example.user.center.manual.AttentionList;
import com.example.user.center.model.SecondAttention;
import com.example.user.center.model.SecondAttentionExample;
import com.example.user.center.model.SecondAuthenticationPicture;
import com.example.user.center.model.SecondUser;
import com.second.utils.response.handler.ResponseEntity;
import com.second.utils.response.handler.ResponseUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shihao
 * @Title: AttentionController
 * @ProjectName Second-order-center
 * @Description: 关注
 * @date Created in
 * @Version: $
 */
@RestController
@Api
@RequestMapping("/Attention")
@CrossOrigin
public class AttentionController {
@Autowired
private SecondAttentionMapper secondAttentionMapper;//关注
    //用户
    @Autowired
    private SecondUserMapper secondUserMapper;
    @RequestMapping(path = "/addAttention", method = RequestMethod.POST)
    @ApiOperation(value = "添加关注用户", notes = "关注用户")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "userId", value = "关注人userId", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "byUserId", value = "被关注人userId", required = true, type = "Integer"),
    })
    public ResponseEntity<JSONObject> addAttention(
            @RequestParam(value = "userId", required = false) Integer userId,
            @RequestParam(value = "byUserId", required = false) Integer byUserId,
            HttpServletResponse response
    ) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
//        查询是否已经关注
        SecondAttentionExample secondAttentionExample = new SecondAttentionExample();
        secondAttentionExample.createCriteria().andUserIdEqualTo(userId)
                .andByUserIdEqualTo(byUserId)
                .andIsDeletedEqualTo((byte) 0);
        List<SecondAttention> secondAttentionList = secondAttentionMapper.selectByExample(secondAttentionExample);
        if (secondAttentionList.size()!=0){
            response.sendError(HttpStatus.FORBIDDEN.value(), "已经关注了");
            return builder.body(ResponseUtils.getResponseBody(1));
        } else {
            SecondAttention secondAttention = new SecondAttention();
            secondAttention.setUserId(userId);
            secondAttention.setByUserId(byUserId);
            secondAttention.setIsDeleted((byte) 0);
            secondAttention.setCreateDate(LocalDateTime.now());
            secondAttention.setModifyDate(LocalDateTime.now());
            secondAttentionMapper.insertSelective(secondAttention);
        }
        return builder.body(ResponseUtils.getResponseBody(0));
    }
    @RequestMapping(path = "/deleteAttention", method = RequestMethod.POST)
    @ApiOperation(value = "取消关注", notes = "取消关注")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "userId", value = "关注人userId", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "byUserId", value = "被关注人userId", required = true, type = "Integer"),
    })
    public ResponseEntity<JSONObject> deleteAttention(
            @RequestParam(value = "userId", required = false) Integer userId,
            @RequestParam(value = "byUserId", required = false) Integer byUserId,
            HttpServletResponse response
    ) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
//        查询是否已经关注
        SecondAttentionExample secondAttentionExample = new SecondAttentionExample();
        secondAttentionExample.createCriteria().andUserIdEqualTo(userId)
                .andByUserIdEqualTo(byUserId)
                .andIsDeletedEqualTo((byte) 0);
        List<SecondAttention> secondAttentionList = secondAttentionMapper.selectByExample(secondAttentionExample);
        if (secondAttentionList.size()==0){
            response.sendError(HttpStatus.FORBIDDEN.value(), "没有关注");
            return builder.body(ResponseUtils.getResponseBody(1));
        } else {
            SecondAttention secondAttention = new SecondAttention();
            secondAttention.setUserId(userId);
            secondAttention.setByUserId(byUserId);
            secondAttention.setIsDeleted((byte) 1);
            secondAttention.setModifyDate(LocalDateTime.now());
            secondAttentionMapper.updateByExampleSelective(secondAttention,secondAttentionExample);
        }
        return builder.body(ResponseUtils.getResponseBody(0));
    }
    @RequestMapping(path = "/selectMyAttention", method = RequestMethod.GET)
    @ApiOperation(value = "查看自己的关注", notes = "查看自己的关注")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "userId", value = "用户id", required = true, type = "Integer"),
    })
    public ResponseEntity<JSONObject> selectMyAttention(
            @RequestParam(value = "userId", required = false) Integer userId,
            HttpServletResponse response
    ) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
        SecondAttentionExample secondAttentionExample = new SecondAttentionExample();
        secondAttentionExample.createCriteria().andUserIdEqualTo(userId)
                .andIsDeletedEqualTo((byte) 0);
        List<SecondAttention> secondAttentions = secondAttentionMapper.selectByExample(secondAttentionExample);
        //关注列表
        List<AttentionList> attentions = new ArrayList<>();
        secondAttentions.forEach(secondAttention -> {
            //判断关注的关系
            //自己的关注
            SecondAttentionExample secondAttentionExample1 = new SecondAttentionExample();
            secondAttentionExample1.createCriteria().andUserIdEqualTo(userId)
                    .andByUserIdEqualTo(secondAttention.getByUserId())
                    .andIsDeletedEqualTo((byte) 0);
            List<SecondAttention> secondAttentionList = secondAttentionMapper.selectByExample(secondAttentionExample1);
            //自己的粉丝
            SecondAttentionExample secondAttentionExample2 = new SecondAttentionExample();
            secondAttentionExample2.createCriteria().andUserIdEqualTo(secondAttention.getByUserId())
                    .andByUserIdEqualTo(userId)
                    .andIsDeletedEqualTo((byte) 0);
            List<SecondAttention> secondAttentionList2 = secondAttentionMapper.selectByExample(secondAttentionExample2);
            //
            SecondUser secondUser = secondUserMapper.selectByPrimaryKey(secondAttention.getByUserId());
            AttentionList attentionList = new AttentionList();
            attentionList.setUserId(userId);
            attentionList.setByUserId(secondAttention.getByUserId());
            attentionList.setHead(secondUser.getFile());
            attentionList.setUserName(secondUser.getNickName());
            if (secondAttentionList.size()!=0 && secondAttentionList2.size()==0){
                attentionList.setRelation(Attention.Relation.YETATTENTION.getState());
            } //自己单向关注了
            if (secondAttentionList.size()!=0 && secondAttentionList2.size()!=0){
                attentionList.setRelation(Attention.Relation.EACHOTHER.getState());
            } //互相关注了
            if (secondAttentionList.size()==0 && secondAttentionList2.size()!=0){
                attentionList.setRelation(Attention.Relation.BYATTENTION.getState());
            }//单向关注了自己
            attentions.add(attentionList);
        });
        return builder.body(ResponseUtils.getResponseBody(attentions));
    }
    @RequestMapping(path = "/selectMyFans", method = RequestMethod.GET)
    @ApiOperation(value = "查看自己的粉丝", notes = "查看自己的粉丝")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "userId", value = "用户id", required = true, type = "Integer"),
    })
    public ResponseEntity<JSONObject> selectMyFans(
            @RequestParam(value = "userId", required = false) Integer userId,
            HttpServletResponse response
    ) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
        SecondAttentionExample secondAttentionExample = new SecondAttentionExample();
        secondAttentionExample.createCriteria().andByUserIdEqualTo(userId)
                .andIsDeletedEqualTo((byte) 0);
        List<SecondAttention> secondAttentions = secondAttentionMapper.selectByExample(secondAttentionExample);
        //粉丝列表
        List<AttentionList> attentions = new ArrayList<>();
        secondAttentions.forEach(secondAttention -> {
            //判断关注的关系
            //自己的关注
            SecondAttentionExample secondAttentionExample1 = new SecondAttentionExample();
            secondAttentionExample1.createCriteria().andUserIdEqualTo(secondAttention.getByUserId())
                    .andByUserIdEqualTo(userId)
                    .andIsDeletedEqualTo((byte) 0);
            List<SecondAttention> secondAttentionList = secondAttentionMapper.selectByExample(secondAttentionExample1);
            //自己的粉丝
            SecondAttentionExample secondAttentionExample2 = new SecondAttentionExample();
            secondAttentionExample2.createCriteria().andUserIdEqualTo(userId)
                    .andByUserIdEqualTo(secondAttention.getByUserId())
                    .andIsDeletedEqualTo((byte) 0);
            List<SecondAttention> secondAttentionList2 = secondAttentionMapper.selectByExample(secondAttentionExample2);

            //
            SecondUser secondUser = secondUserMapper.selectByPrimaryKey(secondAttention.getUserId());
            //
            AttentionList attentionList = new AttentionList();
            attentionList.setUserId(secondAttention.getByUserId());
            attentionList.setByUserId(userId);
            attentionList.setHead(secondUser.getFile());
            attentionList.setUserName(secondUser.getNickName());
            if (secondAttentionList.size()!=0 && secondAttentionList2.size()==0){
                attentionList.setRelation(Attention.Relation.YETATTENTION.getState());
            } //自己单向关注了
            if (secondAttentionList.size()==0 && secondAttentionList2.size()!=0){
                attentionList.setRelation(Attention.Relation.BYATTENTION.getState());
            }//单向关注了自己
            if (secondAttentionList.size()!=0 && secondAttentionList2.size()!=0){
                attentionList.setRelation(Attention.Relation.EACHOTHER.getState());
            } //互相关注了
            if (secondAttentionList.size()==0 && secondAttentionList2.size()==0){
                attentionList.setRelation(Attention.Relation.NO.getState());
            }
            attentions.add(attentionList);
        });
        return builder.body(ResponseUtils.getResponseBody(attentions));
    }
}
