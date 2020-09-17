package com.example.payment.center.service.Impl;

import com.example.payment.center.manual.dao.AddStockMapper;
import com.example.payment.center.service.AddStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author shihao
 * @Title: AddStockServiceImpl
 * @ProjectName Second-order-center
 * @Description:
 * @date Created in
 * @Version: $
 */
@Service
public class AddStockServiceImpl implements AddStockService {
    @Autowired
    private AddStockMapper addStockMapper;
    @Override
    public Integer addStock(Integer goodsId,Integer quantity) {
        return addStockMapper.addStock(goodsId,quantity);
    }
}
