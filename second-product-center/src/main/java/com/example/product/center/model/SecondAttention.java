package com.example.product.center.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SecondAttention implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_attention.id
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_attention.user_id
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_attention.by_user_id
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    private Integer byUserId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_attention.create_date
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    private LocalDateTime createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_attention.modify_date
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    private LocalDateTime modifyDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_attention.is_deleted
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    private Byte isDeleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table second_attention
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_attention.id
     *
     * @return the value of second_attention.id
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_attention.id
     *
     * @param id the value for second_attention.id
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_attention.user_id
     *
     * @return the value of second_attention.user_id
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_attention.user_id
     *
     * @param userId the value for second_attention.user_id
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_attention.by_user_id
     *
     * @return the value of second_attention.by_user_id
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    public Integer getByUserId() {
        return byUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_attention.by_user_id
     *
     * @param byUserId the value for second_attention.by_user_id
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    public void setByUserId(Integer byUserId) {
        this.byUserId = byUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_attention.create_date
     *
     * @return the value of second_attention.create_date
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    public LocalDateTime getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_attention.create_date
     *
     * @param createDate the value for second_attention.create_date
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_attention.modify_date
     *
     * @return the value of second_attention.modify_date
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    public LocalDateTime getModifyDate() {
        return modifyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_attention.modify_date
     *
     * @param modifyDate the value for second_attention.modify_date
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    public void setModifyDate(LocalDateTime modifyDate) {
        this.modifyDate = modifyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_attention.is_deleted
     *
     * @return the value of second_attention.is_deleted
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    public Byte getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_attention.is_deleted
     *
     * @param isDeleted the value for second_attention.is_deleted
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_attention
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", byUserId=").append(byUserId);
        sb.append(", createDate=").append(createDate);
        sb.append(", modifyDate=").append(modifyDate);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}