package com.example.payment.center.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SecondStoreBalance implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_store_balance.id
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_store_balance.user_id
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_store_balance.store_id
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    private Integer storeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_store_balance.balance_type
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    private String balanceType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_store_balance.second_balance
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    private Integer secondBalance;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_store_balance.second_remark
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    private String secondRemark;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_store_balance.create_time
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    private LocalDateTime createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_store_balance.modify_time
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    private LocalDateTime modifyTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_store_balance.is_deleted
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    private Short isDeleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table second_store_balance
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_store_balance.id
     *
     * @return the value of second_store_balance.id
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_store_balance.id
     *
     * @param id the value for second_store_balance.id
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_store_balance.user_id
     *
     * @return the value of second_store_balance.user_id
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_store_balance.user_id
     *
     * @param userId the value for second_store_balance.user_id
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_store_balance.store_id
     *
     * @return the value of second_store_balance.store_id
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public Integer getStoreId() {
        return storeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_store_balance.store_id
     *
     * @param storeId the value for second_store_balance.store_id
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_store_balance.balance_type
     *
     * @return the value of second_store_balance.balance_type
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public String getBalanceType() {
        return balanceType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_store_balance.balance_type
     *
     * @param balanceType the value for second_store_balance.balance_type
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public void setBalanceType(String balanceType) {
        this.balanceType = balanceType == null ? null : balanceType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_store_balance.second_balance
     *
     * @return the value of second_store_balance.second_balance
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public Integer getSecondBalance() {
        return secondBalance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_store_balance.second_balance
     *
     * @param secondBalance the value for second_store_balance.second_balance
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public void setSecondBalance(Integer secondBalance) {
        this.secondBalance = secondBalance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_store_balance.second_remark
     *
     * @return the value of second_store_balance.second_remark
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public String getSecondRemark() {
        return secondRemark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_store_balance.second_remark
     *
     * @param secondRemark the value for second_store_balance.second_remark
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public void setSecondRemark(String secondRemark) {
        this.secondRemark = secondRemark == null ? null : secondRemark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_store_balance.create_time
     *
     * @return the value of second_store_balance.create_time
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_store_balance.create_time
     *
     * @param createTime the value for second_store_balance.create_time
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_store_balance.modify_time
     *
     * @return the value of second_store_balance.modify_time
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_store_balance.modify_time
     *
     * @param modifyTime the value for second_store_balance.modify_time
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_store_balance.is_deleted
     *
     * @return the value of second_store_balance.is_deleted
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public Short getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_store_balance.is_deleted
     *
     * @param isDeleted the value for second_store_balance.is_deleted
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public void setIsDeleted(Short isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store_balance
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", storeId=").append(storeId);
        sb.append(", balanceType=").append(balanceType);
        sb.append(", secondBalance=").append(secondBalance);
        sb.append(", secondRemark=").append(secondRemark);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}