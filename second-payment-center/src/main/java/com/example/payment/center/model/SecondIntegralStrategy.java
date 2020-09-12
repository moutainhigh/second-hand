package com.example.payment.center.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SecondIntegralStrategy implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_integral_strategy.id
     *
     * @mbg.generated Fri Sep 11 14:22:58 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_integral_strategy.product_id
     *
     * @mbg.generated Fri Sep 11 14:22:58 CST 2020
     */
    private Integer productId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_integral_strategy.integral_id
     *
     * @mbg.generated Fri Sep 11 14:22:58 CST 2020
     */
    private Integer integralId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_integral_strategy.exempt_commission
     *
     * @mbg.generated Fri Sep 11 14:22:58 CST 2020
     */
    private Integer exemptCommission;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_integral_strategy.create_date
     *
     * @mbg.generated Fri Sep 11 14:22:58 CST 2020
     */
    private LocalDateTime createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_integral_strategy.modify_date
     *
     * @mbg.generated Fri Sep 11 14:22:58 CST 2020
     */
    private LocalDateTime modifyDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_integral_strategy.is_deleted
     *
     * @mbg.generated Fri Sep 11 14:22:58 CST 2020
     */
    private Byte isDeleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table second_integral_strategy
     *
     * @mbg.generated Fri Sep 11 14:22:58 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_integral_strategy.id
     *
     * @return the value of second_integral_strategy.id
     *
     * @mbg.generated Fri Sep 11 14:22:58 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_integral_strategy.id
     *
     * @param id the value for second_integral_strategy.id
     *
     * @mbg.generated Fri Sep 11 14:22:58 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_integral_strategy.product_id
     *
     * @return the value of second_integral_strategy.product_id
     *
     * @mbg.generated Fri Sep 11 14:22:58 CST 2020
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_integral_strategy.product_id
     *
     * @param productId the value for second_integral_strategy.product_id
     *
     * @mbg.generated Fri Sep 11 14:22:58 CST 2020
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_integral_strategy.integral_id
     *
     * @return the value of second_integral_strategy.integral_id
     *
     * @mbg.generated Fri Sep 11 14:22:58 CST 2020
     */
    public Integer getIntegralId() {
        return integralId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_integral_strategy.integral_id
     *
     * @param integralId the value for second_integral_strategy.integral_id
     *
     * @mbg.generated Fri Sep 11 14:22:58 CST 2020
     */
    public void setIntegralId(Integer integralId) {
        this.integralId = integralId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_integral_strategy.exempt_commission
     *
     * @return the value of second_integral_strategy.exempt_commission
     *
     * @mbg.generated Fri Sep 11 14:22:58 CST 2020
     */
    public Integer getExemptCommission() {
        return exemptCommission;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_integral_strategy.exempt_commission
     *
     * @param exemptCommission the value for second_integral_strategy.exempt_commission
     *
     * @mbg.generated Fri Sep 11 14:22:58 CST 2020
     */
    public void setExemptCommission(Integer exemptCommission) {
        this.exemptCommission = exemptCommission;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_integral_strategy.create_date
     *
     * @return the value of second_integral_strategy.create_date
     *
     * @mbg.generated Fri Sep 11 14:22:58 CST 2020
     */
    public LocalDateTime getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_integral_strategy.create_date
     *
     * @param createDate the value for second_integral_strategy.create_date
     *
     * @mbg.generated Fri Sep 11 14:22:58 CST 2020
     */
    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_integral_strategy.modify_date
     *
     * @return the value of second_integral_strategy.modify_date
     *
     * @mbg.generated Fri Sep 11 14:22:58 CST 2020
     */
    public LocalDateTime getModifyDate() {
        return modifyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_integral_strategy.modify_date
     *
     * @param modifyDate the value for second_integral_strategy.modify_date
     *
     * @mbg.generated Fri Sep 11 14:22:58 CST 2020
     */
    public void setModifyDate(LocalDateTime modifyDate) {
        this.modifyDate = modifyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_integral_strategy.is_deleted
     *
     * @return the value of second_integral_strategy.is_deleted
     *
     * @mbg.generated Fri Sep 11 14:22:58 CST 2020
     */
    public Byte getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_integral_strategy.is_deleted
     *
     * @param isDeleted the value for second_integral_strategy.is_deleted
     *
     * @mbg.generated Fri Sep 11 14:22:58 CST 2020
     */
    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_integral_strategy
     *
     * @mbg.generated Fri Sep 11 14:22:58 CST 2020
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", productId=").append(productId);
        sb.append(", integralId=").append(integralId);
        sb.append(", exemptCommission=").append(exemptCommission);
        sb.append(", createDate=").append(createDate);
        sb.append(", modifyDate=").append(modifyDate);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}