package com.example.product.center.dao;

import com.example.product.center.model.SecondStore;
import com.example.product.center.model.SecondStoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecondStoreMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store
     *
     * @mbg.generated Mon Sep 14 14:07:18 CST 2020
     */
    long countByExample(SecondStoreExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store
     *
     * @mbg.generated Mon Sep 14 14:07:18 CST 2020
     */
    int deleteByExample(SecondStoreExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store
     *
     * @mbg.generated Mon Sep 14 14:07:18 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store
     *
     * @mbg.generated Mon Sep 14 14:07:18 CST 2020
     */
    int insert(SecondStore record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store
     *
     * @mbg.generated Mon Sep 14 14:07:18 CST 2020
     */
    int insertSelective(SecondStore record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store
     *
     * @mbg.generated Mon Sep 14 14:07:18 CST 2020
     */
    List<SecondStore> selectByExample(SecondStoreExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store
     *
     * @mbg.generated Mon Sep 14 14:07:18 CST 2020
     */
    SecondStore selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store
     *
     * @mbg.generated Mon Sep 14 14:07:18 CST 2020
     */
    int updateByExampleSelective(@Param("record") SecondStore record, @Param("example") SecondStoreExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store
     *
     * @mbg.generated Mon Sep 14 14:07:18 CST 2020
     */
    int updateByExample(@Param("record") SecondStore record, @Param("example") SecondStoreExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store
     *
     * @mbg.generated Mon Sep 14 14:07:18 CST 2020
     */
    int updateByPrimaryKeySelective(SecondStore record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store
     *
     * @mbg.generated Mon Sep 14 14:07:18 CST 2020
     */
    int updateByPrimaryKey(SecondStore record);
}