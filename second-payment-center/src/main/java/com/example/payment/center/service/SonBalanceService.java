package com.example.payment.center.service;

import org.apache.ibatis.annotations.Param;

/**
 * @author shihao
 * @Title: SonBalanceService
 * @ProjectName Second-order-center
 * @Description: 子站点
 * @date Created in
 * @Version: $
 */
public interface SonBalanceService {
    /**
     *
     * @param sonId
     * @param money
     * @return 子站点加余额
     */
    int add(@Param("sonId")Integer sonId, @Param("money")Integer money);
}
