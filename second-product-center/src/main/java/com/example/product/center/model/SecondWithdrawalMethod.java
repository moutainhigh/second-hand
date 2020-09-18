package com.example.product.center.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SecondWithdrawalMethod implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_withdrawal_method.id
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_withdrawal_method.withdrawal_way_code
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    private String withdrawalWayCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_withdrawal_method.withdrawal_way_name
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    private String withdrawalWayName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_withdrawal_method.withdrawal_commission
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    private Integer withdrawalCommission;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_withdrawal_method.commission_type
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    private String commissionType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_withdrawal_method.grant_account
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    private String grantAccount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_withdrawal_method.create_date
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    private LocalDateTime createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_withdrawal_method.modify_date
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    private LocalDateTime modifyDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_withdrawal_method.is_deleted
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    private Byte isDeleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table second_withdrawal_method
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_withdrawal_method.id
     *
     * @return the value of second_withdrawal_method.id
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_withdrawal_method.id
     *
     * @param id the value for second_withdrawal_method.id
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_withdrawal_method.withdrawal_way_code
     *
     * @return the value of second_withdrawal_method.withdrawal_way_code
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    public String getWithdrawalWayCode() {
        return withdrawalWayCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_withdrawal_method.withdrawal_way_code
     *
     * @param withdrawalWayCode the value for second_withdrawal_method.withdrawal_way_code
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    public void setWithdrawalWayCode(String withdrawalWayCode) {
        this.withdrawalWayCode = withdrawalWayCode == null ? null : withdrawalWayCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_withdrawal_method.withdrawal_way_name
     *
     * @return the value of second_withdrawal_method.withdrawal_way_name
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    public String getWithdrawalWayName() {
        return withdrawalWayName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_withdrawal_method.withdrawal_way_name
     *
     * @param withdrawalWayName the value for second_withdrawal_method.withdrawal_way_name
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    public void setWithdrawalWayName(String withdrawalWayName) {
        this.withdrawalWayName = withdrawalWayName == null ? null : withdrawalWayName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_withdrawal_method.withdrawal_commission
     *
     * @return the value of second_withdrawal_method.withdrawal_commission
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    public Integer getWithdrawalCommission() {
        return withdrawalCommission;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_withdrawal_method.withdrawal_commission
     *
     * @param withdrawalCommission the value for second_withdrawal_method.withdrawal_commission
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    public void setWithdrawalCommission(Integer withdrawalCommission) {
        this.withdrawalCommission = withdrawalCommission;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_withdrawal_method.commission_type
     *
     * @return the value of second_withdrawal_method.commission_type
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    public String getCommissionType() {
        return commissionType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_withdrawal_method.commission_type
     *
     * @param commissionType the value for second_withdrawal_method.commission_type
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    public void setCommissionType(String commissionType) {
        this.commissionType = commissionType == null ? null : commissionType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_withdrawal_method.grant_account
     *
     * @return the value of second_withdrawal_method.grant_account
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    public String getGrantAccount() {
        return grantAccount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_withdrawal_method.grant_account
     *
     * @param grantAccount the value for second_withdrawal_method.grant_account
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    public void setGrantAccount(String grantAccount) {
        this.grantAccount = grantAccount == null ? null : grantAccount.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_withdrawal_method.create_date
     *
     * @return the value of second_withdrawal_method.create_date
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    public LocalDateTime getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_withdrawal_method.create_date
     *
     * @param createDate the value for second_withdrawal_method.create_date
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_withdrawal_method.modify_date
     *
     * @return the value of second_withdrawal_method.modify_date
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    public LocalDateTime getModifyDate() {
        return modifyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_withdrawal_method.modify_date
     *
     * @param modifyDate the value for second_withdrawal_method.modify_date
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    public void setModifyDate(LocalDateTime modifyDate) {
        this.modifyDate = modifyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_withdrawal_method.is_deleted
     *
     * @return the value of second_withdrawal_method.is_deleted
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    public Byte getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_withdrawal_method.is_deleted
     *
     * @param isDeleted the value for second_withdrawal_method.is_deleted
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_withdrawal_method
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", withdrawalWayCode=").append(withdrawalWayCode);
        sb.append(", withdrawalWayName=").append(withdrawalWayName);
        sb.append(", withdrawalCommission=").append(withdrawalCommission);
        sb.append(", commissionType=").append(commissionType);
        sb.append(", grantAccount=").append(grantAccount);
        sb.append(", createDate=").append(createDate);
        sb.append(", modifyDate=").append(modifyDate);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}