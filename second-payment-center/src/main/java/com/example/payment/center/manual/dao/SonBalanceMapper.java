package com.example.payment.center.manual.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface SonBalanceMapper {
    /**
     *
     * @param sonId
     * @param money
     * @return 子站点加余额
     */
    int add(@Param("sonId")Integer sonId,@Param("money")Integer money);
}
