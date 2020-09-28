package com.example.payment.center.dao;

import com.example.payment.center.model.SecondEvaluateFile;
import com.example.payment.center.model.SecondEvaluateFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecondEvaluateFileMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_evaluate_file
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    long countByExample(SecondEvaluateFileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_evaluate_file
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    int deleteByExample(SecondEvaluateFileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_evaluate_file
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_evaluate_file
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    int insert(SecondEvaluateFile record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_evaluate_file
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    int insertSelective(SecondEvaluateFile record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_evaluate_file
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    List<SecondEvaluateFile> selectByExample(SecondEvaluateFileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_evaluate_file
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    SecondEvaluateFile selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_evaluate_file
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    int updateByExampleSelective(@Param("record") SecondEvaluateFile record, @Param("example") SecondEvaluateFileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_evaluate_file
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    int updateByExample(@Param("record") SecondEvaluateFile record, @Param("example") SecondEvaluateFileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_evaluate_file
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    int updateByPrimaryKeySelective(SecondEvaluateFile record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_evaluate_file
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    int updateByPrimaryKey(SecondEvaluateFile record);
}