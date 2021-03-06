package com.example.order.center.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SecondProductPictrue implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_product_pictrue.id
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_product_pictrue.product_id
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    private Integer productId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_product_pictrue.file
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    private String file;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_product_pictrue.second_desc
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    private String secondDesc;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_product_pictrue.create_time
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    private LocalDateTime createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_product_pictrue.modify_time
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    private LocalDateTime modifyTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_product_pictrue.is_deleted
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    private Short isDeleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table second_product_pictrue
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_product_pictrue.id
     *
     * @return the value of second_product_pictrue.id
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_product_pictrue.id
     *
     * @param id the value for second_product_pictrue.id
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_product_pictrue.product_id
     *
     * @return the value of second_product_pictrue.product_id
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_product_pictrue.product_id
     *
     * @param productId the value for second_product_pictrue.product_id
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_product_pictrue.file
     *
     * @return the value of second_product_pictrue.file
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public String getFile() {
        return file;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_product_pictrue.file
     *
     * @param file the value for second_product_pictrue.file
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public void setFile(String file) {
        this.file = file == null ? null : file.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_product_pictrue.second_desc
     *
     * @return the value of second_product_pictrue.second_desc
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public String getSecondDesc() {
        return secondDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_product_pictrue.second_desc
     *
     * @param secondDesc the value for second_product_pictrue.second_desc
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public void setSecondDesc(String secondDesc) {
        this.secondDesc = secondDesc == null ? null : secondDesc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_product_pictrue.create_time
     *
     * @return the value of second_product_pictrue.create_time
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_product_pictrue.create_time
     *
     * @param createTime the value for second_product_pictrue.create_time
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_product_pictrue.modify_time
     *
     * @return the value of second_product_pictrue.modify_time
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_product_pictrue.modify_time
     *
     * @param modifyTime the value for second_product_pictrue.modify_time
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_product_pictrue.is_deleted
     *
     * @return the value of second_product_pictrue.is_deleted
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public Short getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_product_pictrue.is_deleted
     *
     * @param isDeleted the value for second_product_pictrue.is_deleted
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    public void setIsDeleted(Short isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product_pictrue
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
        sb.append(", productId=").append(productId);
        sb.append(", file=").append(file);
        sb.append(", secondDesc=").append(secondDesc);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}