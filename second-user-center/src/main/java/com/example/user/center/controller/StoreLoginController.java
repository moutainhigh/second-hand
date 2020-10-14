package com.example.user.center.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.user.center.config.WxStoreLoginConfig;
import com.example.user.center.dao.*;
import com.example.user.center.manual.*;
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
    //店铺余额
    @Autowired
    private SecondStoreBalanceMapper secondStoreBalanceMapper;
    @Autowired
    private SecondStoreAuthenticationMapper secondStoreAuthenticationMapper;
    @Autowired
    private SecondStoreAuthenticationPictureMapper secondStoreAuthenticationPictureMapper;
    //地址
    @Autowired
    private SecondStoreAddressMapper secondStoreAddressMapper;

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
            secondUser.setFile(userInfo.getString("avatarUrl"));
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
        secondStore.setSecondStatus(Authentication.UserState.NOPASS.getState());
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
            @ApiImplicitParam(paramType = "query", name = "storeName", value = "店铺名称", required = true, type = "String"),
            @ApiImplicitParam(paramType = "query", name = "province", value = "省", required = true, type = "String"),
            @ApiImplicitParam(paramType = "query", name = "city", value = "市", required = true, type = "String"),
            @ApiImplicitParam(paramType = "query", name = "conty", value = "区/县", required = true, type = "String"),
            @ApiImplicitParam(paramType = "query", name = "addressDetail", value = "地址详情", required = true, type = "String"),
            @ApiImplicitParam(paramType = "query", name = "phoneNumber", value = "联系方式", required = true, type = "String"),
            @ApiImplicitParam(paramType = "query", name = "sex", value = "性别", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "storeId", value = "店铺id", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "userId", value = "用户id", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "authenticationDesc", value = "认证说明", required = true, type = "String"),
            @ApiImplicitParam(paramType = "query", name = "longitude", value = "经度", required = true, type = "String"),
            @ApiImplicitParam(paramType = "query", name = "latitude", value = "纬度", required = true, type = "String"),
    })
    public ResponseEntity<JSONObject> authenticationStore(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "longitude", required = false) String longitude,
            @RequestParam(value = "latitude", required = false) String latitude,
            @RequestParam(value = "storeName", required = false) String storeName,
            @RequestParam(value = "province", required = false) String province,
            @RequestParam(value = "city", required = false) String city,
            @RequestParam(value = "conty", required = false) String conty,
            @RequestParam(value = "phoneNumber", required = false) String phoneNumber,
            @RequestParam(value = "addressDetail", required = false) String addressDetail,
                                                     @RequestParam(value = "sex", required = false) Integer sex,
                                                     @RequestParam(value = "storeId", required = false) Integer storeId,
                                                     @RequestParam(value = "userId", required = false) Integer userId,
                                                     @RequestParam(value = "authenticationDesc", required = false) String authenticationDesc,
                                                     HttpServletResponse response, HttpServletRequest request) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();

        SecondStoreAuthenticationExample secondStoreAuthenticationExample = new SecondStoreAuthenticationExample();
        secondStoreAuthenticationExample.createCriteria()
                .andUserIdEqualTo(userId)
                .andStoreIdEqualTo(storeId)
                .andIsDeletedEqualTo((byte) 0)
        .andAuthenticationStateEqualTo(Authentication.State.PASS.getState());
        List<SecondStoreAuthentication> secondStoreAuthentications
                = secondStoreAuthenticationMapper.selectByExample(secondStoreAuthenticationExample);
        if (secondStoreAuthentications.size()!=0){
            return builder.body(ResponseUtils.getResponseBody("已经认证了"));
        }
        secondStoreAuthenticationExample.clear();
        secondStoreAuthenticationExample.createCriteria()
                .andUserIdEqualTo(userId)
                .andStoreIdEqualTo(storeId)
                .andIsDeletedEqualTo((byte) 0)
                .andAuthenticationStateEqualTo(Authentication.State.AUDIT.getState());
        List<SecondStoreAuthentication> secondStoreAuthentications1
                = secondStoreAuthenticationMapper.selectByExample(secondStoreAuthenticationExample);
        if (secondStoreAuthentications1.size()==0){
            SecondStoreAuthentication secondStoreAuthentication = new SecondStoreAuthentication();
            secondStoreAuthentication.setName(name);
            secondStoreAuthentication.setStoreId(storeId);
            secondStoreAuthentication.setUserId(userId);
            secondStoreAuthentication.setAuthenticationDesc(authenticationDesc);
            secondStoreAuthentication.setSex(sex);
            secondStoreAuthentication.setAuthenticationState(Authentication.State.AUDIT.getState());
            secondStoreAuthentication.setModifyDate(LocalDateTime.now());
            secondStoreAuthentication.setIsDeleted((byte) 0);
            secondStoreAuthenticationMapper.insertSelective(secondStoreAuthentication);
            //地址
            SecondStoreAddress secondStoreAddress = new SecondStoreAddress();
            secondStoreAddress.setStoreId(storeId);
            secondStoreAddress.setSecondProvince(province);
            secondStoreAddress.setLatitude(latitude);
            secondStoreAddress.setLongitude(longitude);
            secondStoreAddress.setSecondCity(city);
            secondStoreAddress.setSecondConty(conty);
            secondStoreAddress.setSecondAddressDetail(addressDetail);
            secondStoreAddress.setContact(phoneNumber);///联系方式
            secondStoreAddress.setContact(name);
            secondStoreAddress.setIsDeleted((short) 1);
            secondStoreAddress.setModifyTime(LocalDateTime.now());
            secondStoreAddressMapper.insertSelective(secondStoreAddress);
            //店铺
            SecondStore secondStore = new SecondStore();
            secondStore.setId(storeId);
            secondStore.setStoreName(storeName);
            secondStore.setContact(name);
            secondStore.setPhoneNumber(phoneNumber);
            secondStore.setSecondAddress(city+conty+addressDetail);
            secondStore.setModifyDate(LocalDateTime.now());
            secondStoreMapper.updateByPrimaryKeySelective(secondStore);
            Map<String,Object> map = new HashMap<>();
            map.put("authenticationId",secondStoreAuthentication.getId());//审核id
            map.put("addressId",secondStoreAddress.getId());//地址id
            return builder.body(ResponseUtils.getResponseBody(map));
        } else {
            SecondStoreAuthentication secondStoreAuthentication = new SecondStoreAuthentication();
            secondStoreAuthentication.setId(secondStoreAuthentications1.get(0).getId());
            secondStoreAuthentication.setName(name);
            secondStoreAuthentication.setStoreId(storeId);
            secondStoreAuthentication.setUserId(userId);
            secondStoreAuthentication.setAuthenticationDesc(authenticationDesc);
            secondStoreAuthentication.setSex(sex);
            secondStoreAuthentication.setAuthenticationState(Authentication.State.AUDIT.getState());
            secondStoreAuthentication.setModifyDate(LocalDateTime.now());
            secondStoreAuthentication.setIsDeleted((byte) 0);
            secondStoreAuthenticationMapper.updateByPrimaryKeySelective(secondStoreAuthentication);
            //地址
            SecondStoreAddressExample secondStoreAddressExample = new SecondStoreAddressExample();
            secondStoreAddressExample.createCriteria()
                    .andStoreIdEqualTo(storeId)
                    .andIsDeletedEqualTo((short) 0);
            SecondStoreAddress secondStoreAddress = new SecondStoreAddress();
            secondStoreAddress.setStoreId(storeId);
            secondStoreAddress.setSecondProvince(province);
            secondStoreAddress.setLatitude(latitude);
            secondStoreAddress.setLongitude(longitude);
            secondStoreAddress.setSecondCity(city);
            secondStoreAddress.setSecondConty(conty);
            secondStoreAddress.setSecondAddressDetail(addressDetail);
            secondStoreAddress.setContact(phoneNumber);///联系方式
            secondStoreAddress.setContact(name);
            secondStoreAddress.setIsDeleted((short) 0);
            secondStoreAddress.setModifyTime(LocalDateTime.now());
            secondStoreAddressMapper.updateByExampleSelective(secondStoreAddress,secondStoreAddressExample);
            //店铺
            SecondStore secondStore = new SecondStore();
            secondStore.setId(storeId);
            secondStore.setStoreName(storeName);
            secondStore.setContact(name);
            secondStore.setPhoneNumber(phoneNumber);
            secondStore.setSecondAddress(city+conty+addressDetail);
            secondStore.setModifyDate(LocalDateTime.now());
            secondStoreMapper.updateByPrimaryKeySelective(secondStore);

            SecondStoreAuthenticationPictureExample secondStoreAuthenticationPictureExample
                     = new SecondStoreAuthenticationPictureExample();
            secondStoreAuthenticationPictureExample.createCriteria()
                    .andSecondAuthenticationIdEqualTo(secondStoreAuthentications1.get(0).getId())
                    .andIsDeletedEqualTo((byte) 0);
            SecondStoreAuthenticationPicture secondStoreAuthenticationPicture = new SecondStoreAuthenticationPicture();
            secondStoreAuthenticationPicture.setIsDeleted((byte) 1);
            secondStoreAuthenticationPictureMapper.updateByExampleSelective(secondStoreAuthenticationPicture,secondStoreAuthenticationPictureExample);
            Map<String,Object> map = new HashMap<>();
            map.put("authenticationId",secondStoreAuthentications1.get(0).getId());//审核id
            map.put("addressId",secondStoreAddress.getId());//地址id
            return builder.body(ResponseUtils.getResponseBody(map));
        }

    }
    @RequestMapping(path = "/authenticationFile", method = RequestMethod.POST)
    @ApiOperation(value = "入驻商家认证文件上传", notes = "入驻商家认证文件上传")
    @ApiImplicitParams({
//            @ApiImplicitParam(paramType = "query", name = "fileIds", value = "文件数组", required = true, type = "String[]"),
            @ApiImplicitParam(paramType = "query", name = "AuthenticationId", value = "审核id", required = true, type = "Integer"),
    })
    public ResponseEntity<JSONObject> authenticationFile(
            @RequestParam(value = "fileIds", required = false) String[] fileIds,
            @RequestParam(value = "AuthenticationId", required = false) Integer AuthenticationId
    ) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
        System.out.println(fileIds);
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
        secondAuthenticationExample.createCriteria().andIsDeletedEqualTo((byte) 0)
        .andAuthenticationStateEqualTo(Authentication.State.AUDIT.getState());
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
            //店铺
            SecondStore secondStore = secondStoreMapper.selectByPrimaryKey(secondStoreAuthentication.getStoreId());
            authenticationStoreList1.setStoreId(secondStore.getId());
            authenticationStoreList1.setStoreName(secondStore.getStoreName());
            authenticationStoreList1.setName(secondStore.getContact());
            authenticationStoreList1.setStoreAddress(secondStore.getSecondAddress());
            authenticationStoreList1.setStorePhone(secondStore.getPhoneNumber());
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
            SecondStore secondStore = new SecondStore();
            secondStore.setId(secondStoreAuthentications.get(0).getStoreId());
            secondStore.setSecondStatus(Authentication.UserState.PASS.getState());
            secondStoreMapper.updateByPrimaryKeySelective(secondStore);
        }
        return builder.body(ResponseUtils.getResponseBody(0));
    }

    @RequestMapping(path = "/enterStoreList", method = RequestMethod.GET)
    @ApiOperation(value = "入驻商家列表", notes = "入驻商家列表")

    public ResponseEntity<JSONObject> enterStoreList(
    ) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
        SecondStoreExample secondStoreExample = new SecondStoreExample();
        secondStoreExample.createCriteria().andStoreTypeEqualTo(Authentication.StoreType.STORE.getState())
                .andSecondStatusEqualTo(Authentication.UserState.PASS.getState())
                .andIsDeletedEqualTo((short) 0);
        List<SecondStore> secondStores = secondStoreMapper.selectByExample(secondStoreExample);
        List<EnterStoreList> enterStoreLists = new ArrayList<>();
        secondStores.forEach(secondStore -> {
            System.out.println(secondStore.getId());
            EnterStoreList enterStoreList = new EnterStoreList();
            enterStoreList.setStoreId(secondStore.getId());
            enterStoreList.setUserId(secondStore.getUserId());
            enterStoreList.setPhone(secondStore.getPhoneNumber());
            enterStoreList.setStoreName(secondStore.getStoreName());
            enterStoreList.setStoreAddress(secondStore.getSecondAddress());
            SecondUser secondUser = secondUserMapper.selectByPrimaryKey(secondStore.getUserId());
            enterStoreList.setNickName(secondUser.getNickName());
            enterStoreLists.add(enterStoreList);
        });
        return builder.body(ResponseUtils.getResponseBody(enterStoreLists));
    }
    @RequestMapping(path = "/enterStoreDelete", method = RequestMethod.POST)
    @ApiOperation(value = "删除入驻商家", notes = "删除入驻商家")

    public ResponseEntity<JSONObject> enterStoreDelete(
            Integer storeId
    ) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
        SecondStore secondStore = new SecondStore();
        secondStore.setId(storeId);
        secondStore.setIsDeleted((short) 0);
        secondStore.setModifyDate(LocalDateTime.now());
        secondStoreMapper.updateByPrimaryKeySelective(secondStore);
        return builder.body(ResponseUtils.getResponseBody(0));
    }
    @RequestMapping(path = "/storeDetails", method = RequestMethod.GET)
    @ApiOperation(value = "店铺详情", notes = "店铺详情")
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
        if (secondStoreBalances.size()!=0){
            storeDetails.setCreateTime(secondStore.getCreateTime());
            storeDetails.setAddress(secondStore.getSecondAddress());
            storeDetails.setStoreStatus(secondStore.getSecondStatus());
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
}
