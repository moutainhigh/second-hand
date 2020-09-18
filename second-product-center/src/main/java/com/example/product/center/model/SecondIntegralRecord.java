package com.example.product.center.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SecondIntegralRecord implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_integral_record.id
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_integral_record.user_id
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_integral_record.store_id
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    private Integer storeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_integral_record.integral_id
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    private Integer integralId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_integral_record.integral_type
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    private String integralType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_integral_record.integral_state
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    private String integralState;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_integral_record.create_date
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    private LocalDateTime createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_integral_record.modify_date
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    private LocalDateTime modifyDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_integral_record.is_deleted
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    private Byte isDeleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table second_integral_record
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_integral_record.id
     *
     * @return the value of second_integral_record.id
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_integral_record.id
     *
     * @param id the value for second_integral_record.id
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_integral_record.user_id
     *
     * @return the value of second_integral_record.user_id
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_integral_record.user_id
     *
     * @param userId the value for second_integral_record.user_id
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_integral_record.store_id
     *
     * @return the value of second_integral_record.store_id
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    public Integer getStoreId() {
        return storeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_integral_record.store_id
     *
     * @param storeId the value for second_integral_record.store_id
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_integral_record.integral_id
     *
     * @return the value of second_integral_record.integral_id
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    public Integer getIntegralId() {
        return integralId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_integral_record.integral_id
     *
     * @param integralId the value for second_integral_record.integral_id
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    public void setIntegralId(Integer integralId) {
        this.integralId = integralId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_integral_record.integral_type
     *
     * @return the value of second_integral_record.integral_type
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    public String getIntegralType() {
        return integralType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_integral_record.integral_type
     *
     * @param integralType the value for second_integral_record.integral_type
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    public void setIntegralType(String integralType) {
        this.integralType = integralType == null ? null : integralType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_integral_record.integral_state
     *
     * @return the value of second_integral_record.integral_state
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    public String getIntegralState() {
        return integralState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_integral_record.integral_state
     *
     * @param integralState the value for second_integral_record.integral_state
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    public void setIntegralState(String integralState) {
        this.integralState = integralState == null ? null : integralState.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_integral_record.create_date
     *
     * @return the value of second_integral_record.create_date
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    public LocalDateTime getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_integral_record.create_date
     *
     * @param createDate the value for second_integral_record.create_date
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_integral_record.modify_date
     *
     * @return the value of second_integral_record.modify_date
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    public LocalDateTime getModifyDate() {
        return modifyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_integral_record.modify_date
     *
     * @param modifyDate the value for second_integral_record.modify_date
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    public void setModifyDate(LocalDateTime modifyDate) {
        this.modifyDate = modifyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_integral_record.is_deleted
     *
     * @return the value of second_integral_record.is_deleted
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    public Byte getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_integral_record.is_deleted
     *
     * @param isDeleted the value for second_integral_record.is_deleted
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_integral_record
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
        sb.append(", userId=").append(userId);
        sb.append(", storeId=").append(storeId);
        sb.append(", integralId=").append(integralId);
        sb.append(", integralType=").append(integralType);
        sb.append(", integralState=").append(integralState);
        sb.append(", createDate=").append(createDate);
        sb.append(", modifyDate=").append(modifyDate);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}