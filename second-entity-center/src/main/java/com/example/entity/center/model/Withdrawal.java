package com.example.entity.center.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Withdrawal implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column withdrawal.id
     *
     * @mbg.generated Mon Sep 07 09:20:51 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column withdrawal.withdrawal_mark
     *
     * @mbg.generated Mon Sep 07 09:20:51 CST 2020
     */
    private String withdrawalMark;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column withdrawal.withdrawal_type
     *
     * @mbg.generated Mon Sep 07 09:20:51 CST 2020
     */
    private String withdrawalType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column withdrawal.phone
     *
     * @mbg.generated Mon Sep 07 09:20:51 CST 2020
     */
    private String phone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column withdrawal.reality_money
     *
     * @mbg.generated Mon Sep 07 09:20:51 CST 2020
     */
    private Integer realityMoney;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column withdrawal.withdrawal_account
     *
     * @mbg.generated Mon Sep 07 09:20:51 CST 2020
     */
    private String withdrawalAccount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column withdrawal.withdrawal_name
     *
     * @mbg.generated Mon Sep 07 09:20:51 CST 2020
     */
    private String withdrawalName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column withdrawal.withdrawal_state
     *
     * @mbg.generated Mon Sep 07 09:20:51 CST 2020
     */
    private String withdrawalState;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column withdrawal.withdrawal_money
     *
     * @mbg.generated Mon Sep 07 09:20:51 CST 2020
     */
    private Integer withdrawalMoney;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column withdrawal.method_id
     *
     * @mbg.generated Mon Sep 07 09:20:51 CST 2020
     */
    private Integer methodId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column withdrawal.stone_id
     *
     * @mbg.generated Mon Sep 07 09:20:51 CST 2020
     */
    private Integer stoneId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column withdrawal.user_id
     *
     * @mbg.generated Mon Sep 07 09:20:51 CST 2020
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column withdrawal.boss_id
     *
     * @mbg.generated Mon Sep 07 09:20:51 CST 2020
     */
    private Integer bossId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column withdrawal.create_date
     *
     * @mbg.generated Mon Sep 07 09:20:51 CST 2020
     */
    private LocalDateTime createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column withdrawal.modify_date
     *
     * @mbg.generated Mon Sep 07 09:20:51 CST 2020
     */
    private LocalDateTime modifyDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column withdrawal.is_deleted
     *
     * @mbg.generated Mon Sep 07 09:20:51 CST 2020
     */
    private Integer isDeleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table withdrawal
     *
     * @mbg.generated Mon Sep 07 09:20:51 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column withdrawal.id
     *
     * @return the value of withdrawal.id
     *
     * @mbg.generated Mon Sep 07 09:20:51 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column withdrawal.id
     *
     * @param id the value for withdrawal.id
     *
     * @mbg.generated Mon Sep 07 09:20:51 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column withdrawal.withdrawal_mark
     *
     * @return the value of withdrawal.withdrawal_mark
     *
     * @mbg.generated Mon Sep 07 09:20:51 CST 2020
     */
    public String getWithdrawalMark() {
        return withdrawalMark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column withdrawal.withdrawal_mark
     *
     * @param withdrawalMark the value for withdrawal.withdrawal_mark
     *
     * @mbg.generated Mon Sep 07 09:20:51 CST 2020
     */
    public void setWithdrawalMark(String withdrawalMark) {
        this.withdrawalMark = withdrawalMark == null ? null : withdrawalMark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column withdrawal.withdrawal_type
     *
     * @return the value of withdrawal.withdrawal_type
     *
     * @mbg.generated Mon Sep 07 09:20:51 CST 2020
     */
    public String getWithdrawalType() {
        return withdrawalType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column withdrawal.withdrawal_type
     *
     * @param withdrawalType the value for withdrawal.withdrawal_type
     *
     * @mbg.generated Mon Sep 07 09:20:51 CST 2020
     */
    public void setWithdrawalType(String withdrawalType) {
        this.withdrawalType = withdrawalType == null ? null : withdrawalType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column withdrawal.phone
     *
     * @return the value of withdrawal.phone
     *
     * @mbg.generated Mon Sep 07 09:20:51 CST 2020
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column withdrawal.phone
     *
     * @param phone the value for withdrawal.phone
     *
     * @mbg.generated Mon Sep 07 09:20:51 CST 2020
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column withdrawal.reality_money
     *
     * @return the value of withdrawal.reality_money
     *
     * @mbg.generated Mon Sep 07 09:20:51 CST 2020
     */
    public Integer getRealityMoney() {
        return realityMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column withdrawal.reality_money
     *
     * @param realityMoney the value for withdrawal.reality_money
     *
     * @mbg.generated Mon Sep 07 09:20:51 CST 2020
     */
    public void setRealityMoney(Integer realityMoney) {
        this.realityMoney = realityMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column withdrawal.withdrawal_account
     *
     * @return the value of withdrawal.withdrawal_account
     *
     * @mbg.generated Mon Sep 07 09:20:51 CST 2020
     */
    public String getWithdrawalAccount() {
        return withdrawalAccount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column withdrawal.withdrawal_account
     *
     * @param withdrawalAccount the value for withdrawal.withdrawal_account
     *
     * @mbg.generated Mon Sep 07 09:20:51 CST 2020
     */
    public void setWithdrawalAccount(String withdrawalAccount) {
        this.withdrawalAccount = withdrawalAccount == null ? null : withdrawalAccount.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column withdrawal.withdrawal_name
     *
     * @return the value of withdrawal.withdrawal_name
     *
     * @mbg.generated Mon Sep 07 09:20:51 CST 2020
     */
    public String getWithdrawalName() {
        return withdrawalName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column withdrawal.withdrawal_name
     *
     * @param withdrawalName the value for withdrawal.withdrawal_name
     *
     * @mbg.generated Mon Sep 07 09:20:51 CST 2020
     */
    public void setWithdrawalName(String withdrawalName) {
        this.withdrawalName = withdrawalName == null ? null : withdrawalName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column withdrawal.withdrawal_state
     *
     * @return the value of withdrawal.withdrawal_state
     *
     * @mbg.generated Mon Sep 07 09:20:51 CST 2020
     */
    public String getWithdrawalState() {
        return withdrawalState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column withdrawal.withdrawal_state
     *
     * @param withdrawalState the value for withdrawal.withdrawal_state
     *
     * @mbg.generated Mon Sep 07 09:20:51 CST 2020
     */
    public void setWithdrawalState(String withdrawalState) {
        this.withdrawalState = withdrawalState == null ? null : withdrawalState.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column withdrawal.withdrawal_money
     *
     * @return the value of withdrawal.withdrawal_money
     *
     * @mbg.generated Mon Sep 07 09:20:51 CST 2020
     */
    public Integer getWithdrawalMoney() {
        return withdrawalMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column withdrawal.withdrawal_money
     *
     * @param withdrawalMoney the value for withdrawal.withdrawal_money
     *
     * @mbg.generated Mon Sep 07 09:20:51 CST 2020
     */
    public void setWithdrawalMoney(Integer withdrawalMoney) {
        this.withdrawalMoney = withdrawalMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column withdrawal.method_id
     *
     * @return the value of withdrawal.method_id
     *
     * @mbg.generated Mon Sep 07 09:20:51 CST 2020
     */
    public Integer getMethodId() {
        return methodId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column withdrawal.method_id
     *
     * @param methodId the value for withdrawal.method_id
     *
     * @mbg.generated Mon Sep 07 09:20:51 CST 2020
     */
    public void setMethodId(Integer methodId) {
        this.methodId = methodId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column withdrawal.stone_id
     *
     * @return the value of withdrawal.stone_id
     *
     * @mbg.generated Mon Sep 07 09:20:51 CST 2020
     */
    public Integer getStoneId() {
        return stoneId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column withdrawal.stone_id
     *
     * @param stoneId the value for withdrawal.stone_id
     *
     * @mbg.generated Mon Sep 07 09:20:51 CST 2020
     */
    public void setStoneId(Integer stoneId) {
        this.stoneId = stoneId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column withdrawal.user_id
     *
     * @return the value of withdrawal.user_id
     *
     * @mbg.generated Mon Sep 07 09:20:51 CST 2020
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column withdrawal.user_id
     *
     * @param userId the value for withdrawal.user_id
     *
     * @mbg.generated Mon Sep 07 09:20:51 CST 2020
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column withdrawal.boss_id
     *
     * @return the value of withdrawal.boss_id
     *
     * @mbg.generated Mon Sep 07 09:20:51 CST 2020
     */
    public Integer getBossId() {
        return bossId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column withdrawal.boss_id
     *
     * @param bossId the value for withdrawal.boss_id
     *
     * @mbg.generated Mon Sep 07 09:20:51 CST 2020
     */
    public void setBossId(Integer bossId) {
        this.bossId = bossId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column withdrawal.create_date
     *
     * @return the value of withdrawal.create_date
     *
     * @mbg.generated Mon Sep 07 09:20:51 CST 2020
     */
    public LocalDateTime getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column withdrawal.create_date
     *
     * @param createDate the value for withdrawal.create_date
     *
     * @mbg.generated Mon Sep 07 09:20:51 CST 2020
     */
    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column withdrawal.modify_date
     *
     * @return the value of withdrawal.modify_date
     *
     * @mbg.generated Mon Sep 07 09:20:51 CST 2020
     */
    public LocalDateTime getModifyDate() {
        return modifyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column withdrawal.modify_date
     *
     * @param modifyDate the value for withdrawal.modify_date
     *
     * @mbg.generated Mon Sep 07 09:20:51 CST 2020
     */
    public void setModifyDate(LocalDateTime modifyDate) {
        this.modifyDate = modifyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column withdrawal.is_deleted
     *
     * @return the value of withdrawal.is_deleted
     *
     * @mbg.generated Mon Sep 07 09:20:51 CST 2020
     */
    public Integer getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column withdrawal.is_deleted
     *
     * @param isDeleted the value for withdrawal.is_deleted
     *
     * @mbg.generated Mon Sep 07 09:20:51 CST 2020
     */
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table withdrawal
     *
     * @mbg.generated Mon Sep 07 09:20:51 CST 2020
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", withdrawalMark=").append(withdrawalMark);
        sb.append(", withdrawalType=").append(withdrawalType);
        sb.append(", phone=").append(phone);
        sb.append(", realityMoney=").append(realityMoney);
        sb.append(", withdrawalAccount=").append(withdrawalAccount);
        sb.append(", withdrawalName=").append(withdrawalName);
        sb.append(", withdrawalState=").append(withdrawalState);
        sb.append(", withdrawalMoney=").append(withdrawalMoney);
        sb.append(", methodId=").append(methodId);
        sb.append(", stoneId=").append(stoneId);
        sb.append(", userId=").append(userId);
        sb.append(", bossId=").append(bossId);
        sb.append(", createDate=").append(createDate);
        sb.append(", modifyDate=").append(modifyDate);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}