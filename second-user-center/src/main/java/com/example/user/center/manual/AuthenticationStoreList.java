package com.example.user.center.manual;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author shihao
 * @Title: AuthenticationStoreList
 * @ProjectName Second-order-center
 * @Description: 入驻商家列表
 * @date Created in
 * @Version: $
 */
public class AuthenticationStoreList {
    /**
     * 审核id
     */
    private Integer id;
    /**
     * 店铺id
     */
    private Integer storeId;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 审核名称
     */
    private String name;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * authenticationState 认证状态
     */
    private Integer authenticationState;
    /**
     * createDate 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createDate;
    /**
     * secondPicture 认证上传文件
     */
    private List<String> secondPictures;
    /**
     * 认证说明
     */
    private String desc;
    /**
     * 用户昵称
     */
    private String nickName;
    /**
     * 商家名称
     */
    private String storeName;
    /**
     * 商家地址
     */
    private String storeAddress;
    /**
     * 联系方式
     */
    private String storePhone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAuthenticationState() {
        return authenticationState;
    }

    public void setAuthenticationState(Integer authenticationState) {
        this.authenticationState = authenticationState;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public List<String> getSecondPictures() {
        return secondPictures;
    }

    public void setSecondPictures(List<String> secondPictures) {
        this.secondPictures = secondPictures;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getStorePhone() {
        return storePhone;
    }

    public void setStorePhone(String storePhone) {
        this.storePhone = storePhone;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }
}
