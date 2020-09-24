package com.example.user.center.manual;

/**
 * @author shihao
 * @Title: Attention
 * @ProjectName Second-order-center
 * @Description: 关注关系
 * @date Created in
 * @Version: $
 */
public class Attention {
    //提交审核状态
    public static enum Relation {
        EACHOTHER("eachOther"),//互相关注
        YETATTENTION("yetAttention"),//关注
        BYATTENTION("byAttention"),//被关注
        NO("no");//没关系
        private String state;

        Relation(String state) {
            this.state = state;
        }

        public String getState(){
            return this.state;
        }

        public static Relation getState(Integer state) {
            for(Relation type1: Relation.values()) {
                if (type1.getState().equals(state)) {
                    return type1;
                }
            }
            return EACHOTHER;
        }

    }
}
