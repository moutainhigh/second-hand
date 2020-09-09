package com.example.user.center.manual;

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
}
