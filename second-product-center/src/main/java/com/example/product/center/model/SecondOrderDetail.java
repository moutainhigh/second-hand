package com.example.product.center.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SecondOrderDetail implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order_detail.id
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order_detail.order_id
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    private Integer orderId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order_detail.detail_status
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    private String detailStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order_detail.goods_id
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    private Integer goodsId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order_detail.hf_tax
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    private Integer hfTax;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order_detail.sell_price
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    private Integer sellPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order_detail.actual_price
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    private Integer actualPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order_detail.quantity
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    private Integer quantity;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order_detail.taking_type
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    private String takingType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order_detail.freight
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    private Integer freight;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order_detail.detail_desc
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    private String detailDesc;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order_detail.create_time
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    private LocalDateTime createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order_detail.modify_time
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    private LocalDateTime modifyTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_order_detail.is_deleted
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    private Byte isDeleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table second_order_detail
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order_detail.id
     *
     * @return the value of second_order_detail.id
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order_detail.id
     *
     * @param id the value for second_order_detail.id
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order_detail.order_id
     *
     * @return the value of second_order_detail.order_id
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order_detail.order_id
     *
     * @param orderId the value for second_order_detail.order_id
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order_detail.detail_status
     *
     * @return the value of second_order_detail.detail_status
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    public String getDetailStatus() {
        return detailStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order_detail.detail_status
     *
     * @param detailStatus the value for second_order_detail.detail_status
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    public void setDetailStatus(String detailStatus) {
        this.detailStatus = detailStatus == null ? null : detailStatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order_detail.goods_id
     *
     * @return the value of second_order_detail.goods_id
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    public Integer getGoodsId() {
        return goodsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order_detail.goods_id
     *
     * @param goodsId the value for second_order_detail.goods_id
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order_detail.hf_tax
     *
     * @return the value of second_order_detail.hf_tax
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    public Integer getHfTax() {
        return hfTax;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order_detail.hf_tax
     *
     * @param hfTax the value for second_order_detail.hf_tax
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    public void setHfTax(Integer hfTax) {
        this.hfTax = hfTax;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order_detail.sell_price
     *
     * @return the value of second_order_detail.sell_price
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    public Integer getSellPrice() {
        return sellPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order_detail.sell_price
     *
     * @param sellPrice the value for second_order_detail.sell_price
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    public void setSellPrice(Integer sellPrice) {
        this.sellPrice = sellPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order_detail.actual_price
     *
     * @return the value of second_order_detail.actual_price
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    public Integer getActualPrice() {
        return actualPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order_detail.actual_price
     *
     * @param actualPrice the value for second_order_detail.actual_price
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    public void setActualPrice(Integer actualPrice) {
        this.actualPrice = actualPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order_detail.quantity
     *
     * @return the value of second_order_detail.quantity
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order_detail.quantity
     *
     * @param quantity the value for second_order_detail.quantity
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order_detail.taking_type
     *
     * @return the value of second_order_detail.taking_type
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    public String getTakingType() {
        return takingType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order_detail.taking_type
     *
     * @param takingType the value for second_order_detail.taking_type
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    public void setTakingType(String takingType) {
        this.takingType = takingType == null ? null : takingType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order_detail.freight
     *
     * @return the value of second_order_detail.freight
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    public Integer getFreight() {
        return freight;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order_detail.freight
     *
     * @param freight the value for second_order_detail.freight
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    public void setFreight(Integer freight) {
        this.freight = freight;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order_detail.detail_desc
     *
     * @return the value of second_order_detail.detail_desc
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    public String getDetailDesc() {
        return detailDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order_detail.detail_desc
     *
     * @param detailDesc the value for second_order_detail.detail_desc
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    public void setDetailDesc(String detailDesc) {
        this.detailDesc = detailDesc == null ? null : detailDesc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order_detail.create_time
     *
     * @return the value of second_order_detail.create_time
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order_detail.create_time
     *
     * @param createTime the value for second_order_detail.create_time
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order_detail.modify_time
     *
     * @return the value of second_order_detail.modify_time
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order_detail.modify_time
     *
     * @param modifyTime the value for second_order_detail.modify_time
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_order_detail.is_deleted
     *
     * @return the value of second_order_detail.is_deleted
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    public Byte getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_order_detail.is_deleted
     *
     * @param isDeleted the value for second_order_detail.is_deleted
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_order_detail
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orderId=").append(orderId);
        sb.append(", detailStatus=").append(detailStatus);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", hfTax=").append(hfTax);
        sb.append(", sellPrice=").append(sellPrice);
        sb.append(", actualPrice=").append(actualPrice);
        sb.append(", quantity=").append(quantity);
        sb.append(", takingType=").append(takingType);
        sb.append(", freight=").append(freight);
        sb.append(", detailDesc=").append(detailDesc);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}