package com.example.user.center.dao;

import com.example.user.center.model.SecondAuthenticationPicture;
import com.example.user.center.model.SecondAuthenticationPictureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecondAuthenticationPictureMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_authentication_picture
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    long countByExample(SecondAuthenticationPictureExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_authentication_picture
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    int deleteByExample(SecondAuthenticationPictureExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_authentication_picture
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_authentication_picture
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    int insert(SecondAuthenticationPicture record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_authentication_picture
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    int insertSelective(SecondAuthenticationPicture record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_authentication_picture
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    List<SecondAuthenticationPicture> selectByExample(SecondAuthenticationPictureExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_authentication_picture
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    SecondAuthenticationPicture selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_authentication_picture
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    int updateByExampleSelective(@Param("record") SecondAuthenticationPicture record, @Param("example") SecondAuthenticationPictureExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_authentication_picture
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    int updateByExample(@Param("record") SecondAuthenticationPicture record, @Param("example") SecondAuthenticationPictureExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_authentication_picture
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    int updateByPrimaryKeySelective(SecondAuthenticationPicture record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_authentication_picture
     *
     * @mbg.generated Mon Sep 28 14:26:56 CST 2020
     */
    int updateByPrimaryKey(SecondAuthenticationPicture record);
}