package com.example.user.center.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SecondAuthenticationPicture implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_authentication_picture.id
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_authentication_picture.second_authentication_id
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    private Integer secondAuthenticationId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_authentication_picture.second_picture
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    private String secondPicture;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_authentication_picture.create_date
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    private LocalDateTime createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_authentication_picture.modify_date
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    private LocalDateTime modifyDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_authentication_picture.is_deleted
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    private Byte isDeleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table second_authentication_picture
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_authentication_picture.id
     *
     * @return the value of second_authentication_picture.id
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_authentication_picture.id
     *
     * @param id the value for second_authentication_picture.id
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_authentication_picture.second_authentication_id
     *
     * @return the value of second_authentication_picture.second_authentication_id
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    public Integer getSecondAuthenticationId() {
        return secondAuthenticationId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_authentication_picture.second_authentication_id
     *
     * @param secondAuthenticationId the value for second_authentication_picture.second_authentication_id
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    public void setSecondAuthenticationId(Integer secondAuthenticationId) {
        this.secondAuthenticationId = secondAuthenticationId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_authentication_picture.second_picture
     *
     * @return the value of second_authentication_picture.second_picture
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    public String getSecondPicture() {
        return secondPicture;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_authentication_picture.second_picture
     *
     * @param secondPicture the value for second_authentication_picture.second_picture
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    public void setSecondPicture(String secondPicture) {
        this.secondPicture = secondPicture == null ? null : secondPicture.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_authentication_picture.create_date
     *
     * @return the value of second_authentication_picture.create_date
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    public LocalDateTime getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_authentication_picture.create_date
     *
     * @param createDate the value for second_authentication_picture.create_date
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_authentication_picture.modify_date
     *
     * @return the value of second_authentication_picture.modify_date
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    public LocalDateTime getModifyDate() {
        return modifyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_authentication_picture.modify_date
     *
     * @param modifyDate the value for second_authentication_picture.modify_date
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    public void setModifyDate(LocalDateTime modifyDate) {
        this.modifyDate = modifyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_authentication_picture.is_deleted
     *
     * @return the value of second_authentication_picture.is_deleted
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    public Byte getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_authentication_picture.is_deleted
     *
     * @param isDeleted the value for second_authentication_picture.is_deleted
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_authentication_picture
     *
     * @mbg.generated Fri Nov 06 14:50:25 CST 2020
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", secondAuthenticationId=").append(secondAuthenticationId);
        sb.append(", secondPicture=").append(secondPicture);
        sb.append(", createDate=").append(createDate);
        sb.append(", modifyDate=").append(modifyDate);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}