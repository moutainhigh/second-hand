package com.example.order.center.manual.Statistics;

import java.util.Date;

/**
 * @author shihao
 * @Title: StatisticsAmount
 * @ProjectName Second-order-center
 * @Description:
 * @date Created in
 * @Version: $
 */
public class StatisticsAmount {
    private Date date;
    private Integer coun;
    private Integer Amount;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getCoun() {
        return coun;
    }

    public void setCoun(Integer coun) {
        this.coun = coun;
    }

    public Integer getAmount() {
        return Amount;
    }

    public void setAmount(Integer amount) {
        Amount = amount;
    }
}
