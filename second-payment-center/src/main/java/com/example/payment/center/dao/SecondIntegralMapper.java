package com.example.payment.center.dao;

import com.example.payment.center.model.SecondIntegral;
import com.example.payment.center.model.SecondIntegralExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecondIntegralMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_integral
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    long countByExample(SecondIntegralExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_integral
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    int deleteByExample(SecondIntegralExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_integral
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_integral
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    int insert(SecondIntegral record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_integral
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    int insertSelective(SecondIntegral record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_integral
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    List<SecondIntegral> selectByExample(SecondIntegralExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_integral
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    SecondIntegral selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_integral
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    int updateByExampleSelective(@Param("record") SecondIntegral record, @Param("example") SecondIntegralExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_integral
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    int updateByExample(@Param("record") SecondIntegral record, @Param("example") SecondIntegralExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_integral
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    int updateByPrimaryKeySelective(SecondIntegral record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_integral
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    int updateByPrimaryKey(SecondIntegral record);
}