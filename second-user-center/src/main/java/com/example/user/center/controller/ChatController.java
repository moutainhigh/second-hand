package com.example.user.center.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.example.user.center.dao.SecondChatMapper;
import com.example.user.center.dao.SecondUserMapper;
import com.example.user.center.manual.ChatWindow;
import com.example.user.center.manual.model.Chat;
import com.example.user.center.model.SecondUser;
import com.example.user.center.service.ChatService;
import com.google.gson.Gson;
import com.second.utils.response.handler.ResponseEntity;
import com.second.utils.response.handler.ResponseUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author shihao
 * @Title: ChatController
 * @ProjectName Second-order-center
 * @Description: 聊天
 * @date Created in
 * @Version: $
 */
@RestController
@Api
@RequestMapping("/Chat")
@CrossOrigin
public class ChatController {
    //聊天
    @Autowired
    private SecondChatMapper secondChatMapper;
    //
    @Autowired
    private ChatService chatService;
    @Resource
    RedisTemplate<String, Object> redisTemplate;
    //用户
    @Autowired
    private SecondUserMapper secondUserMapper;
    /**
     * 查询聊天记录
     */
    @ApiOperation(value = "查询聊天记录", notes = "查询聊天记录")
    @RequestMapping(value = "/selectChat", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "userId", value = "用户id", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "ByUserId", value = "收消息用户id", required = true, type = "Integer"),
    })
    public ResponseEntity<JSONObject> selectChat(
            @RequestParam(value = "userId", required = false) Integer userId,
            @RequestParam(value = "ByUserId", required = false) Integer byUserId
    ) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder(HttpStatus.OK);

        return builder.body(ResponseUtils.getResponseBody(chatService.select(userId, byUserId)));
    }
    /**
     * 建立聊天窗口
     */
    @ApiOperation(value = "建立聊天窗口", notes = "建立聊天窗口")
    @RequestMapping(value = "/addChatWindow", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "userId", value = "用户id", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "ByUserId", value = "收消息用户id", required = true, type = "Integer"),
    })
    public ResponseEntity<JSONObject> addChatWindow(
            @RequestParam(value = "userId", required = false) Integer userId,
            @RequestParam(value = "ByUserId", required = false) Integer byUserId
    ) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder(HttpStatus.OK);
        List<ChatWindow> chatWindows = new ArrayList<>();
        SecondUser secondUser = secondUserMapper.selectByPrimaryKey(userId);
        SecondUser bySecondUser = secondUserMapper.selectByPrimaryKey(byUserId);
        ChatWindow chatWindow = new ChatWindow();
        chatWindow.setUserId(userId);
        chatWindow.setUserName(secondUser.getNickName());
        chatWindow.setByUserId(byUserId);
        chatWindow.setByUserName(bySecondUser.getNickName());
        chatWindow.setCreateTime(LocalDateTime.now());
        chatWindow.setModifyTime(LocalDateTime.now());
        Object object =
                redisTemplate.opsForValue().get(String.valueOf(userId)+"window");
        if (object!=null){
            System.out.println(chatWindows);
            chatWindows = JSON.parseObject(String.valueOf(object), new TypeReference<List<ChatWindow>>(){});
            //被建立用户id
            Set<Integer> byUser = chatWindows.stream().map(ChatWindow::getByUserId).collect(Collectors.toSet());
            chatWindows.forEach(chatWindow1 ->{
                if (chatWindow1.getByUserId().equals(byUserId)){
                    chatWindow1.setModifyTime(LocalDateTime.now());
                }
            });
            //存在
            boolean result =
            byUser.contains(byUserId);
            if (!result){
                chatWindows.add(chatWindow);
            }
            String json = JSONObject.toJSONString(chatWindows);
            redisTemplate.opsForValue().set(String.valueOf(userId)+"window", json);
        } else {
            chatWindows.add(chatWindow);
            String json = JSONObject.toJSONString(chatWindows);
            redisTemplate.opsForValue().set(String.valueOf(userId)+"window", json);
        }

        return builder.body(ResponseUtils.getResponseBody(0));
    }
    /**
     * 删除聊天窗口
     */
    @ApiOperation(value = "删除聊天窗口", notes = "删除聊天窗口")
    @RequestMapping(value = "/delChatWindow", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "userId", value = "用户id", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "ByUserId", value = "收消息用户id", required = true, type = "Integer"),
    })
    public ResponseEntity<JSONObject> delChatWindow(
            @RequestParam(value = "userId", required = false) Integer userId
    ) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder(HttpStatus.OK);
        redisTemplate.delete(String.valueOf(userId)+"window");
        return builder.body(ResponseUtils.getResponseBody(0));
    }
    /**
     * 查询聊天窗口
     */
    @ApiOperation(value = "查询聊天窗口", notes = "查询聊天窗口")
    @RequestMapping(value = "/selChatWindow", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "userId", value = "用户id", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "ByUserId", value = "收消息用户id", required = true, type = "Integer"),
    })
    public ResponseEntity<JSONObject> selChatWindow(
            @RequestParam(value = "userId", required = false) Integer userId
    ) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder(HttpStatus.OK);
        Object object =
        redisTemplate.opsForValue().get(String.valueOf(userId)+"window");
        System.out.println(object);
        List<ChatWindow> chatWindows = new ArrayList<>();
        if (object!=null){
            chatWindows =
                    JSON.parseObject(String.valueOf(object), new TypeReference<List<ChatWindow>>(){});
        }
        List<ChatWindow> latestItem = chatWindows.stream().sorted(Comparator.comparing(ChatWindow::getModifyTime).reversed()).collect(Collectors.toList());
        return builder.body(ResponseUtils.getResponseBody(latestItem));
    }
}