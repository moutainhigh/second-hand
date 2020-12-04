package com.example.order.center.service.Impl;

import com.example.order.center.manual.dao.PayOrderMapper;
import com.example.order.center.service.PayOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author shihao
 * @Title: PayOrderServiceImpl
 * @ProjectName Second-order-center
 * @Description:
 * @date Created in
 * @Version: $
 */
@Service
public class PayOrderServiceImpl implements PayOrderService {
    @Autowired
    private PayOrderMapper payOrderMapper;

    @Override
    public Integer stock(Integer quantity,Integer goodsId) {
        return payOrderMapper.stock(quantity,goodsId);
    }

    @Override
    public Integer stockVideo(Integer quantity, Integer productId) {
        return payOrderMapper.stockVideo(quantity, productId);
    }
}
