package com.example.product.center.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.product.center.dao.SecondLabelMapper;
import com.example.product.center.model.SecondLabel;
import com.example.product.center.model.SecondLabelExample;
import com.second.utils.response.handler.ResponseEntity;
import com.second.utils.response.handler.ResponseUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * @author shihao
 * @Title: labelController
 * @ProjectName Second-order-center
 * @Description: 标签
 * @date Created in
 * @Version: $
 */
@RestController
@Api
@RequestMapping("/Label")
@CrossOrigin
public class LabelController {
    //b标签
    @Autowired
    private SecondLabelMapper secondLabelMapper;
    @RequestMapping(path = "/label", method = RequestMethod.POST)
    @ApiOperation(value = "添加标签", notes = "添加标签")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "labelName", value = "标签名称", required = false, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "labelDesc", value = "标签描述", required = false, type = "String"),
    })
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public ResponseEntity<JSONObject> deleted(
            @RequestParam(name = "labelName", required = false) String labelName,
            @RequestParam(name = "labelDesc", required = false) String labelDesc
    ) throws JSONException {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
        SecondLabel secondLabel = new SecondLabel();
        secondLabel.setLabelName(labelName);
        secondLabel.setLabelDesc(labelDesc);
        secondLabel.setCreateTime(LocalDateTime.now());
        secondLabel.setModifyTime(LocalDateTime.now());
        secondLabel.setIsDeleted((short) 0);
        secondLabelMapper.insertSelective(secondLabel);
        return builder.body(ResponseUtils.getResponseBody(0));
    }
    @RequestMapping(path = "/updateLabel", method = RequestMethod.POST)
    @ApiOperation(value = "修改标签", notes = "修改标签")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "labelName", value = "标签名称", required = false, type = "String"),
            @ApiImplicitParam(paramType = "query", name = "labelDesc", value = "标签描述", required = false, type = "String"),
            @ApiImplicitParam(paramType = "query", name = "labelId", value = "标签id", required = false, type = "Integer"),
    })
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public ResponseEntity<JSONObject> updateLabel(
            @RequestParam(name = "labelName", required = false) String labelName,
            @RequestParam(name = "lableId", required = false) Integer lableId,
            @RequestParam(name = "labelDesc", required = false) String labelDesc
    ) throws JSONException {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
        SecondLabel secondLabel = new SecondLabel();
        secondLabel.setId(lableId);
        secondLabel.setLabelName(labelName);
        secondLabel.setLabelDesc(labelDesc);
        secondLabel.setModifyTime(LocalDateTime.now());
        secondLabel.setIsDeleted((short) 0);
        secondLabelMapper.updateByPrimaryKeySelective(secondLabel);
        return builder.body(ResponseUtils.getResponseBody(0));
    }
    @RequestMapping(path = "/deleteLabel", method = RequestMethod.POST)
    @ApiOperation(value = "删除标签", notes = "删除标签")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "labelId", value = "标签id", required = false, type = "Integer"),
    })
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public ResponseEntity<JSONObject> deleteLabel(
            @RequestParam(name = "lableId", required = false) Integer labelId
    ) throws JSONException {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
        SecondLabel secondLabel = new SecondLabel();
        secondLabel.setId(labelId);
        secondLabel.setModifyTime(LocalDateTime.now());
        secondLabel.setIsDeleted((short) 1);
        secondLabelMapper.updateByPrimaryKeySelective(secondLabel);
        return builder.body(ResponseUtils.getResponseBody(0));
    }
    @RequestMapping(path = "/selectLabel", method = RequestMethod.GET)
    @ApiOperation(value = "查询标签", notes = "查询标签")
    public ResponseEntity<JSONObject> selectLabel(
    ) throws JSONException {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
        SecondLabelExample secondLabelExample = new SecondLabelExample();
        secondLabelExample.createCriteria().andIsDeletedEqualTo((short) 0);

        return builder.body(ResponseUtils.getResponseBody(secondLabelMapper.selectByExample(secondLabelExample)));
    }
}
