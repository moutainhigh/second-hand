package com.example.order.center.dao;

import com.example.order.center.model.SecondProductWant;
import com.example.order.center.model.SecondProductWantExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecondProductWantMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product_want
     *
     * @mbg.generated Fri Sep 11 16:22:40 CST 2020
     */
    long countByExample(SecondProductWantExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product_want
     *
     * @mbg.generated Fri Sep 11 16:22:40 CST 2020
     */
    int deleteByExample(SecondProductWantExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product_want
     *
     * @mbg.generated Fri Sep 11 16:22:40 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product_want
     *
     * @mbg.generated Fri Sep 11 16:22:40 CST 2020
     */
    int insert(SecondProductWant record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product_want
     *
     * @mbg.generated Fri Sep 11 16:22:40 CST 2020
     */
    int insertSelective(SecondProductWant record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product_want
     *
     * @mbg.generated Fri Sep 11 16:22:40 CST 2020
     */
    List<SecondProductWant> selectByExample(SecondProductWantExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product_want
     *
     * @mbg.generated Fri Sep 11 16:22:40 CST 2020
     */
    SecondProductWant selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product_want
     *
     * @mbg.generated Fri Sep 11 16:22:40 CST 2020
     */
    int updateByExampleSelective(@Param("record") SecondProductWant record, @Param("example") SecondProductWantExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product_want
     *
     * @mbg.generated Fri Sep 11 16:22:40 CST 2020
     */
    int updateByExample(@Param("record") SecondProductWant record, @Param("example") SecondProductWantExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product_want
     *
     * @mbg.generated Fri Sep 11 16:22:40 CST 2020
     */
    int updateByPrimaryKeySelective(SecondProductWant record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product_want
     *
     * @mbg.generated Fri Sep 11 16:22:40 CST 2020
     */
    int updateByPrimaryKey(SecondProductWant record);
}