package com.example.payment.center.manual.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author shihao
 * @Title: BalanceMapper
 * @ProjectName Second-order-center
 * @Description: 店铺余额
 * @date Created in
 * @Version: $
 */
@Mapper
public interface BalanceMapper {
    /**
     * 减余额
     * userId:
     * storeId:
     * @return
     */
    Integer addStock(@Param("userId")Integer userId, @Param("storeId")Integer storeId, @Param("type")String type,@Param("money")Integer money);
}
