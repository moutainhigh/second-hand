package com.example.order.center.manual.Statistics;

/**
 * @author shihao
 * @Title: StatisticsUserList
 * @ProjectName Second-order-center
 * @Description: 统计
 * @date Created in
 * @Version: $
 */
public class StatisticsUserList {
    private Integer userNumber;//用户数
    private Integer userGeneral;//普通用户
    private Integer userAuthentication;//学生认证
    private Integer userStore;//商家用户

    public Integer getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(Integer userNumber) {
        this.userNumber = userNumber;
    }

    public Integer getUserGeneral() {
        return userGeneral;
    }

    public void setUserGeneral(Integer userGeneral) {
        this.userGeneral = userGeneral;
    }

    public Integer getUserAuthentication() {
        return userAuthentication;
    }

    public void setUserAuthentication(Integer userAuthentication) {
        this.userAuthentication = userAuthentication;
    }

    public Integer getUserStore() {
        return userStore;
    }

    public void setUserStore(Integer userStore) {
        this.userStore = userStore;
    }
}
