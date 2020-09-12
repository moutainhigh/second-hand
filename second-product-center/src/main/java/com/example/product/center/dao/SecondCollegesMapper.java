package com.example.product.center.dao;

import com.example.product.center.model.SecondColleges;
import com.example.product.center.model.SecondCollegesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecondCollegesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_colleges
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    long countByExample(SecondCollegesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_colleges
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    int deleteByExample(SecondCollegesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_colleges
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_colleges
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    int insert(SecondColleges record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_colleges
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    int insertSelective(SecondColleges record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_colleges
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    List<SecondColleges> selectByExample(SecondCollegesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_colleges
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    SecondColleges selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_colleges
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    int updateByExampleSelective(@Param("record") SecondColleges record, @Param("example") SecondCollegesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_colleges
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    int updateByExample(@Param("record") SecondColleges record, @Param("example") SecondCollegesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_colleges
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    int updateByPrimaryKeySelective(SecondColleges record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_colleges
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    int updateByPrimaryKey(SecondColleges record);
}