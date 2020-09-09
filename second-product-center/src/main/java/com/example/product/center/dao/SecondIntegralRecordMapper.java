package com.example.product.center.dao;

import com.example.product.center.model.SecondIntegralRecord;
import com.example.product.center.model.SecondIntegralRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecondIntegralRecordMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_integral_record
     *
     * @mbg.generated Wed Sep 09 09:12:19 CST 2020
     */
    long countByExample(SecondIntegralRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_integral_record
     *
     * @mbg.generated Wed Sep 09 09:12:19 CST 2020
     */
    int deleteByExample(SecondIntegralRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_integral_record
     *
     * @mbg.generated Wed Sep 09 09:12:19 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_integral_record
     *
     * @mbg.generated Wed Sep 09 09:12:19 CST 2020
     */
    int insert(SecondIntegralRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_integral_record
     *
     * @mbg.generated Wed Sep 09 09:12:19 CST 2020
     */
    int insertSelective(SecondIntegralRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_integral_record
     *
     * @mbg.generated Wed Sep 09 09:12:19 CST 2020
     */
    List<SecondIntegralRecord> selectByExample(SecondIntegralRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_integral_record
     *
     * @mbg.generated Wed Sep 09 09:12:19 CST 2020
     */
    SecondIntegralRecord selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_integral_record
     *
     * @mbg.generated Wed Sep 09 09:12:19 CST 2020
     */
    int updateByExampleSelective(@Param("record") SecondIntegralRecord record, @Param("example") SecondIntegralRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_integral_record
     *
     * @mbg.generated Wed Sep 09 09:12:19 CST 2020
     */
    int updateByExample(@Param("record") SecondIntegralRecord record, @Param("example") SecondIntegralRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_integral_record
     *
     * @mbg.generated Wed Sep 09 09:12:19 CST 2020
     */
    int updateByPrimaryKeySelective(SecondIntegralRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_integral_record
     *
     * @mbg.generated Wed Sep 09 09:12:19 CST 2020
     */
    int updateByPrimaryKey(SecondIntegralRecord record);
}