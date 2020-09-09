package com.example.payment.center.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SecondSlideshow implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_slideshow.id
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_slideshow.file
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    private String file;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_slideshow.file_type
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    private String fileType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_slideshow.create_date
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    private LocalDateTime createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_slideshow.modify_date
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    private LocalDateTime modifyDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_slideshow.is_deleted
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    private Byte isDeleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table second_slideshow
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_slideshow.id
     *
     * @return the value of second_slideshow.id
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_slideshow.id
     *
     * @param id the value for second_slideshow.id
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_slideshow.file
     *
     * @return the value of second_slideshow.file
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public String getFile() {
        return file;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_slideshow.file
     *
     * @param file the value for second_slideshow.file
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public void setFile(String file) {
        this.file = file == null ? null : file.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_slideshow.file_type
     *
     * @return the value of second_slideshow.file_type
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public String getFileType() {
        return fileType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_slideshow.file_type
     *
     * @param fileType the value for second_slideshow.file_type
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public void setFileType(String fileType) {
        this.fileType = fileType == null ? null : fileType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_slideshow.create_date
     *
     * @return the value of second_slideshow.create_date
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public LocalDateTime getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_slideshow.create_date
     *
     * @param createDate the value for second_slideshow.create_date
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_slideshow.modify_date
     *
     * @return the value of second_slideshow.modify_date
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public LocalDateTime getModifyDate() {
        return modifyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_slideshow.modify_date
     *
     * @param modifyDate the value for second_slideshow.modify_date
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public void setModifyDate(LocalDateTime modifyDate) {
        this.modifyDate = modifyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_slideshow.is_deleted
     *
     * @return the value of second_slideshow.is_deleted
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public Byte getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_slideshow.is_deleted
     *
     * @param isDeleted the value for second_slideshow.is_deleted
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_slideshow
     *
     * @mbg.generated Wed Sep 09 15:47:52 CST 2020
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", file=").append(file);
        sb.append(", fileType=").append(fileType);
        sb.append(", createDate=").append(createDate);
        sb.append(", modifyDate=").append(modifyDate);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}