package com.example.payment.center.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SecondLabel implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_label.id
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_label.label_name
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    private String labelName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_label.label_desc
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    private String labelDesc;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_label.create_time
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    private LocalDateTime createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_label.modify_time
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    private LocalDateTime modifyTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_label.is_deleted
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    private Short isDeleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table second_label
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_label.id
     *
     * @return the value of second_label.id
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_label.id
     *
     * @param id the value for second_label.id
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_label.label_name
     *
     * @return the value of second_label.label_name
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public String getLabelName() {
        return labelName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_label.label_name
     *
     * @param labelName the value for second_label.label_name
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public void setLabelName(String labelName) {
        this.labelName = labelName == null ? null : labelName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_label.label_desc
     *
     * @return the value of second_label.label_desc
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public String getLabelDesc() {
        return labelDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_label.label_desc
     *
     * @param labelDesc the value for second_label.label_desc
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public void setLabelDesc(String labelDesc) {
        this.labelDesc = labelDesc == null ? null : labelDesc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_label.create_time
     *
     * @return the value of second_label.create_time
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_label.create_time
     *
     * @param createTime the value for second_label.create_time
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_label.modify_time
     *
     * @return the value of second_label.modify_time
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_label.modify_time
     *
     * @param modifyTime the value for second_label.modify_time
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_label.is_deleted
     *
     * @return the value of second_label.is_deleted
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public Short getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_label.is_deleted
     *
     * @param isDeleted the value for second_label.is_deleted
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public void setIsDeleted(Short isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_label
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
        sb.append(", labelName=").append(labelName);
        sb.append(", labelDesc=").append(labelDesc);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}