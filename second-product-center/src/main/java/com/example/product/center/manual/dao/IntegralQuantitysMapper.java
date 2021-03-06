package com.example.product.center.manual.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

public interface IntegralQuantitysMapper {
    /**
     *
     * @param integralId
     * @param quantity
     * @return
     * 改变卡券库存
     */
    Integer updateQuantity(@Param("integralId")Integer integralId, @Param("quantity") Integer quantity);
    /**
     * 修改额度
     */
    Integer updateExemptCommission(@Param("exemptCommission")Integer exemptCommission,@Param("userId")Integer userId,@Param("storeId")Integer storeId);
    /**
     *
     * @param balanceType 余额类型
     * @param balance 扣减数量
     * param
     * @return
     * 扣减用户积分余额
     */
    Integer updateBalance(@Param("balanceType")String balanceType, @Param("balance") Integer balance,@Param("userId")Integer userId,@Param("storeId")Integer storeId);
    /**
     *
     * @param balanceType 余额类型
     * @param balance 扣减数量
     * param
     * @return
     * 增加用户积分余额
     */
    Integer addBalance(@Param("balanceType")String balanceType, @Param("balance") Integer balance,@Param("userId")Integer userId,@Param("storeId")Integer storeId);
}

