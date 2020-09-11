package com.example.product.center.dao;

import com.example.product.center.model.SecondEvaluate;
import com.example.product.center.model.SecondEvaluateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecondEvaluateMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_evaluate
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    long countByExample(SecondEvaluateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_evaluate
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    int deleteByExample(SecondEvaluateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_evaluate
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_evaluate
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    int insert(SecondEvaluate record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_evaluate
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    int insertSelective(SecondEvaluate record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_evaluate
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    List<SecondEvaluate> selectByExampleWithBLOBs(SecondEvaluateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_evaluate
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    List<SecondEvaluate> selectByExample(SecondEvaluateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_evaluate
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    SecondEvaluate selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_evaluate
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    int updateByExampleSelective(@Param("record") SecondEvaluate record, @Param("example") SecondEvaluateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_evaluate
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    int updateByExampleWithBLOBs(@Param("record") SecondEvaluate record, @Param("example") SecondEvaluateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_evaluate
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    int updateByExample(@Param("record") SecondEvaluate record, @Param("example") SecondEvaluateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_evaluate
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    int updateByPrimaryKeySelective(SecondEvaluate record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_evaluate
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    int updateByPrimaryKeyWithBLOBs(SecondEvaluate record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_evaluate
     *
     * @mbg.generated Thu Sep 10 17:38:15 CST 2020
     */
    int updateByPrimaryKey(SecondEvaluate record);
}