package com.example.user.center.dao;

import com.example.user.center.model.SecondWithdrawalMethod;
import com.example.user.center.model.SecondWithdrawalMethodExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecondWithdrawalMethodMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_withdrawal_method
     *
     * @mbg.generated Thu Sep 10 17:38:46 CST 2020
     */
    long countByExample(SecondWithdrawalMethodExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_withdrawal_method
     *
     * @mbg.generated Thu Sep 10 17:38:46 CST 2020
     */
    int deleteByExample(SecondWithdrawalMethodExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_withdrawal_method
     *
     * @mbg.generated Thu Sep 10 17:38:46 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_withdrawal_method
     *
     * @mbg.generated Thu Sep 10 17:38:46 CST 2020
     */
    int insert(SecondWithdrawalMethod record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_withdrawal_method
     *
     * @mbg.generated Thu Sep 10 17:38:46 CST 2020
     */
    int insertSelective(SecondWithdrawalMethod record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_withdrawal_method
     *
     * @mbg.generated Thu Sep 10 17:38:46 CST 2020
     */
    List<SecondWithdrawalMethod> selectByExample(SecondWithdrawalMethodExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_withdrawal_method
     *
     * @mbg.generated Thu Sep 10 17:38:46 CST 2020
     */
    SecondWithdrawalMethod selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_withdrawal_method
     *
     * @mbg.generated Thu Sep 10 17:38:46 CST 2020
     */
    int updateByExampleSelective(@Param("record") SecondWithdrawalMethod record, @Param("example") SecondWithdrawalMethodExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_withdrawal_method
     *
     * @mbg.generated Thu Sep 10 17:38:46 CST 2020
     */
    int updateByExample(@Param("record") SecondWithdrawalMethod record, @Param("example") SecondWithdrawalMethodExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_withdrawal_method
     *
     * @mbg.generated Thu Sep 10 17:38:46 CST 2020
     */
    int updateByPrimaryKeySelective(SecondWithdrawalMethod record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_withdrawal_method
     *
     * @mbg.generated Thu Sep 10 17:38:46 CST 2020
     */
    int updateByPrimaryKey(SecondWithdrawalMethod record);
}