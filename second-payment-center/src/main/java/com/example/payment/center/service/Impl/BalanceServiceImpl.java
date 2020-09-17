package com.example.payment.center.service.Impl;

import com.example.payment.center.manual.dao.BalanceMapper;
import com.example.payment.center.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author shihao
 * @Title: BalanceServiceImpl
 * @ProjectName Second-order-center
 * @Description:
 * @date Created in
 * @Version: $
 */
@Service
public class BalanceServiceImpl implements BalanceService {
    @Autowired
    private BalanceMapper balanceMapper;
    @Override
    public Integer addStock(Integer userId, Integer storeId, String type,Integer money) {
        return balanceMapper.addStock(userId,storeId,type,money);
    }
}
