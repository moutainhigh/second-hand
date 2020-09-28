package com.example.user.center.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SecondProductWant implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_product_want.id
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_product_want.type
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    private String type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_product_want.product_id
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    private Integer productId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_product_want.user_id
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_product_want.create_time
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    private LocalDateTime createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_product_want.modify_time
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    private LocalDateTime modifyTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_product_want.is_deleted
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    private Short isDeleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table second_product_want
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_product_want.id
     *
     * @return the value of second_product_want.id
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_product_want.id
     *
     * @param id the value for second_product_want.id
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_product_want.type
     *
     * @return the value of second_product_want.type
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_product_want.type
     *
     * @param type the value for second_product_want.type
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_product_want.product_id
     *
     * @return the value of second_product_want.product_id
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_product_want.product_id
     *
     * @param productId the value for second_product_want.product_id
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_product_want.user_id
     *
     * @return the value of second_product_want.user_id
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_product_want.user_id
     *
     * @param userId the value for second_product_want.user_id
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_product_want.create_time
     *
     * @return the value of second_product_want.create_time
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_product_want.create_time
     *
     * @param createTime the value for second_product_want.create_time
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_product_want.modify_time
     *
     * @return the value of second_product_want.modify_time
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_product_want.modify_time
     *
     * @param modifyTime the value for second_product_want.modify_time
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_product_want.is_deleted
     *
     * @return the value of second_product_want.is_deleted
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public Short getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_product_want.is_deleted
     *
     * @param isDeleted the value for second_product_want.is_deleted
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public void setIsDeleted(Short isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product_want
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", productId=").append(productId);
        sb.append(", userId=").append(userId);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}