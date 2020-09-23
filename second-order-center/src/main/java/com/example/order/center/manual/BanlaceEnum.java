package com.example.order.center.manual;

/**
 * @author shihao
 * @Title: BanlaceEnum
 * @ProjectName Second-order-center
 * @Description: 余额积分枚举
 * @date Created in
 * @Version: $
 */
public class BanlaceEnum {
    //余额类型,积分,钱
    public static enum Relation {
        MONEY("money"),//金额
        INTEGRAL("integral");//积分
        private String state;

        Relation(String state) {
            this.state = state;
        }

        public String getState(){
            return this.state;
        }

        public static Relation getState(String state) {
            for(Relation type1: Relation.values()) {
                if (type1.getState().equals(state)) {
                    return type1;
                }
            }
            return MONEY;
        }

    }

    //收支
    public static enum incomeExpenses {
        PUT("put"),//收
        PAY("pay");//支
        private String state;

        incomeExpenses(String state) {
            this.state = state;
        }

        public String getState(){
            return this.state;
        }

        public static incomeExpenses getState(String state) {
            for(incomeExpenses type1: incomeExpenses.values()) {
                if (type1.getState().equals(state)) {
                    return type1;
                }
            }
            return PUT;
        }

    }
}
