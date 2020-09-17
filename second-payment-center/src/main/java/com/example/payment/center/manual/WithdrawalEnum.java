package com.example.payment.center.manual;

/**
 * @author shihao
 * @Title: WithdrawalEnum
 * @ProjectName Second-order-center
 * @Description: 提现枚举
 * @date Created in
 * @Version: $
 */
public class WithdrawalEnum {
    //提现来源
    public static enum WithdrawalSource {
        USER("user"),//用户提现
        STORE("store"),//店铺提现
        SON("son");//子站点提现

        private String Source;
        WithdrawalSource(String Source) {
            this.Source = Source;
        }
        public String getWithdrawalSource() {
            return this.Source;
        }

        public static WithdrawalSource getWithdrawalSource(String name) {
            for(WithdrawalSource payment: WithdrawalSource.values()) {
                if (payment.getWithdrawalSource().equals(name)) {
                    return payment;
                }
            }
            return USER;
        }
    }
    //取款状态
    public static enum WithdrawalState {
        COMPLETE("complete"),//完成
        CHECK("check"),//审核
        CANCEL("cancel");//取消

        private String Source;
        WithdrawalState(String Source) {
            this.Source = Source;
        }
        public String getWithdrawalState() {
            return this.Source;
        }

        public static WithdrawalState getWithdrawalState(String name) {
            for(WithdrawalState payment: WithdrawalState.values()) {
                if (payment.getWithdrawalState().equals(name)) {
                    return payment;
                }
            }
            return CHECK;
        }
    }
}
