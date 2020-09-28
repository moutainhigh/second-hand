package com.example.payment.center.dao;

import com.example.payment.center.model.SecondAuthentication;
import com.example.payment.center.model.SecondAuthenticationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecondAuthenticationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_authentication
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    long countByExample(SecondAuthenticationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_authentication
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    int deleteByExample(SecondAuthenticationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_authentication
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_authentication
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    int insert(SecondAuthentication record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_authentication
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    int insertSelective(SecondAuthentication record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_authentication
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    List<SecondAuthentication> selectByExample(SecondAuthenticationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_authentication
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    SecondAuthentication selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_authentication
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    int updateByExampleSelective(@Param("record") SecondAuthentication record, @Param("example") SecondAuthenticationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_authentication
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    int updateByExample(@Param("record") SecondAuthentication record, @Param("example") SecondAuthenticationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_authentication
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    int updateByPrimaryKeySelective(SecondAuthentication record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_authentication
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    int updateByPrimaryKey(SecondAuthentication record);
}