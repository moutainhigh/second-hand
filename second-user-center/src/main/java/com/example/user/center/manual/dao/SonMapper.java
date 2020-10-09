package com.example.user.center.manual.dao;

import com.example.user.center.manual.model.Son;
import com.example.user.center.model.SecondChat;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SonMapper {
    /**
     * 查询大学
     */
    List<Son> select();
}
