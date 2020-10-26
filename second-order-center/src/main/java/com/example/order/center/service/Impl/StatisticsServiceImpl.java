package com.example.order.center.service.Impl;

import com.example.order.center.manual.Statistics.StatisticsAmount;
import com.example.order.center.manual.Statistics.StatisticsDaySum;
import com.example.order.center.manual.dao.StatisticsMapper;
import com.example.order.center.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shihao
 * @Title: StatisticsServiceImpl
 * @ProjectName Second-order-center
 * @Description:
 * @date Created in
 * @Version: $
 */
@Service
public class StatisticsServiceImpl implements StatisticsService {
    @Autowired
    private StatisticsMapper statisticsMapper;
    @Override
    public List<StatisticsAmount> dataAmount(Integer stoneId) {
        return statisticsMapper.dataAmount(stoneId);
    }

    @Override
    public List<StatisticsDaySum> dayAmount(Integer stoneId) {
        return statisticsMapper.dayAmount(stoneId);
    }
}
