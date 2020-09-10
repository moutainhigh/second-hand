package com.example.product.center.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SecondStoreBalanceDetail implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_store_balance_detail.id
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_store_balance_detail.user_id
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_store_balance_detail.store_id
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    private Integer storeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_store_balance_detail.amount
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    private Integer amount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_store_balance_detail.detail_type
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    private String detailType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_store_balance_detail.income_expenses
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    private String incomeExpenses;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_store_balance_detail.create_time
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    private LocalDateTime createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_store_balance_detail.modify_time
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    private LocalDateTime modifyTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_store_balance_detail.is_deleted
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    private Short isDeleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table second_store_balance_detail
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_store_balance_detail.id
     *
     * @return the value of second_store_balance_detail.id
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_store_balance_detail.id
     *
     * @param id the value for second_store_balance_detail.id
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_store_balance_detail.user_id
     *
     * @return the value of second_store_balance_detail.user_id
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_store_balance_detail.user_id
     *
     * @param userId the value for second_store_balance_detail.user_id
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_store_balance_detail.store_id
     *
     * @return the value of second_store_balance_detail.store_id
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public Integer getStoreId() {
        return storeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_store_balance_detail.store_id
     *
     * @param storeId the value for second_store_balance_detail.store_id
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_store_balance_detail.amount
     *
     * @return the value of second_store_balance_detail.amount
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_store_balance_detail.amount
     *
     * @param amount the value for second_store_balance_detail.amount
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_store_balance_detail.detail_type
     *
     * @return the value of second_store_balance_detail.detail_type
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public String getDetailType() {
        return detailType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_store_balance_detail.detail_type
     *
     * @param detailType the value for second_store_balance_detail.detail_type
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public void setDetailType(String detailType) {
        this.detailType = detailType == null ? null : detailType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_store_balance_detail.income_expenses
     *
     * @return the value of second_store_balance_detail.income_expenses
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public String getIncomeExpenses() {
        return incomeExpenses;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_store_balance_detail.income_expenses
     *
     * @param incomeExpenses the value for second_store_balance_detail.income_expenses
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public void setIncomeExpenses(String incomeExpenses) {
        this.incomeExpenses = incomeExpenses == null ? null : incomeExpenses.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_store_balance_detail.create_time
     *
     * @return the value of second_store_balance_detail.create_time
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_store_balance_detail.create_time
     *
     * @param createTime the value for second_store_balance_detail.create_time
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_store_balance_detail.modify_time
     *
     * @return the value of second_store_balance_detail.modify_time
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_store_balance_detail.modify_time
     *
     * @param modifyTime the value for second_store_balance_detail.modify_time
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_store_balance_detail.is_deleted
     *
     * @return the value of second_store_balance_detail.is_deleted
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public Short getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_store_balance_detail.is_deleted
     *
     * @param isDeleted the value for second_store_balance_detail.is_deleted
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    public void setIsDeleted(Short isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store_balance_detail
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
        sb.append(", userId=").append(userId);
        sb.append(", storeId=").append(storeId);
        sb.append(", amount=").append(amount);
        sb.append(", detailType=").append(detailType);
        sb.append(", incomeExpenses=").append(incomeExpenses);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}