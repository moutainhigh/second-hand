package com.example.user.center.manual;

/**
 * @author shihao
 * @Title: WantEnum
 * @ProjectName Second-order-center
 * @Description: 想要实体枚举
 * @date Created in
 * @Version: $
 */
public class WantEnum {
    //商品点赞，收藏，想要，浏览
    public static enum Relation {
        PRAISE("praise"),//点赞
        WANT("want"),//想要
        LOOK("look"),//浏览
        COLLECT("collect");//收藏
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
            return PRAISE;
        }

    }
}
