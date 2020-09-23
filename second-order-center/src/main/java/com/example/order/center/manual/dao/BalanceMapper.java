package com.example.order.center.manual.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author shihao
 * @Title: BalanceMapper
 * @ProjectName Second-order-center
 * @Description: 余额
 * @date Created in
 * @Version: $
 */
@Mapper
public interface BalanceMapper {
    /**
     * 加余额
     * userId: 用户id
     * storeId: 店铺id
     * @return
     */
    Integer addBalance(@Param("userId")Integer userId, @Param("storeId")Integer storeId, @Param("type")String type, @Param("money")Integer money);
}
