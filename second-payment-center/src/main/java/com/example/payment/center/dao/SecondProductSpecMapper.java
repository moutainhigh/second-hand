package com.example.payment.center.dao;

import com.example.payment.center.model.SecondProductSpec;
import com.example.payment.center.model.SecondProductSpecExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecondProductSpecMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product_spec
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    long countByExample(SecondProductSpecExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product_spec
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    int deleteByExample(SecondProductSpecExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product_spec
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product_spec
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    int insert(SecondProductSpec record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product_spec
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    int insertSelective(SecondProductSpec record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product_spec
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    List<SecondProductSpec> selectByExample(SecondProductSpecExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product_spec
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    SecondProductSpec selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product_spec
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    int updateByExampleSelective(@Param("record") SecondProductSpec record, @Param("example") SecondProductSpecExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product_spec
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    int updateByExample(@Param("record") SecondProductSpec record, @Param("example") SecondProductSpecExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product_spec
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    int updateByPrimaryKeySelective(SecondProductSpec record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product_spec
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    int updateByPrimaryKey(SecondProductSpec record);
}