package com.example.order.center.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SecondStoreAddress implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_store_address.id
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_store_address.store_id
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    private Integer storeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_store_address.is_fault_address
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    private Integer isFaultAddress;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_store_address.second_province
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    private String secondProvince;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_store_address.second_city
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    private String secondCity;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_store_address.second_conty
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    private String secondConty;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_store_address.second_address_detail
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    private String secondAddressDetail;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_store_address.longitude
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    private String longitude;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_store_address.latitude
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    private String latitude;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_store_address.contact
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    private String contact;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_store_address.phone_number
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    private String phoneNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_store_address.second_desc
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    private String secondDesc;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_store_address.create_time
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    private LocalDateTime createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_store_address.modify_time
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    private LocalDateTime modifyTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_store_address.is_deleted
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    private Short isDeleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table second_store_address
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_store_address.id
     *
     * @return the value of second_store_address.id
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_store_address.id
     *
     * @param id the value for second_store_address.id
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_store_address.store_id
     *
     * @return the value of second_store_address.store_id
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public Integer getStoreId() {
        return storeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_store_address.store_id
     *
     * @param storeId the value for second_store_address.store_id
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_store_address.is_fault_address
     *
     * @return the value of second_store_address.is_fault_address
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public Integer getIsFaultAddress() {
        return isFaultAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_store_address.is_fault_address
     *
     * @param isFaultAddress the value for second_store_address.is_fault_address
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public void setIsFaultAddress(Integer isFaultAddress) {
        this.isFaultAddress = isFaultAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_store_address.second_province
     *
     * @return the value of second_store_address.second_province
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public String getSecondProvince() {
        return secondProvince;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_store_address.second_province
     *
     * @param secondProvince the value for second_store_address.second_province
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public void setSecondProvince(String secondProvince) {
        this.secondProvince = secondProvince == null ? null : secondProvince.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_store_address.second_city
     *
     * @return the value of second_store_address.second_city
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public String getSecondCity() {
        return secondCity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_store_address.second_city
     *
     * @param secondCity the value for second_store_address.second_city
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public void setSecondCity(String secondCity) {
        this.secondCity = secondCity == null ? null : secondCity.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_store_address.second_conty
     *
     * @return the value of second_store_address.second_conty
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public String getSecondConty() {
        return secondConty;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_store_address.second_conty
     *
     * @param secondConty the value for second_store_address.second_conty
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public void setSecondConty(String secondConty) {
        this.secondConty = secondConty == null ? null : secondConty.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_store_address.second_address_detail
     *
     * @return the value of second_store_address.second_address_detail
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public String getSecondAddressDetail() {
        return secondAddressDetail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_store_address.second_address_detail
     *
     * @param secondAddressDetail the value for second_store_address.second_address_detail
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public void setSecondAddressDetail(String secondAddressDetail) {
        this.secondAddressDetail = secondAddressDetail == null ? null : secondAddressDetail.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_store_address.longitude
     *
     * @return the value of second_store_address.longitude
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_store_address.longitude
     *
     * @param longitude the value for second_store_address.longitude
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_store_address.latitude
     *
     * @return the value of second_store_address.latitude
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_store_address.latitude
     *
     * @param latitude the value for second_store_address.latitude
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_store_address.contact
     *
     * @return the value of second_store_address.contact
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public String getContact() {
        return contact;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_store_address.contact
     *
     * @param contact the value for second_store_address.contact
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_store_address.phone_number
     *
     * @return the value of second_store_address.phone_number
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_store_address.phone_number
     *
     * @param phoneNumber the value for second_store_address.phone_number
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_store_address.second_desc
     *
     * @return the value of second_store_address.second_desc
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public String getSecondDesc() {
        return secondDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_store_address.second_desc
     *
     * @param secondDesc the value for second_store_address.second_desc
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public void setSecondDesc(String secondDesc) {
        this.secondDesc = secondDesc == null ? null : secondDesc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_store_address.create_time
     *
     * @return the value of second_store_address.create_time
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_store_address.create_time
     *
     * @param createTime the value for second_store_address.create_time
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_store_address.modify_time
     *
     * @return the value of second_store_address.modify_time
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_store_address.modify_time
     *
     * @param modifyTime the value for second_store_address.modify_time
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_store_address.is_deleted
     *
     * @return the value of second_store_address.is_deleted
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public Short getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_store_address.is_deleted
     *
     * @param isDeleted the value for second_store_address.is_deleted
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public void setIsDeleted(Short isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store_address
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", storeId=").append(storeId);
        sb.append(", isFaultAddress=").append(isFaultAddress);
        sb.append(", secondProvince=").append(secondProvince);
        sb.append(", secondCity=").append(secondCity);
        sb.append(", secondConty=").append(secondConty);
        sb.append(", secondAddressDetail=").append(secondAddressDetail);
        sb.append(", longitude=").append(longitude);
        sb.append(", latitude=").append(latitude);
        sb.append(", contact=").append(contact);
        sb.append(", phoneNumber=").append(phoneNumber);
        sb.append(", secondDesc=").append(secondDesc);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}