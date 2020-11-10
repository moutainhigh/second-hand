package com.example.payment.center.manual;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.models.auth.In;

import java.time.LocalDateTime;

/**
 * @author shihao
 * @Title: SecondWithdrawalList
 * @ProjectName Second-order-center
 * @Description: 提现列表
 * @date Created in
 * @Version: $
 */
public class SecondWithdrawalList {
    private Integer secondWithdrawal;//提现id
    private String sonName;//子站点名称
    private String userName;//用户名称
    private String storeName;//店铺名称
    private String name;//提现名称
    private Integer withdrawalMoney;//取款金额
    private Integer realityMoney;//实际金额
    private String WithdrawalMethod;//取款方法
    private String account;//账号
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;//创建时间

    public Integer getSecondWithdrawal() {
        return secondWithdrawal;
    }

    public void setSecondWithdrawal(Integer secondWithdrawal) {
        this.secondWithdrawal = secondWithdrawal;
    }

    public String getSonName() {
        return sonName;
    }

    public void setSonName(String sonName) {
        this.sonName = sonName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWithdrawalMoney() {
        return withdrawalMoney;
    }

    public void setWithdrawalMoney(Integer withdrawalMoney) {
        this.withdrawalMoney = withdrawalMoney;
    }

    public Integer getRealityMoney() {
        return realityMoney;
    }

    public void setRealityMoney(Integer realityMoney) {
        this.realityMoney = realityMoney;
    }

    public String getWithdrawalMethod() {
        return WithdrawalMethod;
    }

    public void setWithdrawalMethod(String withdrawalMethod) {
        WithdrawalMethod = withdrawalMethod;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "SecondWithdrawalList{" +
                "secondWithdrawal=" + secondWithdrawal +
                ", sonName='" + sonName + '\'' +
                ", userName='" + userName + '\'' +
                ", storeName='" + storeName + '\'' +
                ", name='" + name + '\'' +
                ", withdrawalMoney=" + withdrawalMoney +
                ", realityMoney=" + realityMoney +
                ", WithdrawalMethod='" + WithdrawalMethod + '\'' +
                ", account='" + account + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
