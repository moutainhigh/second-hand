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
    //轮播图 分类 和 首页
    public static enum SlideshowType {
        HOMEPAGE("homepage"),//首页轮播图
        CATEGORY("category");//分类轮播图
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
