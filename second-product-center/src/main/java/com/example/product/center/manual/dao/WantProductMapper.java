package com.example.product.center.manual.dao;

import com.example.product.center.model.SecondProductWant;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author shihao
 * @Title: WantProductMapper
 * @ProjectName Second-order-center
 * @Description: 点赞查询
 * @date Created in
 * @Version: $
 */
public interface WantProductMapper {
    /**
     * 今日点赞查询
     * @param userId
     * @param type
     * @param productId
     * @return
     */
    List<SecondProductWant> selectProductPraise(@Param("userId")Integer userId,
                                                @Param("type")String type,
                                                @Param("productId")Integer productId);
    /**
     * 今日点赞查询
     * @param userId
     * @param type
     * @param productId
     * @return
     */
    List<SecondProductWant> selectProductPraise1(@Param("userId")Integer userId,
                                                 @Param("type")String type,
                                                 @Param("productId")Integer productId);
}
