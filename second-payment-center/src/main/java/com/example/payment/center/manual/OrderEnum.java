package com.example.payment.center.manual;

/**
 * @author shihao
 * @Title: OrderEnum
 * @ProjectName Second-order-center
 * @Description: 订单枚举
 * @date Created in
 * @Version: $
 */
public class OrderEnum {
//支付状态
    public static enum OrderStatus {
        ALL("all"),
        PAYMENT("payment"),//待支付
        PROCESS("process"),//待发货
        TRANSPORT("pickUp"),//待提货
        EVALUATE("evaluate"),//待评价
        COMPLETE("complete"),//完成
        CONTROVERSIAL("controversial"),//交易纠纷
        CANCEL("cancel");//取消
        private String orderStatus;
        OrderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
        }
        public String getOrderStatus() {
            return this.orderStatus;
        }

        public static OrderStatus getOrderStatusEnum(String name) {
            for(OrderStatus payment: OrderStatus.values()) {
                if (payment.getOrderStatus().equals(name)) {
                    return payment;
                }
            }
            return PAYMENT;
        }
    }
    //支付类型
    public static enum PayType {
        ORDER("order"),//普通订单
        VIDEO("video");//视频订单
        private String payType;
        PayType(String payType) {
            this.payType = payType;
        }
        public String getPayTypeType() {
            return this.payType;
        }
    }
/**
 * 支付状态
 */
public static enum PaymentStatus {
    UNPAID(0),
    PAID(1);
    private Integer paymentStatus;
    PaymentStatus(Integer paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
    public Integer getPaymentStatus() {
        return this.paymentStatus;
    }
}
/**
 * 支付类型
 */
public static enum PaymentType {
    WECHART(1, "wechart"),
    BALANCE(0, "balance"),
    APPCHART(2, "appchart"),
    APPALIPAY(3,"appalipay");
    private Integer paymentType;
    private String paymentTypeName;

    PaymentType(Integer paymentType, String paymentTypeName) {
        this.paymentType = paymentType;
        this.paymentTypeName = paymentTypeName;
    }

    public Integer getPaymentType() {
        return this.paymentType;
    }
    public String getPaymentTypeName() {
        return this.paymentTypeName;
    }

    public static PaymentType getPaymentTypeEnum(String name) {
        for(PaymentType payment: PaymentType.values()) {
            if (payment.getPaymentTypeName().equals(name)) {
                return payment;
            }
        }
        return BALANCE;
    }
}
}
