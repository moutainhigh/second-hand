package com.example.user.center.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.user.center.dao.SecondAuthMapper;
import com.example.user.center.dao.SecondUserMapper;
import com.example.user.center.manual.Authentication;
import com.example.user.center.model.SecondAuth;
import com.example.user.center.model.SecondAuthExample;
import com.example.user.center.model.SecondAuthenticationPicture;
import com.example.user.center.model.SecondUser;
import com.second.common.utils.Encrypt;
import com.second.utils.response.handler.ResponseEntity;
import com.second.utils.response.handler.ResponseUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shihao
 * @Title: BossLoginController
 * @ProjectName Second-order-center
 * @Description: 总后台登录
 * @date Created in
 * @Version: $
 */
@RestController
@Api
@RequestMapping("/BossLogin")
@CrossOrigin
public class BossLoginController {
    @Autowired
    private SecondAuthMapper secondAuthMapper;
    @Autowired
    private SecondUserMapper secondUserMapper;
//    总后台登录
@RequestMapping(path = "/Login", method = RequestMethod.POST)
@ApiOperation(value = "登录", notes = "登录")

    public ResponseEntity<JSONObject> Login(
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "password", required = false) String password,
            HttpServletResponse response
    ) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
        SecondAuthExample secondAuthExample = new SecondAuthExample();
        secondAuthExample.createCriteria().andUsernameEqualTo(username)
                .andLoginTypeEqualTo(Authentication.LoginType.BOSS.getState())
                .andIsDeletedEqualTo((byte) 0);
        List<SecondAuth> secondAuthList = secondAuthMapper.selectByExample(secondAuthExample);
        BCryptPasswordEncoder bcp = new BCryptPasswordEncoder();
        boolean a = bcp.matches(password,secondAuthList.get(0).getPassword());
        if (a){
            Encrypt encrypt = new Encrypt();
            String token = encrypt.getToken(true, secondAuthList.get(0).getUserId(), "boss", 0);
            Map<String,Object> map = new HashMap<>();
            map.put("token",token);
            map.put("userId",secondAuthList.get(0).getUserId());
            map.put("LoginType",Authentication.LoginType.BOSS.getState());
            return builder.body(ResponseUtils.getResponseBody(map));
        } else {
            response.sendError(HttpStatus.UNAUTHORIZED.value(), "账号或者密码错误");
            return builder.body(ResponseUtils.getResponseBody(1));
        }
    }
    @RequestMapping(path = "/AddLogin", method = RequestMethod.POST)
    @ApiOperation(value = "添加登录", notes = "添加登录")
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public ResponseEntity<JSONObject> AddLogin(
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "password", required = false) String password,
            @RequestParam(value = "userId", required = false) Integer userId,
            HttpServletResponse response
    ) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
        SecondAuthExample secondAuthExample = new SecondAuthExample();
        secondAuthExample.createCriteria().andIsDeletedEqualTo((byte) 0)
                .andUserIdEqualTo(userId).andLoginTypeEqualTo(Authentication.LoginType.BOSS.getState());
        List<SecondAuth> secondAuths = secondAuthMapper.selectByExample(secondAuthExample);
        //判断此用户是否已经有了登录权限
        if (secondAuths.size()!=0){
            response.sendError(HttpStatus.UNAUTHORIZED.value(), "已经有账号了");
            return builder.body(ResponseUtils.getResponseBody(1));
        }
        secondAuthExample.clear();
        secondAuthExample.createCriteria().andUsernameEqualTo(username)
                .andIsDeletedEqualTo((byte) 0)
                .andLoginTypeEqualTo(Authentication.LoginType.BOSS.getState());
        List<SecondAuth> secondAuths1 = secondAuthMapper.selectByExample(secondAuthExample);
        //判断用户名是否存在
        if (secondAuths1.size()!=0){
            response.sendError(HttpStatus.UNAUTHORIZED.value(), "用户名存在");
            return builder.body(ResponseUtils.getResponseBody(1));
        }
        SecondUser secondUser = new SecondUser();
        secondUser.setNickName(username);
        secondUser.setUserStatus((byte) 0);
        secondUser.setUserType(Authentication.LoginType.BOSS.getState());
        secondUser.setIsAuthentication(0);
        secondUser.setCreateDate(LocalDateTime.now());
        secondUser.setModifyDate(LocalDateTime.now());
        secondUser.setIdDeleted((byte) 0);
        secondUserMapper.insertSelective(secondUser);
        userId = secondUser.getId();
        BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
        SecondAuth secondAuth = new SecondAuth();
        secondAuth.setUserId(userId);
        secondAuth.setUsername(username);
        secondAuth.setPassword(bcryptPasswordEncoder.encode(password));
        secondAuth.setLoginType(Authentication.LoginType.BOSS.getState());
        secondAuth.setIsDeleted((byte) 0);
        secondAuth.setCreateDate(LocalDateTime.now());
        secondAuth.setCreateDate(LocalDateTime.now());
        secondAuthMapper.insertSelective(secondAuth);
        return builder.body(ResponseUtils.getResponseBody(0));
    }
}
