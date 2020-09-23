package com.example.user.center.dao;

import com.example.user.center.model.SecondChat;
import com.example.user.center.model.SecondChatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecondChatMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_chat
     *
     * @mbg.generated Wed Sep 23 11:44:57 CST 2020
     */
    long countByExample(SecondChatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_chat
     *
     * @mbg.generated Wed Sep 23 11:44:57 CST 2020
     */
    int deleteByExample(SecondChatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_chat
     *
     * @mbg.generated Wed Sep 23 11:44:57 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_chat
     *
     * @mbg.generated Wed Sep 23 11:44:57 CST 2020
     */
    int insert(SecondChat record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_chat
     *
     * @mbg.generated Wed Sep 23 11:44:57 CST 2020
     */
    int insertSelective(SecondChat record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_chat
     *
     * @mbg.generated Wed Sep 23 11:44:57 CST 2020
     */
    List<SecondChat> selectByExampleWithBLOBs(SecondChatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_chat
     *
     * @mbg.generated Wed Sep 23 11:44:57 CST 2020
     */
    List<SecondChat> selectByExample(SecondChatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_chat
     *
     * @mbg.generated Wed Sep 23 11:44:57 CST 2020
     */
    SecondChat selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_chat
     *
     * @mbg.generated Wed Sep 23 11:44:57 CST 2020
     */
    int updateByExampleSelective(@Param("record") SecondChat record, @Param("example") SecondChatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_chat
     *
     * @mbg.generated Wed Sep 23 11:44:57 CST 2020
     */
    int updateByExampleWithBLOBs(@Param("record") SecondChat record, @Param("example") SecondChatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_chat
     *
     * @mbg.generated Wed Sep 23 11:44:57 CST 2020
     */
    int updateByExample(@Param("record") SecondChat record, @Param("example") SecondChatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_chat
     *
     * @mbg.generated Wed Sep 23 11:44:57 CST 2020
     */
    int updateByPrimaryKeySelective(SecondChat record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_chat
     *
     * @mbg.generated Wed Sep 23 11:44:57 CST 2020
     */
    int updateByPrimaryKeyWithBLOBs(SecondChat record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_chat
     *
     * @mbg.generated Wed Sep 23 11:44:57 CST 2020
     */
    int updateByPrimaryKey(SecondChat record);
}