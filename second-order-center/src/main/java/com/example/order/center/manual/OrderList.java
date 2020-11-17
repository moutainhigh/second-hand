package com.example.order.center.manual;

import io.swagger.models.auth.In;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author shihao
 * @Title: OrderList
 * @ProjectName Second-order-center
 * @Description: 订单列表
 * @date Created in
 * @Version: $
 */
public class OrderList {
    private String orderStatus;//订单状态
    private Integer orderId;//订单id
    private String orderCode;//订单号
    private String storeName;//店铺名称
    private Integer storeId;//店铺id
    private Integer storeUserId;//商品所属的店铺用户id
    private String storeNickName;
    private String storeUserFile;
    private LocalDateTime createTime;//创建时间
    private Integer userId;//用户id
    private String nickName;//用户昵称
    private String userFile;//用户头像
    private Integer sonId;//子站点id
    private String storeAddress;//店铺地址
    private String phoneAddress;//地址电话
    private String nameAddress;//地址姓名
    private Integer payOrderId;//支付订单

    private List<OrderProductList> orderProductLists;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
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

    public List<OrderProductList> getOrderProductLists() {
        return orderProductLists;
    }

    public void setOrderProductLists(List<OrderProductList> orderProductLists) {
        this.orderProductLists = orderProductLists;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getSonId() {
        return sonId;
    }

    public void setSonId(Integer sonId) {
        this.sonId = sonId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getUserFile() {
        return userFile;
    }

    public void setUserFile(String userFile) {
        this.userFile = userFile;
    }

    public Integer getStoreUserId() {
        return storeUserId;
    }

    public void setStoreUserId(Integer storeUserId) {
        this.storeUserId = storeUserId;
    }

    public String getStoreNickName() {
        return storeNickName;
    }

    public void setStoreNickName(String storeNickName) {
        this.storeNickName = storeNickName;
    }

    public String getStoreUserFile() {
        return storeUserFile;
    }

    public void setStoreUserFile(String storeUserFile) {
        this.storeUserFile = storeUserFile;
    }

    public Integer getPayOrderId() {
        return payOrderId;
    }

    public void setPayOrderId(Integer payOrderId) {
        this.payOrderId = payOrderId;
    }

    public String getPhoneAddress() {
        return phoneAddress;
    }

    public void setPhoneAddress(String phoneAddress) {
        this.phoneAddress = phoneAddress;
    }

    public String getNameAddress() {
        return nameAddress;
    }

    public void setNameAddress(String nameAddress) {
        this.nameAddress = nameAddress;
    }
}
