package com.example.product.center.dao;

import com.example.product.center.model.SecondAuth;
import com.example.product.center.model.SecondAuthExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecondAuthMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_auth
     *
     * @mbg.generated Wed Sep 09 09:12:19 CST 2020
     */
    long countByExample(SecondAuthExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_auth
     *
     * @mbg.generated Wed Sep 09 09:12:19 CST 2020
     */
    int deleteByExample(SecondAuthExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_auth
     *
     * @mbg.generated Wed Sep 09 09:12:19 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_auth
     *
     * @mbg.generated Wed Sep 09 09:12:19 CST 2020
     */
    int insert(SecondAuth record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_auth
     *
     * @mbg.generated Wed Sep 09 09:12:19 CST 2020
     */
    int insertSelective(SecondAuth record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_auth
     *
     * @mbg.generated Wed Sep 09 09:12:19 CST 2020
     */
    List<SecondAuth> selectByExample(SecondAuthExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_auth
     *
     * @mbg.generated Wed Sep 09 09:12:19 CST 2020
     */
    SecondAuth selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_auth
     *
     * @mbg.generated Wed Sep 09 09:12:19 CST 2020
     */
    int updateByExampleSelective(@Param("record") SecondAuth record, @Param("example") SecondAuthExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_auth
     *
     * @mbg.generated Wed Sep 09 09:12:19 CST 2020
     */
    int updateByExample(@Param("record") SecondAuth record, @Param("example") SecondAuthExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_auth
     *
     * @mbg.generated Wed Sep 09 09:12:19 CST 2020
     */
    int updateByPrimaryKeySelective(SecondAuth record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_auth
     *
     * @mbg.generated Wed Sep 09 09:12:19 CST 2020
     */
    int updateByPrimaryKey(SecondAuth record);
}