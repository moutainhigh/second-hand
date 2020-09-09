package com.example.product.center.dao;

import com.example.product.center.model.SecondIntegralStrategy;
import com.example.product.center.model.SecondIntegralStrategyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecondIntegralStrategyMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_integral_strategy
     *
     * @mbg.generated Wed Sep 09 09:12:19 CST 2020
     */
    long countByExample(SecondIntegralStrategyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_integral_strategy
     *
     * @mbg.generated Wed Sep 09 09:12:19 CST 2020
     */
    int deleteByExample(SecondIntegralStrategyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_integral_strategy
     *
     * @mbg.generated Wed Sep 09 09:12:19 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_integral_strategy
     *
     * @mbg.generated Wed Sep 09 09:12:19 CST 2020
     */
    int insert(SecondIntegralStrategy record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_integral_strategy
     *
     * @mbg.generated Wed Sep 09 09:12:19 CST 2020
     */
    int insertSelective(SecondIntegralStrategy record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_integral_strategy
     *
     * @mbg.generated Wed Sep 09 09:12:19 CST 2020
     */
    List<SecondIntegralStrategy> selectByExample(SecondIntegralStrategyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_integral_strategy
     *
     * @mbg.generated Wed Sep 09 09:12:19 CST 2020
     */
    SecondIntegralStrategy selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_integral_strategy
     *
     * @mbg.generated Wed Sep 09 09:12:19 CST 2020
     */
    int updateByExampleSelective(@Param("record") SecondIntegralStrategy record, @Param("example") SecondIntegralStrategyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_integral_strategy
     *
     * @mbg.generated Wed Sep 09 09:12:19 CST 2020
     */
    int updateByExample(@Param("record") SecondIntegralStrategy record, @Param("example") SecondIntegralStrategyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_integral_strategy
     *
     * @mbg.generated Wed Sep 09 09:12:19 CST 2020
     */
    int updateByPrimaryKeySelective(SecondIntegralStrategy record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_integral_strategy
     *
     * @mbg.generated Wed Sep 09 09:12:19 CST 2020
     */
    int updateByPrimaryKey(SecondIntegralStrategy record);
}