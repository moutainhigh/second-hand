package com.example.user.center.manual;

import com.example.user.center.model.SecondMessage;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

/**
 * @author shihao
 * @Title: MiniMessage
 * @ProjectName Second-order-center
 * @Description: 小程序消息
 * @date Created in
 * @Version: $
 */
public class MiniMessage {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    private SecondMessage secondMessage;

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public SecondMessage getSecondMessage() {
        return secondMessage;
    }

    public void setSecondMessage(SecondMessage secondMessage) {
        this.secondMessage = secondMessage;
    }
}
