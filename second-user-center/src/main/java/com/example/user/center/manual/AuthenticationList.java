package com.example.user.center.manual;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author shihao
 * @Title: AuthenticationList
 * @ProjectName Second-order-center
 * @Description:
 * @date Created in
 * @Version: $
 */
public class AuthenticationList {
    /**
     * 审核id
     */
    private Integer id;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 审核名称
     */
    private String name;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * collegesName 学校名称
     */
    private String collegesName;
    /**
     * entranceTime 入学时间
     */
    private LocalDateTime entranceTime;
    /**
     * studentNumber 学号
     */
    private String studentNumber;
    /**
     * collegesRecord 学校类别
     */
    private String collegesRecord;
    /**
     * authenticationState 认证状态
     */
    private Integer authenticationState;
    /**
     * createDate 创建时间
     */
    private LocalDateTime createDate;
    /**
     * secondPicture 认证上传文件
     */
    private List<String> secondPictures;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getCollegesName() {
        return collegesName;
    }

    public void setCollegesName(String collegesName) {
        this.collegesName = collegesName;
    }

    public LocalDateTime getEntranceTime() {
        return entranceTime;
    }

    public void setEntranceTime(LocalDateTime entranceTime) {
        this.entranceTime = entranceTime;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getCollegesRecord() {
        return collegesRecord;
    }

    public void setCollegesRecord(String collegesRecord) {
        this.collegesRecord = collegesRecord;
    }

    public Integer getAuthenticationState() {
        return authenticationState;
    }

    public void setAuthenticationState(Integer authenticationState) {
        this.authenticationState = authenticationState;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public List<String> getSecondPictures() {
        return secondPictures;
    }

    public void setSecondPictures(List<String> secondPictures) {
        this.secondPictures = secondPictures;
    }

    @Override
    public String toString() {
        return "AuthenticationList{" +
                "id=" + id +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", collegesName='" + collegesName + '\'' +
                ", entranceTime=" + entranceTime +
                ", studentNumber='" + studentNumber + '\'' +
                ", collegesRecord='" + collegesRecord + '\'' +
                ", authenticationState='" + authenticationState + '\'' +
                ", createDate=" + createDate +
                ", secondPictures=" + secondPictures +
                '}';
    }
}
