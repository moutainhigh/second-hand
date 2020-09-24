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
    private Integer attentionNumber;//关注数量
    private Integer myFansNumber;//粉丝数量
    private Integer evaluateNumber;//评价数量
    private Integer authentication;//是否认证 0认证
    private String attention;//关注关系

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
}
