package com.example.product.center.manual;

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
        PRODUCT("product"),//积分
        WITHDRAW("withdraw");//普通商品
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
}
