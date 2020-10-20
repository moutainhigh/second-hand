package com.example.order.center.manual.Statistics;

/**
 * @author shihao
 * @Title: StatisticsOrderList
 * @ProjectName Second-order-center
 * @Description: 订单统计
 * @date Created in
 * @Version: $
 */
public class StatisticsOrderList {
    private Integer orderNumber;//用户数
    private Integer process;//待发货
    private Integer pickUp;//待提货
    private Integer evaluate;//待评价
    private Integer complete;//已完成

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getProcess() {
        return process;
    }

    public void setProcess(Integer process) {
        this.process = process;
    }

    public Integer getPickUp() {
        return pickUp;
    }

    public void setPickUp(Integer pickUp) {
        this.pickUp = pickUp;
    }

    public Integer getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(Integer evaluate) {
        this.evaluate = evaluate;
    }

    public Integer getComplete() {
        return complete;
    }

    public void setComplete(Integer complete) {
        this.complete = complete;
    }
}
