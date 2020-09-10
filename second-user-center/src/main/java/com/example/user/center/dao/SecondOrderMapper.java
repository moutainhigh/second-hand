package com.example.user.center.dao;

import com.example.user.center.model.SecondOrder;
import com.example.user.center.model.SecondOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecondOrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_order
     *
     * @mbg.generated Thu Sep 10 17:38:46 CST 2020
     */
    long countByExample(SecondOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_order
     *
     * @mbg.generated Thu Sep 10 17:38:46 CST 2020
     */
    int deleteByExample(SecondOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_order
     *
     * @mbg.generated Thu Sep 10 17:38:46 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_order
     *
     * @mbg.generated Thu Sep 10 17:38:46 CST 2020
     */
    int insert(SecondOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_order
     *
     * @mbg.generated Thu Sep 10 17:38:46 CST 2020
     */
    int insertSelective(SecondOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_order
     *
     * @mbg.generated Thu Sep 10 17:38:46 CST 2020
     */
    List<SecondOrder> selectByExample(SecondOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_order
     *
     * @mbg.generated Thu Sep 10 17:38:46 CST 2020
     */
    SecondOrder selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_order
     *
     * @mbg.generated Thu Sep 10 17:38:46 CST 2020
     */
    int updateByExampleSelective(@Param("record") SecondOrder record, @Param("example") SecondOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_order
     *
     * @mbg.generated Thu Sep 10 17:38:46 CST 2020
     */
    int updateByExample(@Param("record") SecondOrder record, @Param("example") SecondOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_order
     *
     * @mbg.generated Thu Sep 10 17:38:46 CST 2020
     */
    int updateByPrimaryKeySelective(SecondOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_order
     *
     * @mbg.generated Thu Sep 10 17:38:46 CST 2020
     */
    int updateByPrimaryKey(SecondOrder record);
}