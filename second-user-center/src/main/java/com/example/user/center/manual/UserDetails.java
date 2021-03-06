package com.example.user.center.manual;

/**
 * @author shihao
 * @Title: UserDetails
 * @ProjectName Second-order-center
 * @Description: 用户详情
 * @date Created in
 * @Version: $
 */
public class UserDetails {
    private Integer userId;//用户id
    private Integer storeId;//店铺id
    private String userFile;//用户头像
    private String nickName;//昵称
    private String phone;
    private String email;//
    private Integer attentionNumber;//关注数量
    private Integer myFansNumber;//粉丝数量
    private Integer evaluateNumber;//评价数量
    private Integer authentication;//是否认证 0认证
    private String attention;//关注关系
    private Integer collectNumber;//收藏数量
    private Integer lookNumber;//浏览数量

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

    public String getUserFile() {
        return userFile;
    }

    public void setUserFile(String userFile) {
        this.userFile = userFile;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getAttentionNumber() {
        return attentionNumber;
    }

    public void setAttentionNumber(Integer attentionNumber) {
        this.attentionNumber = attentionNumber;
    }

    public Integer getMyFansNumber() {
        return myFansNumber;
    }

    public void setMyFansNumber(Integer myFansNumber) {
        this.myFansNumber = myFansNumber;
    }

    public Integer getEvaluateNumber() {
        return evaluateNumber;
    }

    public void setEvaluateNumber(Integer evaluateNumber) {
        this.evaluateNumber = evaluateNumber;
    }

    public Integer getAuthentication() {
        return authentication;
    }

    public void setAuthentication(Integer authentication) {
        this.authentication = authentication;
    }

    public String getAttention() {
        return attention;
    }

    public void setAttention(String attention) {
        this.attention = attention;
    }

    public Integer getCollectNumber() {
        return collectNumber;
    }

    public void setCollectNumber(Integer collectNumber) {
        this.collectNumber = collectNumber;
    }

    public Integer getLookNumber() {
        return lookNumber;
    }

    public void setLookNumber(Integer lookNumber) {
        this.lookNumber = lookNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "userId=" + userId +
                ", storeId=" + storeId +
                ", userFile='" + userFile + '\'' +
                ", nickName='" + nickName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", attentionNumber=" + attentionNumber +
                ", myFansNumber=" + myFansNumber +
                ", evaluateNumber=" + evaluateNumber +
                ", authentication=" + authentication +
                ", attention='" + attention + '\'' +
                ", collectNumber=" + collectNumber +
                ", lookNumber=" + lookNumber +
                '}';
    }
}
