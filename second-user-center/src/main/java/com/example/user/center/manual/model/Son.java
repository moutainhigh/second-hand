package com.example.user.center.manual.model;

/**
 * @author shihao
 * @Title: SonMapper
 * @ProjectName Second-order-center
 * @Description:
 * @date Created in
 * @Version: $
 */
public class Son {
    private Integer collegesId;//学校id
    private String collegesName;//学校名称
    private String record;//学校性质
    private String city;//城市
    private Integer cityId;//城市id

    public Integer getCollegesId() {
        return collegesId;
    }

    public void setCollegesId(Integer collegesId) {
        this.collegesId = collegesId;
    }

    public String getCollegesName() {
        return collegesName;
    }

    public void setCollegesName(String collegesName) {
        this.collegesName = collegesName;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }
}
