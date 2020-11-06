package com.example.user.center.manual;

import java.time.LocalDateTime;

/**
 * @author shihao
 * @Title: StoreDetails
 * @ProjectName Second-order-center
 * @Description: 店铺详情
 * @date Created in
 * @Version: $
 */
public class StoreDetails {
    private Integer userId;//用户id
    private Integer storeId;//店铺id
    private Integer money;//店铺余额
    private Integer sumMoney;//总额
    private Integer storeStatus;//店铺状态
    private String address;//店铺地址
    private LocalDateTime createTime;//创建时间
    private Integer sonId;//子站点id
    private String sonName;//子站点名称
    private String sonFile;//子站点头像
    private String sonCollegesName;//子站点学校名称
    private String service;//子站点客服
    private String weChat;//子站点微信

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getStoreStatus() {
        return storeStatus;
    }

    public void setStoreStatus(Integer storeStatus) {
        this.storeStatus = storeStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getSonId() {
        return sonId;
    }

    public void setSonId(Integer sonId) {
        this.sonId = sonId;
    }

    public String getSonName() {
        return sonName;
    }

    public void setSonName(String sonName) {
        this.sonName = sonName;
    }

    public String getSonFile() {
        return sonFile;
    }

    public void setSonFile(String sonFile) {
        this.sonFile = sonFile;
    }

    public String getSonCollegesName() {
        return sonCollegesName;
    }

    public void setSonCollegesName(String sonCollegesName) {
        this.sonCollegesName = sonCollegesName;
    }

    public Integer getSumMoney() {
        return sumMoney;
    }

    public void setSumMoney(Integer sumMoney) {
        this.sumMoney = sumMoney;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getWeChat() {
        return weChat;
    }

    public void setWeChat(String weChat) {
        this.weChat = weChat;
    }
}
