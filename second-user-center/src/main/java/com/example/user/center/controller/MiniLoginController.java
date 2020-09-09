package com.example.user.center.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.user.center.config.WxLoginConfig;
import com.example.user.center.dao.*;
import com.example.user.center.manual.Authentication;
import com.example.user.center.manual.AuthenticationList;
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


    @RequestMapping(path = "/wechart", method = RequestMethod.GET)
    @ApiOperation(value = "微信登录", notes = "微信登录")
    public ResponseEntity<JSONObject> wxLogin(@RequestParam(value = "code", required = false) String code,
                                              @RequestParam(value = "appName", required = false) String appName,
                                              @RequestParam(value = "encryptedData", required = false) String encryptedData,
                                              @RequestParam(value = "iv", required = false) String iv, HttpServletResponse response, HttpServletRequest request) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        JSONObject SessionKeyOpenId = WxLoginConfig.getSessionKeyOrOpenId(code, appName);
        String openid = (String) SessionKeyOpenId.get("openid");
        String sessionKey = String.valueOf(SessionKeyOpenId.get("session_key"));

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
//            secondUser.setPhone(userInfo.getString("phone"));
            System.out.println(userInfo);
            secondUser.setCreateDate(LocalDateTime.now());
            secondUser.setModifyDate(LocalDateTime.now());
            secondUser.setIdDeleted((byte) 0);
            secondUser.setIsAuthentication(Authentication.UserState.NOPASS.getState());
            secondUser.setRegion(userInfo.getString("province"));
            secondUser.setUserStatus((byte) 0);
            secondUser.setNickName(userInfo.getString("nickName"));
            secondUserMapper.insert(secondUser);
        } else {
            secondUser = list.get(0);
        }
        SecondAuth record = new SecondAuth();
        record.setAuthKey(openid);
        record.setAuthStatus(Byte.valueOf("0"));
        record.setAuthType(WxLoginConfig.AuthType.WECHART.getAuthType());
        record.setCreateDate(LocalDateTime.now());
        record.setModifyDate(LocalDateTime.now());
        record.setUserId(secondUser.getId());
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
                                                     @RequestParam(value = "date", required = false) Date date,
                                                     @RequestParam(value = "number", required = false) String number,
                                                     @RequestParam(value = "colleges", required = false) Integer colleges,
                                                     @RequestParam(value = "record", required = false) String record,
                                                     @RequestParam(value = "userId", required = false) Integer userId,
                                                     HttpServletResponse response, HttpServletRequest request) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
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
        System.out.println(secondAuthentication);
        secondAuthenticationMapper.insert(secondAuthentication);

        return builder.body(ResponseUtils.getResponseBody(secondAuthentication.getId()));//审核id
    }
    @RequestMapping(path = "/authenticationFile", method = RequestMethod.POST)
    @ApiOperation(value = "学生认证文件上传", notes = "提交学生认证文件上传")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "fileIds", value = "文件数组", required = true, type = "Integer[]"),
            @ApiImplicitParam(paramType = "query", name = "AuthenticationId", value = "审核id", required = true, type = "Integer"),
    })
    public ResponseEntity<JSONObject> authenticationFile(
            @RequestParam(value = "fileIds", required = false) Integer[] fileIds,
            @RequestParam(value = "AuthenticationId", required = false) Integer AuthenticationId
                                                     ) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
        String s = "http://localhost:7004/user/File/getPicture?id=";
        for (Integer file: fileIds){
            SecondAuthenticationPicture secondAuthenticationPicture = new SecondAuthenticationPicture();
            secondAuthenticationPicture.setSecondAuthenticationId(AuthenticationId);
            secondAuthenticationPicture.setSecondPicture(s+String.valueOf(file));
            secondAuthenticationPicture.setCreateDate(LocalDateTime.now());
            secondAuthenticationPicture.setModifyDate(LocalDateTime.now());
            secondAuthenticationPicture.setIsDeleted((byte) 0);
            secondAuthenticationPictureMapper.insertSelective(secondAuthenticationPicture);
        }
        return builder.body(ResponseUtils.getResponseBody(0));
    }

    @RequestMapping(path = "/authenticationList", method = RequestMethod.GET)
    @ApiOperation(value = "学生认证列表", notes = "学生认证列表")

    public ResponseEntity<JSONObject> authenticationList(
    ) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
//审核列表
        SecondAuthenticationExample secondAuthenticationExample = new SecondAuthenticationExample();
        secondAuthenticationExample.createCriteria().andIsDeletedEqualTo((byte) 0);
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
            authenticationList.add(authenticationList1);
        });
        return builder.body(ResponseUtils.getResponseBody(authenticationList));
    }

    @RequestMapping(path = "/authenticationDispose", method = RequestMethod.POST)
    @ApiOperation(value = "学生认证处理", notes = "学生认证处理")
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
        SecondAuthentication secondAuthentication = new SecondAuthentication();
        secondAuthentication.setAuthenticationState(Authentication.State.getState(EndAuthenticationState).getState());
        SecondAuthenticationExample secondAuthenticationExample = new SecondAuthenticationExample();
        secondAuthenticationExample.createCriteria().andIsDeletedEqualTo((byte) 0)
                .andIdEqualTo(AuthenticationId)
                .andAuthenticationStateEqualTo(Authentication.State.getState(StartAuthenticationState).getState());
        secondAuthenticationMapper.updateByExampleSelective(secondAuthentication,secondAuthenticationExample);
        //修改用户表状态
        List<SecondAuthentication> secondAuthentications = secondAuthenticationMapper.selectByExample(secondAuthenticationExample);
        if (secondAuthentications.size()!=0 && EndAuthenticationState.equals(Authentication.State.PASS.getState())){
            SecondUser secondUser = new SecondUser();
            secondUser.setId(secondAuthentications.get(0).getUserId());
            secondUser.setIsAuthentication(Authentication.UserState.PASS.getState());
            secondUserMapper.updateByPrimaryKeySelective(secondUser);
        }
        return builder.body(ResponseUtils.getResponseBody(0));
    }
    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        //转换日期
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
    }
}
