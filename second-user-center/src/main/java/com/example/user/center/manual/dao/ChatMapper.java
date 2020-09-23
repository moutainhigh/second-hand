package com.example.user.center.manual.dao;

import com.example.user.center.model.SecondChat;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ChatMapper {
    /**
     * 查询聊天记录
     *
     * @param userId
     * @param byUserId
     * @return
     */
    List<SecondChat> select(@Param("userId") Integer userId, @Param("byUserId") Integer byUserId);
}
