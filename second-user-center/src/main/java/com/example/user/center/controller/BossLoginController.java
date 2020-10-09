package com.example.user.center.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.user.center.dao.*;
import com.example.user.center.manual.Authentication;
import com.example.user.center.manual.SlideshowEnum;
import com.example.user.center.model.*;
import com.second.common.service.FileMangeService;
import com.second.common.utils.Encrypt;
import com.second.utils.response.handler.ResponseEntity;
import com.second.utils.response.handler.ResponseUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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
    @Autowired
    private SecondBossMapper secondBossMapper;
    @Autowired
    private SecondSlideshowMapper secondSlideshowMapper;
    //文件
    @Autowired
    private SecondFileMapper secondFileMapper;
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

    @RequestMapping(path = "/AddBasics", method = RequestMethod.POST)
    @ApiOperation(value = "添加商家基础信息", notes = "添加商家基础信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "service", value = "客服", required = true, type = "String"),
            @ApiImplicitParam(paramType = "query", name = "weChat", value = "微信", required = true, type = "String"),
            @ApiImplicitParam(paramType = "query", name = "newUserIntegral", value = "新用户认证加的积分", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "storeWithdrawalCommission", value = "商家提现手续费率", required = true, type = "Double"),
            @ApiImplicitParam(paramType = "query", name = "userWithdrawalCommission", value = "用户提现手续费率", required = true, type = "Double"),
            @ApiImplicitParam(paramType = "query", name = "sonWithdrawalCommission", value = "子站点提现手续费率", required = true, type = "Double"),
    })
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public ResponseEntity<JSONObject> AddBasics(
            @RequestParam(value = "service", required = false) String service,
            @RequestParam(value = "weChat", required = false) String weChat,
            @RequestParam(value = "newUserIntegral", required = false) Integer newUserIntegral,
            @RequestParam(value = "storeWithdrawalCommission", required = false) Double storeWithdrawalCommission,
            @RequestParam(value = "userWithdrawalCommission", required = false) Double userWithdrawalCommission,
            @RequestParam(value = "sonWithdrawalCommission", required = false) Double sonWithdrawalCommission,
            @RequestParam(value = "slideshow", required = false) String[] slideshow,
            HttpServletResponse response
    ) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
        SecondBoss secondBoss1 = secondBossMapper.selectByPrimaryKey(1);
        if (secondBoss1==null){
            SecondBoss secondBoss = new SecondBoss();
            secondBoss.setId(1);
            secondBoss.setService(service);
            secondBoss.setWeChat(weChat);
            secondBoss.setNewUserIntegral(newUserIntegral);
            secondBoss.setStoreWithdrawalCommission(storeWithdrawalCommission);
            secondBoss.setUserWithdrawalCommission(userWithdrawalCommission);
            secondBoss.setSonWithdrawalCommission(sonWithdrawalCommission);
            secondBossMapper.insertSelective(secondBoss);
        } else {
            SecondBoss secondBoss = new SecondBoss();
            secondBoss.setId(1);
            secondBoss.setService(service);
            secondBoss.setWeChat(weChat);
            secondBoss.setNewUserIntegral(newUserIntegral);
            secondBoss.setStoreWithdrawalCommission(storeWithdrawalCommission);
            secondBoss.setUserWithdrawalCommission(userWithdrawalCommission);
            secondBoss.setSonWithdrawalCommission(sonWithdrawalCommission);
            secondBossMapper.updateByPrimaryKeySelective(secondBoss);
        }
        for (String file:slideshow){
            SecondSlideshow secondSlideshow = new SecondSlideshow();
            secondSlideshow.setFile(file);
            secondSlideshow.setFileType(SlideshowEnum.SlideshowType.HOMEPAGE.getOrderStatus());
            secondSlideshow.setCreateDate(LocalDateTime.now());
            secondSlideshow.setModifyDate(LocalDateTime.now());
            secondSlideshow.setIsDeleted((byte) 0);
            secondSlideshowMapper.insertSelective(secondSlideshow);
        }
        return builder.body(ResponseUtils.getResponseBody(0));
    }
    @ApiOperation(value = "删除首页轮播图", notes = "删除首页轮播图")
    @RequestMapping(value = "/deleted", method = RequestMethod.POST)
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public ResponseEntity<JSONObject> deleted(String file,String type) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder(HttpStatus.OK);
        SecondSlideshowExample secondSlideshowExample = new SecondSlideshowExample();
        secondSlideshowExample.createCriteria()
                .andFileEqualTo(file)
                .andFileTypeEqualTo(type);
        SecondSlideshow secondSlideshow = new SecondSlideshow();
        secondSlideshow.setIsDeleted((byte) 0);
        secondSlideshowMapper.updateByExampleSelective(secondSlideshow,secondSlideshowExample);
        fileDelete2(file);
        return builder.body(ResponseUtils.getResponseBody(0));
    }
    public ResponseEntity<JSONObject> fileDelete2(String file) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder(HttpStatus.OK);
        String str1 = file.substring(0, file.indexOf("="));
        String str2 = file.substring(str1.length() + 1, file.length());

        SecondFile fileDesc = secondFileMapper.selectByPrimaryKey(Integer.valueOf(str2));
        FileMangeService fileManageService = new FileMangeService();
        if (fileDesc != null) {
            fileManageService.deleteFile(fileDesc.getGroupName(), fileDesc.getRemoteFilename());
        }
        secondFileMapper.deleteByPrimaryKey(Integer.valueOf(str2));
        return builder.body(ResponseUtils.getResponseBody(Integer.valueOf(str2)));
    }
    /**
     * 轮播图查询
     */
    @ApiOperation(value = "查询轮播图", notes = "查询轮播图")
    @RequestMapping(value = "/select", method = RequestMethod.GET)
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public ResponseEntity<JSONObject> select(String type) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder(HttpStatus.OK);
        SecondSlideshowExample secondSlideshowExample = new SecondSlideshowExample();
        secondSlideshowExample.createCriteria()
                .andFileTypeEqualTo(type);
        List<SecondSlideshow> secondSlideshows =
        secondSlideshowMapper.selectByExample(secondSlideshowExample);

        return builder.body(ResponseUtils.getResponseBody(secondSlideshows));
    }
}
