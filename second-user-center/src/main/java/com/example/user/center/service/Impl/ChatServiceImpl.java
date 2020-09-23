package com.example.user.center.service.Impl;

import com.example.user.center.manual.dao.ChatMapper;
import com.example.user.center.model.SecondChat;
import com.example.user.center.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shihao
 * @Title: ChatServiceImpl
 * @ProjectName Second-order-center
 * @Description: 聊天
 * @date Created in
 * @Version: $
 */
@Service
public class ChatServiceImpl implements ChatService {
@Autowired
private ChatMapper chatMapper;
    @Override
    public List<SecondChat> select(Integer userId, Integer byUserId) {
        return chatMapper.select(userId,byUserId);
    }
}
