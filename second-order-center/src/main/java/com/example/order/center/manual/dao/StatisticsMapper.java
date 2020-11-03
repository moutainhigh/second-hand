package com.example.order.center.manual.dao;

import com.example.order.center.manual.Statistics.MonthAmount;
import com.example.order.center.manual.Statistics.StatisticsAmount;
import com.example.order.center.manual.Statistics.StatisticsDaySum;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author shihao
 * @Title: StatisticsMapper
 * @ProjectName Second-order-center
 * @Description: 统计
 * @date Created in
 * @Version: $
 */
@Mapper
public interface StatisticsMapper {
    /**
     * 店铺筛选每天的营业额
     * @param stoneId
     * @return
     */
    List<StatisticsAmount> dataAmount(@Param("stoneId")Integer stoneId);

    /**
     * 七天营业
     * @param stoneId
     * @return
     */
    List<StatisticsDaySum> dayAmount(@Param("stoneId")Integer stoneId);

    /**
     * 每月
     * @param sonId 子站点id
     * @param year 哪一年
     * @param stores 店铺数组
     * @return
     */
    List<MonthAmount> monthAmount(@Param("sonId")Integer sonId,@Param("year")Integer year,@Param("stores")List<Integer> stores);
}
