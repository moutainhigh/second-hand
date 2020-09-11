package com.example.user.center.dao;

import com.example.user.center.model.SecondProduct;
import com.example.user.center.model.SecondProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecondProductMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    long countByExample(SecondProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    int deleteByExample(SecondProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    int insert(SecondProduct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    int insertSelective(SecondProduct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    List<SecondProduct> selectByExample(SecondProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    SecondProduct selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    int updateByExampleSelective(@Param("record") SecondProduct record, @Param("example") SecondProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    int updateByExample(@Param("record") SecondProduct record, @Param("example") SecondProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    int updateByPrimaryKeySelective(SecondProduct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    int updateByPrimaryKey(SecondProduct record);
}