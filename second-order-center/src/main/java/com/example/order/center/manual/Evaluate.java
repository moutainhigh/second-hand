package com.example.order.center.manual;

import io.swagger.models.auth.In;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author shihao
 * @Title: Evaluate
 * @ProjectName Second-order-center
 * @Description: 评价
 * @date Created in
 * @Version: $
 */
public class Evaluate {
    private Integer evaluateId;//评价id
    private Integer orderdetailId;//详情id
    private Integer userId;//用户id
    private String evaluate;//评价内容
    private LocalDateTime createTime;//创建时间
    private String userFile;//用户头像
    private String nickName;//用户昵称
    private List<String> evaluateFiles;//评价图
    private Integer goodsId;//物品id

    public Integer getEvaluateId() {
        return evaluateId;
    }

    public void setEvaluateId(Integer evaluateId) {
        this.evaluateId = evaluateId;
    }

    public Integer getOrderdetailId() {
        return orderdetailId;
    }

    public void setOrderdetailId(Integer orderdetailId) {
        this.orderdetailId = orderdetailId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
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

    public List<String> getEvaluateFiles() {
        return evaluateFiles;
    }

    public void setEvaluateFiles(List<String> evaluateFiles) {
        this.evaluateFiles = evaluateFiles;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }
}
