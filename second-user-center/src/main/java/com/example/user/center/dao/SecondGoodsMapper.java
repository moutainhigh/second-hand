package com.example.user.center.dao;

import com.example.user.center.model.SecondGoods;
import com.example.user.center.model.SecondGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecondGoodsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_goods
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    long countByExample(SecondGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_goods
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    int deleteByExample(SecondGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_goods
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_goods
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    int insert(SecondGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_goods
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    int insertSelective(SecondGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_goods
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    List<SecondGoods> selectByExample(SecondGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_goods
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    SecondGoods selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_goods
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    int updateByExampleSelective(@Param("record") SecondGoods record, @Param("example") SecondGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_goods
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    int updateByExample(@Param("record") SecondGoods record, @Param("example") SecondGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_goods
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    int updateByPrimaryKeySelective(SecondGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_goods
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    int updateByPrimaryKey(SecondGoods record);
}