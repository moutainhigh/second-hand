package com.example.payment.service;

import org.apache.ibatis.annotations.Param;

/**
 * @author shihao
 * @Title: AddStockService
 * @ProjectName Second-order-center
 * @Description:
 * @date Created in
 * @Version: $
 */
public interface AddStockService {
    /**
     * 添加库存
     * @return
     */
    Integer addStock(@Param("goodsId")Integer goodsId);
}
