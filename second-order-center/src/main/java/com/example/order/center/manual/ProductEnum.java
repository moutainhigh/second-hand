package com.example.order.center.manual;

/**
 * @author shihao
 * @Title: ProductEnum
 * @ProjectName Second-order-center
 * @Description:
 * @date Created in
 * @Version: $
 */
public class ProductEnum {
    //商品类型 积分商品,普通商品
    public static enum Relation {
        INTEGRAL("integral"),//积分
        GENERAL("general");//普通商品
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
            return GENERAL;
        }

    }
    //商品展示类型 卡券,普通商品
    public static enum ShowType {
        COUPON("coupon"),//卡券
        PRODUCT("product");//商品
        private String state;

        ShowType(String state) {
            this.state = state;
        }

        public String getState(){
            return this.state;
        }

        public static ShowType getState(String state) {
            for(ShowType type1: ShowType.values()) {
                if (type1.getState().equals(state)) {
                    return type1;
                }
            }
            return PRODUCT;
        }

    }
    //商品上下架
    public static enum IsPutaway {
        PUTAWAY(0),//上架
        OUT(1);//下架
        private Integer state;

        IsPutaway(Integer state) {
            this.state = state;
        }

        public Integer getState(){
            return this.state;
        }

        public static IsPutaway getState(Integer state) {
            for(IsPutaway type1: IsPutaway.values()) {
                if (type1.getState().equals(state)) {
                    return type1;
                }
            }
            return PUTAWAY;
        }

    }
    //商品状态
    public static enum ProductState {
        SELL("sell"),//售卖中
        SELLOUT("sellOut");//售出
        private String state;

        ProductState(String state) {
            this.state = state;
        }

        public String getState(){
            return this.state;
        }

        public static ProductState getState(String state) {
            for(ProductState type1: ProductState.values()) {
                if (type1.getState().equals(state)) {
                    return type1;
                }
            }
            return SELL;
        }

    }
}
