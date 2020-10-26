package com.example.order.center.manual.Statistics;

/**
 * @author shihao
 * @Title: StatisticsMiniStore
 * @ProjectName Second-order-center
 * @Description: 商家端统计
 * @date Created in
 * @Version: $
 */
public class StatisticsMiniStore {
    private Integer sevenAmount;//七天的收入
    private Integer dayMax;//单日最高
    private Integer daySum;//日均
    private Integer orderNumber;//下单数
    private Integer paymentOrder;//付款订单
    private Integer cancelOrder;//核销订单

    public Integer getSevenAmount() {
        return sevenAmount;
    }

    public void setSevenAmount(Integer sevenAmount) {
        this.sevenAmount = sevenAmount;
    }

    public Integer getDayMax() {
        return dayMax;
    }

    public void setDayMax(Integer dayMax) {
        this.dayMax = dayMax;
    }

    public Integer getDaySum() {
        return daySum;
    }

    public void setDaySum(Integer daySum) {
        this.daySum = daySum;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getPaymentOrder() {
        return paymentOrder;
    }

    public void setPaymentOrder(Integer paymentOrder) {
        this.paymentOrder = paymentOrder;
    }

    public Integer getCancelOrder() {
        return cancelOrder;
    }

    public void setCancelOrder(Integer cancelOrder) {
        this.cancelOrder = cancelOrder;
    }
}
