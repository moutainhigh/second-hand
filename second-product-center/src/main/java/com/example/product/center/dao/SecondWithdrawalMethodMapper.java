package com.example.product.center.dao;

import com.example.product.center.model.SecondWithdrawalMethod;
import com.example.product.center.model.SecondWithdrawalMethodExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecondWithdrawalMethodMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_withdrawal_method
     *
     * @mbg.generated Mon Sep 14 14:07:18 CST 2020
     */
    long countByExample(SecondWithdrawalMethodExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_withdrawal_method
     *
     * @mbg.generated Mon Sep 14 14:07:18 CST 2020
     */
    int deleteByExample(SecondWithdrawalMethodExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_withdrawal_method
     *
     * @mbg.generated Mon Sep 14 14:07:18 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_withdrawal_method
     *
     * @mbg.generated Mon Sep 14 14:07:18 CST 2020
     */
    int insert(SecondWithdrawalMethod record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_withdrawal_method
     *
     * @mbg.generated Mon Sep 14 14:07:18 CST 2020
     */
    int insertSelective(SecondWithdrawalMethod record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_withdrawal_method
     *
     * @mbg.generated Mon Sep 14 14:07:18 CST 2020
     */
    List<SecondWithdrawalMethod> selectByExample(SecondWithdrawalMethodExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_withdrawal_method
     *
     * @mbg.generated Mon Sep 14 14:07:18 CST 2020
     */
    SecondWithdrawalMethod selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_withdrawal_method
     *
     * @mbg.generated Mon Sep 14 14:07:18 CST 2020
     */
    int updateByExampleSelective(@Param("record") SecondWithdrawalMethod record, @Param("example") SecondWithdrawalMethodExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_withdrawal_method
     *
     * @mbg.generated Mon Sep 14 14:07:18 CST 2020
     */
    int updateByExample(@Param("record") SecondWithdrawalMethod record, @Param("example") SecondWithdrawalMethodExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_withdrawal_method
     *
     * @mbg.generated Mon Sep 14 14:07:18 CST 2020
     */
    int updateByPrimaryKeySelective(SecondWithdrawalMethod record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_withdrawal_method
     *
     * @mbg.generated Mon Sep 14 14:07:18 CST 2020
     */
    int updateByPrimaryKey(SecondWithdrawalMethod record);
}