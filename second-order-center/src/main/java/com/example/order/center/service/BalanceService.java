package com.example.order.center.service;

import org.apache.ibatis.annotations.Param;

public interface BalanceService {
    /**
     * 加余额
     * userId: 用户id
     * storeId: 店铺id
     * @return
     */
    Integer addBalance(@Param("userId")Integer userId, @Param("storeId")Integer storeId, @Param("type")String type, @Param("money")Integer money);
}
