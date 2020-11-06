package com.example.user.center.dao;

import com.example.user.center.model.SecondCity;
import com.example.user.center.model.SecondCityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecondCityMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_city
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    long countByExample(SecondCityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_city
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    int deleteByExample(SecondCityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_city
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_city
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    int insert(SecondCity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_city
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    int insertSelective(SecondCity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_city
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    List<SecondCity> selectByExample(SecondCityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_city
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    SecondCity selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_city
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    int updateByExampleSelective(@Param("record") SecondCity record, @Param("example") SecondCityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_city
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    int updateByExample(@Param("record") SecondCity record, @Param("example") SecondCityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_city
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    int updateByPrimaryKeySelective(SecondCity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_city
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    int updateByPrimaryKey(SecondCity record);
}