package com.example.order.center.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SecondAuth implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_auth.id
     *
     * @mbg.generated Fri Sep 11 16:22:39 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_auth.user_id
     *
     * @mbg.generated Fri Sep 11 16:22:39 CST 2020
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_auth.auth_type
     *
     * @mbg.generated Fri Sep 11 16:22:39 CST 2020
     */
    private String authType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_auth.auth_key
     *
     * @mbg.generated Fri Sep 11 16:22:39 CST 2020
     */
    private String authKey;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_auth.login_type
     *
     * @mbg.generated Fri Sep 11 16:22:39 CST 2020
     */
    private String loginType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_auth.encode_type
     *
     * @mbg.generated Fri Sep 11 16:22:39 CST 2020
     */
    private String encodeType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_auth.auth_status
     *
     * @mbg.generated Fri Sep 11 16:22:39 CST 2020
     */
    private Byte authStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_auth.username
     *
     * @mbg.generated Fri Sep 11 16:22:39 CST 2020
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_auth.password
     *
     * @mbg.generated Fri Sep 11 16:22:39 CST 2020
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_auth.store_id
     *
     * @mbg.generated Fri Sep 11 16:22:39 CST 2020
     */
    private Integer storeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_auth.create_date
     *
     * @mbg.generated Fri Sep 11 16:22:39 CST 2020
     */
    private LocalDateTime createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_auth.modify_date
     *
     * @mbg.generated Fri Sep 11 16:22:39 CST 2020
     */
    private LocalDateTime modifyDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_auth.is_deleted
     *
     * @mbg.generated Fri Sep 11 16:22:39 CST 2020
     */
    private Byte isDeleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table second_auth
     *
     * @mbg.generated Fri Sep 11 16:22:39 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_auth.id
     *
     * @return the value of second_auth.id
     *
     * @mbg.generated Fri Sep 11 16:22:39 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_auth.id
     *
     * @param id the value for second_auth.id
     *
     * @mbg.generated Fri Sep 11 16:22:39 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_auth.user_id
     *
     * @return the value of second_auth.user_id
     *
     * @mbg.generated Fri Sep 11 16:22:39 CST 2020
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_auth.user_id
     *
     * @param userId the value for second_auth.user_id
     *
     * @mbg.generated Fri Sep 11 16:22:39 CST 2020
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_auth.auth_type
     *
     * @return the value of second_auth.auth_type
     *
     * @mbg.generated Fri Sep 11 16:22:39 CST 2020
     */
    public String getAuthType() {
        return authType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_auth.auth_type
     *
     * @param authType the value for second_auth.auth_type
     *
     * @mbg.generated Fri Sep 11 16:22:39 CST 2020
     */
    public void setAuthType(String authType) {
        this.authType = authType == null ? null : authType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_auth.auth_key
     *
     * @return the value of second_auth.auth_key
     *
     * @mbg.generated Fri Sep 11 16:22:39 CST 2020
     */
    public String getAuthKey() {
        return authKey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_auth.auth_key
     *
     * @param authKey the value for second_auth.auth_key
     *
     * @mbg.generated Fri Sep 11 16:22:39 CST 2020
     */
    public void setAuthKey(String authKey) {
        this.authKey = authKey == null ? null : authKey.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_auth.login_type
     *
     * @return the value of second_auth.login_type
     *
     * @mbg.generated Fri Sep 11 16:22:39 CST 2020
     */
    public String getLoginType() {
        return loginType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_auth.login_type
     *
     * @param loginType the value for second_auth.login_type
     *
     * @mbg.generated Fri Sep 11 16:22:39 CST 2020
     */
    public void setLoginType(String loginType) {
        this.loginType = loginType == null ? null : loginType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_auth.encode_type
     *
     * @return the value of second_auth.encode_type
     *
     * @mbg.generated Fri Sep 11 16:22:39 CST 2020
     */
    public String getEncodeType() {
        return encodeType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_auth.encode_type
     *
     * @param encodeType the value for second_auth.encode_type
     *
     * @mbg.generated Fri Sep 11 16:22:39 CST 2020
     */
    public void setEncodeType(String encodeType) {
        this.encodeType = encodeType == null ? null : encodeType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_auth.auth_status
     *
     * @return the value of second_auth.auth_status
     *
     * @mbg.generated Fri Sep 11 16:22:39 CST 2020
     */
    public Byte getAuthStatus() {
        return authStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_auth.auth_status
     *
     * @param authStatus the value for second_auth.auth_status
     *
     * @mbg.generated Fri Sep 11 16:22:39 CST 2020
     */
    public void setAuthStatus(Byte authStatus) {
        this.authStatus = authStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_auth.username
     *
     * @return the value of second_auth.username
     *
     * @mbg.generated Fri Sep 11 16:22:39 CST 2020
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_auth.username
     *
     * @param username the value for second_auth.username
     *
     * @mbg.generated Fri Sep 11 16:22:39 CST 2020
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_auth.password
     *
     * @return the value of second_auth.password
     *
     * @mbg.generated Fri Sep 11 16:22:39 CST 2020
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_auth.password
     *
     * @param password the value for second_auth.password
     *
     * @mbg.generated Fri Sep 11 16:22:39 CST 2020
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_auth.store_id
     *
     * @return the value of second_auth.store_id
     *
     * @mbg.generated Fri Sep 11 16:22:39 CST 2020
     */
    public Integer getStoreId() {
        return storeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_auth.store_id
     *
     * @param storeId the value for second_auth.store_id
     *
     * @mbg.generated Fri Sep 11 16:22:39 CST 2020
     */
    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_auth.create_date
     *
     * @return the value of second_auth.create_date
     *
     * @mbg.generated Fri Sep 11 16:22:39 CST 2020
     */
    public LocalDateTime getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_auth.create_date
     *
     * @param createDate the value for second_auth.create_date
     *
     * @mbg.generated Fri Sep 11 16:22:39 CST 2020
     */
    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_auth.modify_date
     *
     * @return the value of second_auth.modify_date
     *
     * @mbg.generated Fri Sep 11 16:22:39 CST 2020
     */
    public LocalDateTime getModifyDate() {
        return modifyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_auth.modify_date
     *
     * @param modifyDate the value for second_auth.modify_date
     *
     * @mbg.generated Fri Sep 11 16:22:39 CST 2020
     */
    public void setModifyDate(LocalDateTime modifyDate) {
        this.modifyDate = modifyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_auth.is_deleted
     *
     * @return the value of second_auth.is_deleted
     *
     * @mbg.generated Fri Sep 11 16:22:39 CST 2020
     */
    public Byte getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_auth.is_deleted
     *
     * @param isDeleted the value for second_auth.is_deleted
     *
     * @mbg.generated Fri Sep 11 16:22:39 CST 2020
     */
    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_auth
     *
     * @mbg.generated Fri Sep 11 16:22:39 CST 2020
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", authType=").append(authType);
        sb.append(", authKey=").append(authKey);
        sb.append(", loginType=").append(loginType);
        sb.append(", encodeType=").append(encodeType);
        sb.append(", authStatus=").append(authStatus);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", storeId=").append(storeId);
        sb.append(", createDate=").append(createDate);
        sb.append(", modifyDate=").append(modifyDate);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}