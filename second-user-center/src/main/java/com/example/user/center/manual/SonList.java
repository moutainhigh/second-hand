package com.example.user.center.manual;

/**
 * @author shihao
 * @Title: SonList
 * @ProjectName Second-order-center
 * @Description:
 * @date Created in
 * @Version: $
 */
public class SonList {
    private Integer id;//子站点id
    private Integer userId;//用户id
    private Integer collegoryId;//学校id
    private String sonName;//子站点名称
    private Integer sonBalance;//子站点余额
    private String collegoryName;//学校名称
    private Integer sonState;//子站点状态
    private String city;//城市
    private String userName;
    private String loginUserName;
    private String sonFile;

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

    public Integer getCollegoryId() {
        return collegoryId;
    }

    public void setCollegoryId(Integer collegoryId) {
        this.collegoryId = collegoryId;
    }

    public String getSonName() {
        return sonName;
    }

    public void setSonName(String sonName) {
        this.sonName = sonName;
    }

    public Integer getSonBalance() {
        return sonBalance;
    }

    public void setSonBalance(Integer sonBalance) {
        this.sonBalance = sonBalance;
    }

    public String getCollegoryName() {
        return collegoryName;
    }

    public void setCollegoryName(String collegoryName) {
        this.collegoryName = collegoryName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLoginUserName() {
        return loginUserName;
    }

    public void setLoginUserName(String loginUserName) {
        this.loginUserName = loginUserName;
    }

    public String getSonFile() {
        return sonFile;
    }

    public void setSonFile(String sonFile) {
        this.sonFile = sonFile;
    }

    public Integer getSonState() {
        return sonState;
    }

    public void setSonState(Integer sonState) {
        this.sonState = sonState;
    }
}
