package com.example.product.center.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SecondOrder implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order.id
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order.order_code
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    private String orderCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order.user_id
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order.pay_status
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    private Integer payStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order.order_type
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    private String orderType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order.order_status
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    private String orderStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order.amount
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    private Integer amount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order.practical_amount
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    private Integer practicalAmount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order.payment_name
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    private String paymentName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order.payment_type
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    private Integer paymentType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order.stone_id
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    private Integer stoneId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order.distributor_id
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    private Integer distributorId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order.hf_memo
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    private String hfMemo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order.hf_remark
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    private String hfRemark;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order.pay_order_id
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    private Integer payOrderId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order.create_time
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    private LocalDateTime createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order.modify_time
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    private LocalDateTime modifyTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order.is_deleted
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    private Byte isDeleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table second_order
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order.id
     *
     * @return the value of second_order.id
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order.id
     *
     * @param id the value for second_order.id
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order.order_code
     *
     * @return the value of second_order.order_code
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public String getOrderCode() {
        return orderCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order.order_code
     *
     * @param orderCode the value for second_order.order_code
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode == null ? null : orderCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order.user_id
     *
     * @return the value of second_order.user_id
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order.user_id
     *
     * @param userId the value for second_order.user_id
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order.pay_status
     *
     * @return the value of second_order.pay_status
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public Integer getPayStatus() {
        return payStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order.pay_status
     *
     * @param payStatus the value for second_order.pay_status
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order.order_type
     *
     * @return the value of second_order.order_type
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public String getOrderType() {
        return orderType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order.order_type
     *
     * @param orderType the value for second_order.order_type
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public void setOrderType(String orderType) {
        this.orderType = orderType == null ? null : orderType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order.order_status
     *
     * @return the value of second_order.order_status
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public String getOrderStatus() {
        return orderStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order.order_status
     *
     * @param orderStatus the value for second_order.order_status
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? null : orderStatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order.amount
     *
     * @return the value of second_order.amount
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order.amount
     *
     * @param amount the value for second_order.amount
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order.practical_amount
     *
     * @return the value of second_order.practical_amount
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public Integer getPracticalAmount() {
        return practicalAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order.practical_amount
     *
     * @param practicalAmount the value for second_order.practical_amount
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public void setPracticalAmount(Integer practicalAmount) {
        this.practicalAmount = practicalAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order.payment_name
     *
     * @return the value of second_order.payment_name
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public String getPaymentName() {
        return paymentName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order.payment_name
     *
     * @param paymentName the value for second_order.payment_name
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName == null ? null : paymentName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order.payment_type
     *
     * @return the value of second_order.payment_type
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public Integer getPaymentType() {
        return paymentType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order.payment_type
     *
     * @param paymentType the value for second_order.payment_type
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order.stone_id
     *
     * @return the value of second_order.stone_id
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public Integer getStoneId() {
        return stoneId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order.stone_id
     *
     * @param stoneId the value for second_order.stone_id
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public void setStoneId(Integer stoneId) {
        this.stoneId = stoneId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order.distributor_id
     *
     * @return the value of second_order.distributor_id
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public Integer getDistributorId() {
        return distributorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order.distributor_id
     *
     * @param distributorId the value for second_order.distributor_id
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public void setDistributorId(Integer distributorId) {
        this.distributorId = distributorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order.hf_memo
     *
     * @return the value of second_order.hf_memo
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public String getHfMemo() {
        return hfMemo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order.hf_memo
     *
     * @param hfMemo the value for second_order.hf_memo
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public void setHfMemo(String hfMemo) {
        this.hfMemo = hfMemo == null ? null : hfMemo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order.hf_remark
     *
     * @return the value of second_order.hf_remark
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public String getHfRemark() {
        return hfRemark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order.hf_remark
     *
     * @param hfRemark the value for second_order.hf_remark
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public void setHfRemark(String hfRemark) {
        this.hfRemark = hfRemark == null ? null : hfRemark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order.pay_order_id
     *
     * @return the value of second_order.pay_order_id
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public Integer getPayOrderId() {
        return payOrderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order.pay_order_id
     *
     * @param payOrderId the value for second_order.pay_order_id
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public void setPayOrderId(Integer payOrderId) {
        this.payOrderId = payOrderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order.create_time
     *
     * @return the value of second_order.create_time
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order.create_time
     *
     * @param createTime the value for second_order.create_time
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order.modify_time
     *
     * @return the value of second_order.modify_time
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order.modify_time
     *
     * @param modifyTime the value for second_order.modify_time
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order.is_deleted
     *
     * @return the value of second_order.is_deleted
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public Byte getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order.is_deleted
     *
     * @param isDeleted the value for second_order.is_deleted
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_order
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
        sb.append(", orderCode=").append(orderCode);
        sb.append(", userId=").append(userId);
        sb.append(", payStatus=").append(payStatus);
        sb.append(", orderType=").append(orderType);
        sb.append(", orderStatus=").append(orderStatus);
        sb.append(", amount=").append(amount);
        sb.append(", practicalAmount=").append(practicalAmount);
        sb.append(", paymentName=").append(paymentName);
        sb.append(", paymentType=").append(paymentType);
        sb.append(", stoneId=").append(stoneId);
        sb.append(", distributorId=").append(distributorId);
        sb.append(", hfMemo=").append(hfMemo);
        sb.append(", hfRemark=").append(hfRemark);
        sb.append(", payOrderId=").append(payOrderId);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}