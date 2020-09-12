package com.example.product.center.dao;

import com.example.product.center.model.SecondStoreAddress;
import com.example.product.center.model.SecondStoreAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecondStoreAddressMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store_address
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    long countByExample(SecondStoreAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store_address
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    int deleteByExample(SecondStoreAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store_address
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store_address
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    int insert(SecondStoreAddress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store_address
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    int insertSelective(SecondStoreAddress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store_address
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    List<SecondStoreAddress> selectByExample(SecondStoreAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store_address
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    SecondStoreAddress selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store_address
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    int updateByExampleSelective(@Param("record") SecondStoreAddress record, @Param("example") SecondStoreAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store_address
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    int updateByExample(@Param("record") SecondStoreAddress record, @Param("example") SecondStoreAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store_address
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    int updateByPrimaryKeySelective(SecondStoreAddress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store_address
     *
     * @mbg.generated Fri Sep 11 17:34:23 CST 2020
     */
    int updateByPrimaryKey(SecondStoreAddress record);
}