package com.example.payment.center.dao;

import com.example.payment.center.model.SecondCategory;
import com.example.payment.center.model.SecondCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecondCategoryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_category
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    long countByExample(SecondCategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_category
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    int deleteByExample(SecondCategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_category
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_category
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    int insert(SecondCategory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_category
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    int insertSelective(SecondCategory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_category
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    List<SecondCategory> selectByExample(SecondCategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_category
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    SecondCategory selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_category
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    int updateByExampleSelective(@Param("record") SecondCategory record, @Param("example") SecondCategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_category
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    int updateByExample(@Param("record") SecondCategory record, @Param("example") SecondCategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_category
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    int updateByPrimaryKeySelective(SecondCategory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_category
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    int updateByPrimaryKey(SecondCategory record);
}