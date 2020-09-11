package com.example.user.center.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SecondSon implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_son.id
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_son.user_id
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_son.file
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    private String file;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_son.collegory_id
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    private Integer collegoryId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_son.son_name
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    private String sonName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_son.son_type
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    private String sonType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_son.son_balance
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    private Integer sonBalance;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_son.create_time
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    private LocalDateTime createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_son.modify_time
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    private LocalDateTime modifyTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_son.is_deleted
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    private Short isDeleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table second_son
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_son.id
     *
     * @return the value of second_son.id
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_son.id
     *
     * @param id the value for second_son.id
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_son.user_id
     *
     * @return the value of second_son.user_id
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_son.user_id
     *
     * @param userId the value for second_son.user_id
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_son.file
     *
     * @return the value of second_son.file
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    public String getFile() {
        return file;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_son.file
     *
     * @param file the value for second_son.file
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    public void setFile(String file) {
        this.file = file == null ? null : file.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_son.collegory_id
     *
     * @return the value of second_son.collegory_id
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    public Integer getCollegoryId() {
        return collegoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_son.collegory_id
     *
     * @param collegoryId the value for second_son.collegory_id
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    public void setCollegoryId(Integer collegoryId) {
        this.collegoryId = collegoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_son.son_name
     *
     * @return the value of second_son.son_name
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    public String getSonName() {
        return sonName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_son.son_name
     *
     * @param sonName the value for second_son.son_name
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    public void setSonName(String sonName) {
        this.sonName = sonName == null ? null : sonName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_son.son_type
     *
     * @return the value of second_son.son_type
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    public String getSonType() {
        return sonType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_son.son_type
     *
     * @param sonType the value for second_son.son_type
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    public void setSonType(String sonType) {
        this.sonType = sonType == null ? null : sonType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_son.son_balance
     *
     * @return the value of second_son.son_balance
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    public Integer getSonBalance() {
        return sonBalance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_son.son_balance
     *
     * @param sonBalance the value for second_son.son_balance
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    public void setSonBalance(Integer sonBalance) {
        this.sonBalance = sonBalance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_son.create_time
     *
     * @return the value of second_son.create_time
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_son.create_time
     *
     * @param createTime the value for second_son.create_time
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_son.modify_time
     *
     * @return the value of second_son.modify_time
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_son.modify_time
     *
     * @param modifyTime the value for second_son.modify_time
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_son.is_deleted
     *
     * @return the value of second_son.is_deleted
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    public Short getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_son.is_deleted
     *
     * @param isDeleted the value for second_son.is_deleted
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    public void setIsDeleted(Short isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_son
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", file=").append(file);
        sb.append(", collegoryId=").append(collegoryId);
        sb.append(", sonName=").append(sonName);
        sb.append(", sonType=").append(sonType);
        sb.append(", sonBalance=").append(sonBalance);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}