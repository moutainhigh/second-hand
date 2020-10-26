package com.example.order.center.service;

import com.example.order.center.manual.Statistics.StatisticsAmount;
import com.example.order.center.manual.Statistics.StatisticsDaySum;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author shihao
 * @Title: StatisticsService
 * @ProjectName Second-order-center
 * @Description:
 * @date Created in
 * @Version: $
 */
public interface StatisticsService {
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
}
