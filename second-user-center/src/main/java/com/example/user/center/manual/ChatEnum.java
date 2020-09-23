package com.example.user.center.manual;

/**
 * @author shihao
 * @Title: ChatEnum
 * @ProjectName Second-order-center
 * @Description: 聊天枚举
 * @date Created in
 * @Version: $
 */
public class ChatEnum {
    /**
     * 已读未读
     */
    public static enum ChatStatus {
        YET((byte) 1),//已读
        NOYET((byte) 0);//未读
        private byte messageStatus;
        ChatStatus(byte messageStatus) {
            this.messageStatus = messageStatus;
        }
        public byte getMessageStatus() {
            return this.messageStatus;
        }
    }
}
