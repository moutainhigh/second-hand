package com.example.product.center.manual;

import java.time.LocalDateTime;

/**
 * @author shihao
 * @Title: IntegralRecordList
 * @ProjectName Second-order-center
 * @Description: 积分换购记录
 * @date Created in
 * @Version: $
 */
public class IntegralRecordList {
    private Integer recordId;//积分换购id
    private Integer userId;//用户id
    private Integer storeId;//店铺id
    private String storeName;//店铺名称
    private String userName;
    private Integer integralId;
    private String integralState;//状态
    private LocalDateTime createTime;
    private Integer productId;
    private String productName;
    private String integralFile;
    private String integralType;//积分换购类型
    private Integer integralNeed;//需要的积分
    private String integralName;//积分换购名称
    private Integer exemptCommission;//
    private String address;

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

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

    public Integer getIntegralId() {
        return integralId;
    }

    public void setIntegralId(Integer integralId) {
        this.integralId = integralId;
    }

    public String getIntegralState() {
        return integralState;
    }

    public void setIntegralState(String integralState) {
        this.integralState = integralState;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getIntegralFile() {
        return integralFile;
    }

    public void setIntegralFile(String integralFile) {
        this.integralFile = integralFile;
    }

    public Integer getIntegralNeed() {
        return integralNeed;
    }

    public void setIntegralNeed(Integer integralNeed) {
        this.integralNeed = integralNeed;
    }

    public String getIntegralName() {
        return integralName;
    }

    public void setIntegralName(String integralName) {
        this.integralName = integralName;
    }

    public Integer getExemptCommission() {
        return exemptCommission;
    }

    public void setExemptCommission(Integer exemptCommission) {
        this.exemptCommission = exemptCommission;
    }

    public String getIntegralType() {
        return integralType;
    }

    public void setIntegralType(String integralType) {
        this.integralType = integralType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
}
