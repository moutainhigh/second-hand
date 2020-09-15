package com.example.product.center.manual;

/**
 * @author shihao
 * @Title: CategoryEnum
 * @ProjectName Second-order-center
 * @Description: 分类枚举
 * @date Created in
 * @Version: $
 */
public class CategoryEnum {
    //商家分类,用户分类
    public static enum Relation {
        STORE("store"),//商家分类
        USER("user");//用户分类
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
            return USER;
        }

    }
}
