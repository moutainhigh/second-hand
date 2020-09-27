package com.example.order.center.manual;

/**
 * @author shihao
 * @Title: IntegralEnum
 * @ProjectName Second-order-center
 * @Description: 积分
 * @date Created in
 * @Version: $
 */
public class IntegralEnum {
    //换购商品,换购免手续费
    public static enum Relation {
        PRODUCT("product"),//积分普通商品
        WITHDRAW("withdraw");//提现
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
            return PRODUCT;
        }

    }
    //积分换购状态
    public static enum State {
        USE("use"),//已使用
        NOUSE("noUse");//未使用
        private String state;

        State(String state) {
            this.state = state;
        }

        public String getState(){
            return this.state;
        }

        public static State getState(String state) {
            for(State type1: State.values()) {
                if (type1.getState().equals(state)) {
                    return type1;
                }
            }
            return NOUSE;
        }

    }
    //积分二维码
    public static enum Code {
        INTEGRAL("integral"),//积分换购商品核销二维码
        PRODUCT("product");//普通商品核销二维码
        private String state;

        Code(String state) {
            this.state = state;
        }

        public String getState(){
            return this.state;
        }

        public static Code getState(String state) {
            for(Code type1: Code.values()) {
                if (type1.getState().equals(state)) {
                    return type1;
                }
            }
            return PRODUCT;
        }

    }
}
