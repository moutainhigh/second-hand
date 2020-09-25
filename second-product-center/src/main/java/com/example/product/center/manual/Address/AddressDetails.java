package com.example.product.center.manual.Address;

import java.util.List;

/**
 * @author shihao
 * @Title: AddressDetails
 * @ProjectName Second-order-center
 * @Description: 地址
 * @date Created in
 * @Version: $
 */
public class AddressDetails {
    private String title;
    private List<AddressLocation> location;
    private List<AddressAdInfo> ad_info;
    private List<AddressComponents> address_components;
    private Double similarity;
    private Integer deviation;
    private Integer reliability;
    private Integer level;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<AddressLocation> getLocation() {
        return location;
    }

    public void setLocation(List<AddressLocation> location) {
        this.location = location;
    }

    public List<AddressAdInfo> getAd_info() {
        return ad_info;
    }

    public void setAd_info(List<AddressAdInfo> ad_info) {
        this.ad_info = ad_info;
    }

    public List<AddressComponents> getAddress_components() {
        return address_components;
    }

    public void setAddress_components(List<AddressComponents> address_components) {
        this.address_components = address_components;
    }

    public Double getSimilarity() {
        return similarity;
    }

    public void setSimilarity(Double similarity) {
        this.similarity = similarity;
    }

    public Integer getDeviation() {
        return deviation;
    }

    public void setDeviation(Integer deviation) {
        this.deviation = deviation;
    }

    public Integer getReliability() {
        return reliability;
    }

    public void setReliability(Integer reliability) {
        this.reliability = reliability;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
