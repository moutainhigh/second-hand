package com.example.user.center.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SecondGoodsSpec implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_goods_spec.id
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_goods_spec.goods_id
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    private Integer goodsId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_goods_spec.product_spec_id
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    private Integer productSpecId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_goods_spec.spec_value
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    private String specValue;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_goods_spec.create_time
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    private LocalDateTime createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_goods_spec.modify_time
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    private LocalDateTime modifyTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_goods_spec.is_deleted
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    private Short isDeleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table second_goods_spec
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_goods_spec.id
     *
     * @return the value of second_goods_spec.id
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_goods_spec.id
     *
     * @param id the value for second_goods_spec.id
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_goods_spec.goods_id
     *
     * @return the value of second_goods_spec.goods_id
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    public Integer getGoodsId() {
        return goodsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_goods_spec.goods_id
     *
     * @param goodsId the value for second_goods_spec.goods_id
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_goods_spec.product_spec_id
     *
     * @return the value of second_goods_spec.product_spec_id
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    public Integer getProductSpecId() {
        return productSpecId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_goods_spec.product_spec_id
     *
     * @param productSpecId the value for second_goods_spec.product_spec_id
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    public void setProductSpecId(Integer productSpecId) {
        this.productSpecId = productSpecId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_goods_spec.spec_value
     *
     * @return the value of second_goods_spec.spec_value
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    public String getSpecValue() {
        return specValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_goods_spec.spec_value
     *
     * @param specValue the value for second_goods_spec.spec_value
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    public void setSpecValue(String specValue) {
        this.specValue = specValue == null ? null : specValue.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_goods_spec.create_time
     *
     * @return the value of second_goods_spec.create_time
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_goods_spec.create_time
     *
     * @param createTime the value for second_goods_spec.create_time
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_goods_spec.modify_time
     *
     * @return the value of second_goods_spec.modify_time
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_goods_spec.modify_time
     *
     * @param modifyTime the value for second_goods_spec.modify_time
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_goods_spec.is_deleted
     *
     * @return the value of second_goods_spec.is_deleted
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    public Short getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_goods_spec.is_deleted
     *
     * @param isDeleted the value for second_goods_spec.is_deleted
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    public void setIsDeleted(Short isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_goods_spec
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", productSpecId=").append(productSpecId);
        sb.append(", specValue=").append(specValue);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}