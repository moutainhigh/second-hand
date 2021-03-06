package com.example.payment.center.dao;

import com.example.payment.center.model.SecondTransactionFlow;
import com.example.payment.center.model.SecondTransactionFlowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecondTransactionFlowMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_transaction_flow
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    long countByExample(SecondTransactionFlowExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_transaction_flow
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    int deleteByExample(SecondTransactionFlowExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_transaction_flow
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_transaction_flow
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    int insert(SecondTransactionFlow record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_transaction_flow
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    int insertSelective(SecondTransactionFlow record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_transaction_flow
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    List<SecondTransactionFlow> selectByExample(SecondTransactionFlowExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_transaction_flow
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    SecondTransactionFlow selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_transaction_flow
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    int updateByExampleSelective(@Param("record") SecondTransactionFlow record, @Param("example") SecondTransactionFlowExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_transaction_flow
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    int updateByExample(@Param("record") SecondTransactionFlow record, @Param("example") SecondTransactionFlowExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_transaction_flow
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    int updateByPrimaryKeySelective(SecondTransactionFlow record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_transaction_flow
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    int updateByPrimaryKey(SecondTransactionFlow record);
}