package com.example.user.center.dao;

import com.example.user.center.model.SecondFile;
import com.example.user.center.model.SecondFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecondFileMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_file
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    long countByExample(SecondFileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_file
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    int deleteByExample(SecondFileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_file
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_file
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    int insert(SecondFile record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_file
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    int insertSelective(SecondFile record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_file
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    List<SecondFile> selectByExample(SecondFileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_file
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    SecondFile selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_file
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    int updateByExampleSelective(@Param("record") SecondFile record, @Param("example") SecondFileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_file
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    int updateByExample(@Param("record") SecondFile record, @Param("example") SecondFileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_file
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    int updateByPrimaryKeySelective(SecondFile record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_file
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    int updateByPrimaryKey(SecondFile record);
}