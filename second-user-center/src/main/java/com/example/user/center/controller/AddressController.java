package com.example.user.center.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.example.user.center.dao.SecondStoreAddressMapper;
import com.example.user.center.dao.SecondStoreMapper;
import com.example.user.center.manual.Address.AddressList;
import com.example.user.center.manual.Address.addressEnum;
import com.example.user.center.manual.Authentication;
import com.example.user.center.manual.ChatEnum;
import com.example.user.center.model.SecondStore;
import com.example.user.center.model.SecondStoreAddress;
import com.example.user.center.model.SecondStoreAddressExample;
import com.second.utils.response.handler.ResponseEntity;
import com.second.utils.response.handler.ResponseUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author shihao
 * @Title: AddressController
 * @ProjectName Second-order-center
 * @Description: 地址管理
 * @date Created in
 * @Version: $
 */
@RestController
@Api
@RequestMapping("/Address")
@CrossOrigin
public class AddressController {
    @Autowired
    private SecondStoreAddressMapper secondStoreAddressMapper;
    @Autowired
    private SecondStoreMapper secondStoreMapper;
    @ApiOperation(value = "添加地址", notes = "添加地址")
    @RequestMapping(value = "/addAddress", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "storeId", value = "店铺id", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "userId", value = "用户id", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "province", value = "省", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "city", value = "市", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "conty", value = "区", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "addressDetail", value = "详情", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "longitude", value = "经度", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "latitude", value = "纬度", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "contact", value = "联系人", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "defaule", value = "是否默认地址", required = true, type = "Boolean"),
            @ApiImplicitParam(paramType = "query", name = "phone", value = "电话", required = true, type = "Integer"),
    })
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public ResponseEntity<JSONObject> addAddress(
            @RequestParam(value = "storeId", required = false) Integer storeId,
            @RequestParam(value = "userId", required = false) Integer userId,
            @RequestParam(value = "defaule", required = false) Boolean defaule,
            @RequestParam(value = "province", required = false) String province,
            @RequestParam(value = "city", required = false) String city,
            @RequestParam(value = "conty", required = false) String conty,
            @RequestParam(value = "addressDetail", required = false) String addressDetail,
            @RequestParam(value = "longitude", required = false) String longitude,
            @RequestParam(value = "latitude", required = false) String latitude,
            @RequestParam(value = "contact", required = false) String contact,
            @RequestParam(value = "phone", required = false) String phone
    ) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder(HttpStatus.OK);{
            SecondStore secondStore = secondStoreMapper.selectByPrimaryKey(storeId);
            if (secondStore.getStoreType().equals(Authentication.StoreType.USER.getState())){
                SecondStoreAddress secondStoreAddress = new SecondStoreAddress();
                if (defaule){
                    secondStoreAddress.setIsFaultAddress(addressEnum.ChatStatus.DEFAULT.getMessageStatus());
                    SecondStoreAddressExample secondStoreAddressExample = new SecondStoreAddressExample();
                    secondStoreAddressExample.createCriteria().andStoreIdEqualTo(storeId)
                            .andIsDeletedEqualTo((short) 0)
                            .andIsFaultAddressEqualTo(addressEnum.ChatStatus.DEFAULT.getMessageStatus());
                    List<SecondStoreAddress> secondStoreAddresses =
                            secondStoreAddressMapper.selectByExample(secondStoreAddressExample);
                    if (secondStoreAddresses.size()!=0){
                        SecondStoreAddress secondStoreAddress1 = new SecondStoreAddress();
                        secondStoreAddress1 = secondStoreAddresses.get(0);
                        secondStoreAddress1.setIsFaultAddress(addressEnum.ChatStatus.NODEFAULT.getMessageStatus());
                        secondStoreAddress1.setModifyTime(LocalDateTime.now());
                        secondStoreAddressMapper.updateByPrimaryKeySelective(secondStoreAddress1);

                    }
                }else {
                    secondStoreAddress.setIsFaultAddress(addressEnum.ChatStatus.NODEFAULT.getMessageStatus());
                }




                secondStoreAddress.setStoreId(storeId);
                secondStoreAddress.setSecondProvince(province);
                secondStoreAddress.setSecondCity(city);
                secondStoreAddress.setSecondConty(conty);
                secondStoreAddress.setSecondAddressDetail(addressDetail);
                secondStoreAddress.setLongitude(longitude);
                secondStoreAddress.setLatitude(latitude);
                secondStoreAddress.setContact(contact);
                secondStoreAddress.setPhoneNumber(phone);
                secondStoreAddress.setCreateTime(LocalDateTime.now());
                secondStoreAddress.setModifyTime(LocalDateTime.now());
                secondStoreAddress.setIsDeleted((short) 0);
                secondStoreAddressMapper.insertSelective(secondStoreAddress);
            }
            return builder.body(ResponseUtils.getResponseBody(0));
        }
    }
    /**
     * 修改地址
     */
    @ApiOperation(value = "修改地址", notes = "修改地址")
    @RequestMapping(value = "/updateAddress", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "addressId", value = "地址id", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "province", value = "省", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "city", value = "市", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "conty", value = "区", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "addressDetail", value = "详情", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "longitude", value = "经度", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "latitude", value = "纬度", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "contact", value = "联系人", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "phone", value = "电话", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "defaule", value = "是否默认地址", required = true, type = "Boolean"),
    })
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public ResponseEntity<JSONObject> updateAddress(
            @RequestParam(value = "addressId", required = false) Integer addressId,
            @RequestParam(value = "defaule", required = false) Boolean defaule,
            @RequestParam(value = "province", required = false) String province,
            @RequestParam(value = "city", required = false) String city,
            @RequestParam(value = "conty", required = false) String conty,
            @RequestParam(value = "addressDetail", required = false) String addressDetail,
            @RequestParam(value = "longitude", required = false) String longitude,
            @RequestParam(value = "latitude", required = false) String latitude,
            @RequestParam(value = "contact", required = false) String contact,
            @RequestParam(value = "phone", required = false) String phone
    ) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder(HttpStatus.OK);{
            SecondStoreAddress secondStoreAddress = new SecondStoreAddress();
            if (defaule){
                secondStoreAddress.setIsFaultAddress(addressEnum.ChatStatus.DEFAULT.getMessageStatus());
                SecondStoreAddressExample secondStoreAddressExample = new SecondStoreAddressExample();
                secondStoreAddressExample.createCriteria().andIdEqualTo(addressId)
                        .andIsDeletedEqualTo((short) 0)
                        .andIsFaultAddressEqualTo(addressEnum.ChatStatus.DEFAULT.getMessageStatus());
                List<SecondStoreAddress> secondStoreAddresses =
                        secondStoreAddressMapper.selectByExample(secondStoreAddressExample);
                if (secondStoreAddresses.size()!=0){
                    SecondStoreAddress secondStoreAddress1 = new SecondStoreAddress();
                    secondStoreAddress1 = secondStoreAddresses.get(0);
                    secondStoreAddress1.setIsFaultAddress(addressEnum.ChatStatus.NODEFAULT.getMessageStatus());
                    secondStoreAddress1.setModifyTime(LocalDateTime.now());
                    secondStoreAddressMapper.updateByPrimaryKeySelective(secondStoreAddress1);
                }
            }else {
                secondStoreAddress.setIsFaultAddress(addressEnum.ChatStatus.NODEFAULT.getMessageStatus());
            }
                secondStoreAddress.setId(addressId);
                secondStoreAddress.setSecondProvince(province);
                secondStoreAddress.setSecondCity(city);
                secondStoreAddress.setSecondConty(conty);
                secondStoreAddress.setSecondAddressDetail(addressDetail);
                secondStoreAddress.setLongitude(longitude);
                secondStoreAddress.setLatitude(latitude);
                secondStoreAddress.setContact(contact);
                secondStoreAddress.setPhoneNumber(phone);
                secondStoreAddress.setModifyTime(LocalDateTime.now());
                secondStoreAddress.setIsDeleted((short) 0);
                secondStoreAddressMapper.updateByPrimaryKeySelective(secondStoreAddress);
            return builder.body(ResponseUtils.getResponseBody(0));
        }
    }
    /**
     * 删除地址
     */
    @ApiOperation(value = "删除地址", notes = "删除地址")
    @RequestMapping(value = "/deleteAddress", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "addressId", value = "地址id", required = true, type = "Integer"),
    })
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public ResponseEntity<JSONObject> deleteAddress(
            @RequestParam(value = "addressId", required = false) Integer addressId
    ) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder(HttpStatus.OK);
        {
            SecondStoreAddress secondStoreAddress = new SecondStoreAddress();
            secondStoreAddress.setId(addressId);
            secondStoreAddress.setModifyTime(LocalDateTime.now());
            secondStoreAddress.setIsDeleted((short) 1);
            secondStoreAddressMapper.updateByPrimaryKeySelective(secondStoreAddress);
            return builder.body(ResponseUtils.getResponseBody(0));
        }
    }
    /**
     * 查询地址
     */
    @ApiOperation(value = "查询地址", notes = "查询地址")
    @RequestMapping(value = "/selectAddress", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "storeId", value = "店铺id", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "userId", value = "用户id", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "defaule", value = "是否默认地址", required = true, type = "Boolean"),
    })
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public ResponseEntity<JSONObject> selectAddress(
            @RequestParam(value = "storeId", required = false) Integer storeId,
            @RequestParam(value = "userId", required = false) Integer userId,
            @RequestParam(value = "defaule", required = false) Integer defaule
    ) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder(HttpStatus.OK);
        {
            SecondStoreAddressExample secondStoreAddressExample = new SecondStoreAddressExample();
            SecondStoreAddressExample.Criteria criteria = secondStoreAddressExample.createCriteria().andStoreIdEqualTo(storeId)
                    .andIsDeletedEqualTo((short) 0);
            if (defaule!=null){
//                secondStoreAddressExample.clear();
                System.out.println("走了");
                criteria.andIsFaultAddressEqualTo(0);
            }
            return builder.body(ResponseUtils.getResponseBody(secondStoreAddressMapper.selectByExample(secondStoreAddressExample)));
        }
    }
    @RequestMapping(value = "/getIngAndLat", method = RequestMethod.GET)
    @ApiOperation(value = "腾讯地图", notes = "腾讯地图")
    public AddressList getIngAndLat(@RequestParam(required = false, defaultValue = "") String address) throws JSONException {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
        System.out.println("----------经纬度查询-----------");
        String key = "4G5BZ-7ROKG-KBKQZ-IVBX5-SBG7K-FCBRX";//申请的key

        StringBuffer sb = new StringBuffer("https://apis.map.qq.com/ws/geocoder/v1/?");
        sb.append("address=" + address);
        sb.append("&key=" + key);
        System.out.println("===>>>查询链接: " + sb.toString());
        String Address = getURLContent(sb.toString());
        System.out.println(Address);
        JSONObject jsonObject = JSON.parseObject(Address);
        AddressList list = JSON.parseObject(String.valueOf(jsonObject), new TypeReference<AddressList>(){});
        System.out.println(list);
        return list;
    }
    public static String getURLContent(String urlStr) {
        //请求的url
        URL url = null;
        //请求的输入流
        BufferedReader in = null;
        //输入流的缓冲
        StringBuffer sb = new StringBuffer();
        try {
            url = new URL(urlStr);
            in = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
            String str = null;
            //一行一行进行读入
            while ((str = in.readLine()) != null) {
                sb.append(str);
            }
        } catch (Exception ex) {

        } finally {
            try {
                if (in != null) {
                    in.close(); //关闭流
                }
            } catch (IOException ex) {

            }
        }
        String result = sb.toString();
        return result;
    }
}
