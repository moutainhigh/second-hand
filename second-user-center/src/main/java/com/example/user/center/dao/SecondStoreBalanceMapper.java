package com.example.user.center.dao;

import com.example.user.center.model.SecondStoreBalance;
import com.example.user.center.model.SecondStoreBalanceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecondStoreBalanceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store_balance
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    long countByExample(SecondStoreBalanceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store_balance
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    int deleteByExample(SecondStoreBalanceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store_balance
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store_balance
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    int insert(SecondStoreBalance record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store_balance
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    int insertSelective(SecondStoreBalance record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store_balance
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    List<SecondStoreBalance> selectByExample(SecondStoreBalanceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store_balance
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    SecondStoreBalance selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store_balance
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    int updateByExampleSelective(@Param("record") SecondStoreBalance record, @Param("example") SecondStoreBalanceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store_balance
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    int updateByExample(@Param("record") SecondStoreBalance record, @Param("example") SecondStoreBalanceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store_balance
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    int updateByPrimaryKeySelective(SecondStoreBalance record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store_balance
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    int updateByPrimaryKey(SecondStoreBalance record);
}