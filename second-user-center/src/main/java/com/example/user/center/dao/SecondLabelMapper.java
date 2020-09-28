package com.example.user.center.dao;

import com.example.user.center.model.SecondLabel;
import com.example.user.center.model.SecondLabelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecondLabelMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_label
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    long countByExample(SecondLabelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_label
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    int deleteByExample(SecondLabelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_label
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_label
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    int insert(SecondLabel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_label
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    int insertSelective(SecondLabel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_label
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    List<SecondLabel> selectByExample(SecondLabelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_label
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    SecondLabel selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_label
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    int updateByExampleSelective(@Param("record") SecondLabel record, @Param("example") SecondLabelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_label
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    int updateByExample(@Param("record") SecondLabel record, @Param("example") SecondLabelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_label
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    int updateByPrimaryKeySelective(SecondLabel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_label
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    int updateByPrimaryKey(SecondLabel record);
}