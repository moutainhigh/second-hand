package com.example.user.center.dao;

import com.example.user.center.model.SecondMessage;
import com.example.user.center.model.SecondMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecondMessageMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_message
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    long countByExample(SecondMessageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_message
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    int deleteByExample(SecondMessageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_message
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_message
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    int insert(SecondMessage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_message
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    int insertSelective(SecondMessage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_message
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    List<SecondMessage> selectByExampleWithBLOBs(SecondMessageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_message
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    List<SecondMessage> selectByExample(SecondMessageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_message
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    SecondMessage selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_message
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    int updateByExampleSelective(@Param("record") SecondMessage record, @Param("example") SecondMessageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_message
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    int updateByExampleWithBLOBs(@Param("record") SecondMessage record, @Param("example") SecondMessageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_message
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    int updateByExample(@Param("record") SecondMessage record, @Param("example") SecondMessageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_message
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    int updateByPrimaryKeySelective(SecondMessage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_message
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    int updateByPrimaryKeyWithBLOBs(SecondMessage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_message
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    int updateByPrimaryKey(SecondMessage record);
}