package com.example.payment.center.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SecondIntegral implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_integral.id
     *
     * @mbg.generated Fri Sep 11 14:22:58 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_integral.integral_name
     *
     * @mbg.generated Fri Sep 11 14:22:58 CST 2020
     */
    private String integralName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_integral.integral_type
     *
     * @mbg.generated Fri Sep 11 14:22:58 CST 2020
     */
    private String integralType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_integral.integral_desc
     *
     * @mbg.generated Fri Sep 11 14:22:58 CST 2020
     */
    private String integralDesc;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_integral.integral_need
     *
     * @mbg.generated Fri Sep 11 14:22:58 CST 2020
     */
    private Integer integralNeed;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_integral.start_time
     *
     * @mbg.generated Fri Sep 11 14:22:58 CST 2020
     */
    private LocalDateTime startTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_integral.end_time
     *
     * @mbg.generated Fri Sep 11 14:22:58 CST 2020
     */
    private LocalDateTime endTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_integral.create_date
     *
     * @mbg.generated Fri Sep 11 14:22:58 CST 2020
     */
    private LocalDateTime createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_integral.modify_date
     *
     * @mbg.generated Fri Sep 11 14:22:58 CST 2020
     */
    private LocalDateTime modifyDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_integral.is_deleted
     *
     * @mbg.generated Fri Sep 11 14:22:58 CST 2020
     */
    private Byte isDeleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table second_integral
     *
     * @mbg.generated Fri Sep 11 14:22:58 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_integral.id
     *
     * @return the value of second_integral.id
     *
     * @mbg.generated Fri Sep 11 14:22:58 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_integral.id
     *
     * @param id the value for second_integral.id
     *
     * @mbg.generated Fri Sep 11 14:22:58 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_integral.integral_name
     *
     * @return the value of second_integral.integral_name
     *
     * @mbg.generated Fri Sep 11 14:22:58 CST 2020
     */
    public String getIntegralName() {
        return integralName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_integral.integral_name
     *
     * @param integralName the value for second_integral.integral_name
     *
     * @mbg.generated Fri Sep 11 14:22:58 CST 2020
     */
    public void setIntegralName(String integralName) {
        this.integralName = integralName == null ? null : integralName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_integral.integral_type
     *
     * @return the value of second_integral.integral_type
     *
     * @mbg.generated Fri Sep 11 14:22:58 CST 2020
     */
    public String getIntegralType() {
        return integralType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_integral.integral_type
     *
     * @param integralType the value for second_integral.integral_type
     *
     * @mbg.generated Fri Sep 11 14:22:58 CST 2020
     */
    public void setIntegralType(String integralType) {
        this.integralType = integralType == null ? null : integralType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_integral.integral_desc
     *
     * @return the value of second_integral.integral_desc
     *
     * @mbg.generated Fri Sep 11 14:22:58 CST 2020
     */
    public String getIntegralDesc() {
        return integralDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_integral.integral_desc
     *
     * @param integralDesc the value for second_integral.integral_desc
     *
     * @mbg.generated Fri Sep 11 14:22:58 CST 2020
     */
    public void setIntegralDesc(String integralDesc) {
        this.integralDesc = integralDesc == null ? null : integralDesc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_integral.integral_need
     *
     * @return the value of second_integral.integral_need
     *
     * @mbg.generated Fri Sep 11 14:22:58 CST 2020
     */
    public Integer getIntegralNeed() {
        return integralNeed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_integral.integral_need
     *
     * @param integralNeed the value for second_integral.integral_need
     *
     * @mbg.generated Fri Sep 11 14:22:58 CST 2020
     */
    public void setIntegralNeed(Integer integralNeed) {
        this.integralNeed = integralNeed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_integral.start_time
     *
     * @return the value of second_integral.start_time
     *
     * @mbg.generated Fri Sep 11 14:22:58 CST 2020
     */
    public LocalDateTime getStartTime() {
        return startTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_integral.start_time
     *
     * @param startTime the value for second_integral.start_time
     *
     * @mbg.generated Fri Sep 11 14:22:58 CST 2020
     */
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_integral.end_time
     *
     * @return the value of second_integral.end_time
     *
     * @mbg.generated Fri Sep 11 14:22:58 CST 2020
     */
    public LocalDateTime getEndTime() {
        return endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_integral.end_time
     *
     * @param endTime the value for second_integral.end_time
     *
     * @mbg.generated Fri Sep 11 14:22:58 CST 2020
     */
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_integral.create_date
     *
     * @return the value of second_integral.create_date
     *
     * @mbg.generated Fri Sep 11 14:22:58 CST 2020
     */
    public LocalDateTime getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_integral.create_date
     *
     * @param createDate the value for second_integral.create_date
     *
     * @mbg.generated Fri Sep 11 14:22:58 CST 2020
     */
    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_integral.modify_date
     *
     * @return the value of second_integral.modify_date
     *
     * @mbg.generated Fri Sep 11 14:22:58 CST 2020
     */
    public LocalDateTime getModifyDate() {
        return modifyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_integral.modify_date
     *
     * @param modifyDate the value for second_integral.modify_date
     *
     * @mbg.generated Fri Sep 11 14:22:58 CST 2020
     */
    public void setModifyDate(LocalDateTime modifyDate) {
        this.modifyDate = modifyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_integral.is_deleted
     *
     * @return the value of second_integral.is_deleted
     *
     * @mbg.generated Fri Sep 11 14:22:58 CST 2020
     */
    public Byte getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_integral.is_deleted
     *
     * @param isDeleted the value for second_integral.is_deleted
     *
     * @mbg.generated Fri Sep 11 14:22:58 CST 2020
     */
    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_integral
     *
     * @mbg.generated Fri Sep 11 14:22:58 CST 2020
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", integralName=").append(integralName);
        sb.append(", integralType=").append(integralType);
        sb.append(", integralDesc=").append(integralDesc);
        sb.append(", integralNeed=").append(integralNeed);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", createDate=").append(createDate);
        sb.append(", modifyDate=").append(modifyDate);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}