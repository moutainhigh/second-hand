package com.example.payment.center.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AddStockMapper {
    /**
     * 添加库存
     * @return
     */
    Integer addStock(@Param("goodsId")Integer goodsId);
}
