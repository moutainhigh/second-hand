package com.example.user.center.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.user.center.config.WxStoreLoginConfig;
import com.example.user.center.dao.*;
import com.example.user.center.manual.Authentication;
import com.example.user.center.manual.AuthenticationList;
import com.example.user.center.manual.AuthenticationStoreList;
import com.example.user.center.model.*;
import com.second.common.utils.Encrypt;
import com.second.utils.response.handler.ResponseEntity;
import com.second.utils.response.handler.ResponseUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.InvalidParameterSpecException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

/**
 * @author shihao
 * @Title: StoreLoginController
 * @ProjectName Second-order-center
 * @Description: 入驻商家
 * @date Created in
 * @Version: $
 */
@RestController
@Api
@RequestMapping("/StoreLogin")
@CrossOrigin
public class StoreLoginController {
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private SecondAuthMapper secondAuthMapper;
    @Autowired
    private SecondUserMapper secondUserMapper;
    //店铺
    @Autowired
    private SecondStoreMapper secondStoreMapper;
    @Autowired
    private SecondStoreAuthenticationMapper secondStoreAuthenticationMapper;
    @Autowired
    private SecondStoreAuthenticationPictureMapper secondStoreAuthenticationPictureMapper;

    @RequestMapping(path = "/wechart", method = RequestMethod.GET)
    @ApiOperation(value = "入驻商家微信登录", notes = "入驻商家微信登录")
    public ResponseEntity<JSONObject> wxLogin(@RequestParam(value = "code", required = false) String code,
                                              @RequestParam(value = "appName", required = false) String appName,
                                              @RequestParam(value = "encryptedData", required = false) String encryptedData,
                                              @RequestParam(value = "iv", required = false) String iv, HttpServletResponse response, HttpServletRequest request) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        JSONObject SessionKeyOpenId = WxStoreLoginConfig.getSessionKeyOrOpenId(code, appName);
        String openid = (String) SessionKeyOpenId.get("openid");
        String sessionKey = String.valueOf(SessionKeyOpenId.get("session_key"));

        SecondAuthExample secondAuthExample = new SecondAuthExample();
        secondAuthExample.createCriteria().andAuthKeyEqualTo(openid)
                .andAuthTypeEqualTo(WxStoreLoginConfig.AuthType.WECHART.getAuthType());
        List<SecondAuth> auths = secondAuthMapper.selectByExample(secondAuthExample);
        SecondUser secondUser = CollectionUtils.isEmpty(auths) ? register(openid, sessionKey, encryptedData, iv) : secondUserMapper.selectByPrimaryKey(auths.get(0).getUserId());

        String skey = UUID.randomUUID().toString();
        String skey_redis = String.valueOf(redisTemplate.opsForValue().get(openid));
        if (!StringUtils.isEmpty(skey_redis)) {
            redisTemplate.delete(skey_redis);
            skey = UUID.randomUUID().toString();
        }

        JSONObject sessionObj = new JSONObject();
        sessionObj.put("openId", openid);
        sessionObj.put("sessionKey", sessionKey);
        redisTemplate.opsForValue().set(skey, sessionObj.toJSONString());
        redisTemplate.opsForValue().set(openid.toString(), skey);
        Encrypt encrypt = new Encrypt();
        String token = encrypt.getToken(true, secondUser.getId(), "store", Integer.valueOf(secondUser.getIsAuthentication()));
        System.out.println(token);
        response.addHeader("token", token);

        map.put("skey", skey);
        map.put("userId", secondUser.getId());//自己的用户id
        map.put("user", secondUser);
        map.put("token", token);
        SecondUser secondUser1 = secondUserMapper.selectByPrimaryKey(secondUser.getId());
        map.put("AuthStart",secondUser1.getIsAuthentication());//认证状态
        List<SecondAuth> auths1 = secondAuthMapper.selectByExample(secondAuthExample);
        map.put("store",auths1.get(0).getStoreId());//登录的店铺id
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
        return builder.body(ResponseUtils.getResponseBody(map));
    }

    public SecondUser register(String openid, String sessionKey, String encryptedData, String iv)
            throws InvalidKeyException, NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException,
            InvalidParameterSpecException, InvalidAlgorithmParameterException, IllegalBlockSizeException,
            BadPaddingException, UnsupportedEncodingException {
        JSONObject userInfo = WxStoreLoginConfig.parseWechart(encryptedData, sessionKey, iv);
        System.out.println(userInfo + "信息啊");
        SecondUser secondUser = new SecondUser();

        SecondUserExample example = new SecondUserExample();
        example.createCriteria().andUsernameEqualTo(openid);
        List<SecondUser> list = secondUserMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            secondUser.setAddress(userInfo.getString("country") + " " + userInfo.getString("province") + " " + userInfo.getString("city"));
//            secondUser.setUsername(openid);
            secondUser.setPhone(userInfo.getString("phone"));
            System.out.println(userInfo);
            secondUser.setCreateDate(LocalDateTime.now());
            secondUser.setModifyDate(LocalDateTime.now());
            secondUser.setIdDeleted((byte) 0);
            secondUser.setIsAuthentication(Authentication.UserState.NOPASS.getState());
            secondUser.setRegion(userInfo.getString("province"));
            secondUser.setUserStatus((byte) 0);
            secondUser.setNickName(userInfo.getString("nickName"));
            secondUser.setUserType(Authentication.LoginType.STOREWX.getState());
            secondUserMapper.insert(secondUser);
        } else {
            secondUser = list.get(0);
        }

        SecondStore secondStore = new SecondStore();
        secondStore.setStoreType(Authentication.StoreType.STORE.getState());
        secondStore.setUserId(secondUser.getId());
        secondStore.setConcernCount(0);
        secondStore.setIsDeleted((short) 0);
        secondStore.setCreateTime(LocalDateTime.now());
        secondStore.setModifyDate(LocalDateTime.now());
        secondStoreMapper.insertSelective(secondStore);
        SecondAuth record = new SecondAuth();
        record.setStoreId(secondStore.getId());
        record.setAuthKey(openid);
        record.setAuthStatus(Byte.valueOf("0"));
        record.setAuthType(WxStoreLoginConfig.AuthType.WECHART.getAuthType());
        record.setCreateDate(LocalDateTime.now());
        record.setModifyDate(LocalDateTime.now());
        record.setUserId(secondUser.getId());
        record.setLoginType(Authentication.LoginType.STOREWX.getState());
        secondAuthMapper.insert(record);
        return secondUser;
    }

    @RequestMapping(path = "/authenticationStore", method = RequestMethod.POST)
    @ApiOperation(value = "商家入驻认证", notes = "商家入驻认证")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "name", value = "名称", required = true, type = "String"),
            @ApiImplicitParam(paramType = "query", name = "sex", value = "性别", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "userId", value = "用户id", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "authenticationDesc", value = "认证说明", required = true, type = "String"),
    })
    public ResponseEntity<JSONObject> authenticationStore(@RequestParam(value = "name", required = false) String name,
                                                     @RequestParam(value = "sex", required = false) Integer sex,
                                                     @RequestParam(value = "userId", required = false) Integer userId,
                                                     @RequestParam(value = "authenticationDesc", required = false) String authenticationDesc,
                                                     HttpServletResponse response, HttpServletRequest request) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
        SecondStoreAuthentication secondStoreAuthentication = new SecondStoreAuthentication();
        secondStoreAuthentication.setUserId(userId);
        secondStoreAuthentication.setAuthenticationDesc(authenticationDesc);
        secondStoreAuthentication.setSex(sex);
        secondStoreAuthentication.setAuthenticationState(Authentication.State.AUDIT.getState());
        secondStoreAuthentication.setCreateDate(LocalDateTime.now());
        secondStoreAuthentication.setModifyDate(LocalDateTime.now());
        secondStoreAuthentication.setIsDeleted((byte) 0);
        secondStoreAuthenticationMapper.insertSelective(secondStoreAuthentication);
        Map<String,Object> map = new HashMap<>();
        map.put("authenticationId",secondStoreAuthentication.getId());//审核id
        return builder.body(ResponseUtils.getResponseBody(map));
    }
    @RequestMapping(path = "/authenticationFile", method = RequestMethod.POST)
    @ApiOperation(value = "入驻商家认证文件上传", notes = "入驻商家认证文件上传")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "fileIds", value = "文件数组", required = true, type = "Integer[]"),
            @ApiImplicitParam(paramType = "query", name = "AuthenticationId", value = "审核id", required = true, type = "Integer"),
    })
    public ResponseEntity<JSONObject> authenticationFile(
            @RequestParam(value = "fileIds", required = false) String[] fileIds,
            @RequestParam(value = "AuthenticationId", required = false) Integer AuthenticationId
    ) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
        for (String file: fileIds){
            SecondStoreAuthenticationPicture secondAuthenticationPicture = new SecondStoreAuthenticationPicture();
            secondAuthenticationPicture.setSecondAuthenticationId(AuthenticationId);
            secondAuthenticationPicture.setSecondPicture(file);
            secondAuthenticationPicture.setCreateDate(LocalDateTime.now());
            secondAuthenticationPicture.setModifyDate(LocalDateTime.now());
            secondAuthenticationPicture.setIsDeleted((byte) 0);
            secondStoreAuthenticationPictureMapper.insertSelective(secondAuthenticationPicture);
        }
        return builder.body(ResponseUtils.getResponseBody(0));
    }

    @RequestMapping(path = "/authenticationList", method = RequestMethod.GET)
    @ApiOperation(value = "商家认证列表", notes = "商家认证列表")

    public ResponseEntity<JSONObject> authenticationList(
    ) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
//审核列表
        SecondStoreAuthenticationExample secondAuthenticationExample = new SecondStoreAuthenticationExample();
        secondAuthenticationExample.createCriteria().andIsDeletedEqualTo((byte) 0);
        List<SecondStoreAuthentication> secondStoreAuthentications = secondStoreAuthenticationMapper.selectByExample(secondAuthenticationExample);
        List<AuthenticationStoreList> authenticationStoreList = new ArrayList<>();
        //        循环审核
        secondStoreAuthentications.forEach(secondStoreAuthentication -> {
            //审核列表
            AuthenticationStoreList authenticationStoreList1 = new AuthenticationStoreList();
//            查询审核列表图片
            SecondStoreAuthenticationPictureExample secondStoreAuthenticationPictureExample = new SecondStoreAuthenticationPictureExample();
            secondStoreAuthenticationPictureExample.createCriteria().andIsDeletedEqualTo((byte) 0).andSecondAuthenticationIdEqualTo(secondStoreAuthentication.getId());
            List<SecondStoreAuthenticationPicture> secondStoreAuthenticationPictures = secondStoreAuthenticationPictureMapper.selectByExample(secondStoreAuthenticationPictureExample);
            //图片放入审核列表
            secondStoreAuthenticationPictures.forEach(secondAuthenticationPicture -> {
                List<String> picts = new ArrayList<>();
                picts.add(secondAuthenticationPicture.getSecondPicture());
                authenticationStoreList1.setSecondPictures(picts);
            });
            //放入审核信息
            authenticationStoreList1.setId(secondStoreAuthentication.getId());//审核id
            authenticationStoreList1.setUserId(secondStoreAuthentication.getUserId());//用户id
            authenticationStoreList1.setName(secondStoreAuthentication.getName());//用户审核名称
            authenticationStoreList1.setSex(secondStoreAuthentication.getSex());//性别
            authenticationStoreList1.setAuthenticationState(secondStoreAuthentication.getAuthenticationState());//认证状态
            authenticationStoreList1.setCreateDate(secondStoreAuthentication.getCreateDate());//创建时间
            authenticationStoreList.add(authenticationStoreList1);
        });
        return builder.body(ResponseUtils.getResponseBody(authenticationStoreList));
    }

    @RequestMapping(path = "/authenticationDispose", method = RequestMethod.POST)
    @ApiOperation(value = "入驻商家认证处理", notes = "入驻商家认证处理")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "StartAuthenticationState", value = "开始审核状态", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "AuthenticationId", value = "审核id", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "EndAuthenticationState", value = "审核id", required = true, type = "Integer"),
    })
    public ResponseEntity<JSONObject> authenticationDispose(
            @RequestParam(value = "AuthenticationId", required = false) Integer AuthenticationId,
            @RequestParam(value = "StartAuthenticationState", required = false) Integer StartAuthenticationState,
            @RequestParam(value = "EndAuthenticationState", required = false) Integer EndAuthenticationState
    ) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
//        修改审核表状态
        SecondStoreAuthentication secondStoreAuthentication = new SecondStoreAuthentication();
        secondStoreAuthentication.setAuthenticationState(Authentication.State.getState(EndAuthenticationState).getState());
        SecondStoreAuthenticationExample secondStoreAuthenticationExample = new SecondStoreAuthenticationExample();
        secondStoreAuthenticationExample.createCriteria().andIsDeletedEqualTo((byte) 0)
                .andIdEqualTo(AuthenticationId)
                .andAuthenticationStateEqualTo(Authentication.State.getState(StartAuthenticationState).getState());
        secondStoreAuthenticationMapper.updateByExampleSelective(secondStoreAuthentication,secondStoreAuthenticationExample);
        //修改用户表状态
        List<SecondStoreAuthentication> secondStoreAuthentications = secondStoreAuthenticationMapper.selectByExample(secondStoreAuthenticationExample);
        if (secondStoreAuthentications.size()!=0 && EndAuthenticationState.equals(Authentication.State.PASS.getState())){
            SecondUser secondUser = new SecondUser();
            secondUser.setId(secondStoreAuthentications.get(0).getUserId());
            secondUser.setIsAuthentication(Authentication.UserState.PASS.getState());
            secondUserMapper.updateByPrimaryKeySelective(secondUser);
        }
        return builder.body(ResponseUtils.getResponseBody(0));
    }
}