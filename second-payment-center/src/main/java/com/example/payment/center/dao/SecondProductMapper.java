package com.example.payment.center.dao;

import com.example.payment.center.model.SecondProduct;
import com.example.payment.center.model.SecondProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecondProductMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    long countByExample(SecondProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    int deleteByExample(SecondProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    int insert(SecondProduct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    int insertSelective(SecondProduct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    List<SecondProduct> selectByExampleWithBLOBs(SecondProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    List<SecondProduct> selectByExample(SecondProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    SecondProduct selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    int updateByExampleSelective(@Param("record") SecondProduct record, @Param("example") SecondProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    int updateByExampleWithBLOBs(@Param("record") SecondProduct record, @Param("example") SecondProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    int updateByExample(@Param("record") SecondProduct record, @Param("example") SecondProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    int updateByPrimaryKeySelective(SecondProduct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    int updateByPrimaryKeyWithBLOBs(SecondProduct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    int updateByPrimaryKey(SecondProduct record);
}