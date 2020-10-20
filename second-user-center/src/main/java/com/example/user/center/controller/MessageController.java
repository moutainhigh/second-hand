package com.example.user.center.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.user.center.config.WebSocketTest;
import com.example.user.center.dao.SecondMessageMapper;
import com.example.user.center.model.SecondFile;
import com.example.user.center.model.SecondMessage;
import com.example.user.center.model.SecondMessageExample;
import com.second.common.service.FileMangeService;
import com.second.utils.response.handler.ResponseEntity;
import com.second.utils.response.handler.ResponseUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.websocket.Session;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shihao
 * @Title: MessageController
 * @ProjectName Second-order-center
 * @Description: 消息
 * @date Created in
 * @Version: $
 */
@RestController
@Api
@RequestMapping("/Message")
@CrossOrigin
public class MessageController {
    @Autowired
    private WebSocketTest webSocketTest;
@Autowired
private SecondMessageMapper secondMessageMapper;
    @ApiOperation(value = "上传图片", notes = "上传图片")
    @RequestMapping(value = "/fileUpLoad", method = RequestMethod.POST)
    public ResponseEntity<JSONObject> fileUpLoad(String message) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder(HttpStatus.OK);
        webSocketTest.onMessage(message);
        return builder.body(ResponseUtils.getResponseBody(0));
    }
    @ApiOperation(value = "保存消息", notes = "保存消息")
    @RequestMapping(value = "/addMessage", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "headline", value = "标题", required = true, type = "String"),
            @ApiImplicitParam(paramType = "query", name = "secondDesc", value = "消息类容", required = true, type = "String"),
            @ApiImplicitParam(paramType = "query", name = "file", value = "展示图", required = true, type = "String"),
    })
    public ResponseEntity<JSONObject> addMessage(
            @RequestParam(value = "headline", required = false) String headline,
            @RequestParam(value = "secondDesc", required = false) String secondDesc,
            @RequestParam(value = "file", required = false) String file
    ) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder(HttpStatus.OK);
        SecondMessage secondMessage = new SecondMessage();
        secondMessage.setHeadline(headline);
        secondMessage.setFile(file);
        secondMessage.setSecondDesc(secondDesc);
        secondMessage.setCreateTime(LocalDateTime.now());
        secondMessage.setModifyTime(LocalDateTime.now());
        secondMessage.setIsDeleted((byte) 0);
        secondMessageMapper.insertSelective(secondMessage);
        return builder.body(ResponseUtils.getResponseBody(0));
    }
    @ApiOperation(value = "删除消息", notes = "删除消息")
    @RequestMapping(value = "/deletedMessage", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "消息id", required = true, type = "Integer"),
    })
    public ResponseEntity<JSONObject> deletedMessage(
            @RequestParam(value = "id", required = false) Integer id
    ) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder(HttpStatus.OK);
        SecondMessage secondMessage = new SecondMessage();
        secondMessage.setId(id);
        secondMessage.setModifyTime(LocalDateTime.now());
        secondMessage.setIsDeleted((byte) 1);
        secondMessageMapper.updateByPrimaryKeySelective(secondMessage);
        return builder.body(ResponseUtils.getResponseBody(0));
    }
    @ApiOperation(value = "修改消息", notes = "修改消息")
    @RequestMapping(value = "/updateMessage", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "headline", value = "标题", required = true, type = "String"),
            @ApiImplicitParam(paramType = "query", name = "secondDesc", value = "消息类容", required = true, type = "String"),
            @ApiImplicitParam(paramType = "query", name = "file", value = "展示图", required = true, type = "String"),
            @ApiImplicitParam(paramType = "query", name = "id", value = "消息id", required = true, type = "Integer"),
    })
    public ResponseEntity<JSONObject> updateMessage(
            @RequestParam(value = "headline", required = false) String headline,
            @RequestParam(value = "secondDesc", required = false) String secondDesc,
            @RequestParam(value = "id", required = false) Integer id,
            @RequestParam(value = "file", required = false) String file
    ) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder(HttpStatus.OK);
        SecondMessage secondMessage = new SecondMessage();
        secondMessage.setId(id);
        secondMessage.setHeadline(headline);
        secondMessage.setFile(file);
        secondMessage.setSecondDesc(secondDesc);
        secondMessage.setCreateTime(LocalDateTime.now());
        secondMessage.setModifyTime(LocalDateTime.now());
        secondMessage.setIsDeleted((byte) 0);
        secondMessageMapper.updateByPrimaryKeySelective(secondMessage);
        return builder.body(ResponseUtils.getResponseBody(0));
    }

    @ApiOperation(value = "查询消息", notes = "查询消息")
    @RequestMapping(value = "/selectMessage", method = RequestMethod.GET)
    public ResponseEntity<JSONObject> selectMessage(
    ) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder(HttpStatus.OK);
        SecondMessageExample secondMessageExample = new SecondMessageExample();
        secondMessageExample.createCriteria().andIsDeletedEqualTo((byte) 0);
        List<SecondMessage> secondMessages =
                secondMessageMapper.selectByExampleWithBLOBs(secondMessageExample);

        return builder.body(ResponseUtils.getResponseBody(secondMessages));
    }

    @ApiOperation(value = "查询消息详情", notes = "查询消息详情")
    @RequestMapping(value = "/selectMessageDetails", method = RequestMethod.GET)
    public ResponseEntity<JSONObject> selectMessageDetails(
            Integer messageId
    ) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder(HttpStatus.OK);
        SecondMessage secondMessage =
                secondMessageMapper.selectByPrimaryKey(messageId);
        return builder.body(ResponseUtils.getResponseBody(secondMessage));
    }
}
