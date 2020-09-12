package com.example.order.center.dao;

import com.example.order.center.model.SecondWithdrawal;
import com.example.order.center.model.SecondWithdrawalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecondWithdrawalMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_withdrawal
     *
     * @mbg.generated Fri Sep 11 16:22:40 CST 2020
     */
    long countByExample(SecondWithdrawalExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_withdrawal
     *
     * @mbg.generated Fri Sep 11 16:22:40 CST 2020
     */
    int deleteByExample(SecondWithdrawalExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_withdrawal
     *
     * @mbg.generated Fri Sep 11 16:22:40 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_withdrawal
     *
     * @mbg.generated Fri Sep 11 16:22:40 CST 2020
     */
    int insert(SecondWithdrawal record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_withdrawal
     *
     * @mbg.generated Fri Sep 11 16:22:40 CST 2020
     */
    int insertSelective(SecondWithdrawal record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_withdrawal
     *
     * @mbg.generated Fri Sep 11 16:22:40 CST 2020
     */
    List<SecondWithdrawal> selectByExample(SecondWithdrawalExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_withdrawal
     *
     * @mbg.generated Fri Sep 11 16:22:40 CST 2020
     */
    SecondWithdrawal selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_withdrawal
     *
     * @mbg.generated Fri Sep 11 16:22:40 CST 2020
     */
    int updateByExampleSelective(@Param("record") SecondWithdrawal record, @Param("example") SecondWithdrawalExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_withdrawal
     *
     * @mbg.generated Fri Sep 11 16:22:40 CST 2020
     */
    int updateByExample(@Param("record") SecondWithdrawal record, @Param("example") SecondWithdrawalExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_withdrawal
     *
     * @mbg.generated Fri Sep 11 16:22:40 CST 2020
     */
    int updateByPrimaryKeySelective(SecondWithdrawal record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_withdrawal
     *
     * @mbg.generated Fri Sep 11 16:22:40 CST 2020
     */
    int updateByPrimaryKey(SecondWithdrawal record);
}