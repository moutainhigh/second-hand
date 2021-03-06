package com.example.user.center.manual;

import java.util.List;

/**
 * @author shihao
 * @Title: EnterStoreList
 * @ProjectName Second-order-center
 * @Description: 入驻商家列表
 * @date Created in
 * @Version: $
 */
public class EnterStoreList {
    private Integer storeId;//商家id
    private Integer userId;//用户id
    private String nickName;//用户昵称
    private String storeName;//店铺名称
    private String storeAddress;//商户地址
    private String phone;//联系方式
    private List<String> file;//

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<String> getFile() {
        return file;
    }

    public void setFile(List<String> file) {
        this.file = file;
    }
}
