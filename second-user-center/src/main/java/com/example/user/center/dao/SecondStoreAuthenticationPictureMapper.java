package com.example.user.center.dao;

import com.example.user.center.model.SecondStoreAuthenticationPicture;
import com.example.user.center.model.SecondStoreAuthenticationPictureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecondStoreAuthenticationPictureMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store_authentication_picture
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    long countByExample(SecondStoreAuthenticationPictureExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store_authentication_picture
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    int deleteByExample(SecondStoreAuthenticationPictureExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store_authentication_picture
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store_authentication_picture
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    int insert(SecondStoreAuthenticationPicture record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store_authentication_picture
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    int insertSelective(SecondStoreAuthenticationPicture record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store_authentication_picture
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    List<SecondStoreAuthenticationPicture> selectByExample(SecondStoreAuthenticationPictureExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store_authentication_picture
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    SecondStoreAuthenticationPicture selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store_authentication_picture
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    int updateByExampleSelective(@Param("record") SecondStoreAuthenticationPicture record, @Param("example") SecondStoreAuthenticationPictureExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store_authentication_picture
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    int updateByExample(@Param("record") SecondStoreAuthenticationPicture record, @Param("example") SecondStoreAuthenticationPictureExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store_authentication_picture
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    int updateByPrimaryKeySelective(SecondStoreAuthenticationPicture record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store_authentication_picture
     *
     * @mbg.generated Fri Sep 11 17:49:54 CST 2020
     */
    int updateByPrimaryKey(SecondStoreAuthenticationPicture record);
}