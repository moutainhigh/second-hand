package com.example.order.center.manual;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author shihao
 * @Title: goods
 * @ProjectName Second-order-center
 * @Description: 购买的物品
 * @date Created in
 * @Version: $
 */
public class goods {
    @ApiModelProperty(required = true, value = "物品id")
    private Integer goodsId;
    @ApiModelProperty(required = true, value = "购买数量")
    private Integer quantity;
    @ApiModelProperty(required = true, value = "店铺id")
    private Integer stoneId;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getStoneId() {
        return stoneId;
    }

    public void setStoneId(Integer stoneId) {
        this.stoneId = stoneId;
    }
}
