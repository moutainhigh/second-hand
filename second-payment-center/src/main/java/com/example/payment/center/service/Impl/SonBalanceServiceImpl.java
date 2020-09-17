package com.example.payment.center.service.Impl;

import com.example.payment.center.manual.dao.SonBalanceMapper;
import com.example.payment.center.service.SonBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author shihao
 * @Title: SonBalanceServiceImpl
 * @ProjectName Second-order-center
 * @Description: 子站点
 * @date Created in
 * @Version: $
 */
@Service
public class SonBalanceServiceImpl implements SonBalanceService {
    @Autowired
    private SonBalanceMapper sonBalanceMapper;

    @Override
    public int add(Integer sonId, Integer money) {
        return sonBalanceMapper.add(sonId,money);
    }
}
