package com.example.user.center.manual;

import java.time.LocalDateTime;

/**
 * @author shihao
 * @Title: ChatWindow
 * @ProjectName Second-order-center
 * @Description: 聊天窗口
 * @date Created in
 * @Version: $
 */
public class ChatWindow {
    private Integer userId;//建立人id
    private String userName;//建立人姓名
    private String byUserName;//被建立人姓名
    private Integer byUserId;//被建立人id
    private LocalDateTime createTime;//创建时间
    private LocalDateTime modifyTime;//修改时间

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getByUserName() {
        return byUserName;
    }

    public void setByUserName(String byUserName) {
        this.byUserName = byUserName;
    }

    public Integer getByUserId() {
        return byUserId;
    }

    public void setByUserId(Integer byUserId) {
        this.byUserId = byUserId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }
}
