package com.example.payment.service.Impl;

import com.example.payment.center.dao.AddStockMapper;
import com.example.payment.service.AddStockService;
import org.apache.ibatis.annotations.Param;
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
    public Integer addStock(Integer goodsId) {
        return addStockMapper.addStock(goodsId);
    }
}
