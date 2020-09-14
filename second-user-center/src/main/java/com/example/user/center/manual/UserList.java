package com.example.user.center.manual;

import java.time.LocalDateTime;

/**
 * @author shihao
 * @Title: UserList
 * @ProjectName Second-order-center
 * @Description: 学生认证用户列表
 * @date Created in
 * @Version: $
 */
public class UserList {
    private Integer userId;//用户id
    private String userFIle;//头像
    private String nickName;//昵称
    private String college;//认证大学
    private Integer productNum;//发布商品数量
    private Integer buyProductNum;//购买商品数量
    private String phone;//电话
    private LocalDateTime createTime;//创建时间
    private Integer income;//收入
    private Integer expend;//支出

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserFIle() {
        return userFIle;
    }

    public void setUserFIle(String userFIle) {
        this.userFIle = userFIle;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public Integer getProductNum() {
        return productNum;
    }

    public void setProductNum(Integer productNum) {
        this.productNum = productNum;
    }

    public Integer getBuyProductNum() {
        return buyProductNum;
    }

    public void setBuyProductNum(Integer buyProductNum) {
        this.buyProductNum = buyProductNum;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getIncome() {
        return income;
    }

    public void setIncome(Integer income) {
        this.income = income;
    }

    public Integer getExpend() {
        return expend;
    }

    public void setExpend(Integer expend) {
        this.expend = expend;
    }
}
