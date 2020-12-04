package com.example.product.center.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SecondOrderVideo implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order_video.id
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order_video.order_code
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    private String orderCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order_video.user_id
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order_video.pay_status
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    private Integer payStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order_video.order_type
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    private String orderType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order_video.order_status
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    private String orderStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order_video.amount
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    private Integer amount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order_video.practical_amount
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    private Integer practicalAmount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order_video.payment_name
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    private String paymentName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order_video.payment_type
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    private Integer paymentType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order_video.stone_id
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    private Integer stoneId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order_video.hf_memo
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    private String hfMemo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order_video.hf_remark
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    private String hfRemark;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order_video.pay_order_id
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    private Integer payOrderId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order_video.video_id
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    private Integer videoId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order_video.uid
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    private String uid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order_video.amt
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    private Integer amt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order_video.ip
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    private String ip;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order_video.code
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    private String code;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order_video.create_time
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    private LocalDateTime createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order_video.modify_time
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    private LocalDateTime modifyTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order_video.is_deleted
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    private Byte isDeleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table second_order_video
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order_video.id
     *
     * @return the value of second_order_video.id
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order_video.id
     *
     * @param id the value for second_order_video.id
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order_video.order_code
     *
     * @return the value of second_order_video.order_code
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    public String getOrderCode() {
        return orderCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order_video.order_code
     *
     * @param orderCode the value for second_order_video.order_code
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode == null ? null : orderCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order_video.user_id
     *
     * @return the value of second_order_video.user_id
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order_video.user_id
     *
     * @param userId the value for second_order_video.user_id
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order_video.pay_status
     *
     * @return the value of second_order_video.pay_status
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    public Integer getPayStatus() {
        return payStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order_video.pay_status
     *
     * @param payStatus the value for second_order_video.pay_status
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order_video.order_type
     *
     * @return the value of second_order_video.order_type
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    public String getOrderType() {
        return orderType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order_video.order_type
     *
     * @param orderType the value for second_order_video.order_type
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    public void setOrderType(String orderType) {
        this.orderType = orderType == null ? null : orderType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order_video.order_status
     *
     * @return the value of second_order_video.order_status
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    public String getOrderStatus() {
        return orderStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order_video.order_status
     *
     * @param orderStatus the value for second_order_video.order_status
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? null : orderStatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order_video.amount
     *
     * @return the value of second_order_video.amount
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order_video.amount
     *
     * @param amount the value for second_order_video.amount
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order_video.practical_amount
     *
     * @return the value of second_order_video.practical_amount
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    public Integer getPracticalAmount() {
        return practicalAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order_video.practical_amount
     *
     * @param practicalAmount the value for second_order_video.practical_amount
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    public void setPracticalAmount(Integer practicalAmount) {
        this.practicalAmount = practicalAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order_video.payment_name
     *
     * @return the value of second_order_video.payment_name
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    public String getPaymentName() {
        return paymentName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order_video.payment_name
     *
     * @param paymentName the value for second_order_video.payment_name
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName == null ? null : paymentName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order_video.payment_type
     *
     * @return the value of second_order_video.payment_type
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    public Integer getPaymentType() {
        return paymentType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order_video.payment_type
     *
     * @param paymentType the value for second_order_video.payment_type
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order_video.stone_id
     *
     * @return the value of second_order_video.stone_id
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    public Integer getStoneId() {
        return stoneId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order_video.stone_id
     *
     * @param stoneId the value for second_order_video.stone_id
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    public void setStoneId(Integer stoneId) {
        this.stoneId = stoneId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order_video.hf_memo
     *
     * @return the value of second_order_video.hf_memo
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    public String getHfMemo() {
        return hfMemo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order_video.hf_memo
     *
     * @param hfMemo the value for second_order_video.hf_memo
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    public void setHfMemo(String hfMemo) {
        this.hfMemo = hfMemo == null ? null : hfMemo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order_video.hf_remark
     *
     * @return the value of second_order_video.hf_remark
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    public String getHfRemark() {
        return hfRemark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order_video.hf_remark
     *
     * @param hfRemark the value for second_order_video.hf_remark
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    public void setHfRemark(String hfRemark) {
        this.hfRemark = hfRemark == null ? null : hfRemark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order_video.pay_order_id
     *
     * @return the value of second_order_video.pay_order_id
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    public Integer getPayOrderId() {
        return payOrderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order_video.pay_order_id
     *
     * @param payOrderId the value for second_order_video.pay_order_id
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    public void setPayOrderId(Integer payOrderId) {
        this.payOrderId = payOrderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order_video.video_id
     *
     * @return the value of second_order_video.video_id
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    public Integer getVideoId() {
        return videoId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order_video.video_id
     *
     * @param videoId the value for second_order_video.video_id
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order_video.uid
     *
     * @return the value of second_order_video.uid
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    public String getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order_video.uid
     *
     * @param uid the value for second_order_video.uid
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order_video.amt
     *
     * @return the value of second_order_video.amt
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    public Integer getAmt() {
        return amt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order_video.amt
     *
     * @param amt the value for second_order_video.amt
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    public void setAmt(Integer amt) {
        this.amt = amt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order_video.ip
     *
     * @return the value of second_order_video.ip
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    public String getIp() {
        return ip;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order_video.ip
     *
     * @param ip the value for second_order_video.ip
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order_video.code
     *
     * @return the value of second_order_video.code
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    public String getCode() {
        return code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order_video.code
     *
     * @param code the value for second_order_video.code
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order_video.create_time
     *
     * @return the value of second_order_video.create_time
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order_video.create_time
     *
     * @param createTime the value for second_order_video.create_time
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order_video.modify_time
     *
     * @return the value of second_order_video.modify_time
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order_video.modify_time
     *
     * @param modifyTime the value for second_order_video.modify_time
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order_video.is_deleted
     *
     * @return the value of second_order_video.is_deleted
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    public Byte getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order_video.is_deleted
     *
     * @param isDeleted the value for second_order_video.is_deleted
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
     */
    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_order_video
     *
     * @mbg.generated Fri Dec 04 09:55:30 CST 2020
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
        sb.append(", hfMemo=").append(hfMemo);
        sb.append(", hfRemark=").append(hfRemark);
        sb.append(", payOrderId=").append(payOrderId);
        sb.append(", videoId=").append(videoId);
        sb.append(", uid=").append(uid);
        sb.append(", amt=").append(amt);
        sb.append(", ip=").append(ip);
        sb.append(", code=").append(code);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}