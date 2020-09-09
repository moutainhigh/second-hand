package com.example.payment.center.dao;

import com.example.payment.center.model.SecondStoreBalanceDetail;
import com.example.payment.center.model.SecondStoreBalanceDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecondStoreBalanceDetailMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store_balance_detail
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    long countByExample(SecondStoreBalanceDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store_balance_detail
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    int deleteByExample(SecondStoreBalanceDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store_balance_detail
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store_balance_detail
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    int insert(SecondStoreBalanceDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store_balance_detail
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    int insertSelective(SecondStoreBalanceDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store_balance_detail
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    List<SecondStoreBalanceDetail> selectByExample(SecondStoreBalanceDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store_balance_detail
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    SecondStoreBalanceDetail selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store_balance_detail
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    int updateByExampleSelective(@Param("record") SecondStoreBalanceDetail record, @Param("example") SecondStoreBalanceDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store_balance_detail
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    int updateByExample(@Param("record") SecondStoreBalanceDetail record, @Param("example") SecondStoreBalanceDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store_balance_detail
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    int updateByPrimaryKeySelective(SecondStoreBalanceDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store_balance_detail
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    int updateByPrimaryKey(SecondStoreBalanceDetail record);
}