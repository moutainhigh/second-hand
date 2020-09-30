package com.example.product.center.manual;

import java.time.LocalDateTime;

/**
 * @author shihao
 * @Title: IntegralList
 * @ProjectName Second-order-center
 * @Description:
 * @date Created in
 * @Version: $
 */
public class IntegralList {
    private Integer id;//积分商品id
    private String integralName;//积分商品名称
    private String integralType;//积分商品类型
    private Integer integralNeed;//所需积分数量
    private String productDesc;
    private String inetgralFile;//图片
    private Integer integralQuantity;//库存
    private Integer productId;//商品id
    private Integer exemptCommission;//可免手续费金额
    private Integer storeId;//店铺id
    private String address;//自提地址
    private String storeName;//店铺名称
    private LocalDateTime createTime;//创建时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIntegralName() {
        return integralName;
    }

    public void setIntegralName(String integralName) {
        this.integralName = integralName;
    }

    public String getIntegralType() {
        return integralType;
    }

    public void setIntegralType(String integralType) {
        this.integralType = integralType;
    }

    public Integer getIntegralNeed() {
        return integralNeed;
    }

    public void setIntegralNeed(Integer integralNeed) {
        this.integralNeed = integralNeed;
    }

    public String getInetgralFile() {
        return inetgralFile;
    }

    public void setInetgralFile(String inetgralFile) {
        this.inetgralFile = inetgralFile;
    }

    public Integer getIntegralQuantity() {
        return integralQuantity;
    }

    public void setIntegralQuantity(Integer integralQuantity) {
        this.integralQuantity = integralQuantity;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getExemptCommission() {
        return exemptCommission;
    }

    public void setExemptCommission(Integer exemptCommission) {
        this.exemptCommission = exemptCommission;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }
}
