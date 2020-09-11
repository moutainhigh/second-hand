package com.example.payment.center.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SecondProductSpec implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_product_spec.id
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_product_spec.second_name
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    private String secondName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_product_spec.product_id
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    private Integer productId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_product_spec.spec_type
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    private String specType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_product_spec.spec_unit
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    private String specUnit;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_product_spec.spec_value
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    private String specValue;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_product_spec.create_time
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    private LocalDateTime createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_product_spec.modify_time
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    private LocalDateTime modifyTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_product_spec.is_deleted
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    private Short isDeleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table second_product_spec
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_product_spec.id
     *
     * @return the value of second_product_spec.id
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_product_spec.id
     *
     * @param id the value for second_product_spec.id
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_product_spec.second_name
     *
     * @return the value of second_product_spec.second_name
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public String getSecondName() {
        return secondName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_product_spec.second_name
     *
     * @param secondName the value for second_product_spec.second_name
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public void setSecondName(String secondName) {
        this.secondName = secondName == null ? null : secondName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_product_spec.product_id
     *
     * @return the value of second_product_spec.product_id
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_product_spec.product_id
     *
     * @param productId the value for second_product_spec.product_id
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_product_spec.spec_type
     *
     * @return the value of second_product_spec.spec_type
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public String getSpecType() {
        return specType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_product_spec.spec_type
     *
     * @param specType the value for second_product_spec.spec_type
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public void setSpecType(String specType) {
        this.specType = specType == null ? null : specType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_product_spec.spec_unit
     *
     * @return the value of second_product_spec.spec_unit
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public String getSpecUnit() {
        return specUnit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_product_spec.spec_unit
     *
     * @param specUnit the value for second_product_spec.spec_unit
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public void setSpecUnit(String specUnit) {
        this.specUnit = specUnit == null ? null : specUnit.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_product_spec.spec_value
     *
     * @return the value of second_product_spec.spec_value
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public String getSpecValue() {
        return specValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_product_spec.spec_value
     *
     * @param specValue the value for second_product_spec.spec_value
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public void setSpecValue(String specValue) {
        this.specValue = specValue == null ? null : specValue.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_product_spec.create_time
     *
     * @return the value of second_product_spec.create_time
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_product_spec.create_time
     *
     * @param createTime the value for second_product_spec.create_time
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_product_spec.modify_time
     *
     * @return the value of second_product_spec.modify_time
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_product_spec.modify_time
     *
     * @param modifyTime the value for second_product_spec.modify_time
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_product_spec.is_deleted
     *
     * @return the value of second_product_spec.is_deleted
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public Short getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_product_spec.is_deleted
     *
     * @param isDeleted the value for second_product_spec.is_deleted
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public void setIsDeleted(Short isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product_spec
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
        sb.append(", secondName=").append(secondName);
        sb.append(", productId=").append(productId);
        sb.append(", specType=").append(specType);
        sb.append(", specUnit=").append(specUnit);
        sb.append(", specValue=").append(specValue);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}