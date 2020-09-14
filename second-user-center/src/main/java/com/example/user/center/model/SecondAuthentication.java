package com.example.user.center.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SecondAuthentication implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_authentication.id
     *
     * @mbg.generated Sat Sep 12 11:56:23 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_authentication.user_id
     *
     * @mbg.generated Sat Sep 12 11:56:23 CST 2020
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_authentication.name
     *
     * @mbg.generated Sat Sep 12 11:56:23 CST 2020
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_authentication.sex
     *
     * @mbg.generated Sat Sep 12 11:56:23 CST 2020
     */
    private Integer sex;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_authentication.colleges_name
     *
     * @mbg.generated Sat Sep 12 11:56:23 CST 2020
     */
    private String collegesName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_authentication.entrance_time
     *
     * @mbg.generated Sat Sep 12 11:56:23 CST 2020
     */
    private LocalDateTime entranceTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_authentication.student_number
     *
     * @mbg.generated Sat Sep 12 11:56:23 CST 2020
     */
    private String studentNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_authentication.store_id
     *
     * @mbg.generated Sat Sep 12 11:56:23 CST 2020
     */
    private Integer storeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_authentication.colleges_id
     *
     * @mbg.generated Sat Sep 12 11:56:23 CST 2020
     */
    private Integer collegesId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_authentication.colleges_record
     *
     * @mbg.generated Sat Sep 12 11:56:23 CST 2020
     */
    private String collegesRecord;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_authentication.authentication_state
     *
     * @mbg.generated Sat Sep 12 11:56:23 CST 2020
     */
    private Integer authenticationState;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_authentication.create_date
     *
     * @mbg.generated Sat Sep 12 11:56:23 CST 2020
     */
    private LocalDateTime createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_authentication.modify_date
     *
     * @mbg.generated Sat Sep 12 11:56:23 CST 2020
     */
    private LocalDateTime modifyDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_authentication.is_deleted
     *
     * @mbg.generated Sat Sep 12 11:56:23 CST 2020
     */
    private Byte isDeleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table second_authentication
     *
     * @mbg.generated Sat Sep 12 11:56:23 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_authentication.id
     *
     * @return the value of second_authentication.id
     *
     * @mbg.generated Sat Sep 12 11:56:23 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_authentication.id
     *
     * @param id the value for second_authentication.id
     *
     * @mbg.generated Sat Sep 12 11:56:23 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_authentication.user_id
     *
     * @return the value of second_authentication.user_id
     *
     * @mbg.generated Sat Sep 12 11:56:23 CST 2020
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_authentication.user_id
     *
     * @param userId the value for second_authentication.user_id
     *
     * @mbg.generated Sat Sep 12 11:56:23 CST 2020
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_authentication.name
     *
     * @return the value of second_authentication.name
     *
     * @mbg.generated Sat Sep 12 11:56:23 CST 2020
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_authentication.name
     *
     * @param name the value for second_authentication.name
     *
     * @mbg.generated Sat Sep 12 11:56:23 CST 2020
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_authentication.sex
     *
     * @return the value of second_authentication.sex
     *
     * @mbg.generated Sat Sep 12 11:56:23 CST 2020
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_authentication.sex
     *
     * @param sex the value for second_authentication.sex
     *
     * @mbg.generated Sat Sep 12 11:56:23 CST 2020
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_authentication.colleges_name
     *
     * @return the value of second_authentication.colleges_name
     *
     * @mbg.generated Sat Sep 12 11:56:23 CST 2020
     */
    public String getCollegesName() {
        return collegesName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_authentication.colleges_name
     *
     * @param collegesName the value for second_authentication.colleges_name
     *
     * @mbg.generated Sat Sep 12 11:56:23 CST 2020
     */
    public void setCollegesName(String collegesName) {
        this.collegesName = collegesName == null ? null : collegesName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_authentication.entrance_time
     *
     * @return the value of second_authentication.entrance_time
     *
     * @mbg.generated Sat Sep 12 11:56:23 CST 2020
     */
    public LocalDateTime getEntranceTime() {
        return entranceTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_authentication.entrance_time
     *
     * @param entranceTime the value for second_authentication.entrance_time
     *
     * @mbg.generated Sat Sep 12 11:56:23 CST 2020
     */
    public void setEntranceTime(LocalDateTime entranceTime) {
        this.entranceTime = entranceTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_authentication.student_number
     *
     * @return the value of second_authentication.student_number
     *
     * @mbg.generated Sat Sep 12 11:56:23 CST 2020
     */
    public String getStudentNumber() {
        return studentNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_authentication.student_number
     *
     * @param studentNumber the value for second_authentication.student_number
     *
     * @mbg.generated Sat Sep 12 11:56:23 CST 2020
     */
    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber == null ? null : studentNumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_authentication.store_id
     *
     * @return the value of second_authentication.store_id
     *
     * @mbg.generated Sat Sep 12 11:56:23 CST 2020
     */
    public Integer getStoreId() {
        return storeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_authentication.store_id
     *
     * @param storeId the value for second_authentication.store_id
     *
     * @mbg.generated Sat Sep 12 11:56:23 CST 2020
     */
    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_authentication.colleges_id
     *
     * @return the value of second_authentication.colleges_id
     *
     * @mbg.generated Sat Sep 12 11:56:23 CST 2020
     */
    public Integer getCollegesId() {
        return collegesId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_authentication.colleges_id
     *
     * @param collegesId the value for second_authentication.colleges_id
     *
     * @mbg.generated Sat Sep 12 11:56:23 CST 2020
     */
    public void setCollegesId(Integer collegesId) {
        this.collegesId = collegesId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_authentication.colleges_record
     *
     * @return the value of second_authentication.colleges_record
     *
     * @mbg.generated Sat Sep 12 11:56:23 CST 2020
     */
    public String getCollegesRecord() {
        return collegesRecord;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_authentication.colleges_record
     *
     * @param collegesRecord the value for second_authentication.colleges_record
     *
     * @mbg.generated Sat Sep 12 11:56:23 CST 2020
     */
    public void setCollegesRecord(String collegesRecord) {
        this.collegesRecord = collegesRecord == null ? null : collegesRecord.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_authentication.authentication_state
     *
     * @return the value of second_authentication.authentication_state
     *
     * @mbg.generated Sat Sep 12 11:56:23 CST 2020
     */
    public Integer getAuthenticationState() {
        return authenticationState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_authentication.authentication_state
     *
     * @param authenticationState the value for second_authentication.authentication_state
     *
     * @mbg.generated Sat Sep 12 11:56:23 CST 2020
     */
    public void setAuthenticationState(Integer authenticationState) {
        this.authenticationState = authenticationState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_authentication.create_date
     *
     * @return the value of second_authentication.create_date
     *
     * @mbg.generated Sat Sep 12 11:56:23 CST 2020
     */
    public LocalDateTime getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_authentication.create_date
     *
     * @param createDate the value for second_authentication.create_date
     *
     * @mbg.generated Sat Sep 12 11:56:23 CST 2020
     */
    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_authentication.modify_date
     *
     * @return the value of second_authentication.modify_date
     *
     * @mbg.generated Sat Sep 12 11:56:23 CST 2020
     */
    public LocalDateTime getModifyDate() {
        return modifyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_authentication.modify_date
     *
     * @param modifyDate the value for second_authentication.modify_date
     *
     * @mbg.generated Sat Sep 12 11:56:23 CST 2020
     */
    public void setModifyDate(LocalDateTime modifyDate) {
        this.modifyDate = modifyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_authentication.is_deleted
     *
     * @return the value of second_authentication.is_deleted
     *
     * @mbg.generated Sat Sep 12 11:56:23 CST 2020
     */
    public Byte getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_authentication.is_deleted
     *
     * @param isDeleted the value for second_authentication.is_deleted
     *
     * @mbg.generated Sat Sep 12 11:56:23 CST 2020
     */
    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_authentication
     *
     * @mbg.generated Sat Sep 12 11:56:23 CST 2020
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", name=").append(name);
        sb.append(", sex=").append(sex);
        sb.append(", collegesName=").append(collegesName);
        sb.append(", entranceTime=").append(entranceTime);
        sb.append(", studentNumber=").append(studentNumber);
        sb.append(", storeId=").append(storeId);
        sb.append(", collegesId=").append(collegesId);
        sb.append(", collegesRecord=").append(collegesRecord);
        sb.append(", authenticationState=").append(authenticationState);
        sb.append(", createDate=").append(createDate);
        sb.append(", modifyDate=").append(modifyDate);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}