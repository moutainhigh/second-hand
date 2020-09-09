package com.example.payment.center.model;

import java.io.Serializable;

public class SecondColleges implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_colleges.id
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_colleges.city_id
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    private Integer cityId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_colleges.name
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_colleges.record
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    private String record;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_colleges.features
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    private String features;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_colleges.institute
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    private Boolean institute;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table second_colleges
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_colleges.id
     *
     * @return the value of second_colleges.id
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_colleges.id
     *
     * @param id the value for second_colleges.id
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_colleges.city_id
     *
     * @return the value of second_colleges.city_id
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public Integer getCityId() {
        return cityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_colleges.city_id
     *
     * @param cityId the value for second_colleges.city_id
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_colleges.name
     *
     * @return the value of second_colleges.name
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_colleges.name
     *
     * @param name the value for second_colleges.name
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_colleges.record
     *
     * @return the value of second_colleges.record
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public String getRecord() {
        return record;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_colleges.record
     *
     * @param record the value for second_colleges.record
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public void setRecord(String record) {
        this.record = record == null ? null : record.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_colleges.features
     *
     * @return the value of second_colleges.features
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public String getFeatures() {
        return features;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_colleges.features
     *
     * @param features the value for second_colleges.features
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public void setFeatures(String features) {
        this.features = features == null ? null : features.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_colleges.institute
     *
     * @return the value of second_colleges.institute
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public Boolean getInstitute() {
        return institute;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_colleges.institute
     *
     * @param institute the value for second_colleges.institute
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public void setInstitute(Boolean institute) {
        this.institute = institute;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_colleges
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
        sb.append(", cityId=").append(cityId);
        sb.append(", name=").append(name);
        sb.append(", record=").append(record);
        sb.append(", features=").append(features);
        sb.append(", institute=").append(institute);
        sb.append("]");
        return sb.toString();
    }
}