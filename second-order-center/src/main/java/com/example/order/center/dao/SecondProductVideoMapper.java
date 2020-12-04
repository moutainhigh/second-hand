package com.example.order.center.dao;

import com.example.order.center.model.SecondProductVideo;
import com.example.order.center.model.SecondProductVideoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecondProductVideoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product_video
     *
     * @mbg.generated Fri Dec 04 10:43:03 CST 2020
     */
    long countByExample(SecondProductVideoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product_video
     *
     * @mbg.generated Fri Dec 04 10:43:03 CST 2020
     */
    int deleteByExample(SecondProductVideoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product_video
     *
     * @mbg.generated Fri Dec 04 10:43:03 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product_video
     *
     * @mbg.generated Fri Dec 04 10:43:03 CST 2020
     */
    int insert(SecondProductVideo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product_video
     *
     * @mbg.generated Fri Dec 04 10:43:03 CST 2020
     */
    int insertSelective(SecondProductVideo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product_video
     *
     * @mbg.generated Fri Dec 04 10:43:03 CST 2020
     */
    List<SecondProductVideo> selectByExample(SecondProductVideoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product_video
     *
     * @mbg.generated Fri Dec 04 10:43:03 CST 2020
     */
    SecondProductVideo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product_video
     *
     * @mbg.generated Fri Dec 04 10:43:03 CST 2020
     */
    int updateByExampleSelective(@Param("record") SecondProductVideo record, @Param("example") SecondProductVideoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product_video
     *
     * @mbg.generated Fri Dec 04 10:43:03 CST 2020
     */
    int updateByExample(@Param("record") SecondProductVideo record, @Param("example") SecondProductVideoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product_video
     *
     * @mbg.generated Fri Dec 04 10:43:03 CST 2020
     */
    int updateByPrimaryKeySelective(SecondProductVideo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_product_video
     *
     * @mbg.generated Fri Dec 04 10:43:03 CST 2020
     */
    int updateByPrimaryKey(SecondProductVideo record);
}