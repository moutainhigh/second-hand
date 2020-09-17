package com.example.payment.center.service;

import org.apache.ibatis.annotations.Param;

public interface BalanceService {
    /**
     * 减余额
     * userId:
     * storeId:
     * @return
     */
    Integer addStock(@Param("userId")Integer userId, @Param("storeId")Integer storeId, @Param("type")String type,@Param("money")Integer money);
}
