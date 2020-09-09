package com.example.product.center.dao;

import com.example.product.center.model.SecondProductLabel;
import com.example.product.center.model.SecondProductLabelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecondProductLabelMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product_label
     *
     * @mbg.generated Wed Sep 09 09:12:19 CST 2020
     */
    long countByExample(SecondProductLabelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product_label
     *
     * @mbg.generated Wed Sep 09 09:12:19 CST 2020
     */
    int deleteByExample(SecondProductLabelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product_label
     *
     * @mbg.generated Wed Sep 09 09:12:19 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product_label
     *
     * @mbg.generated Wed Sep 09 09:12:19 CST 2020
     */
    int insert(SecondProductLabel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product_label
     *
     * @mbg.generated Wed Sep 09 09:12:19 CST 2020
     */
    int insertSelective(SecondProductLabel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product_label
     *
     * @mbg.generated Wed Sep 09 09:12:19 CST 2020
     */
    List<SecondProductLabel> selectByExample(SecondProductLabelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product_label
     *
     * @mbg.generated Wed Sep 09 09:12:19 CST 2020
     */
    SecondProductLabel selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product_label
     *
     * @mbg.generated Wed Sep 09 09:12:19 CST 2020
     */
    int updateByExampleSelective(@Param("record") SecondProductLabel record, @Param("example") SecondProductLabelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product_label
     *
     * @mbg.generated Wed Sep 09 09:12:19 CST 2020
     */
    int updateByExample(@Param("record") SecondProductLabel record, @Param("example") SecondProductLabelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product_label
     *
     * @mbg.generated Wed Sep 09 09:12:19 CST 2020
     */
    int updateByPrimaryKeySelective(SecondProductLabel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product_label
     *
     * @mbg.generated Wed Sep 09 09:12:19 CST 2020
     */
    int updateByPrimaryKey(SecondProductLabel record);
}