package com.example.order.center.manual;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author shihao
 * @Title: CreateOrderRequest
 * @ProjectName Second-order-center
 * @Description:
 * @date Created in
 * @Version: $
 */
public class CreateOrderRequest {
    @ApiModelProperty(required = true, value = "物品列表")
    private String goodsList;
    @ApiModelProperty(required = true, value = "订单备注")
    private String remark;
//    @ApiModelProperty(required = true, value = "支付类型名称")
//    private String paymentName;
    @ApiModelProperty(required = false, value = "描述")
    private String hfDesc;
    @ApiModelProperty(required = false, value = "用户id")
    private Integer userId;
    @ApiModelProperty(required = false, value = "支付类型")
    private String paymentType;

    public String getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(String goodsList) {
        this.goodsList = goodsList;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getHfRemark() {
        return remark;
    }

    public void setHfRemark(String hfRemark) {
        this.remark = hfRemark;
    }

    public String getHfDesc() {
        return hfDesc;
    }

    public void setHfDesc(String hfDesc) {
        this.hfDesc = hfDesc;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
}
