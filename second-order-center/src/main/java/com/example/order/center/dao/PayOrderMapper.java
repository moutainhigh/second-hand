package com.example.order.center.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PayOrderMapper {
    /**
     * 扣减库存
     */
    Integer stock(@Param("quantity")Integer quantity,@Param("goodsId") Integer goodsId);
}
