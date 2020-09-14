package com.example.order.center.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SecondOrderAddress implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order_address.id
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order_address.order_id
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    private Integer orderId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order_address.second_province
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    private String secondProvince;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order_address.second_city
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    private String secondCity;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order_address.second_conty
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    private String secondConty;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order_address.second_address_detail
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    private String secondAddressDetail;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order_address.longitude
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    private String longitude;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order_address.latitude
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    private String latitude;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order_address.contact
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    private String contact;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order_address.phone
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    private String phone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order_address.second_desc
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    private String secondDesc;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order_address.create_time
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    private LocalDateTime createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order_address.modify_time
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    private LocalDateTime modifyTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order_address.is_deleted
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    private Short isDeleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table second_order_address
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order_address.id
     *
     * @return the value of second_order_address.id
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order_address.id
     *
     * @param id the value for second_order_address.id
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order_address.order_id
     *
     * @return the value of second_order_address.order_id
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order_address.order_id
     *
     * @param orderId the value for second_order_address.order_id
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order_address.second_province
     *
     * @return the value of second_order_address.second_province
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public String getSecondProvince() {
        return secondProvince;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order_address.second_province
     *
     * @param secondProvince the value for second_order_address.second_province
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public void setSecondProvince(String secondProvince) {
        this.secondProvince = secondProvince == null ? null : secondProvince.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order_address.second_city
     *
     * @return the value of second_order_address.second_city
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public String getSecondCity() {
        return secondCity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order_address.second_city
     *
     * @param secondCity the value for second_order_address.second_city
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public void setSecondCity(String secondCity) {
        this.secondCity = secondCity == null ? null : secondCity.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order_address.second_conty
     *
     * @return the value of second_order_address.second_conty
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public String getSecondConty() {
        return secondConty;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order_address.second_conty
     *
     * @param secondConty the value for second_order_address.second_conty
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public void setSecondConty(String secondConty) {
        this.secondConty = secondConty == null ? null : secondConty.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order_address.second_address_detail
     *
     * @return the value of second_order_address.second_address_detail
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public String getSecondAddressDetail() {
        return secondAddressDetail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order_address.second_address_detail
     *
     * @param secondAddressDetail the value for second_order_address.second_address_detail
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public void setSecondAddressDetail(String secondAddressDetail) {
        this.secondAddressDetail = secondAddressDetail == null ? null : secondAddressDetail.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order_address.longitude
     *
     * @return the value of second_order_address.longitude
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order_address.longitude
     *
     * @param longitude the value for second_order_address.longitude
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order_address.latitude
     *
     * @return the value of second_order_address.latitude
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order_address.latitude
     *
     * @param latitude the value for second_order_address.latitude
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order_address.contact
     *
     * @return the value of second_order_address.contact
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public String getContact() {
        return contact;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order_address.contact
     *
     * @param contact the value for second_order_address.contact
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order_address.phone
     *
     * @return the value of second_order_address.phone
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order_address.phone
     *
     * @param phone the value for second_order_address.phone
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order_address.second_desc
     *
     * @return the value of second_order_address.second_desc
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public String getSecondDesc() {
        return secondDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order_address.second_desc
     *
     * @param secondDesc the value for second_order_address.second_desc
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public void setSecondDesc(String secondDesc) {
        this.secondDesc = secondDesc == null ? null : secondDesc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order_address.create_time
     *
     * @return the value of second_order_address.create_time
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order_address.create_time
     *
     * @param createTime the value for second_order_address.create_time
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order_address.modify_time
     *
     * @return the value of second_order_address.modify_time
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order_address.modify_time
     *
     * @param modifyTime the value for second_order_address.modify_time
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order_address.is_deleted
     *
     * @return the value of second_order_address.is_deleted
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public Short getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order_address.is_deleted
     *
     * @param isDeleted the value for second_order_address.is_deleted
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public void setIsDeleted(Short isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_order_address
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
        sb.append(", orderId=").append(orderId);
        sb.append(", secondProvince=").append(secondProvince);
        sb.append(", secondCity=").append(secondCity);
        sb.append(", secondConty=").append(secondConty);
        sb.append(", secondAddressDetail=").append(secondAddressDetail);
        sb.append(", longitude=").append(longitude);
        sb.append(", latitude=").append(latitude);
        sb.append(", contact=").append(contact);
        sb.append(", phone=").append(phone);
        sb.append(", secondDesc=").append(secondDesc);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}