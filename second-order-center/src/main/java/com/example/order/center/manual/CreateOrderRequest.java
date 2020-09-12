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
    private String hfRemark;
    @ApiModelProperty(required = true, value = "订单类型")
    private String orderType;
    @ApiModelProperty(required = true, value = "支付类型")
    private String paymentName;
    @ApiModelProperty(required = false, value = "描述")
    private String hfDesc;
    @ApiModelProperty(required = false, value = "店铺id")
    private Integer stoneId;
}
