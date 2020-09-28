package com.example.user.center.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SecondBossSetting implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_boss_setting.id
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_boss_setting.boss_id
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    private Integer bossId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_boss_setting.boss_type
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    private String bossType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_boss_setting.app_id
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    private String appId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_boss_setting.public_appId
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    private String publicAppid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_boss_setting.mch_id
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    private String mchId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_boss_setting.pay_key
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    private String payKey;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_boss_setting.apiclient_cert
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    private String apiclientCert;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_boss_setting.grant_type
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    private String grantType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_boss_setting.create_time
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    private LocalDateTime createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_boss_setting.modify_time
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    private LocalDateTime modifyTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_boss_setting.is_deleted
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    private Byte isDeleted;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_boss_setting.secret
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    private String secret;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table second_boss_setting
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_boss_setting.id
     *
     * @return the value of second_boss_setting.id
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_boss_setting.id
     *
     * @param id the value for second_boss_setting.id
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_boss_setting.boss_id
     *
     * @return the value of second_boss_setting.boss_id
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public Integer getBossId() {
        return bossId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_boss_setting.boss_id
     *
     * @param bossId the value for second_boss_setting.boss_id
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public void setBossId(Integer bossId) {
        this.bossId = bossId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_boss_setting.boss_type
     *
     * @return the value of second_boss_setting.boss_type
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public String getBossType() {
        return bossType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_boss_setting.boss_type
     *
     * @param bossType the value for second_boss_setting.boss_type
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public void setBossType(String bossType) {
        this.bossType = bossType == null ? null : bossType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_boss_setting.app_id
     *
     * @return the value of second_boss_setting.app_id
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public String getAppId() {
        return appId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_boss_setting.app_id
     *
     * @param appId the value for second_boss_setting.app_id
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_boss_setting.public_appId
     *
     * @return the value of second_boss_setting.public_appId
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public String getPublicAppid() {
        return publicAppid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_boss_setting.public_appId
     *
     * @param publicAppid the value for second_boss_setting.public_appId
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public void setPublicAppid(String publicAppid) {
        this.publicAppid = publicAppid == null ? null : publicAppid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_boss_setting.mch_id
     *
     * @return the value of second_boss_setting.mch_id
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public String getMchId() {
        return mchId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_boss_setting.mch_id
     *
     * @param mchId the value for second_boss_setting.mch_id
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public void setMchId(String mchId) {
        this.mchId = mchId == null ? null : mchId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_boss_setting.pay_key
     *
     * @return the value of second_boss_setting.pay_key
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public String getPayKey() {
        return payKey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_boss_setting.pay_key
     *
     * @param payKey the value for second_boss_setting.pay_key
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public void setPayKey(String payKey) {
        this.payKey = payKey == null ? null : payKey.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_boss_setting.apiclient_cert
     *
     * @return the value of second_boss_setting.apiclient_cert
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public String getApiclientCert() {
        return apiclientCert;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_boss_setting.apiclient_cert
     *
     * @param apiclientCert the value for second_boss_setting.apiclient_cert
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public void setApiclientCert(String apiclientCert) {
        this.apiclientCert = apiclientCert == null ? null : apiclientCert.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_boss_setting.grant_type
     *
     * @return the value of second_boss_setting.grant_type
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public String getGrantType() {
        return grantType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_boss_setting.grant_type
     *
     * @param grantType the value for second_boss_setting.grant_type
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public void setGrantType(String grantType) {
        this.grantType = grantType == null ? null : grantType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_boss_setting.create_time
     *
     * @return the value of second_boss_setting.create_time
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_boss_setting.create_time
     *
     * @param createTime the value for second_boss_setting.create_time
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_boss_setting.modify_time
     *
     * @return the value of second_boss_setting.modify_time
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_boss_setting.modify_time
     *
     * @param modifyTime the value for second_boss_setting.modify_time
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_boss_setting.is_deleted
     *
     * @return the value of second_boss_setting.is_deleted
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public Byte getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_boss_setting.is_deleted
     *
     * @param isDeleted the value for second_boss_setting.is_deleted
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_boss_setting.secret
     *
     * @return the value of second_boss_setting.secret
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public String getSecret() {
        return secret;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_boss_setting.secret
     *
     * @param secret the value for second_boss_setting.secret
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public void setSecret(String secret) {
        this.secret = secret == null ? null : secret.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_boss_setting
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
        sb.append(", bossId=").append(bossId);
        sb.append(", bossType=").append(bossType);
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