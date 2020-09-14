package com.example.product.center.dao;

import com.example.product.center.model.SecondOrderDetail;
import com.example.product.center.model.SecondOrderDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecondOrderDetailMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_order_detail
     *
     * @mbg.generated Mon Sep 14 14:07:18 CST 2020
     */
    long countByExample(SecondOrderDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_order_detail
     *
     * @mbg.generated Mon Sep 14 14:07:18 CST 2020
     */
    int deleteByExample(SecondOrderDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_order_detail
     *
     * @mbg.generated Mon Sep 14 14:07:18 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_order_detail
     *
     * @mbg.generated Mon Sep 14 14:07:18 CST 2020
     */
    int insert(SecondOrderDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_order_detail
     *
     * @mbg.generated Mon Sep 14 14:07:18 CST 2020
     */
    int insertSelective(SecondOrderDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_order_detail
     *
     * @mbg.generated Mon Sep 14 14:07:18 CST 2020
     */
    List<SecondOrderDetail> selectByExample(SecondOrderDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_order_detail
     *
     * @mbg.generated Mon Sep 14 14:07:18 CST 2020
     */
    SecondOrderDetail selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_order_detail
     *
     * @mbg.generated Mon Sep 14 14:07:18 CST 2020
     */
    int updateByExampleSelective(@Param("record") SecondOrderDetail record, @Param("example") SecondOrderDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_order_detail
     *
     * @mbg.generated Mon Sep 14 14:07:18 CST 2020
     */
    int updateByExample(@Param("record") SecondOrderDetail record, @Param("example") SecondOrderDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_order_detail
     *
     * @mbg.generated Mon Sep 14 14:07:18 CST 2020
     */
    int updateByPrimaryKeySelective(SecondOrderDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_order_detail
     *
     * @mbg.generated Mon Sep 14 14:07:18 CST 2020
     */
    int updateByPrimaryKey(SecondOrderDetail record);
}