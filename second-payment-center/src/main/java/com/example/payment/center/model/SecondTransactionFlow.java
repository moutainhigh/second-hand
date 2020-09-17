package com.example.payment.center.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SecondTransactionFlow implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_transaction_flow.id
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_transaction_flow.user_id
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_transaction_flow.open_id
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    private String openId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_transaction_flow.transaction_type
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    private String transactionType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_transaction_flow.out_trade_no
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    private String outTradeNo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_transaction_flow.out_refund_no
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    private String outRefundNo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_transaction_flow.wechart_package
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    private String wechartPackage;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_transaction_flow.signType
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    private String signtype;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_transaction_flow.app_id
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    private String appId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_transaction_flow.mch_id
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    private String mchId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_transaction_flow.wechart_body
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    private String wechartBody;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_transaction_flow.hf_status
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    private String hfStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_transaction_flow.device_info
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    private String deviceInfo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_transaction_flow.fee_type
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    private String feeType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_transaction_flow.total_fee
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    private String totalFee;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_transaction_flow.trade_type
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    private String tradeType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_transaction_flow.notify_url
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    private String notifyUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_transaction_flow.spbill_create_ip
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    private String spbillCreateIp;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_transaction_flow.create_date
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    private LocalDateTime createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_transaction_flow.modify_date
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    private LocalDateTime modifyDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_transaction_flow.id_deleted
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    private Byte idDeleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table second_transaction_flow
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_transaction_flow.id
     *
     * @return the value of second_transaction_flow.id
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_transaction_flow.id
     *
     * @param id the value for second_transaction_flow.id
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_transaction_flow.user_id
     *
     * @return the value of second_transaction_flow.user_id
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_transaction_flow.user_id
     *
     * @param userId the value for second_transaction_flow.user_id
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_transaction_flow.open_id
     *
     * @return the value of second_transaction_flow.open_id
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_transaction_flow.open_id
     *
     * @param openId the value for second_transaction_flow.open_id
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_transaction_flow.transaction_type
     *
     * @return the value of second_transaction_flow.transaction_type
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    public String getTransactionType() {
        return transactionType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_transaction_flow.transaction_type
     *
     * @param transactionType the value for second_transaction_flow.transaction_type
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType == null ? null : transactionType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_transaction_flow.out_trade_no
     *
     * @return the value of second_transaction_flow.out_trade_no
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    public String getOutTradeNo() {
        return outTradeNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_transaction_flow.out_trade_no
     *
     * @param outTradeNo the value for second_transaction_flow.out_trade_no
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo == null ? null : outTradeNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_transaction_flow.out_refund_no
     *
     * @return the value of second_transaction_flow.out_refund_no
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    public String getOutRefundNo() {
        return outRefundNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_transaction_flow.out_refund_no
     *
     * @param outRefundNo the value for second_transaction_flow.out_refund_no
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    public void setOutRefundNo(String outRefundNo) {
        this.outRefundNo = outRefundNo == null ? null : outRefundNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_transaction_flow.wechart_package
     *
     * @return the value of second_transaction_flow.wechart_package
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    public String getWechartPackage() {
        return wechartPackage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_transaction_flow.wechart_package
     *
     * @param wechartPackage the value for second_transaction_flow.wechart_package
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    public void setWechartPackage(String wechartPackage) {
        this.wechartPackage = wechartPackage == null ? null : wechartPackage.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_transaction_flow.signType
     *
     * @return the value of second_transaction_flow.signType
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    public String getSigntype() {
        return signtype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_transaction_flow.signType
     *
     * @param signtype the value for second_transaction_flow.signType
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    public void setSigntype(String signtype) {
        this.signtype = signtype == null ? null : signtype.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_transaction_flow.app_id
     *
     * @return the value of second_transaction_flow.app_id
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    public String getAppId() {
        return appId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_transaction_flow.app_id
     *
     * @param appId the value for second_transaction_flow.app_id
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_transaction_flow.mch_id
     *
     * @return the value of second_transaction_flow.mch_id
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    public String getMchId() {
        return mchId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_transaction_flow.mch_id
     *
     * @param mchId the value for second_transaction_flow.mch_id
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    public void setMchId(String mchId) {
        this.mchId = mchId == null ? null : mchId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_transaction_flow.wechart_body
     *
     * @return the value of second_transaction_flow.wechart_body
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    public String getWechartBody() {
        return wechartBody;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_transaction_flow.wechart_body
     *
     * @param wechartBody the value for second_transaction_flow.wechart_body
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    public void setWechartBody(String wechartBody) {
        this.wechartBody = wechartBody == null ? null : wechartBody.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_transaction_flow.hf_status
     *
     * @return the value of second_transaction_flow.hf_status
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    public String getHfStatus() {
        return hfStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_transaction_flow.hf_status
     *
     * @param hfStatus the value for second_transaction_flow.hf_status
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    public void setHfStatus(String hfStatus) {
        this.hfStatus = hfStatus == null ? null : hfStatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_transaction_flow.device_info
     *
     * @return the value of second_transaction_flow.device_info
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    public String getDeviceInfo() {
        return deviceInfo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_transaction_flow.device_info
     *
     * @param deviceInfo the value for second_transaction_flow.device_info
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo == null ? null : deviceInfo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_transaction_flow.fee_type
     *
     * @return the value of second_transaction_flow.fee_type
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    public String getFeeType() {
        return feeType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_transaction_flow.fee_type
     *
     * @param feeType the value for second_transaction_flow.fee_type
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    public void setFeeType(String feeType) {
        this.feeType = feeType == null ? null : feeType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_transaction_flow.total_fee
     *
     * @return the value of second_transaction_flow.total_fee
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    public String getTotalFee() {
        return totalFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_transaction_flow.total_fee
     *
     * @param totalFee the value for second_transaction_flow.total_fee
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    public void setTotalFee(String totalFee) {
        this.totalFee = totalFee == null ? null : totalFee.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_transaction_flow.trade_type
     *
     * @return the value of second_transaction_flow.trade_type
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    public String getTradeType() {
        return tradeType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_transaction_flow.trade_type
     *
     * @param tradeType the value for second_transaction_flow.trade_type
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    public void setTradeType(String tradeType) {
        this.tradeType = tradeType == null ? null : tradeType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_transaction_flow.notify_url
     *
     * @return the value of second_transaction_flow.notify_url
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    public String getNotifyUrl() {
        return notifyUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_transaction_flow.notify_url
     *
     * @param notifyUrl the value for second_transaction_flow.notify_url
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl == null ? null : notifyUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_transaction_flow.spbill_create_ip
     *
     * @return the value of second_transaction_flow.spbill_create_ip
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    public String getSpbillCreateIp() {
        return spbillCreateIp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_transaction_flow.spbill_create_ip
     *
     * @param spbillCreateIp the value for second_transaction_flow.spbill_create_ip
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    public void setSpbillCreateIp(String spbillCreateIp) {
        this.spbillCreateIp = spbillCreateIp == null ? null : spbillCreateIp.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_transaction_flow.create_date
     *
     * @return the value of second_transaction_flow.create_date
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    public LocalDateTime getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_transaction_flow.create_date
     *
     * @param createDate the value for second_transaction_flow.create_date
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_transaction_flow.modify_date
     *
     * @return the value of second_transaction_flow.modify_date
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    public LocalDateTime getModifyDate() {
        return modifyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_transaction_flow.modify_date
     *
     * @param modifyDate the value for second_transaction_flow.modify_date
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    public void setModifyDate(LocalDateTime modifyDate) {
        this.modifyDate = modifyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_transaction_flow.id_deleted
     *
     * @return the value of second_transaction_flow.id_deleted
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    public Byte getIdDeleted() {
        return idDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_transaction_flow.id_deleted
     *
     * @param idDeleted the value for second_transaction_flow.id_deleted
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    public void setIdDeleted(Byte idDeleted) {
        this.idDeleted = idDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_transaction_flow
     *
     * @mbg.generated Thu Sep 17 15:58:56 CST 2020
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", openId=").append(openId);
        sb.append(", transactionType=").append(transactionType);
        sb.append(", outTradeNo=").append(outTradeNo);
        sb.append(", outRefundNo=").append(outRefundNo);
        sb.append(", wechartPackage=").append(wechartPackage);
        sb.append(", signtype=").append(signtype);
        sb.append(", appId=").append(appId);
        sb.append(", mchId=").append(mchId);
        sb.append(", wechartBody=").append(wechartBody);
        sb.append(", hfStatus=").append(hfStatus);
        sb.append(", deviceInfo=").append(deviceInfo);
        sb.append(", feeType=").append(feeType);
        sb.append(", totalFee=").append(totalFee);
        sb.append(", tradeType=").append(tradeType);
        sb.append(", notifyUrl=").append(notifyUrl);
        sb.append(", spbillCreateIp=").append(spbillCreateIp);
        sb.append(", createDate=").append(createDate);
        sb.append(", modifyDate=").append(modifyDate);
        sb.append(", idDeleted=").append(idDeleted);
        sb.append("]");
        return sb.toString();
    }
}