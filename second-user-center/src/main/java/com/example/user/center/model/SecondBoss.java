package com.example.user.center.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SecondBoss implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_boss.id
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_boss.boss_name
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    private String bossName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_boss.amount
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    private Integer amount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_boss.user_id
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_boss.registered_capital
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    private Integer registeredCapital;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_boss.business_scope
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    private String businessScope;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_boss.app_id
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    private String appId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_boss.public_appId
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    private String publicAppid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_boss.mch_id
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    private String mchId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_boss.pay_key
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    private String payKey;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_boss.apiclient_cert
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    private String apiclientCert;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_boss.grant_type
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    private String grantType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_boss.create_time
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    private LocalDateTime createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_boss.modify_time
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    private LocalDateTime modifyTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_boss.is_deleted
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    private Byte isDeleted;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_boss.secret
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    private String secret;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table second_boss
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_boss.id
     *
     * @return the value of second_boss.id
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_boss.id
     *
     * @param id the value for second_boss.id
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_boss.boss_name
     *
     * @return the value of second_boss.boss_name
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    public String getBossName() {
        return bossName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_boss.boss_name
     *
     * @param bossName the value for second_boss.boss_name
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    public void setBossName(String bossName) {
        this.bossName = bossName == null ? null : bossName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_boss.amount
     *
     * @return the value of second_boss.amount
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_boss.amount
     *
     * @param amount the value for second_boss.amount
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_boss.user_id
     *
     * @return the value of second_boss.user_id
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_boss.user_id
     *
     * @param userId the value for second_boss.user_id
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_boss.registered_capital
     *
     * @return the value of second_boss.registered_capital
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    public Integer getRegisteredCapital() {
        return registeredCapital;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_boss.registered_capital
     *
     * @param registeredCapital the value for second_boss.registered_capital
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    public void setRegisteredCapital(Integer registeredCapital) {
        this.registeredCapital = registeredCapital;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_boss.business_scope
     *
     * @return the value of second_boss.business_scope
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    public String getBusinessScope() {
        return businessScope;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_boss.business_scope
     *
     * @param businessScope the value for second_boss.business_scope
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope == null ? null : businessScope.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_boss.app_id
     *
     * @return the value of second_boss.app_id
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    public String getAppId() {
        return appId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_boss.app_id
     *
     * @param appId the value for second_boss.app_id
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_boss.public_appId
     *
     * @return the value of second_boss.public_appId
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    public String getPublicAppid() {
        return publicAppid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_boss.public_appId
     *
     * @param publicAppid the value for second_boss.public_appId
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    public void setPublicAppid(String publicAppid) {
        this.publicAppid = publicAppid == null ? null : publicAppid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_boss.mch_id
     *
     * @return the value of second_boss.mch_id
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    public String getMchId() {
        return mchId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_boss.mch_id
     *
     * @param mchId the value for second_boss.mch_id
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    public void setMchId(String mchId) {
        this.mchId = mchId == null ? null : mchId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_boss.pay_key
     *
     * @return the value of second_boss.pay_key
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    public String getPayKey() {
        return payKey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_boss.pay_key
     *
     * @param payKey the value for second_boss.pay_key
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    public void setPayKey(String payKey) {
        this.payKey = payKey == null ? null : payKey.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_boss.apiclient_cert
     *
     * @return the value of second_boss.apiclient_cert
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    public String getApiclientCert() {
        return apiclientCert;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_boss.apiclient_cert
     *
     * @param apiclientCert the value for second_boss.apiclient_cert
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    public void setApiclientCert(String apiclientCert) {
        this.apiclientCert = apiclientCert == null ? null : apiclientCert.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_boss.grant_type
     *
     * @return the value of second_boss.grant_type
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    public String getGrantType() {
        return grantType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_boss.grant_type
     *
     * @param grantType the value for second_boss.grant_type
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    public void setGrantType(String grantType) {
        this.grantType = grantType == null ? null : grantType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_boss.create_time
     *
     * @return the value of second_boss.create_time
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_boss.create_time
     *
     * @param createTime the value for second_boss.create_time
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_boss.modify_time
     *
     * @return the value of second_boss.modify_time
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_boss.modify_time
     *
     * @param modifyTime the value for second_boss.modify_time
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_boss.is_deleted
     *
     * @return the value of second_boss.is_deleted
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    public Byte getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_boss.is_deleted
     *
     * @param isDeleted the value for second_boss.is_deleted
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_boss.secret
     *
     * @return the value of second_boss.secret
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    public String getSecret() {
        return secret;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_boss.secret
     *
     * @param secret the value for second_boss.secret
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    public void setSecret(String secret) {
        this.secret = secret == null ? null : secret.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_boss
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", bossName=").append(bossName);
        sb.append(", amount=").append(amount);
        sb.append(", userId=").append(userId);
        sb.append(", registeredCapital=").append(registeredCapital);
        sb.append(", businessScope=").append(businessScope);
        sb.append(", appId=").append(appId);
        sb.append(", publicAppid=").append(publicAppid);
        sb.append(", mchId=").append(mchId);
        sb.append(", payKey=").append(payKey);
        sb.append(", apiclientCert=").append(apiclientCert);
        sb.append(", grantType=").append(grantType);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", secret=").append(secret);
        sb.append("]");
        return sb.toString();
    }
}