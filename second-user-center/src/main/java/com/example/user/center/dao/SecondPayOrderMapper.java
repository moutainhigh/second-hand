package com.example.user.center.dao;

import com.example.user.center.model.SecondPayOrder;
import com.example.user.center.model.SecondPayOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecondPayOrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_pay_order
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    long countByExample(SecondPayOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_pay_order
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    int deleteByExample(SecondPayOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_pay_order
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_pay_order
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    int insert(SecondPayOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_pay_order
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    int insertSelective(SecondPayOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_pay_order
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    List<SecondPayOrder> selectByExample(SecondPayOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_pay_order
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    SecondPayOrder selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_pay_order
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    int updateByExampleSelective(@Param("record") SecondPayOrder record, @Param("example") SecondPayOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_pay_order
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    int updateByExample(@Param("record") SecondPayOrder record, @Param("example") SecondPayOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_pay_order
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    int updateByPrimaryKeySelective(SecondPayOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_pay_order
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    int updateByPrimaryKey(SecondPayOrder record);
}