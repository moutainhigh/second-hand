package com.example.product.center.manual.Address;

/**
 * @author shihao
 * @Title: addressEnum
 * @ProjectName Second-order-center
 * @Description: 地址枚举
 * @date Created in
 * @Version: $
 */
public class addressEnum {
    /**
     * 已读未读
     */
    public static enum ChatStatus {
        NODEFAULT( 1),//不是默认
        DEFAULT( 0);//默认
        private Integer messageStatus;
        ChatStatus(Integer messageStatus) {
            this.messageStatus = messageStatus;
        }
        public Integer getMessageStatus() {
            return this.messageStatus;
        }
    }
}
