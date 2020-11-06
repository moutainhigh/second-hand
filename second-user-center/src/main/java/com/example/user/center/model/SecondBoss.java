package com.example.user.center.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SecondBoss implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_boss.id
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_boss.boss_name
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    private String bossName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_boss.amount
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    private Integer amount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_boss.user_id
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_boss.registered_capital
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    private Integer registeredCapital;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_boss.service
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    private String service;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_boss.we_chat
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    private String weChat;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_boss.business_scope
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    private String businessScope;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_boss.store_withdrawal_commission
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    private Double storeWithdrawalCommission;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_boss.user_withdrawal_commission
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    private Double userWithdrawalCommission;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_boss.son_withdrawal_commission
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    private Double sonWithdrawalCommission;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_boss.new_user_integral
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    private Integer newUserIntegral;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_boss.create_time
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    private LocalDateTime createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_boss.modify_time
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    private LocalDateTime modifyTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_boss.is_deleted
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    private Byte isDeleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table second_boss
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_boss.id
     *
     * @return the value of second_boss.id
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
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
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
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
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
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
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
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
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
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
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
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
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
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
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
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
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
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
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    public void setRegisteredCapital(Integer registeredCapital) {
        this.registeredCapital = registeredCapital;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_boss.service
     *
     * @return the value of second_boss.service
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    public String getService() {
        return service;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_boss.service
     *
     * @param service the value for second_boss.service
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    public void setService(String service) {
        this.service = service == null ? null : service.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_boss.we_chat
     *
     * @return the value of second_boss.we_chat
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    public String getWeChat() {
        return weChat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_boss.we_chat
     *
     * @param weChat the value for second_boss.we_chat
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    public void setWeChat(String weChat) {
        this.weChat = weChat == null ? null : weChat.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_boss.business_scope
     *
     * @return the value of second_boss.business_scope
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
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
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope == null ? null : businessScope.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_boss.store_withdrawal_commission
     *
     * @return the value of second_boss.store_withdrawal_commission
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    public Double getStoreWithdrawalCommission() {
        return storeWithdrawalCommission;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_boss.store_withdrawal_commission
     *
     * @param storeWithdrawalCommission the value for second_boss.store_withdrawal_commission
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    public void setStoreWithdrawalCommission(Double storeWithdrawalCommission) {
        this.storeWithdrawalCommission = storeWithdrawalCommission;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_boss.user_withdrawal_commission
     *
     * @return the value of second_boss.user_withdrawal_commission
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    public Double getUserWithdrawalCommission() {
        return userWithdrawalCommission;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_boss.user_withdrawal_commission
     *
     * @param userWithdrawalCommission the value for second_boss.user_withdrawal_commission
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    public void setUserWithdrawalCommission(Double userWithdrawalCommission) {
        this.userWithdrawalCommission = userWithdrawalCommission;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_boss.son_withdrawal_commission
     *
     * @return the value of second_boss.son_withdrawal_commission
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    public Double getSonWithdrawalCommission() {
        return sonWithdrawalCommission;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_boss.son_withdrawal_commission
     *
     * @param sonWithdrawalCommission the value for second_boss.son_withdrawal_commission
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    public void setSonWithdrawalCommission(Double sonWithdrawalCommission) {
        this.sonWithdrawalCommission = sonWithdrawalCommission;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_boss.new_user_integral
     *
     * @return the value of second_boss.new_user_integral
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    public Integer getNewUserIntegral() {
        return newUserIntegral;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_boss.new_user_integral
     *
     * @param newUserIntegral the value for second_boss.new_user_integral
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    public void setNewUserIntegral(Integer newUserIntegral) {
        this.newUserIntegral = newUserIntegral;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_boss.create_time
     *
     * @return the value of second_boss.create_time
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
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
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
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
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
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
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
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
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
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
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_boss
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
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
        sb.append(", service=").append(service);
        sb.append(", weChat=").append(weChat);
        sb.append(", businessScope=").append(businessScope);
        sb.append(", storeWithdrawalCommission=").append(storeWithdrawalCommission);
        sb.append(", userWithdrawalCommission=").append(userWithdrawalCommission);
        sb.append(", sonWithdrawalCommission=").append(sonWithdrawalCommission);
        sb.append(", newUserIntegral=").append(newUserIntegral);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}