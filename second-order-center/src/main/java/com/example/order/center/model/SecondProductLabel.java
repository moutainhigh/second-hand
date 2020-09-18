package com.example.order.center.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SecondProductLabel implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_product_label.id
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_product_label.label_id
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    private Integer labelId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_product_label.product_id
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    private Integer productId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_product_label.create_time
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    private LocalDateTime createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_product_label.modify_time
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    private LocalDateTime modifyTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_product_label.is_deleted
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    private Short isDeleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table second_product_label
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_product_label.id
     *
     * @return the value of second_product_label.id
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_product_label.id
     *
     * @param id the value for second_product_label.id
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_product_label.label_id
     *
     * @return the value of second_product_label.label_id
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public Integer getLabelId() {
        return labelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_product_label.label_id
     *
     * @param labelId the value for second_product_label.label_id
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public void setLabelId(Integer labelId) {
        this.labelId = labelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_product_label.product_id
     *
     * @return the value of second_product_label.product_id
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_product_label.product_id
     *
     * @param productId the value for second_product_label.product_id
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_product_label.create_time
     *
     * @return the value of second_product_label.create_time
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_product_label.create_time
     *
     * @param createTime the value for second_product_label.create_time
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_product_label.modify_time
     *
     * @return the value of second_product_label.modify_time
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_product_label.modify_time
     *
     * @param modifyTime the value for second_product_label.modify_time
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_product_label.is_deleted
     *
     * @return the value of second_product_label.is_deleted
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public Short getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_product_label.is_deleted
     *
     * @param isDeleted the value for second_product_label.is_deleted
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public void setIsDeleted(Short isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product_label
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
        sb.append(", labelId=").append(labelId);
        sb.append(", productId=").append(productId);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}