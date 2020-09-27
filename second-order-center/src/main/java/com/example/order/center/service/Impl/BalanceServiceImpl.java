package com.example.order.center.service.Impl;

import com.example.order.center.dao.SecondStoreBalanceMapper;
import com.example.order.center.manual.dao.BalanceMapper;
import com.example.order.center.model.SecondStoreBalance;
import com.example.order.center.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author shihao
 * @Title: BalanceServiceImpl
 * @ProjectName Second-order-center
 * @Description: 余额
 * @date Created in
 * @Version: $
 */
@Service
public class BalanceServiceImpl implements BalanceService {
    @Autowired
    private BalanceMapper balanceMapper;
    /**
     * 确认收货后加余额
     * @param
     * @param storeId
     * @param type
     * @param money
     * @return
     */
    @Override
    public Integer addBalance(Integer storeId, String type, Integer money) {
        return balanceMapper.addBalance(storeId,type,money);
    }
}
