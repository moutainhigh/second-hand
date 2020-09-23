package com.example.user.center.service;

import com.example.user.center.model.SecondChat;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author shihao
 * @Title: ChatService
 * @ProjectName Second-order-center
 * @Description: 聊天
 * @date Created in
 * @Version: $
 */
public interface ChatService {
    /**
     * 查询聊天记录
     * @param userId
     * @param byUserId
     * @return
     */
    List<SecondChat> select(@Param("userId")Integer userId, @Param("byUserId")Integer byUserId);
}
