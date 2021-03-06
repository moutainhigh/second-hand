package com.example.payment.center.dao;

import com.example.payment.center.model.SecondProductPictrue;
import com.example.payment.center.model.SecondProductPictrueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecondProductPictrueMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product_pictrue
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    long countByExample(SecondProductPictrueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product_pictrue
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    int deleteByExample(SecondProductPictrueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product_pictrue
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product_pictrue
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    int insert(SecondProductPictrue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product_pictrue
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    int insertSelective(SecondProductPictrue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product_pictrue
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    List<SecondProductPictrue> selectByExample(SecondProductPictrueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product_pictrue
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    SecondProductPictrue selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product_pictrue
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    int updateByExampleSelective(@Param("record") SecondProductPictrue record, @Param("example") SecondProductPictrueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product_pictrue
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    int updateByExample(@Param("record") SecondProductPictrue record, @Param("example") SecondProductPictrueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product_pictrue
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    int updateByPrimaryKeySelective(SecondProductPictrue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product_pictrue
     *
     * @mbg.generated Mon Sep 28 10:25:30 CST 2020
     */
    int updateByPrimaryKey(SecondProductPictrue record);
}