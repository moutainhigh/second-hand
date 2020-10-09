package com.example.user.center.service;

import com.example.user.center.manual.model.Son;
import com.example.user.center.model.SecondChat;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;


public interface SonService {
    /**
     * 查询大学
     */
    List<Son> select();
}
