package com.example.order.center.manual;

/**
 * @author shihao
 * @Title: Authentication
 * @ProjectName Second-order-center
 * @Description:
 * @date Created in
 * @Version: $
 */
public class Authentication {
    //提交审核状态
    public static enum State {
        AUDIT(1),//审核中
        DOWN(2),//未通过
        PASS(0);//通过
    private Integer state;

        State(Integer state) {
            this.state = state;
        }

        public Integer getState(){
        return this.state;
    }

        public static State getState(Integer state) {
            for(State type1: State.values()) {
                if (type1.getState().equals(state)) {
                    return type1;
                }
            }
            return AUDIT;
        }

    }
//用户审核状态
    public static enum UserState {
        NOPASS(1),//未审核
        PASS(0);//已经审核
        private int state;

        UserState(Integer state) {
            this.state = state;
        }

        public Integer getState(){
            return this.state;
        }

        public static UserState getState(Integer state) {
            for(UserState type1: UserState.values()) {
                if (type1.getState().equals(state)) {
                    return type1;
                }
            }
            return NOPASS;
        }

    }

    //用户登录方式
    public static enum LoginType {
        USERWX("user"),//用户端微信登录
        BOSS("boss"),//平台后台登录
        STOREWX("store"),//店铺小程序端口登录
        SON("son");//子站点后台登录
        private String state;

        LoginType(String state) {
            this.state = state;
        }

        public String getState(){
            return this.state;
        }

        public static LoginType getState(String state) {
            for(LoginType type1: LoginType.values()) {
                if (type1.getState().equals(state)) {
                    return type1;
                }
            }
            return USERWX;
        }

    }

    //店铺类型
    public static enum StoreType {
        USER("user"),//用户店铺
        BOSS("boss"),//总后台店铺
        STORE("store");//入驻商家店铺
        private String state;

        StoreType(String state) {
            this.state = state;
        }

        public String getState(){
            return this.state;
        }

        public static StoreType getState(Integer state) {
            for(StoreType type1: StoreType.values()) {
                if (type1.getState().equals(state)) {
                    return type1;
                }
            }
            return USER;
        }

    }
}
