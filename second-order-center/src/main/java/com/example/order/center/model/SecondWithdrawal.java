package com.example.order.center.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SecondWithdrawal implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_withdrawal.id
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_withdrawal.source
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    private String source;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_withdrawal.withdrawal_mark
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    private String withdrawalMark;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_withdrawal.withdrawal_type
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    private String withdrawalType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_withdrawal.phone
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    private String phone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_withdrawal.withdrawal_money
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    private Integer withdrawalMoney;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_withdrawal.reality_money
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    private Integer realityMoney;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_withdrawal.withdrawal_account
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    private String withdrawalAccount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_withdrawal.withdrawal_name
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    private String withdrawalName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_withdrawal.withdrawal_state
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    private String withdrawalState;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_withdrawal.method_id
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    private Integer methodId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_withdrawal.store_id
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    private Integer storeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_withdrawal.user_id
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_withdrawal.son_id
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    private Integer sonId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_withdrawal.create_date
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    private LocalDateTime createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_withdrawal.modify_date
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    private LocalDateTime modifyDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_withdrawal.is_deleted
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    private Byte isDeleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table second_withdrawal
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_withdrawal.id
     *
     * @return the value of second_withdrawal.id
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_withdrawal.id
     *
     * @param id the value for second_withdrawal.id
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_withdrawal.source
     *
     * @return the value of second_withdrawal.source
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public String getSource() {
        return source;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_withdrawal.source
     *
     * @param source the value for second_withdrawal.source
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_withdrawal.withdrawal_mark
     *
     * @return the value of second_withdrawal.withdrawal_mark
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public String getWithdrawalMark() {
        return withdrawalMark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_withdrawal.withdrawal_mark
     *
     * @param withdrawalMark the value for second_withdrawal.withdrawal_mark
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public void setWithdrawalMark(String withdrawalMark) {
        this.withdrawalMark = withdrawalMark == null ? null : withdrawalMark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_withdrawal.withdrawal_type
     *
     * @return the value of second_withdrawal.withdrawal_type
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public String getWithdrawalType() {
        return withdrawalType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_withdrawal.withdrawal_type
     *
     * @param withdrawalType the value for second_withdrawal.withdrawal_type
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public void setWithdrawalType(String withdrawalType) {
        this.withdrawalType = withdrawalType == null ? null : withdrawalType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_withdrawal.phone
     *
     * @return the value of second_withdrawal.phone
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_withdrawal.phone
     *
     * @param phone the value for second_withdrawal.phone
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_withdrawal.withdrawal_money
     *
     * @return the value of second_withdrawal.withdrawal_money
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public Integer getWithdrawalMoney() {
        return withdrawalMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_withdrawal.withdrawal_money
     *
     * @param withdrawalMoney the value for second_withdrawal.withdrawal_money
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public void setWithdrawalMoney(Integer withdrawalMoney) {
        this.withdrawalMoney = withdrawalMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_withdrawal.reality_money
     *
     * @return the value of second_withdrawal.reality_money
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public Integer getRealityMoney() {
        return realityMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_withdrawal.reality_money
     *
     * @param realityMoney the value for second_withdrawal.reality_money
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public void setRealityMoney(Integer realityMoney) {
        this.realityMoney = realityMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_withdrawal.withdrawal_account
     *
     * @return the value of second_withdrawal.withdrawal_account
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public String getWithdrawalAccount() {
        return withdrawalAccount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_withdrawal.withdrawal_account
     *
     * @param withdrawalAccount the value for second_withdrawal.withdrawal_account
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public void setWithdrawalAccount(String withdrawalAccount) {
        this.withdrawalAccount = withdrawalAccount == null ? null : withdrawalAccount.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_withdrawal.withdrawal_name
     *
     * @return the value of second_withdrawal.withdrawal_name
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public String getWithdrawalName() {
        return withdrawalName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_withdrawal.withdrawal_name
     *
     * @param withdrawalName the value for second_withdrawal.withdrawal_name
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public void setWithdrawalName(String withdrawalName) {
        this.withdrawalName = withdrawalName == null ? null : withdrawalName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_withdrawal.withdrawal_state
     *
     * @return the value of second_withdrawal.withdrawal_state
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public String getWithdrawalState() {
        return withdrawalState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_withdrawal.withdrawal_state
     *
     * @param withdrawalState the value for second_withdrawal.withdrawal_state
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public void setWithdrawalState(String withdrawalState) {
        this.withdrawalState = withdrawalState == null ? null : withdrawalState.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_withdrawal.method_id
     *
     * @return the value of second_withdrawal.method_id
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public Integer getMethodId() {
        return methodId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_withdrawal.method_id
     *
     * @param methodId the value for second_withdrawal.method_id
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public void setMethodId(Integer methodId) {
        this.methodId = methodId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_withdrawal.store_id
     *
     * @return the value of second_withdrawal.store_id
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public Integer getStoreId() {
        return storeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_withdrawal.store_id
     *
     * @param storeId the value for second_withdrawal.store_id
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_withdrawal.user_id
     *
     * @return the value of second_withdrawal.user_id
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_withdrawal.user_id
     *
     * @param userId the value for second_withdrawal.user_id
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_withdrawal.son_id
     *
     * @return the value of second_withdrawal.son_id
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public Integer getSonId() {
        return sonId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_withdrawal.son_id
     *
     * @param sonId the value for second_withdrawal.son_id
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public void setSonId(Integer sonId) {
        this.sonId = sonId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_withdrawal.create_date
     *
     * @return the value of second_withdrawal.create_date
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public LocalDateTime getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_withdrawal.create_date
     *
     * @param createDate the value for second_withdrawal.create_date
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_withdrawal.modify_date
     *
     * @return the value of second_withdrawal.modify_date
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public LocalDateTime getModifyDate() {
        return modifyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_withdrawal.modify_date
     *
     * @param modifyDate the value for second_withdrawal.modify_date
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public void setModifyDate(LocalDateTime modifyDate) {
        this.modifyDate = modifyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_withdrawal.is_deleted
     *
     * @return the value of second_withdrawal.is_deleted
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public Byte getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_withdrawal.is_deleted
     *
     * @param isDeleted the value for second_withdrawal.is_deleted
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_withdrawal
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", source=").append(source);
        sb.append(", withdrawalMark=").append(withdrawalMark);
        sb.append(", withdrawalType=").append(withdrawalType);
        sb.append(", phone=").append(phone);
        sb.append(", withdrawalMoney=").append(withdrawalMoney);
        sb.append(", realityMoney=").append(realityMoney);
        sb.append(", withdrawalAccount=").append(withdrawalAccount);
        sb.append(", withdrawalName=").append(withdrawalName);
        sb.append(", withdrawalState=").append(withdrawalState);
        sb.append(", methodId=").append(methodId);
        sb.append(", storeId=").append(storeId);
        sb.append(", userId=").append(userId);
        sb.append(", sonId=").append(sonId);
        sb.append(", createDate=").append(createDate);
        sb.append(", modifyDate=").append(modifyDate);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}