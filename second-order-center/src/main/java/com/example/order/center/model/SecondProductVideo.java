package com.example.order.center.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SecondProductVideo implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_product_video.id
     *
     * @mbg.generated Fri Dec 04 10:43:03 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_product_video.item_id
     *
     * @mbg.generated Fri Dec 04 10:43:03 CST 2020
     */
    private String itemId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_product_video.check_item_face_price
     *
     * @mbg.generated Fri Dec 04 10:43:03 CST 2020
     */
    private Long checkItemFacePrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_product_video.item_price
     *
     * @mbg.generated Fri Dec 04 10:43:03 CST 2020
     */
    private Long itemPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_product_video.quantity
     *
     * @mbg.generated Fri Dec 04 10:43:03 CST 2020
     */
    private Integer quantity;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_product_video.price
     *
     * @mbg.generated Fri Dec 04 10:43:03 CST 2020
     */
    private Integer price;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_product_video.line_price
     *
     * @mbg.generated Fri Dec 04 10:43:03 CST 2020
     */
    private Integer linePrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_product_video.product_name
     *
     * @mbg.generated Fri Dec 04 10:43:03 CST 2020
     */
    private String productName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_product_video.product_desc
     *
     * @mbg.generated Fri Dec 04 10:43:03 CST 2020
     */
    private String productDesc;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_product_video.file
     *
     * @mbg.generated Fri Dec 04 10:43:03 CST 2020
     */
    private String file;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_product_video.is_putaway
     *
     * @mbg.generated Fri Dec 04 10:43:03 CST 2020
     */
    private Integer isPutaway;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_product_video.product_state
     *
     * @mbg.generated Fri Dec 04 10:43:03 CST 2020
     */
    private String productState;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_product_video.category_id
     *
     * @mbg.generated Fri Dec 04 10:43:03 CST 2020
     */
    private Integer categoryId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_product_video.create_time
     *
     * @mbg.generated Fri Dec 04 10:43:03 CST 2020
     */
    private LocalDateTime createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_product_video.modify_time
     *
     * @mbg.generated Fri Dec 04 10:43:03 CST 2020
     */
    private LocalDateTime modifyTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_product_video.is_deleted
     *
     * @mbg.generated Fri Dec 04 10:43:03 CST 2020
     */
    private Short isDeleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table second_product_video
     *
     * @mbg.generated Fri Dec 04 10:43:03 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_product_video.id
     *
     * @return the value of second_product_video.id
     *
     * @mbg.generated Fri Dec 04 10:43:03 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_product_video.id
     *
     * @param id the value for second_product_video.id
     *
     * @mbg.generated Fri Dec 04 10:43:03 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_product_video.item_id
     *
     * @return the value of second_product_video.item_id
     *
     * @mbg.generated Fri Dec 04 10:43:03 CST 2020
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_product_video.item_id
     *
     * @param itemId the value for second_product_video.item_id
     *
     * @mbg.generated Fri Dec 04 10:43:03 CST 2020
     */
    public void setItemId(String itemId) {
        this.itemId = itemId == null ? null : itemId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_product_video.check_item_face_price
     *
     * @return the value of second_product_video.check_item_face_price
     *
     * @mbg.generated Fri Dec 04 10:43:03 CST 2020
     */
    public Long getCheckItemFacePrice() {
        return checkItemFacePrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_product_video.check_item_face_price
     *
     * @param checkItemFacePrice the value for second_product_video.check_item_face_price
     *
     * @mbg.generated Fri Dec 04 10:43:03 CST 2020
     */
    public void setCheckItemFacePrice(Long checkItemFacePrice) {
        this.checkItemFacePrice = checkItemFacePrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_product_video.item_price
     *
     * @return the value of second_product_video.item_price
     *
     * @mbg.generated Fri Dec 04 10:43:03 CST 2020
     */
    public Long getItemPrice() {
        return itemPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_product_video.item_price
     *
     * @param itemPrice the value for second_product_video.item_price
     *
     * @mbg.generated Fri Dec 04 10:43:03 CST 2020
     */
    public void setItemPrice(Long itemPrice) {
        this.itemPrice = itemPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_product_video.quantity
     *
     * @return the value of second_product_video.quantity
     *
     * @mbg.generated Fri Dec 04 10:43:03 CST 2020
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_product_video.quantity
     *
     * @param quantity the value for second_product_video.quantity
     *
     * @mbg.generated Fri Dec 04 10:43:03 CST 2020
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_product_video.price
     *
     * @return the value of second_product_video.price
     *
     * @mbg.generated Fri Dec 04 10:43:03 CST 2020
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_product_video.price
     *
     * @param price the value for second_product_video.price
     *
     * @mbg.generated Fri Dec 04 10:43:03 CST 2020
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_product_video.line_price
     *
     * @return the value of second_product_video.line_price
     *
     * @mbg.generated Fri Dec 04 10:43:03 CST 2020
     */
    public Integer getLinePrice() {
        return linePrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_product_video.line_price
     *
     * @param linePrice the value for second_product_video.line_price
     *
     * @mbg.generated Fri Dec 04 10:43:03 CST 2020
     */
    public void setLinePrice(Integer linePrice) {
        this.linePrice = linePrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_product_video.product_name
     *
     * @return the value of second_product_video.product_name
     *
     * @mbg.generated Fri Dec 04 10:43:03 CST 2020
     */
    public String getProductName() {
        return productName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_product_video.product_name
     *
     * @param productName the value for second_product_video.product_name
     *
     * @mbg.generated Fri Dec 04 10:43:03 CST 2020
     */
    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_product_video.product_desc
     *
     * @return the value of second_product_video.product_desc
     *
     * @mbg.generated Fri Dec 04 10:43:03 CST 2020
     */
    public String getProductDesc() {
        return productDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_product_video.product_desc
     *
     * @param productDesc the value for second_product_video.product_desc
     *
     * @mbg.generated Fri Dec 04 10:43:03 CST 2020
     */
    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc == null ? null : productDesc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_product_video.file
     *
     * @return the value of second_product_video.file
     *
     * @mbg.generated Fri Dec 04 10:43:03 CST 2020
     */
    public String getFile() {
        return file;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_product_video.file
     *
     * @param file the value for second_product_video.file
     *
     * @mbg.generated Fri Dec 04 10:43:03 CST 2020
     */
    public void setFile(String file) {
        this.file = file == null ? null : file.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_product_video.is_putaway
     *
     * @return the value of second_product_video.is_putaway
     *
     * @mbg.generated Fri Dec 04 10:43:03 CST 2020
     */
    public Integer getIsPutaway() {
        return isPutaway;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_product_video.is_putaway
     *
     * @param isPutaway the value for second_product_video.is_putaway
     *
     * @mbg.generated Fri Dec 04 10:43:03 CST 2020
     */
    public void setIsPutaway(Integer isPutaway) {
        this.isPutaway = isPutaway;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_product_video.product_state
     *
     * @return the value of second_product_video.product_state
     *
     * @mbg.generated Fri Dec 04 10:43:03 CST 2020
     */
    public String getProductState() {
        return productState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_product_video.product_state
     *
     * @param productState the value for second_product_video.product_state
     *
     * @mbg.generated Fri Dec 04 10:43:03 CST 2020
     */
    public void setProductState(String productState) {
        this.productState = productState == null ? null : productState.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_product_video.category_id
     *
     * @return the value of second_product_video.category_id
     *
     * @mbg.generated Fri Dec 04 10:43:03 CST 2020
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_product_video.category_id
     *
     * @param categoryId the value for second_product_video.category_id
     *
     * @mbg.generated Fri Dec 04 10:43:03 CST 2020
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_product_video.create_time
     *
     * @return the value of second_product_video.create_time
     *
     * @mbg.generated Fri Dec 04 10:43:03 CST 2020
     */
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_product_video.create_time
     *
     * @param createTime the value for second_product_video.create_time
     *
     * @mbg.generated Fri Dec 04 10:43:03 CST 2020
     */
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_product_video.modify_time
     *
     * @return the value of second_product_video.modify_time
     *
     * @mbg.generated Fri Dec 04 10:43:03 CST 2020
     */
    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_product_video.modify_time
     *
     * @param modifyTime the value for second_product_video.modify_time
     *
     * @mbg.generated Fri Dec 04 10:43:03 CST 2020
     */
    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_product_video.is_deleted
     *
     * @return the value of second_product_video.is_deleted
     *
     * @mbg.generated Fri Dec 04 10:43:03 CST 2020
     */
    public Short getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_product_video.is_deleted
     *
     * @param isDeleted the value for second_product_video.is_deleted
     *
     * @mbg.generated Fri Dec 04 10:43:03 CST 2020
     */
    public void setIsDeleted(Short isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product_video
     *
     * @mbg.generated Fri Dec 04 10:43:03 CST 2020
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", itemId=").append(itemId);
        sb.append(", checkItemFacePrice=").append(checkItemFacePrice);
        sb.append(", itemPrice=").append(itemPrice);
        sb.append(", quantity=").append(quantity);
        sb.append(", price=").append(price);
        sb.append(", linePrice=").append(linePrice);
        sb.append(", productName=").append(productName);
        sb.append(", productDesc=").append(productDesc);
        sb.append(", file=").append(file);
        sb.append(", isPutaway=").append(isPutaway);
        sb.append(", productState=").append(productState);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}