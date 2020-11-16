package com.example.user.center.manual;

/**
 * @author shihao
 * @Title: SonTransactionAmount
 * @ProjectName Second-order-center
 * @Description: 子站点交易金额
 * @date Created in
 * @Version: $
 */
public class SonTransactionAmount {
        private String sonName;
        private Integer money;
        private Integer userNum;
        private Integer sonId;

    public String getSonName() {
        return sonName;
    }

    public void setSonName(String sonName) {
        this.sonName = sonName;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getUserNum() {
        return userNum;
    }

    public void setUserNum(Integer userNum) {
        this.userNum = userNum;
    }

    public Integer getSonId() {
        return sonId;
    }

    public void setSonId(Integer sonId) {
        this.sonId = sonId;
    }
}
