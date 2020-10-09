package com.example.user.center.service.Impl;

import com.example.user.center.manual.dao.SonMapper;
import com.example.user.center.manual.model.Son;
import com.example.user.center.model.SecondChat;
import com.example.user.center.service.SonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shihao
 * @Title: SonServiceImpl
 * @ProjectName Second-order-center
 * @Description:
 * @date Created in
 * @Version: $
 */
import java.util.List;
@Service
public class SonServiceImpl implements SonService {
    @Autowired
    private SonMapper sonMapper;
    @Override
    public List<Son> select() {
        return sonMapper.select();
    }
}
