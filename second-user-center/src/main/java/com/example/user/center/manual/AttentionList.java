package com.example.user.center.manual;

/**
 * @author shihao
 * @Title: AttentionList
 * @ProjectName Second-order-center
 * @Description: 关注列表
 * @date Created in
 * @Version: $
 */
public class AttentionList {
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 被关注用户id
     */
    private Integer byUserId;
    /**
     *头像
     */
    private String head;
    /**
     * 关注关系
     */
    private String relation;
    /**
     * 用户名
     */
    private String userName;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getByUserId() {
        return byUserId;
    }

    public void setByUserId(Integer byUserId) {
        this.byUserId = byUserId;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "AttentionList{" +
                "userId=" + userId +
                ", byUserId=" + byUserId +
                ", head='" + head + '\'' +
                ", relation='" + relation + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
