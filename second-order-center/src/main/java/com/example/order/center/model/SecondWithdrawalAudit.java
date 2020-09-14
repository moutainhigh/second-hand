package com.example.order.center.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SecondWithdrawalAudit implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_withdrawal_audit.id
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_withdrawal_audit.withdrawal_id
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    private Integer withdrawalId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_withdrawal_audit.approver
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    private Integer approver;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_withdrawal_audit.audit_state
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    private String auditState;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_withdrawal_audit.create_date
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    private LocalDateTime createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_withdrawal_audit.modify_date
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    private LocalDateTime modifyDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_withdrawal_audit.is_deleted
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    private Byte isDeleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table second_withdrawal_audit
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_withdrawal_audit.id
     *
     * @return the value of second_withdrawal_audit.id
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_withdrawal_audit.id
     *
     * @param id the value for second_withdrawal_audit.id
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_withdrawal_audit.withdrawal_id
     *
     * @return the value of second_withdrawal_audit.withdrawal_id
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public Integer getWithdrawalId() {
        return withdrawalId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_withdrawal_audit.withdrawal_id
     *
     * @param withdrawalId the value for second_withdrawal_audit.withdrawal_id
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public void setWithdrawalId(Integer withdrawalId) {
        this.withdrawalId = withdrawalId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_withdrawal_audit.approver
     *
     * @return the value of second_withdrawal_audit.approver
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public Integer getApprover() {
        return approver;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_withdrawal_audit.approver
     *
     * @param approver the value for second_withdrawal_audit.approver
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public void setApprover(Integer approver) {
        this.approver = approver;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_withdrawal_audit.audit_state
     *
     * @return the value of second_withdrawal_audit.audit_state
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public String getAuditState() {
        return auditState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_withdrawal_audit.audit_state
     *
     * @param auditState the value for second_withdrawal_audit.audit_state
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public void setAuditState(String auditState) {
        this.auditState = auditState == null ? null : auditState.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_withdrawal_audit.create_date
     *
     * @return the value of second_withdrawal_audit.create_date
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public LocalDateTime getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_withdrawal_audit.create_date
     *
     * @param createDate the value for second_withdrawal_audit.create_date
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_withdrawal_audit.modify_date
     *
     * @return the value of second_withdrawal_audit.modify_date
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public LocalDateTime getModifyDate() {
        return modifyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_withdrawal_audit.modify_date
     *
     * @param modifyDate the value for second_withdrawal_audit.modify_date
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public void setModifyDate(LocalDateTime modifyDate) {
        this.modifyDate = modifyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_withdrawal_audit.is_deleted
     *
     * @return the value of second_withdrawal_audit.is_deleted
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public Byte getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_withdrawal_audit.is_deleted
     *
     * @param isDeleted the value for second_withdrawal_audit.is_deleted
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_withdrawal_audit
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", withdrawalId=").append(withdrawalId);
        sb.append(", approver=").append(approver);
        sb.append(", auditState=").append(auditState);
        sb.append(", createDate=").append(createDate);
        sb.append(", modifyDate=").append(modifyDate);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}