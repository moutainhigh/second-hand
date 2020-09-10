package com.example.user.center.dao;

import com.example.user.center.model.SecondAttention;
import com.example.user.center.model.SecondAttentionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecondAttentionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_attention
     *
     * @mbg.generated Thu Sep 10 17:38:46 CST 2020
     */
    long countByExample(SecondAttentionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_attention
     *
     * @mbg.generated Thu Sep 10 17:38:46 CST 2020
     */
    int deleteByExample(SecondAttentionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_attention
     *
     * @mbg.generated Thu Sep 10 17:38:46 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_attention
     *
     * @mbg.generated Thu Sep 10 17:38:46 CST 2020
     */
    int insert(SecondAttention record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_attention
     *
     * @mbg.generated Thu Sep 10 17:38:46 CST 2020
     */
    int insertSelective(SecondAttention record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_attention
     *
     * @mbg.generated Thu Sep 10 17:38:46 CST 2020
     */
    List<SecondAttention> selectByExample(SecondAttentionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_attention
     *
     * @mbg.generated Thu Sep 10 17:38:46 CST 2020
     */
    SecondAttention selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_attention
     *
     * @mbg.generated Thu Sep 10 17:38:46 CST 2020
     */
    int updateByExampleSelective(@Param("record") SecondAttention record, @Param("example") SecondAttentionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_attention
     *
     * @mbg.generated Thu Sep 10 17:38:46 CST 2020
     */
    int updateByExample(@Param("record") SecondAttention record, @Param("example") SecondAttentionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_attention
     *
     * @mbg.generated Thu Sep 10 17:38:46 CST 2020
     */
    int updateByPrimaryKeySelective(SecondAttention record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_attention
     *
     * @mbg.generated Thu Sep 10 17:38:46 CST 2020
     */
    int updateByPrimaryKey(SecondAttention record);
}