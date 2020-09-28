package com.example.user.center.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SecondUser implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_user.id
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_user.username
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_user.phone
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    private String phone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_user.email
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    private String email;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_user.nick_name
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    private String nickName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_user.real_name
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    private String realName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_user.sex
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    private Byte sex;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_user.birth_day
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    private LocalDateTime birthDay;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_user.user_status
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    private Byte userStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_user.file
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    private String file;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_user.address
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    private String address;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_user.user_level
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    private Byte userLevel;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_user.last_auth_time
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    private LocalDateTime lastAuthTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_user.region
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    private String region;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_user.user_type
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    private String userType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_user.is_authentication
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    private Integer isAuthentication;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_user.create_date
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    private LocalDateTime createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_user.modify_date
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    private LocalDateTime modifyDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_user.id_deleted
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    private Byte idDeleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table second_user
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_user.id
     *
     * @return the value of second_user.id
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_user.id
     *
     * @param id the value for second_user.id
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_user.username
     *
     * @return the value of second_user.username
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_user.username
     *
     * @param username the value for second_user.username
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_user.phone
     *
     * @return the value of second_user.phone
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_user.phone
     *
     * @param phone the value for second_user.phone
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_user.email
     *
     * @return the value of second_user.email
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_user.email
     *
     * @param email the value for second_user.email
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_user.nick_name
     *
     * @return the value of second_user.nick_name
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_user.nick_name
     *
     * @param nickName the value for second_user.nick_name
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_user.real_name
     *
     * @return the value of second_user.real_name
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public String getRealName() {
        return realName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_user.real_name
     *
     * @param realName the value for second_user.real_name
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_user.sex
     *
     * @return the value of second_user.sex
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public Byte getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_user.sex
     *
     * @param sex the value for second_user.sex
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public void setSex(Byte sex) {
        this.sex = sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_user.birth_day
     *
     * @return the value of second_user.birth_day
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public LocalDateTime getBirthDay() {
        return birthDay;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_user.birth_day
     *
     * @param birthDay the value for second_user.birth_day
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public void setBirthDay(LocalDateTime birthDay) {
        this.birthDay = birthDay;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_user.user_status
     *
     * @return the value of second_user.user_status
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public Byte getUserStatus() {
        return userStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_user.user_status
     *
     * @param userStatus the value for second_user.user_status
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public void setUserStatus(Byte userStatus) {
        this.userStatus = userStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_user.file
     *
     * @return the value of second_user.file
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public String getFile() {
        return file;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_user.file
     *
     * @param file the value for second_user.file
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public void setFile(String file) {
        this.file = file == null ? null : file.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_user.address
     *
     * @return the value of second_user.address
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_user.address
     *
     * @param address the value for second_user.address
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_user.user_level
     *
     * @return the value of second_user.user_level
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public Byte getUserLevel() {
        return userLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_user.user_level
     *
     * @param userLevel the value for second_user.user_level
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public void setUserLevel(Byte userLevel) {
        this.userLevel = userLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_user.last_auth_time
     *
     * @return the value of second_user.last_auth_time
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public LocalDateTime getLastAuthTime() {
        return lastAuthTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_user.last_auth_time
     *
     * @param lastAuthTime the value for second_user.last_auth_time
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public void setLastAuthTime(LocalDateTime lastAuthTime) {
        this.lastAuthTime = lastAuthTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_user.region
     *
     * @return the value of second_user.region
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public String getRegion() {
        return region;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_user.region
     *
     * @param region the value for second_user.region
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_user.user_type
     *
     * @return the value of second_user.user_type
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public String getUserType() {
        return userType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_user.user_type
     *
     * @param userType the value for second_user.user_type
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_user.is_authentication
     *
     * @return the value of second_user.is_authentication
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public Integer getIsAuthentication() {
        return isAuthentication;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_user.is_authentication
     *
     * @param isAuthentication the value for second_user.is_authentication
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public void setIsAuthentication(Integer isAuthentication) {
        this.isAuthentication = isAuthentication;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_user.create_date
     *
     * @return the value of second_user.create_date
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public LocalDateTime getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_user.create_date
     *
     * @param createDate the value for second_user.create_date
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_user.modify_date
     *
     * @return the value of second_user.modify_date
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public LocalDateTime getModifyDate() {
        return modifyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_user.modify_date
     *
     * @param modifyDate the value for second_user.modify_date
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public void setModifyDate(LocalDateTime modifyDate) {
        this.modifyDate = modifyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_user.id_deleted
     *
     * @return the value of second_user.id_deleted
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public Byte getIdDeleted() {
        return idDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_user.id_deleted
     *
     * @param idDeleted the value for second_user.id_deleted
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    public void setIdDeleted(Byte idDeleted) {
        this.idDeleted = idDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_user
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
        sb.append(", username=").append(username);
        sb.append(", phone=").append(phone);
        sb.append(", email=").append(email);
        sb.append(", nickName=").append(nickName);
        sb.append(", realName=").append(realName);
        sb.append(", sex=").append(sex);
        sb.append(", birthDay=").append(birthDay);
        sb.append(", userStatus=").append(userStatus);
        sb.append(", file=").append(file);
        sb.append(", address=").append(address);
        sb.append(", userLevel=").append(userLevel);
        sb.append(", lastAuthTime=").append(lastAuthTime);
        sb.append(", region=").append(region);
        sb.append(", userType=").append(userType);
        sb.append(", isAuthentication=").append(isAuthentication);
        sb.append(", createDate=").append(createDate);
        sb.append(", modifyDate=").append(modifyDate);
        sb.append(", idDeleted=").append(idDeleted);
        sb.append("]");
        return sb.toString();
    }
}