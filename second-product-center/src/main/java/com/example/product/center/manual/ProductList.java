package com.example.product.center.manual;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author shihao
 * @Title: ProductList
 * @ProjectName Second-order-center
 * @Description: 商品列表
 * @date Created in
 * @Version: $
 */

public class ProductList {
    /**
     * 商品
     */
    private Integer id;//商品id
    private String productName;//商品名称
    private String productDesc;//商品描述
    private String productType;//商品类型
    private String showType;//商品展示类型
    private Integer price;//价格
    private Integer isPutaway;//是否上架
    private LocalDateTime createTime;//创建时间
    private List<String> files;//商品图
    private String file;//列表图
    private String productState;//商品状态
    /**
     * 店铺
     */
    private Integer storeId;//店铺id
    private String storeType;//店铺类型
    private String storeName;//店铺名称
    private Integer concernCount;//店铺关注人数
    private Integer secondStatus;//店铺状态
    private Short isStoreDeleted;
    /**
     * 用户
     */
    private Integer userId;//
    private String nickName;//用户名称
    private Integer isAuthentication;//是否认证
    private String userFile;//用户头像
    private Short isUserDeleted;
    /**
     * 地址
     */
    private Integer addressId;//地址id
    private String province;//省
    private String city;//市
    private String conty;//区/县
    private String addressDetail;//地址详情
    private String longitude;//经度
    private String latitude;//纬度
    private String phone;//电话
    private String addressDesc;//备注
    /**
     * 学校
     */
    private String colleges;//学校名称
    private String record;//学校层次
    private Integer sonId;//子站点id
    /**
     * 分类
     */
    //点赞数
    private Integer praise;
    //想要数
    private Integer want;
    //收藏数
    private Integer collect;
    //浏览数
    private Integer look;
    /**
     * 标签
     */

    private List<String> labelName;//标签名称

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getShowType() {
        return showType;
    }

    public void setShowType(String showType) {
        this.showType = showType;
    }

    public Integer getIsPutaway() {
        return isPutaway;
    }

    public void setIsPutaway(Integer isPutaway) {
        this.isPutaway = isPutaway;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getStoreType() {
        return storeType;
    }

    public void setStoreType(String storeType) {
        this.storeType = storeType;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Integer getConcernCount() {
        return concernCount;
    }

    public void setConcernCount(Integer concernCount) {
        this.concernCount = concernCount;
    }

    public Integer getSecondStatus() {
        return secondStatus;
    }

    public void setSecondStatus(Integer secondstatus) {
        this.secondStatus = secondstatus;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getIsAuthentication() {
        return isAuthentication;
    }

    public void setIsAuthentication(Integer isAuthentication) {
        this.isAuthentication = isAuthentication;
    }

    public String getUserFile() {
        return userFile;
    }

    public void setUserFile(String userFile) {
        this.userFile = userFile;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getConty() {
        return conty;
    }

    public void setConty(String conty) {
        this.conty = conty;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddressDesc() {
        return addressDesc;
    }

    public void setAddressDesc(String addressDesc) {
        this.addressDesc = addressDesc;
    }

    public String getColleges() {
        return colleges;
    }

    public void setColleges(String colleges) {
        this.colleges = colleges;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public List<String> getFiles() {
        return files;
    }

    public void setFiles(List<String> files) {
        this.files = files;
    }

    public List<String> getLabelName() {
        return labelName;
    }

    public void setLabelName(List<String> labelName) {
        this.labelName = labelName;
    }

    public Short getIsStoreDeleted() {
        return isStoreDeleted;
    }

    public void setIsStoreDeleted(Short isStoreDeleted) {
        this.isStoreDeleted = isStoreDeleted;
    }

    public Short getIsUserDeleted() {
        return isUserDeleted;
    }

    public void setIsUserDeleted(Short isUserDeleted) {
        this.isUserDeleted = isUserDeleted;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSonId() {
        return sonId;
    }

    public void setSonId(Integer sonId) {
        this.sonId = sonId;
    }

    public Integer getPraise() {
        return praise;
    }

    public void setPraise(Integer praise) {
        this.praise = praise;
    }

    public Integer getWant() {
        return want;
    }

    public void setWant(Integer want) {
        this.want = want;
    }

    public Integer getCollect() {
        return collect;
    }

    public void setCollect(Integer collect) {
        this.collect = collect;
    }

    public Integer getLook() {
        return look;
    }

    public void setLook(Integer look) {
        this.look = look;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getProductState() {
        return productState;
    }

    public void setProductState(String productState) {
        this.productState = productState;
    }
}
