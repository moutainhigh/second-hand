package com.example.product.center.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SecondEvaluate implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_evaluate.id
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_evaluate.order_id
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    private Integer orderId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_evaluate.product_id
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    private Integer productId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_evaluate.level
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    private Integer level;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_evaluate.user_id
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_evaluate.star
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    private Integer star;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_evaluate.parent_evaluate_id
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    private Integer parentEvaluateId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_evaluate.create_time
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    private LocalDateTime createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_evaluate.modify_time
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    private LocalDateTime modifyTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_evaluate.is_deleted
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    private Short isDeleted;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_evaluate.evaluate
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    private String evaluate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table second_evaluate
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_evaluate.id
     *
     * @return the value of second_evaluate.id
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_evaluate.id
     *
     * @param id the value for second_evaluate.id
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_evaluate.order_id
     *
     * @return the value of second_evaluate.order_id
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_evaluate.order_id
     *
     * @param orderId the value for second_evaluate.order_id
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_evaluate.product_id
     *
     * @return the value of second_evaluate.product_id
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_evaluate.product_id
     *
     * @param productId the value for second_evaluate.product_id
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_evaluate.level
     *
     * @return the value of second_evaluate.level
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_evaluate.level
     *
     * @param level the value for second_evaluate.level
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_evaluate.user_id
     *
     * @return the value of second_evaluate.user_id
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_evaluate.user_id
     *
     * @param userId the value for second_evaluate.user_id
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_evaluate.star
     *
     * @return the value of second_evaluate.star
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public Integer getStar() {
        return star;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_evaluate.star
     *
     * @param star the value for second_evaluate.star
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public void setStar(Integer star) {
        this.star = star;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_evaluate.parent_evaluate_id
     *
     * @return the value of second_evaluate.parent_evaluate_id
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public Integer getParentEvaluateId() {
        return parentEvaluateId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_evaluate.parent_evaluate_id
     *
     * @param parentEvaluateId the value for second_evaluate.parent_evaluate_id
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public void setParentEvaluateId(Integer parentEvaluateId) {
        this.parentEvaluateId = parentEvaluateId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_evaluate.create_time
     *
     * @return the value of second_evaluate.create_time
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_evaluate.create_time
     *
     * @param createTime the value for second_evaluate.create_time
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_evaluate.modify_time
     *
     * @return the value of second_evaluate.modify_time
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_evaluate.modify_time
     *
     * @param modifyTime the value for second_evaluate.modify_time
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_evaluate.is_deleted
     *
     * @return the value of second_evaluate.is_deleted
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public Short getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_evaluate.is_deleted
     *
     * @param isDeleted the value for second_evaluate.is_deleted
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public void setIsDeleted(Short isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_evaluate.evaluate
     *
     * @return the value of second_evaluate.evaluate
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public String getEvaluate() {
        return evaluate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_evaluate.evaluate
     *
     * @param evaluate the value for second_evaluate.evaluate
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate == null ? null : evaluate.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_evaluate
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orderId=").append(orderId);
        sb.append(", productId=").append(productId);
        sb.append(", level=").append(level);
        sb.append(", userId=").append(userId);
        sb.append(", star=").append(star);
        sb.append(", parentEvaluateId=").append(parentEvaluateId);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", evaluate=").append(evaluate);
        sb.append("]");
        return sb.toString();
    }
}