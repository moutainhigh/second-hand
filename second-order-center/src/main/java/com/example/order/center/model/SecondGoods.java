package com.example.order.center.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SecondGoods implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_goods.id
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_goods.goods_name
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    private String goodsName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_goods.product_id
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    private Integer productId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_goods.goods_desc
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    private String goodsDesc;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_goods.sell_price
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    private Integer sellPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_goods.line_price
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    private Integer linePrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_goods.goods_resp
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    private Integer goodsResp;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_goods.integral
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    private Integer integral;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_goods.create_time
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    private LocalDateTime createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_goods.modify_time
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    private LocalDateTime modifyTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_goods.is_deleted
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    private Short isDeleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table second_goods
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_goods.id
     *
     * @return the value of second_goods.id
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_goods.id
     *
     * @param id the value for second_goods.id
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_goods.goods_name
     *
     * @return the value of second_goods.goods_name
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_goods.goods_name
     *
     * @param goodsName the value for second_goods.goods_name
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_goods.product_id
     *
     * @return the value of second_goods.product_id
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_goods.product_id
     *
     * @param productId the value for second_goods.product_id
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_goods.goods_desc
     *
     * @return the value of second_goods.goods_desc
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public String getGoodsDesc() {
        return goodsDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_goods.goods_desc
     *
     * @param goodsDesc the value for second_goods.goods_desc
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc == null ? null : goodsDesc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_goods.sell_price
     *
     * @return the value of second_goods.sell_price
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public Integer getSellPrice() {
        return sellPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_goods.sell_price
     *
     * @param sellPrice the value for second_goods.sell_price
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public void setSellPrice(Integer sellPrice) {
        this.sellPrice = sellPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_goods.line_price
     *
     * @return the value of second_goods.line_price
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public Integer getLinePrice() {
        return linePrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_goods.line_price
     *
     * @param linePrice the value for second_goods.line_price
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public void setLinePrice(Integer linePrice) {
        this.linePrice = linePrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_goods.goods_resp
     *
     * @return the value of second_goods.goods_resp
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public Integer getGoodsResp() {
        return goodsResp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_goods.goods_resp
     *
     * @param goodsResp the value for second_goods.goods_resp
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public void setGoodsResp(Integer goodsResp) {
        this.goodsResp = goodsResp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_goods.integral
     *
     * @return the value of second_goods.integral
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public Integer getIntegral() {
        return integral;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_goods.integral
     *
     * @param integral the value for second_goods.integral
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_goods.create_time
     *
     * @return the value of second_goods.create_time
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_goods.create_time
     *
     * @param createTime the value for second_goods.create_time
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_goods.modify_time
     *
     * @return the value of second_goods.modify_time
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_goods.modify_time
     *
     * @param modifyTime the value for second_goods.modify_time
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_goods.is_deleted
     *
     * @return the value of second_goods.is_deleted
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public Short getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_goods.is_deleted
     *
     * @param isDeleted the value for second_goods.is_deleted
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    public void setIsDeleted(Short isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_goods
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
        sb.append(", goodsName=").append(goodsName);
        sb.append(", productId=").append(productId);
        sb.append(", goodsDesc=").append(goodsDesc);
        sb.append(", sellPrice=").append(sellPrice);
        sb.append(", linePrice=").append(linePrice);
        sb.append(", goodsResp=").append(goodsResp);
        sb.append(", integral=").append(integral);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}