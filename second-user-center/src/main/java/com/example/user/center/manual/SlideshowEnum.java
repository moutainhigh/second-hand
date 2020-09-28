package com.example.user.center.manual;

/**
 * @author shihao
 * @Title: SlideshowEnum
 * @ProjectName Second-order-center
 * @Description: 轮播图枚举
 * @date Created in
 * @Version: $
 */
public class SlideshowEnum {
    //支付状态
    public static enum SlideshowType {
        HOMEPAGE("homepage"),
        CATEGORY("category");//取消
        private String slideshowType;
        SlideshowType(String slideshowType) {
            this.slideshowType = slideshowType;
        }
        public String getOrderStatus() {
            return this.slideshowType;
        }

        public static SlideshowType getOrderStatusEnum(String name) {
            for(SlideshowType payment: SlideshowType.values()) {
                if (payment.getOrderStatus().equals(name)) {
                    return payment;
                }
            }
            return HOMEPAGE;
        }
    }
}
