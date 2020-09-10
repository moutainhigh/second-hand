package com.example.user.center.dao;

import com.example.user.center.model.SecondOrderAddress;
import com.example.user.center.model.SecondOrderAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecondOrderAddressMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_order_address
     *
     * @mbg.generated Thu Sep 10 17:38:46 CST 2020
     */
    long countByExample(SecondOrderAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_order_address
     *
     * @mbg.generated Thu Sep 10 17:38:46 CST 2020
     */
    int deleteByExample(SecondOrderAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_order_address
     *
     * @mbg.generated Thu Sep 10 17:38:46 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_order_address
     *
     * @mbg.generated Thu Sep 10 17:38:46 CST 2020
     */
    int insert(SecondOrderAddress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_order_address
     *
     * @mbg.generated Thu Sep 10 17:38:46 CST 2020
     */
    int insertSelective(SecondOrderAddress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_order_address
     *
     * @mbg.generated Thu Sep 10 17:38:46 CST 2020
     */
    List<SecondOrderAddress> selectByExample(SecondOrderAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_order_address
     *
     * @mbg.generated Thu Sep 10 17:38:46 CST 2020
     */
    SecondOrderAddress selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_order_address
     *
     * @mbg.generated Thu Sep 10 17:38:46 CST 2020
     */
    int updateByExampleSelective(@Param("record") SecondOrderAddress record, @Param("example") SecondOrderAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_order_address
     *
     * @mbg.generated Thu Sep 10 17:38:46 CST 2020
     */
    int updateByExample(@Param("record") SecondOrderAddress record, @Param("example") SecondOrderAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_order_address
     *
     * @mbg.generated Thu Sep 10 17:38:46 CST 2020
     */
    int updateByPrimaryKeySelective(SecondOrderAddress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_order_address
     *
     * @mbg.generated Thu Sep 10 17:38:46 CST 2020
     */
    int updateByPrimaryKey(SecondOrderAddress record);
}