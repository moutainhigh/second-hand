package com.example.order.center.service;

import org.apache.ibatis.annotations.Param;

/**
 * @author shihao
 * @Title: PayOrderService
 * @ProjectName Second-order-center
 * @Description:
 * @date Created in
 * @Version: $
 */
public interface PayOrderService {
    /**
     * 扣减库存
     */
    Integer stock(@Param("quantity")Integer quantity, @Param("goodsId")Integer goodsId);
    /**
     * 扣减视频商品库存
     */
    Integer stockVideo(@Param("quantity")Integer quantity,@Param("productId") Integer productId);
}
