package com.example.user.center.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.user.center.dao.*;
import com.example.user.center.manual.Authentication;
import com.example.user.center.manual.SonList;
import com.example.user.center.model.*;
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
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shihao
 * @Title: SonController
 * @ProjectName Second-order-center
 * @Description: 子站点
 * @date Created in
 * @Version: $
 */
@RestController
@Api
@RequestMapping("/SonLogin")
@CrossOrigin
public class SonLoginController {

    //学校
    @Autowired
    private SecondCollegesMapper secondCollegesMapper;
    //学校城市
    @Autowired
    private SecondCityMapper secondCityMapper;
    //子站点
    @Autowired
    private SecondSonMapper secondSonMapper;
    //鉴权登录
    @Autowired
    private SecondAuthMapper secondAuthMapper;
    //用户
    @Autowired
    private SecondUserMapper secondUserMapper;
    @RequestMapping(path = "/addSon", method = RequestMethod.POST)
    @ApiOperation(value = "创建子站点", notes = "创建子站点")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "name", value = "子站点名称", required = true, type = "String"),
            @ApiImplicitParam(paramType = "query", name = "username", value = "登录用户名", required = true, type = "String"),
            @ApiImplicitParam(paramType = "query", name = "password", value = "登录密码", required = true, type = "String"),
            @ApiImplicitParam(paramType = "query", name = "collegoryId", value = "学校id", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "userId", value = "用户id", required = true, type = "Integer"),

    })
    public ResponseEntity<JSONObject> addSon(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "password", required = false) String password,
            @RequestParam(value = "file", required = false) String file,
                                                          @RequestParam(value = "collegoryId", required = false) Integer collegoryId,
                                                          @RequestParam(value = "userId", required = false) Integer userId,
                                                          HttpServletResponse response, HttpServletRequest request) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
        //看下此学校是否已经有了子站点
        SecondSonExample secondSonExample = new SecondSonExample();
        secondSonExample.createCriteria().andCollegoryIdEqualTo(collegoryId)
                .andIsDeletedEqualTo((short) 0);
            List<SecondSon> secondSons = secondSonMapper.selectByExample(secondSonExample);
            if (secondSons.size()!=0){
                response.sendError(HttpStatus.FORBIDDEN.value(), "已经存在子站点");
                return builder.body(ResponseUtils.getResponseBody(1));
            }
        //判断用户名是否存在
        SecondAuthExample secondAuthExample = new SecondAuthExample();
        secondAuthExample.createCriteria().andUsernameEqualTo(username)
                .andIsDeletedEqualTo((byte) 0)
                .andLoginTypeEqualTo(Authentication.LoginType.BOSS.getState());
        List<SecondAuth> secondAuths1 = secondAuthMapper.selectByExample(secondAuthExample);
        if (secondAuths1.size()!=0){
            response.sendError(HttpStatus.UNAUTHORIZED.value(), "用户名存在");
            return builder.body(ResponseUtils.getResponseBody(1));
        }
        //创建子站点
        SecondSon secondSon = new SecondSon();
        secondSon.setFile(file);
        secondSon.setUserId(userId);
        secondSon.setCollegoryId(collegoryId);
        secondSon.setSonName(name);
        secondSon.setSonBalance(0);
        secondSon.setCreateTime(LocalDateTime.now());
        secondSon.setModifyTime(LocalDateTime.now());
        secondSon.setIsDeleted((short) 0);
        secondSonMapper.insertSelective(secondSon);
        SecondAuth secondAuth = new SecondAuth();
        secondAuth.setUserId(userId);
        secondAuth.setLoginType(Authentication.LoginType.SON.getState());
        secondAuth.setUsername(username);
        BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
        secondAuth.setPassword(bcryptPasswordEncoder.encode(password));
        secondAuth.setStoreId(secondSon.getId());//子站点登录这里为子站点id
        secondAuth.setAuthStatus(Byte.valueOf("0"));

        secondAuth.setCreateDate(LocalDateTime.now());
        secondAuth.setModifyDate(LocalDateTime.now());
        secondAuth.setIsDeleted((byte) 0);
        secondAuthMapper.insertSelective(secondAuth);
        return builder.body(ResponseUtils.getResponseBody(0));
    }

    @RequestMapping(path = "/Login", method = RequestMethod.POST)
    @ApiOperation(value = "子站点登录", notes = "子站点登录")
    public ResponseEntity<JSONObject> Login(
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "password", required = false) String password,
            HttpServletResponse response
    ) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
        SecondAuthExample secondAuthExample = new SecondAuthExample();
        secondAuthExample.createCriteria().andUsernameEqualTo(username)
                .andLoginTypeEqualTo(Authentication.LoginType.SON.getState())
                .andIsDeletedEqualTo((byte) 0);
        List<SecondAuth> secondAuthList = secondAuthMapper.selectByExample(secondAuthExample);
        BCryptPasswordEncoder bcp = new BCryptPasswordEncoder();
        boolean a = bcp.matches(password,secondAuthList.get(0).getPassword());
        if (a){
            Encrypt encrypt = new Encrypt();
            String token = encrypt.getToken(true, secondAuthList.get(0).getUserId(), "son", 0);
            Map<String,Object> map = new HashMap<>();
            map.put("token",token);
            map.put("userId",secondAuthList.get(0).getUserId());
            map.put("LoginType",Authentication.LoginType.SON.getState());
            map.put("sonId",secondAuthList.get(0).getStoreId());
            return builder.body(ResponseUtils.getResponseBody(map));
        } else {
            response.sendError(HttpStatus.UNAUTHORIZED.value(), "账号或者密码错误");
            return builder.body(ResponseUtils.getResponseBody(1));
        }
    }

    @RequestMapping(path = "/deleteSon", method = RequestMethod.POST)
    @ApiOperation(value = "删除子站点", notes = "删除子站点")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "子站点id", required = true, type = "Integer"),
    })
    public ResponseEntity<JSONObject> deleteSon(
            @RequestParam(value = "id", required = false) Integer id,
            HttpServletResponse response
    ) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
        SecondSon secondSon = new SecondSon();
        secondSon.setId(id);
        secondSon.setModifyTime(LocalDateTime.now());
        secondSon.setIsDeleted((short) 1);
        secondSonMapper.updateByPrimaryKeySelective(secondSon);
        SecondAuthExample secondAuthExample = new SecondAuthExample();
        secondAuthExample.createCriteria().andIsDeletedEqualTo((byte) 0)
                .andLoginTypeEqualTo(Authentication.LoginType.SON.getState())
        .andStoreIdEqualTo(id);
        SecondAuth secondAuth = new SecondAuth();
        secondAuth.setIsDeleted((byte) 1);
        secondAuth.setModifyDate(LocalDateTime.now());
        secondAuthMapper.updateByExampleSelective(secondAuth,secondAuthExample);
        return builder.body(ResponseUtils.getResponseBody(0));
    }
    @RequestMapping(path = "/ListSon", method = RequestMethod.POST)
    @ApiOperation(value = "子站点列表", notes = "子站点列表")

    public ResponseEntity<JSONObject> ListSon(
            HttpServletResponse response
    ) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
        SecondSonExample secondSonExample = new SecondSonExample();
        secondSonExample.createCriteria().andIsDeletedEqualTo((short) 0);
        List<SecondSon> secondSons = secondSonMapper.selectByExample(secondSonExample);
        List<SonList> sonLists = new ArrayList<>();
        secondSons.forEach(secondSon -> {
            SonList sonList = new SonList();
            sonList.setId(secondSon.getId());//子站点id
            sonList.setUserId(secondSon.getUserId());
            sonList.setCollegoryId(secondSon.getCollegoryId());//学校id
            sonList.setSonName(secondSon.getSonName());//子站点名称
            sonList.setSonBalance(secondSon.getSonBalance());//余额
            SecondColleges secondColleges =
            secondCollegesMapper.selectByPrimaryKey(secondSon.getCollegoryId());//学校id查询
            sonList.setCollegoryName(secondColleges.getName());
            SecondCityExample secondCityExample = new SecondCityExample();//城市查询
            secondCityExample.createCriteria().andCityIdEqualTo(secondColleges.getCityId());
            List<SecondCity> secondCities =
            secondCityMapper.selectByExample(secondCityExample);
            sonList.setCity(secondCities.get(0).getName());//城市
            SecondUser secondUser =
            secondUserMapper.selectByPrimaryKey(secondSon.getUserId());//用户查询
            sonList.setUserName(secondUser.getNickName());
            sonList.setSonFile(secondSon.getFile());
            sonLists.add(sonList);
        });
        return builder.body(ResponseUtils.getResponseBody(sonLists));
    }
}