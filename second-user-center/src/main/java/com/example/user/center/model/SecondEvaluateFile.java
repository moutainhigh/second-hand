package com.example.user.center.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SecondEvaluateFile implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_evaluate_file.id
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_evaluate_file.evaluate_id
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    private Integer evaluateId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_evaluate_file.file
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    private String file;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_evaluate_file.create_time
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    private LocalDateTime createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_evaluate_file.modify_time
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    private LocalDateTime modifyTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_evaluate_file.is_deleted
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    private Short isDeleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table second_evaluate_file
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_evaluate_file.id
     *
     * @return the value of second_evaluate_file.id
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_evaluate_file.id
     *
     * @param id the value for second_evaluate_file.id
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_evaluate_file.evaluate_id
     *
     * @return the value of second_evaluate_file.evaluate_id
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public Integer getEvaluateId() {
        return evaluateId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_evaluate_file.evaluate_id
     *
     * @param evaluateId the value for second_evaluate_file.evaluate_id
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public void setEvaluateId(Integer evaluateId) {
        this.evaluateId = evaluateId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_evaluate_file.file
     *
     * @return the value of second_evaluate_file.file
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public String getFile() {
        return file;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_evaluate_file.file
     *
     * @param file the value for second_evaluate_file.file
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public void setFile(String file) {
        this.file = file == null ? null : file.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_evaluate_file.create_time
     *
     * @return the value of second_evaluate_file.create_time
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_evaluate_file.create_time
     *
     * @param createTime the value for second_evaluate_file.create_time
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_evaluate_file.modify_time
     *
     * @return the value of second_evaluate_file.modify_time
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_evaluate_file.modify_time
     *
     * @param modifyTime the value for second_evaluate_file.modify_time
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_evaluate_file.is_deleted
     *
     * @return the value of second_evaluate_file.is_deleted
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public Short getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_evaluate_file.is_deleted
     *
     * @param isDeleted the value for second_evaluate_file.is_deleted
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public void setIsDeleted(Short isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_evaluate_file
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
        sb.append(", evaluateId=").append(evaluateId);
        sb.append(", file=").append(file);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}