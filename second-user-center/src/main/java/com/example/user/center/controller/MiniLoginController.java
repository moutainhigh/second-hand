package com.example.user.center.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.user.center.config.WxLoginConfig;
import com.example.user.center.dao.*;
import com.example.user.center.manual.*;
import com.example.user.center.model.*;
import com.google.common.collect.Lists;
import com.second.common.service.FileMangeService;
import com.second.common.utils.Encrypt;
import com.second.utils.response.handler.ResponseEntity;
import com.second.utils.response.handler.ResponseUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author shihao
 * @Title: MiniLoginController
 * @ProjectName Second-order-center
 * @Description:
 * @date Created in
 * @Version: $
 */
@RestController
@Api
@RequestMapping("/MiniLoginController")
@CrossOrigin
public class MiniLoginController {
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private SecondAuthMapper secondAuthMapper;
    @Autowired
    private SecondUserMapper secondUserMapper;
    //学生认证
    @Autowired
    private SecondAuthenticationMapper secondAuthenticationMapper;
    //学校
    @Autowired
    private SecondCollegesMapper collegesMapper;
    @Autowired
    private SecondAuthenticationPictureMapper secondAuthenticationPictureMapper;
//店铺
@Autowired
private SecondStoreMapper secondStoreMapper;
//商品
    @Autowired
    private SecondProductMapper secondProductMapper;
    //订单
    @Autowired
    private SecondOrderMapper secondOrderMapper;
    //
    @Autowired
    private SecondUserSonMapper secondUserSonMapper;
    //子站点
    @Autowired
    private SecondSonMapper secondSonMapper;
    //boss
    @Autowired
    private SecondBossMapper secondBossMapper;
    //关注
    @Autowired
    private SecondAttentionMapper secondAttentionMapper;
    //评价
    @Autowired
    private SecondEvaluateMapper secondEvaluateMapper;
    //余额
    @Autowired
    private SecondStoreBalanceMapper secondStoreBalanceMapper;
    //收藏想要
    @Autowired
    private SecondProductWantMapper secondProductWantMapper;
    @Autowired
    private SecondGoodsMapper secondGoodsMapper;
    @RequestMapping(path = "/wechart", method = RequestMethod.GET)
    @ApiOperation(value = "微信登录", notes = "微信登录")
    public ResponseEntity<JSONObject> wxLogin(@RequestParam(value = "code", required = false) String code,
                                              @RequestParam(value = "appName", required = false) String appName,
                                              @RequestParam(value = "encryptedData", required = false) String encryptedData,
                                              @RequestParam(value = "iv", required = false) String iv, HttpServletResponse response, HttpServletRequest request) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        JSONObject SessionKeyOpenId = WxLoginConfig.getSessionKeyOrOpenId(code, appName);
        System.out.println(SessionKeyOpenId);
        String openid = (String) SessionKeyOpenId.get("openid");
        String sessionKey = String.valueOf(SessionKeyOpenId.get("session_key"));
        System.out.println(openid+"我是openId");
        SecondAuthExample secondAuthExample = new SecondAuthExample();
        secondAuthExample.createCriteria().andAuthKeyEqualTo(openid)
                .andAuthTypeEqualTo(WxLoginConfig.AuthType.WECHART.getAuthType());
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
        String token = encrypt.getToken(true, secondUser.getId(), "user", Integer.valueOf(secondUser.getIsAuthentication()));
        System.out.println(token);
        response.addHeader("token", token);

        map.put("skey", skey);
        map.put("userId", secondUser.getId());
        map.put("user", secondUser);
        map.put("token", token);
        SecondUser secondUser1 = secondUserMapper.selectByPrimaryKey(secondUser.getId());
        map.put("AuthStart",secondUser1.getIsAuthentication());//认证状态
        SecondStoreExample secondStoreExample = new SecondStoreExample();
        secondStoreExample.createCriteria().andUserIdEqualTo(secondUser.getId())
                .andIsDeletedEqualTo((short) 0);
        List<SecondStore> secondStores = secondStoreMapper.selectByExample(secondStoreExample);
        map.put("storeId",secondStores.get(0).getId());
        SecondUserSonExample secondUserSonExample = new SecondUserSonExample();
        secondUserSonExample.createCriteria().andUserIdEqualTo(secondUser.getId())
                .andStoreIdEqualTo(secondStores.get(0).getId())
                .andIsDeletedEqualTo((byte) 0);
        List<SecondUserSon> secondUserSons =
        secondUserSonMapper.selectByExample(secondUserSonExample);
        SecondSon secondSon = new SecondSon();
        if (secondUserSons.size()!=0){
            secondSon = secondSonMapper.selectByPrimaryKey(secondUserSons.get(0).getSonId());
        }
        map.put("sonId", secondSon.getId());
        map.put("sonName", secondSon.getSonName());
//        map.put("college", secondSon.getcoll)
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
        return builder.body(ResponseUtils.getResponseBody(map));
    }

    public SecondUser register(String openid, String sessionKey, String encryptedData, String iv)
            throws InvalidKeyException, NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException,
            InvalidParameterSpecException, InvalidAlgorithmParameterException, IllegalBlockSizeException,
            BadPaddingException, UnsupportedEncodingException {
        JSONObject userInfo = WxLoginConfig.parseWechart(encryptedData, sessionKey, iv);
        System.out.println(userInfo + "信息啊");
        SecondUser secondUser = new SecondUser();

        SecondUserExample example = new SecondUserExample();
        example.createCriteria().andUsernameEqualTo(openid);
        List<SecondUser> list = secondUserMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            secondUser.setAddress(userInfo.getString("country") + " " + userInfo.getString("province") + " " + userInfo.getString("city"));
//            secondUser.setUsername(openid);
            secondUser.setFile(userInfo.getString("avatarUrl"));
            secondUser.setPhone(userInfo.getString("phone"));
            System.out.println(userInfo);
            secondUser.setCreateDate(LocalDateTime.now());
            secondUser.setModifyDate(LocalDateTime.now());
            secondUser.setIdDeleted((byte) 0);
            secondUser.setIsAuthentication(Authentication.UserState.NOPASS.getState());
            secondUser.setRegion(userInfo.getString("province"));
            secondUser.setUserStatus((byte) 0);
            secondUser.setNickName(userInfo.getString("nickName"));
            secondUser.setUserType(Authentication.LoginType.USERWX.getState());
            secondUserMapper.insert(secondUser);
        } else {
            secondUser = list.get(0);
        }

        SecondStore secondStore = new SecondStore();
        secondStore.setSecondBalance(0);
        secondStore.setStoreType(Authentication.StoreType.USER.getState());
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
        record.setAuthType(WxLoginConfig.AuthType.WECHART.getAuthType());
        record.setCreateDate(LocalDateTime.now());
        record.setModifyDate(LocalDateTime.now());
        record.setUserId(secondUser.getId());
        record.setLoginType(Authentication.LoginType.USERWX.getState());
        record.setIsDeleted((byte) 0);
        secondAuthMapper.insert(record);
        return secondUser;
    }

    @RequestMapping(path = "/authentication", method = RequestMethod.POST)
    @ApiOperation(value = "学生认证", notes = "提交学生认证")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "name", value = "名称", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "sex", value = "性别", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "date", value = "入学时间", required = true, type = "Date"),
            @ApiImplicitParam(paramType = "query", name = "number", value = "学号", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "colleges", value = "学校id", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "record", value = "学校类别", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "userId", value = "用户id", required = true, type = "Integer"),
    })
    public ResponseEntity<JSONObject> authentication(@RequestParam(value = "name", required = false) String name,
                                                     @RequestParam(value = "sex", required = false) Integer sex,
                                                     @RequestParam(value = "storeId", required = false) Integer storeId,
                                                     @RequestParam(value = "date", required = false) Date date,
                                                     @RequestParam(value = "number", required = false) String number,
                                                     @RequestParam(value = "colleges", required = false) Integer colleges,
                                                     @RequestParam(value = "record", required = false) String record,
                                                     @RequestParam(value = "userId", required = false) Integer userId,
                                                     HttpServletResponse response, HttpServletRequest request) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
        SecondAuthenticationExample secondAuthenticationExample
                = new SecondAuthenticationExample();
        secondAuthenticationExample.createCriteria()
                .andUserIdEqualTo(userId)
                .andIsDeletedEqualTo((byte) 0)
        .andAuthenticationStateEqualTo(Authentication.State.PASS.getState());
        List<SecondAuthentication> secondAuthenticationExamples
                 = secondAuthenticationMapper.selectByExample(secondAuthenticationExample);
        if (secondAuthenticationExamples.size()!=0){
            return builder.body(ResponseUtils.getResponseBody("已经审核通过"));
        }
        secondAuthenticationExample.clear();
        secondAuthenticationExample.createCriteria()
                .andUserIdEqualTo(userId)
                .andIsDeletedEqualTo((byte) 0)
                .andAuthenticationStateEqualTo(Authentication.State.AUDIT.getState());
        List<SecondAuthentication> secondAuthenticationExamples1
                = secondAuthenticationMapper.selectByExample(secondAuthenticationExample);
        if (secondAuthenticationExamples1.size()==0){
            //学生认证
            SecondColleges secondColleges = collegesMapper.selectByPrimaryKey(colleges);
            SecondAuthentication secondAuthentication = new SecondAuthentication();
            secondAuthentication.setCollegesName(secondColleges.getName());
            secondAuthentication.setName(name);//名称
            secondAuthentication.setSex(sex);//性别
            Instant instant = date.toInstant();//入学时间
            //date转LocalDateTime
            ZoneId zoneId = ZoneId.systemDefault();
            LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
            secondAuthentication.setEntranceTime(localDateTime);
            secondAuthentication.setStudentNumber(number);//学号
            secondAuthentication.setCollegesId(colleges);//学校id
            secondAuthentication.setCollegesRecord(record);//学校类别
            secondAuthentication.setUserId(userId);//用户id
            secondAuthentication.setAuthenticationState(Authentication.State.AUDIT.getState());//审核状态
            secondAuthentication.setCreateDate(LocalDateTime.now());
            secondAuthentication.setModifyDate(LocalDateTime.now());
            secondAuthentication.setIsDeleted((byte) 0);
            secondAuthentication.setStoreId(storeId);
            secondAuthenticationMapper.insert(secondAuthentication);

            return builder.body(ResponseUtils.getResponseBody(secondAuthentication.getId()));//审核id
        }else {
            //学生认证
            SecondColleges secondColleges = collegesMapper.selectByPrimaryKey(colleges);
            SecondAuthentication secondAuthentication = new SecondAuthentication();
            secondAuthentication.setId(secondAuthenticationExamples1.get(0).getId());
            secondAuthentication.setCollegesName(secondColleges.getName());
            secondAuthentication.setName(name);//名称
            secondAuthentication.setSex(sex);//性别
            Instant instant = date.toInstant();//入学时间
            //date转LocalDateTime
            ZoneId zoneId = ZoneId.systemDefault();
            LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
            secondAuthentication.setEntranceTime(localDateTime);
            secondAuthentication.setStudentNumber(number);//学号
            secondAuthentication.setCollegesId(colleges);//学校id
            secondAuthentication.setCollegesRecord(record);//学校类别
            secondAuthentication.setUserId(userId);//用户id
            secondAuthentication.setAuthenticationState(Authentication.State.AUDIT.getState());//审核状态
            secondAuthentication.setModifyDate(LocalDateTime.now());
            secondAuthentication.setIsDeleted((byte) 0);
            secondAuthentication.setStoreId(storeId);
            secondAuthenticationMapper.updateByPrimaryKeySelective(secondAuthentication);
            return builder.body(ResponseUtils.getResponseBody(secondAuthenticationExamples1.get(0).getId()));

        }

    }
    @RequestMapping(path = "/authenticationFile", method = RequestMethod.POST)
    @ApiOperation(value = "学生认证文件上传", notes = "提交学生认证文件上传")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "fileIds", value = "文件数组", required = true, type = "String[]"),
            @ApiImplicitParam(paramType = "query", name = "AuthenticationId", value = "审核id", required = true, type = "Integer"),
    })
    public ResponseEntity<JSONObject> authenticationFile(
            @RequestParam(value = "fileIds", required = false) String[] fileIds,
            @RequestParam(value = "AuthenticationId", required = false) Integer AuthenticationId
                                                     ) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
        for (String file: fileIds){
            SecondAuthenticationPicture secondAuthenticationPicture = new SecondAuthenticationPicture();
            secondAuthenticationPicture.setSecondAuthenticationId(AuthenticationId);
            secondAuthenticationPicture.setSecondPicture(file);
            secondAuthenticationPicture.setCreateDate(LocalDateTime.now());
            secondAuthenticationPicture.setModifyDate(LocalDateTime.now());
            secondAuthenticationPicture.setIsDeleted((byte) 0);
            secondAuthenticationPictureMapper.insertSelective(secondAuthenticationPicture);
        }
        return builder.body(ResponseUtils.getResponseBody(0));
    }

    @RequestMapping(path = "/authenticationList", method = RequestMethod.GET)
    @ApiOperation(value = "学生认证列表", notes = "学生认证列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "sonId", value = "子站点id", required = true, type = "Integer"),
    })
    public ResponseEntity<JSONObject> authenticationList(
            @RequestParam(value = "sonId", required = false) Integer sonId
    ) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
//审核列表
        SecondAuthenticationExample secondAuthenticationExample = new SecondAuthenticationExample();
        secondAuthenticationExample.createCriteria().andIsDeletedEqualTo((byte) 0)
        .andAuthenticationStateEqualTo(Authentication.State.AUDIT.getState());
        List<SecondAuthentication> secondAuthentications = secondAuthenticationMapper.selectByExample(secondAuthenticationExample);
        List<AuthenticationList> authenticationList = new ArrayList<>();
        //        循环审核
        secondAuthentications.forEach(secondAuthentication -> {
            //审核列表
            AuthenticationList authenticationList1 = new AuthenticationList();
//            查询审核列表图片
            SecondAuthenticationPictureExample secondAuthenticationPictureExample = new SecondAuthenticationPictureExample();
            secondAuthenticationPictureExample.createCriteria().andIsDeletedEqualTo((byte) 0).andSecondAuthenticationIdEqualTo(secondAuthentication.getId());
            List<SecondAuthenticationPicture> secondAuthenticationPictures = secondAuthenticationPictureMapper.selectByExample(secondAuthenticationPictureExample);
            //图片放入审核列表
            secondAuthenticationPictures.forEach(secondAuthenticationPicture -> {
                List<String> picts = new ArrayList<>();
                picts.add(secondAuthenticationPicture.getSecondPicture());
                authenticationList1.setSecondPictures(picts);
            });
            //放入审核信息
            authenticationList1.setId(secondAuthentication.getId());//审核id
            authenticationList1.setUserId(secondAuthentication.getUserId());//用户id
            authenticationList1.setName(secondAuthentication.getName());//用户审核名称
            authenticationList1.setSex(secondAuthentication.getSex());//性别
            authenticationList1.setCollegesName(secondAuthentication.getCollegesName());//学校名称
            authenticationList1.setEntranceTime(secondAuthentication.getEntranceTime());//入学时间
            authenticationList1.setStudentNumber(secondAuthentication.getStudentNumber());//学号
            authenticationList1.setCollegesRecord(secondAuthentication.getCollegesRecord());//学校类别
            authenticationList1.setAuthenticationState(secondAuthentication.getAuthenticationState());//认证状态
            authenticationList1.setCreateDate(secondAuthentication.getCreateDate());//创建时间
            //学校
            SecondColleges secondColleges = collegesMapper.selectByPrimaryKey(secondAuthentication.getCollegesId());
            //子站点
            SecondSonExample secondSonExample = new SecondSonExample();
            secondSonExample.createCriteria().andCollegoryIdEqualTo(secondColleges.getId())
                    .andIsDeletedEqualTo((short) 0);
            List<SecondSon> secondSon = secondSonMapper.selectByExample(secondSonExample);
            authenticationList1.setSonId(secondSon.get(0).getId());
            authenticationList1.setSonName(secondSon.get(0).getSonName());
            authenticationList.add(authenticationList1);
        });
        if (sonId != null){
            List<AuthenticationList> authenticationList1 =
            authenticationList.stream().filter(a-> a.getSonId().equals(sonId)).collect(Collectors.toList());
            return builder.body(ResponseUtils.getResponseBody(authenticationList1));
        }
        return builder.body(ResponseUtils.getResponseBody(authenticationList));
    }

    @RequestMapping(path = "/authenticationDispose", method = RequestMethod.POST)
    @ApiOperation(value = "学生认证处理", notes = "学生认证处理")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "StartAuthenticationState", value = "开始审核状态", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "AuthenticationId", value = "审核id", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "EndAuthenticationState", value = "结束审核状态", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "sonId", value = "子站点id", required = true, type = "Integer"),
    })
    public ResponseEntity<JSONObject> authenticationDispose(
            @RequestParam(value = "AuthenticationId", required = false) Integer AuthenticationId,
            @RequestParam(value = "StartAuthenticationState", required = false) Integer StartAuthenticationState,
            @RequestParam(value = "sonId", required = false) Integer sonId,
            @RequestParam(value = "EndAuthenticationState", required = false) Integer EndAuthenticationState
    ) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
//        修改审核表状态
        SecondAuthentication secondAuthentication = new SecondAuthentication();
        secondAuthentication.setAuthenticationState(Authentication.State.getState(EndAuthenticationState).getState());
        SecondAuthenticationExample secondAuthenticationExample = new SecondAuthenticationExample();
        secondAuthenticationExample.createCriteria().andIsDeletedEqualTo((byte) 0)
                .andIdEqualTo(AuthenticationId)
                .andAuthenticationStateEqualTo(Authentication.State.getState(StartAuthenticationState).getState());
        List<SecondAuthentication> secondAuthentications = secondAuthenticationMapper.selectByExample(secondAuthenticationExample);
        secondAuthenticationMapper.updateByExampleSelective(secondAuthentication,secondAuthenticationExample);
        //修改用户表状态

        if (secondAuthentications.size()!=0 && EndAuthenticationState.equals(Authentication.State.PASS.getState())){
            SecondUser secondUser = new SecondUser();
            secondUser.setPhone(secondAuthentications.get(0).getStudentNumber());
            secondUser.setId(secondAuthentications.get(0).getUserId());
            secondUser.setIsAuthentication(Authentication.UserState.PASS.getState());
            secondUserMapper.updateByPrimaryKeySelective(secondUser);
            SecondStoreExample secondStoreExample = new SecondStoreExample();
            secondStoreExample.createCriteria().andUserIdEqualTo(secondAuthentications.get(0).getUserId())
                    .andIsDeletedEqualTo((short) 0);
            SecondStore secondStore = new SecondStore();
            secondStore.setPhoneNumber(secondAuthentications.get(0).getStudentNumber());
            secondStore.setSecondStatus(0);
            secondStore.setCreateTime(LocalDateTime.now());
            secondStoreMapper.updateByExampleSelective(secondStore,secondStoreExample);
            SecondUserSonExample secondUserSonExample = new SecondUserSonExample();
            secondUserSonExample.createCriteria().andUserIdEqualTo(secondAuthentications.get(0).getUserId())
                    .andStoreIdEqualTo(secondAuthentications.get(0).getStoreId())
                    .andSonIdEqualTo(sonId)
                    .andIsDeletedEqualTo((byte) 0);
            List<SecondUserSon> secondUserSons
                     = secondUserSonMapper.selectByExample(secondUserSonExample);
            if (secondUserSons.size()==0){
                //用户店铺积分
                SecondBoss secondBoss = secondBossMapper.selectByPrimaryKey(1);
                SecondStoreBalanceExample secondStoreBalanceExample = new SecondStoreBalanceExample();
                secondStoreBalanceExample.createCriteria()
                        .andUserIdEqualTo(secondAuthentications.get(0).getUserId())
                        .andStoreIdEqualTo(secondAuthentications.get(0).getStoreId())
                        .andIsDeletedEqualTo((short) 0)
                        .andBalanceTypeEqualTo(BanlaceEnum.Relation.INTEGRAL.getState());
                List<SecondStoreBalance> secondStoreBalances =
                        secondStoreBalanceMapper.selectByExample(secondStoreBalanceExample);
                if (secondStoreBalances.size()==0){
                    SecondStoreBalance secondStoreBalance = new SecondStoreBalance();
                    secondStoreBalance.setUserId(secondAuthentications.get(0).getUserId());
                    secondStoreBalance.setStoreId(secondAuthentications.get(0).getStoreId());
                    secondStoreBalance.setBalanceType(BanlaceEnum.Relation.INTEGRAL.getState());
                    secondStoreBalance.setIsDeleted((short) 0);
                    secondStoreBalance.setSecondBalance(secondBoss.getNewUserIntegral());
                    secondStoreBalance.setCreateTime(LocalDateTime.now());
                    secondStoreBalance.setModifyTime(LocalDateTime.now());
                    secondStoreBalanceMapper.insertSelective(secondStoreBalance);
                }

                SecondUserSon secondUserSon = new SecondUserSon();
                secondUserSon.setStoreId(secondAuthentications.get(0).getStoreId());
                secondUserSon.setUserId(secondAuthentications.get(0).getUserId());
                secondUserSon.setSonId(sonId);
                secondUserSon.setCreateDate(LocalDateTime.now());
                secondUserSon.setModifyDate(LocalDateTime.now());
                secondUserSon.setIsDeleted((byte) 0);
                secondUserSonMapper.insertSelective(secondUserSon);
            }
        }
        return builder.body(ResponseUtils.getResponseBody(0));
    }

    @RequestMapping(path = "/UserList", method = RequestMethod.GET)
    @ApiOperation(value = "用户列表", notes = "用户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "IsAuthentication", value = "是否认证,0是，1否", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "sonId", value = "子站点id", required = true, type = "Integer"),
    })
    public ResponseEntity<JSONObject> UserList(
            Integer IsAuthentication,
            Integer sonId
    ) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
        SecondUserExample secondUserExample = new SecondUserExample();
        secondUserExample.createCriteria().andIsAuthenticationEqualTo(IsAuthentication)
        .andUserTypeEqualTo(Authentication.LoginType.USERWX.getState());
        List<SecondUser> secondUsers =
        secondUserMapper.selectByExample(secondUserExample);
        List<UserList> userLists = new ArrayList<>();
        secondUsers.forEach(secondUser -> {
            UserList userList = new UserList();
            userList.setUserId(secondUser.getId());
            userList.setUserFIle(secondUser.getFile());
            userList.setNickName(secondUser.getNickName());
//            SecondAuthenticationExample secondAuthenticationExample = new SecondAuthenticationExample();
//            secondAuthenticationExample.createCriteria().andUserIdEqualTo(secondUser.getId())
//                    .andAuthenticationStateEqualTo(IsAuthentication)
//            .andIsDeletedEqualTo((byte) 0);
//            List<SecondAuthentication> secondAuthentication =
//                    secondAuthenticationMapper.selectByExample(secondAuthenticationExample);
//            if (secondAuthentication.size()!=0){
//                userList.setCollege(secondAuthentication.get(0).getCollegesName());
//            }
            SecondStoreExample secondStoreExample = new SecondStoreExample();
            secondStoreExample.createCriteria().andUserIdEqualTo(secondUser.getId())
                    .andIsDeletedEqualTo((short) 0)
                    .andSecondStatusEqualTo(IsAuthentication);
            List<SecondStore> secondStores = secondStoreMapper.selectByExample(secondStoreExample);
            //默认一个用户一个店铺
            SecondProductExample secondProductExample = new SecondProductExample();
            secondProductExample.createCriteria().andStoreIdEqualTo(secondStores.get(0).getId());
            List<SecondProduct> secondProducts =
            secondProductMapper.selectByExample(secondProductExample);
            //发布数量
            userList.setProductNum(secondProducts.size());
            //购买数量
            SecondOrderExample secondOrderExample = new SecondOrderExample();
            secondOrderExample.createCriteria().andUserIdEqualTo(secondUser.getId())
            .andOrderStatusNotEqualTo(OrderEnum.OrderStatus.PAYMENT.getOrderStatus());
            List<SecondOrder> orders =
            secondOrderMapper.selectByExample(secondOrderExample);
            userList.setBuyProductNum(orders.size());//购买数量
            secondOrderExample.clear();
            secondOrderExample.createCriteria().andStoneIdEqualTo(secondStores.get(0).getId())
                    .andOrderStatusEqualTo(OrderEnum.OrderStatus.COMPLETE.getOrderStatus());
            secondOrderExample.or()// CONTROVERSIAL EVALUATE
                    .andStoneIdEqualTo(secondStores.get(0).getId())
                    .andOrderStatusEqualTo(OrderEnum.OrderStatus.EVALUATE.getOrderStatus());;

            List<SecondOrder> secondOrders = secondOrderMapper.selectByExample(secondOrderExample);
            if (secondOrders.size()!=0){
//                System.out.println(secondOrders.toString());
                Integer Income = secondOrders.stream().mapToInt(SecondOrder::getAmount).sum();
                userList.setIncome(Income);//收入
            }else {
                userList.setIncome(0);//收入
            }
            secondOrderExample.clear();
            secondOrderExample.createCriteria().andUserIdEqualTo(secondUser.getId())
                    .andOrderStatusEqualTo(OrderEnum.OrderStatus.EVALUATE.getOrderStatus());
            SecondOrderExample.Criteria criteria1 =secondOrderExample.createCriteria()
                    .andUserIdEqualTo(secondUser.getId())
                    .andOrderStatusEqualTo(OrderEnum.OrderStatus.COMPLETE.getOrderStatus());
            secondOrderExample.or(criteria1);
            List<SecondOrder> secondOrders1 = secondOrderMapper.selectByExample(secondOrderExample);
            if (secondOrders1.size()!=0){
                Integer Expend= secondOrders1.stream().mapToInt(SecondOrder::getAmount).sum();
                userList.setExpend(Expend);//支出
            } else {
                userList.setExpend(0);//支出
            }
            userList.setPhone(secondStores.get(0).getPhoneNumber());
            userList.setCreateTime(secondUser.getCreateDate());
            userLists.add(userList);
        });
        if (sonId!=null&&IsAuthentication.equals(Authentication.State.PASS.getState())){
            System.out.println(sonId);
            System.out.println(IsAuthentication);
            List<UserList> userLists1 = new ArrayList<>();

            userLists.forEach(userList -> {
                SecondStoreExample secondStoreExample = new SecondStoreExample();
                secondStoreExample.createCriteria().andUserIdEqualTo(userList.getUserId())
                        .andIsDeletedEqualTo((short) 0)
                        .andSecondStatusEqualTo(IsAuthentication);
                List<SecondStore> secondStores = secondStoreMapper.selectByExample(secondStoreExample);
                SecondUserSonExample secondUserSonExample = new SecondUserSonExample();
                secondUserSonExample.createCriteria().andUserIdEqualTo(userList.getUserId())
                        .andStoreIdEqualTo(secondStores.get(0).getId())
                        .andIsDeletedEqualTo((byte) 0)
                        .andSonIdEqualTo(sonId);
                List<SecondUserSon> secondUserSons =
                        secondUserSonMapper.selectByExample(secondUserSonExample);
                if (secondUserSons.size()!=0){
                    SecondSon secondSon = secondSonMapper.selectByPrimaryKey(sonId);
                    userList.setCollege(secondSon.getSonName());
                    userLists1.add(userList);
                }
            });
            return builder.body(ResponseUtils.getResponseBody(userLists1));
        }
        return builder.body(ResponseUtils.getResponseBody(userLists));
    }
    @RequestMapping(path = "/UserDetails", method = RequestMethod.GET)
    @ApiOperation(value = "用户详情", notes = "我的用户详情")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "userId", value = "用户id", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "myUserId", value = "用户id", required = true, type = "Integer"),
    })
    public ResponseEntity<JSONObject> UserDetails(
            Integer userId,
            Integer myUserId
    ) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
        SecondStoreExample secondStoreExample = new SecondStoreExample();
        secondStoreExample.createCriteria().andUserIdEqualTo(userId)
                .andIsDeletedEqualTo((short) 0);
        List<SecondStore> secondStores = secondStoreMapper.selectByExample(secondStoreExample);

        SecondUser secondUser = secondUserMapper.selectByPrimaryKey(userId);
        UserDetails userDetails = new UserDetails();
        userDetails.setUserId(userId);
        if (secondStores.size()!=0){
            userDetails.setStoreId(secondStores.get(0).getId());
            userDetails.setAuthentication(secondStores.get(0).getSecondStatus());
        }
        userDetails.setUserFile(secondUser.getFile());//头像
        userDetails.setNickName(secondUser.getNickName());//昵称
        SecondAttentionExample secondAttentionExample = new SecondAttentionExample();
        secondAttentionExample.createCriteria().andIsDeletedEqualTo((byte) 0)
                .andUserIdEqualTo(userId);
        List<SecondAttention> secondAttentions = secondAttentionMapper.selectByExample(secondAttentionExample);
        userDetails.setAttentionNumber(secondAttentions.size());//关注数量
        secondAttentionExample.clear();
        secondAttentionExample.createCriteria().andByUserIdEqualTo(userId)
                .andIsDeletedEqualTo((byte) 0);
        List<SecondAttention> secondAttentions1 = secondAttentionMapper.selectByExample(secondAttentionExample);
        userDetails.setMyFansNumber(secondAttentions1.size());//粉丝数量
        //评价
        SecondProductExample secondProductExample = new SecondProductExample();
        secondProductExample.createCriteria()
                .andStoreIdEqualTo(secondStores.get(0).getId())
                .andIsDeletedEqualTo((short) 0);
        List<SecondProduct> secondProducts =
                secondProductMapper.selectByExample(secondProductExample);
        Set<Integer> productIds =
                secondProducts.stream().map(SecondProduct::getId).collect(Collectors.toSet());
        if (productIds.size()!=0){
            SecondGoodsExample secondGoodsExample = new SecondGoodsExample();
            secondGoodsExample.createCriteria().andProductIdIn(Lists.newArrayList(productIds));
            List<SecondGoods> secondGoods =
                    secondGoodsMapper.selectByExample(secondGoodsExample);
            Set<Integer> goodsIds = secondGoods.stream().map(SecondGoods::getId).collect(Collectors.toSet());
            SecondEvaluateExample secondEvaluateExample = new SecondEvaluateExample();
            secondEvaluateExample.createCriteria().andGoodsIdIn(Lists.newArrayList(goodsIds))
                    .andIsDeletedEqualTo((short) 0);
            List<SecondEvaluate> secondEvaluates=
                    secondEvaluateMapper.selectByExample(secondEvaluateExample);
            userDetails.setEvaluateNumber(secondEvaluates.size());//评价数量
        }else {
            userDetails.setEvaluateNumber(0);//评价数量
        }
        if (myUserId!=null){
            //被关注
            secondAttentionExample.clear();
            secondAttentionExample.createCriteria().andUserIdEqualTo(userId)
                    .andIsDeletedEqualTo((byte) 0)
                    .andByUserIdEqualTo(myUserId);
            List<SecondAttention> secondAttentions2 =
                    secondAttentionMapper.selectByExample(secondAttentionExample);
            //关注
            secondAttentionExample.clear();
            secondAttentionExample.createCriteria().andUserIdEqualTo(myUserId)
                    .andIsDeletedEqualTo((byte) 0)
                    .andByUserIdEqualTo(userId);
            List<SecondAttention> secondAttentions3 =
                    secondAttentionMapper.selectByExample(secondAttentionExample);
            if (secondAttentions2.size()!=0 && secondAttentions3.size()==0){
                userDetails.setAttention(Attention.Relation.BYATTENTION.getState());//关注关系被关注
            } else if (secondAttentions2.size()==0 && secondAttentions3.size()!=0){
                userDetails.setAttention(Attention.Relation.YETATTENTION.getState());//关注关系关注
            } else if (secondAttentions2.size()!=0 && secondAttentions3.size()!=0){
                userDetails.setAttention(Attention.Relation.EACHOTHER.getState());//关注互相关注
            } else {
                userDetails.setAttention(Attention.Relation.NO.getState());//没关系
            }
//收藏
            SecondProductWantExample secondProductWantExample = new SecondProductWantExample();
            secondProductWantExample.createCriteria()
                    .andIsDeletedEqualTo((short) 0)
                    .andTypeEqualTo(WantEnum.Relation.COLLECT.getState())
                    .andUserIdEqualTo(userId);
            List<SecondProductWant> secondProductWants =
                    secondProductWantMapper.selectByExample(secondProductWantExample);
            userDetails.setCollectNumber(secondProductWants.size());
            //浏览
            secondProductWantExample.clear();
            secondProductWantExample.createCriteria()
                    .andIsDeletedEqualTo((short) 0)
                    .andTypeEqualTo(WantEnum.Relation.LOOK.getState())
                    .andUserIdEqualTo(userId);
            List<SecondProductWant> secondProductWants1 =
                    secondProductWantMapper.selectByExample(secondProductWantExample);
            userDetails.setLookNumber(secondProductWants1.size());
        }
        return builder.body(ResponseUtils.getResponseBody(userDetails));
    }
    @RequestMapping(path = "/UserMoney", method = RequestMethod.GET)
    @ApiOperation(value = "用户积分查询", notes = "用户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "userId", value = "用户id", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "storeId", value = "店铺", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "type", value = "类型", required = true, type = "Integer"),
    })
    public ResponseEntity<JSONObject> UserMoney(
            Integer userId,
            Integer storeId,
            String type
    ) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
        SecondStoreBalanceExample secondStoreBalanceExample = new SecondStoreBalanceExample();
        secondStoreBalanceExample.createCriteria().andUserIdEqualTo(userId)
                .andStoreIdEqualTo(storeId)
                .andBalanceTypeEqualTo(BanlaceEnum.Relation.getState(type).getState())
                .andIsDeletedEqualTo((short) 0);
        List<SecondStoreBalance> secondStoreBalances =
        secondStoreBalanceMapper.selectByExample(secondStoreBalanceExample);
        if (secondStoreBalances.size()!=0){
            return builder.body(ResponseUtils.getResponseBody(secondStoreBalances));
        }else {
            SecondStoreBalance secondStoreBalance = new SecondStoreBalance();
            secondStoreBalance.setUserId(userId);
            secondStoreBalance.setStoreId(storeId);
            secondStoreBalance.setBalanceType(BanlaceEnum.Relation.getState(type).getState());
            secondStoreBalance.setSecondBalance(0);
            secondStoreBalance.setCreateTime(LocalDateTime.now());
            secondStoreBalance.setModifyTime(LocalDateTime.now());
            secondStoreBalance.setIsDeleted((short) 0);
            secondStoreBalanceMapper.insertSelective(secondStoreBalance);
            List<SecondStoreBalance> secondStoreBalances1 =
                    secondStoreBalanceMapper.selectByExample(secondStoreBalanceExample);
            return builder.body(ResponseUtils.getResponseBody(secondStoreBalances1));
        }
    }
    @RequestMapping(path = "/UserStoreDetails", method = RequestMethod.GET)
    @ApiOperation(value = "用户店铺详情", notes = "用户店铺详情")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "userId", value = "用户id", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "storeId", value = "店铺id", required = true, type = "Integer"),
    })
    public ResponseEntity<JSONObject> UserStoreDetails(
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
        if (secondStore.getSecondStatus().equals(Authentication.UserState.PASS.getState())){
            SecondUserSonExample secondUserSonExample = new SecondUserSonExample();
            secondUserSonExample.createCriteria().andUserIdEqualTo(userId)
                    .andStoreIdEqualTo(storeId)
                    .andIsDeletedEqualTo((byte) 0);
            List<SecondUserSon> secondUserSons =
                    secondUserSonMapper.selectByExample(secondUserSonExample);
            SecondSon secondSon = secondSonMapper.selectByPrimaryKey(secondUserSons.get(0).getSonId());
            storeDetails.setSonId(secondSon.getId());
            storeDetails.setService(secondSon.getService());
            storeDetails.setWeChat(secondSon.getWeChat());
            storeDetails.setSonName(secondSon.getSonName());
            storeDetails.setSonFile(secondSon.getFile());
        }
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
    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        //转换日期
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
    }
}
