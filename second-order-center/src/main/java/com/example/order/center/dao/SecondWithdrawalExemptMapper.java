package com.example.order.center.dao;

import com.example.order.center.model.SecondWithdrawalExempt;
import com.example.order.center.model.SecondWithdrawalExemptExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecondWithdrawalExemptMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_withdrawal_exempt
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    long countByExample(SecondWithdrawalExemptExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_withdrawal_exempt
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    int deleteByExample(SecondWithdrawalExemptExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_withdrawal_exempt
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_withdrawal_exempt
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    int insert(SecondWithdrawalExempt record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_withdrawal_exempt
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    int insertSelective(SecondWithdrawalExempt record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_withdrawal_exempt
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    List<SecondWithdrawalExempt> selectByExample(SecondWithdrawalExemptExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_withdrawal_exempt
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    SecondWithdrawalExempt selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_withdrawal_exempt
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    int updateByExampleSelective(@Param("record") SecondWithdrawalExempt record, @Param("example") SecondWithdrawalExemptExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_withdrawal_exempt
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    int updateByExample(@Param("record") SecondWithdrawalExempt record, @Param("example") SecondWithdrawalExemptExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_withdrawal_exempt
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    int updateByPrimaryKeySelective(SecondWithdrawalExempt record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_withdrawal_exempt
     *
     * @mbg.generated Mon Sep 14 12:10:16 CST 2020
     */
    int updateByPrimaryKey(SecondWithdrawalExempt record);
}