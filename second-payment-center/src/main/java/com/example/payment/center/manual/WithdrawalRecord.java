package com.example.payment.center.manual;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

/**
 * @author shihao
 * @Title: WithdrawalRecord
 * @ProjectName Second-order-center
 * @Description: 提现记录
 * @date Created in
 * @Version: $
 */
public class WithdrawalRecord {
    private Integer withdrawalId;//提现id
    private Integer deduck;//手续费
    private String mark;//订单号
    private Integer money;//取款金额
    private Integer realityMoney;//实际金额
    private String type;//取款类型
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;//发起时间
    private String state;

    public Integer getWithdrawalId() {
        return withdrawalId;
    }

    public void setWithdrawalId(Integer withdrawalId) {
        this.withdrawalId = withdrawalId;
    }

    public Integer getDeduck() {
        return deduck;
    }

    public void setDeduck(Integer deduck) {
        this.deduck = deduck;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getRealityMoney() {
        return realityMoney;
    }

    public void setRealityMoney(Integer realityMoney) {
        this.realityMoney = realityMoney;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
