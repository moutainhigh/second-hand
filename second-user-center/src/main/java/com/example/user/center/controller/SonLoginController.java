package com.example.user.center.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.user.center.dao.*;
import com.example.user.center.manual.Authentication;
import com.example.user.center.manual.BanlaceEnum;
import com.example.user.center.manual.SonList;
import com.example.user.center.manual.StoreDetails;
import com.example.user.center.model.*;
import com.example.user.center.service.SonService;
import com.google.common.collect.Lists;
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
import java.util.*;
import java.util.stream.Collectors;

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
    //学校
    @Autowired
    private SonService sonService;
    //店铺
    @Autowired
    private SecondStoreMapper secondStoreMapper;
    //店铺余额
    @Autowired
    private SecondStoreBalanceMapper secondStoreBalanceMapper;
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
                .andLoginTypeEqualTo(Authentication.LoginType.SON.getState());
        List<SecondAuth> secondAuths1 = secondAuthMapper.selectByExample(secondAuthExample);
        if (secondAuths1.size()!=0){
            response.sendError(HttpStatus.UNAUTHORIZED.value(), "用户名存在");
            return builder.body(ResponseUtils.getResponseBody(1));
        }
        //创建用户
        SecondUser secondUser = new SecondUser();
        secondUser.setNickName(username);
        secondUser.setUserStatus((byte) 0);
        secondUser.setUserType(Authentication.LoginType.SON.getState());
        secondUser.setIsAuthentication(0);
        secondUser.setCreateDate(LocalDateTime.now());
        secondUser.setModifyDate(LocalDateTime.now());
        secondUser.setIdDeleted((byte) 0);
        secondUserMapper.insertSelective(secondUser);
        SecondStore secondStore = new SecondStore();
        secondStore.setStoreType(Authentication.StoreType.SON.getState());
        secondStore.setUserId(secondUser.getId());
        secondStore.setCreateTime(LocalDateTime.now());
        secondStore.setModifyDate(LocalDateTime.now());
        secondStore.setIsDeleted((short) 0);
        secondStore.setSecondStatus(Authentication.State.PASS.getState());
        secondStore.setConcernCount(0);
        secondStoreMapper.insertSelective(secondStore);
        userId = secondUser.getId();
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
    @RequestMapping(path = "/updateSon", method = RequestMethod.POST)
    @ApiOperation(value = "修改子站点", notes = "修改子站点")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "name", value = "子站点名称", required = true, type = "String"),
            @ApiImplicitParam(paramType = "query", name = "username", value = "登录用户名", required = true, type = "String"),
            @ApiImplicitParam(paramType = "query", name = "password", value = "登录密码", required = true, type = "String"),
            @ApiImplicitParam(paramType = "query", name = "collegoryId", value = "学校id", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "sonId", value = "子站点id", required = true, type = "Integer"),

    })
    public ResponseEntity<JSONObject> updateSon(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "password", required = false) String password,
            @RequestParam(value = "file", required = false) String file,
            @RequestParam(value = "collegoryId", required = false) Integer collegoryId,
            @RequestParam(value = "sonId", required = false) Integer sonId,
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
        //创建用户
        //创建子站点
        SecondSon secondSon = new SecondSon();
        secondSon.setId(sonId);
        secondSon.setFile(file);
        secondSon.setCollegoryId(collegoryId);
        secondSon.setSonName(name);
        secondSon.setSonBalance(0);
        secondSon.setModifyTime(LocalDateTime.now());
        secondSonMapper.updateByPrimaryKeySelective(secondSon);
        SecondSon secondSon1 = secondSonMapper.selectByPrimaryKey(sonId);
        SecondAuthExample secondAuthExample1 = new SecondAuthExample();
        secondAuthExample1.createCriteria()
                .andUserIdEqualTo(secondSon1.getUserId())
                .andLoginTypeEqualTo(Authentication.LoginType.SON.getState())
                .andStoreIdEqualTo(sonId)
                .andIsDeletedEqualTo((byte) 0);
        SecondAuth secondAuth = new SecondAuth();
        secondAuth.setLoginType(Authentication.LoginType.SON.getState());
        secondAuth.setUsername(username);
        BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
        secondAuth.setPassword(bcryptPasswordEncoder.encode(password));
        secondAuth.setStoreId(secondSon.getId());//子站点登录这里为子站点id
        secondAuth.setAuthStatus(Byte.valueOf("0"));
        secondAuth.setModifyDate(LocalDateTime.now());
        secondAuthMapper.updateByExampleSelective(secondAuth,secondAuthExample1);
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
        if (secondAuthList.size()==0){
            response.sendError(HttpStatus.UNAUTHORIZED.value(), "账号或者密码错误");
            return builder.body(ResponseUtils.getResponseBody(1));
        }
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
            SecondStoreExample secondStoreExample = new SecondStoreExample();
            secondStoreExample.createCriteria().andIsDeletedEqualTo((short) 0)
                    .andUserIdEqualTo(secondAuthList.get(0).getUserId());
            List<SecondStore> secondStores =
            secondStoreMapper.selectByExample(secondStoreExample);
            if (secondStores.size()!=0){
                map.put("storeId",secondStores.get(0).getId());
            } else {
                SecondStore secondStore = new SecondStore();
                secondStore.setStoreType(Authentication.StoreType.SON.getState());
                secondStore.setUserId(secondAuthList.get(0).getUserId());
                secondStore.setCreateTime(LocalDateTime.now());
                secondStore.setModifyDate(LocalDateTime.now());
                secondStore.setIsDeleted((short) 0);
                secondStore.setSecondStatus(Authentication.State.PASS.getState());
                secondStore.setConcernCount(0);
                secondStoreMapper.insertSelective(secondStore);
                map.put("storeId",secondStore.getId());
            }

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
            sonList.setSonState(secondSon.getSonState());
            sonList.setId(secondSon.getId());//子站点id
            sonList.setUserId(secondSon.getUserId());
            sonList.setCollegoryId(secondSon.getCollegoryId());//学校id
            sonList.setSonName(secondSon.getSonName());//子站点名称
            sonList.setSonBalance(secondSon.getSonBalance());//余额
            SecondColleges secondColleges =
            secondCollegesMapper.selectByPrimaryKey(secondSon.getCollegoryId());//学校id查询
            sonList.setRecord(secondColleges.getRecord());
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

    @RequestMapping(path = "/stateSon", method = RequestMethod.POST)
    @ApiOperation(value = "子站点状态改变", notes = "子站点状态改变")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "state", value = "状态0 1", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "sonId", value = "子站点id", required = true, type = "Integer"),
    })
    public ResponseEntity<JSONObject> stateSon(
            Integer state,
            Integer sonId,
            HttpServletResponse response
    ) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
        SecondSon secondSon = new SecondSon();
        secondSon.setId(sonId);
        secondSon.setSonState(state);
        secondSonMapper.updateByPrimaryKeySelective(secondSon);
        return builder.body(ResponseUtils.getResponseBody(0));
    }

    @RequestMapping(path = "/colleges", method = RequestMethod.GET)
    @ApiOperation(value = "学校查询", notes = "学校查询")
    public ResponseEntity<JSONObject> colleges(
            HttpServletResponse response
    ) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();

        return builder.body(ResponseUtils.getResponseBody(sonService.select()));
    }
    @RequestMapping(path = "/sonDetails", method = RequestMethod.GET)
    @ApiOperation(value = "子站点详情", notes = "子站点详情")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "userId", value = "用户id", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "storeId", value = "店铺id", required = true, type = "Integer"),
    })
    public ResponseEntity<JSONObject> UserDetails(
            Integer userId,
            Integer storeId
    ) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
        SecondStore secondStore = secondStoreMapper.selectByPrimaryKey(storeId);
        SecondStoreBalanceExample secondStoreBalanceExample = new SecondStoreBalanceExample();
        secondStoreBalanceExample.createCriteria()
                .andUserIdEqualTo(userId)
                .andStoreIdEqualTo(storeId)
                .andBalanceTypeEqualTo(BanlaceEnum.Relation.MONEY.getState())
                .andIsDeletedEqualTo((short) 0);
        List<SecondStoreBalance> secondStoreBalances =
                secondStoreBalanceMapper.selectByExample(secondStoreBalanceExample);
        StoreDetails storeDetails = new StoreDetails();
        storeDetails.setUserId(userId);
        storeDetails.setStoreId(storeId);
        storeDetails.setCreateTime(secondStore.getCreateTime());
        storeDetails.setAddress(secondStore.getSecondAddress());
        storeDetails.setStoreStatus(secondStore.getSecondStatus());
        if (secondStoreBalances.size()!=0){
            storeDetails.setMoney(secondStoreBalances.get(0).getSecondBalance());
        } else {
            SecondStoreBalance secondStoreBalance = new SecondStoreBalance();
            secondStoreBalance.setUserId(userId);
            secondStoreBalance.setStoreId(storeId);
            secondStoreBalance.setBalanceType(BanlaceEnum.Relation.MONEY.getState());
            secondStoreBalance.setSecondBalance(0);
            secondStoreBalance.setCreateTime(LocalDateTime.now());
            secondStoreBalance.setModifyTime(LocalDateTime.now());
            secondStoreBalance.setIsDeleted((short) 0);
            secondStoreBalanceMapper.insertSelective(secondStoreBalance);
            storeDetails.setMoney(0);
        }
        return builder.body(ResponseUtils.getResponseBody(storeDetails));
    }

    @RequestMapping(path = "/sonCity", method = RequestMethod.GET)
    @ApiOperation(value = "每座城市的子站点", notes = "每座城市的子站点")
    public ResponseEntity<JSONObject> sonCity(
    ) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
        SecondCityExample secondCityExample = new SecondCityExample();
        secondCityExample.createCriteria().andCityIdIsNotNull();
        List<SecondCity> secondCities = secondCityMapper.selectByExample(secondCityExample);

        SecondSonExample secondSonExample = new SecondSonExample();
        secondSonExample.createCriteria().andIsDeletedEqualTo((short) 0);
        List<SecondSon> secondSons = secondSonMapper.selectByExample(secondSonExample);
        Set<Integer> college = secondSons.stream().map(SecondSon::getCollegoryId).collect(Collectors.toSet());

        SecondCollegesExample secondCollegesExample = new SecondCollegesExample();
        secondCollegesExample.createCriteria().andIdIn(Lists.newArrayList(college));
        List<SecondColleges> secondColleges = secondCollegesMapper.selectByExample(secondCollegesExample);
        System.out.println(secondColleges.size());
        Map<String,Integer> map = new HashMap<>();
        for (SecondColleges list : secondColleges) {
            SecondCity secondCity = secondCityMapper.selectByPrimaryKey(list.getCityId());
            if(map.containsKey(secondCity.getName())) {
                map.put(secondCity.getName(), map.get(secondCity.getName()).intValue()+1);
            }else {
                map.put(secondCity.getName(), new Integer(1));
            }
        }
        return builder.body(ResponseUtils.getResponseBody(map));
    }
}
