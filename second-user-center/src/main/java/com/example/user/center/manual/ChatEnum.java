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
        YET((short) 1),//已读
        NOYET((short) 0);//未读
        private short messageStatus;
        ChatStatus(short messageStatus) {
            this.messageStatus = messageStatus;
        }
        public short getMessageStatus() {
            return this.messageStatus;
        }
    }
}
