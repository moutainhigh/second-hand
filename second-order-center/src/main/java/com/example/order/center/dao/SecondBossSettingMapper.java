package com.example.order.center.dao;

import com.example.order.center.model.SecondBossSetting;
import com.example.order.center.model.SecondBossSettingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecondBossSettingMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_boss_setting
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    long countByExample(SecondBossSettingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_boss_setting
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    int deleteByExample(SecondBossSettingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_boss_setting
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_boss_setting
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    int insert(SecondBossSetting record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_boss_setting
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    int insertSelective(SecondBossSetting record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_boss_setting
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    List<SecondBossSetting> selectByExampleWithBLOBs(SecondBossSettingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_boss_setting
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    List<SecondBossSetting> selectByExample(SecondBossSettingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_boss_setting
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    SecondBossSetting selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_boss_setting
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    int updateByExampleSelective(@Param("record") SecondBossSetting record, @Param("example") SecondBossSettingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_boss_setting
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    int updateByExampleWithBLOBs(@Param("record") SecondBossSetting record, @Param("example") SecondBossSettingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_boss_setting
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    int updateByExample(@Param("record") SecondBossSetting record, @Param("example") SecondBossSettingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_boss_setting
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    int updateByPrimaryKeySelective(SecondBossSetting record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_boss_setting
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    int updateByPrimaryKeyWithBLOBs(SecondBossSetting record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_boss_setting
     *
     * @mbg.generated Fri Sep 18 10:25:11 CST 2020
     */
    int updateByPrimaryKey(SecondBossSetting record);
}