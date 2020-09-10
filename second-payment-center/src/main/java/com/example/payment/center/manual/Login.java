package com.example.payment.center.manual;

public enum Login {
    WECHART("wechart"),//小程序微信
    ACCOUNT("account");//后台账号密码登录
    private String paymentTypeName;

    Login(String paymentTypeName) {

        this.paymentTypeName = paymentTypeName;
    }


    public String getPaymentTypeName() {
        return this.paymentTypeName;
    }

    public static Login getPaymentTypeEnum(String name) {
        for(Login TYPE: Login.values()) {
            if (TYPE.getPaymentTypeName().equals(name)) {
                return TYPE;
            }
        }
        return WECHART;
    }
}
