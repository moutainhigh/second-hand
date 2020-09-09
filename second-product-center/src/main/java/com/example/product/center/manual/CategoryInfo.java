package com.example.product.center.manual;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author shihao
 * @Title: CategoryInfo
 * @ProjectName Second-order-center
 * @Description: 分类一级的列表
 * @date Created in
 * @Version: $
 */
public class CategoryInfo {
    private static final long serialVersionUID = -8286142101647864914L;

    private Integer id;
    private String name;
    private Integer level;
    private String fileId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;
    private List<CategoryInfo> categories;
    public List<CategoryInfo> getCategories() {
        return categories;
    }
    public void setCategories(List<CategoryInfo> categories) {
        this.categories = categories;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String hfName) {
        this.name = hfName;
    }
    public Integer getLevel() {
        return level;
    }
    public void setLevel(Integer level) {
        this.level = level;
    }
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    public LocalDateTime getDate() {
        return date;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    public String getFileId() {
        return fileId;
    }
    public void setFileId(String fileId) {
        this.fileId = fileId;
    }
}
