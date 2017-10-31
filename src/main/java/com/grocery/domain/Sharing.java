package com.grocery.domain;

/**
 * Created by Jason on 31/10/2017.
 */
public abstract class Sharing {

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TECH_SHARING.ID
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TECH_SHARING.VERSION
     *
     * @mbggenerated
     */
    private Integer version;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TECH_SHARING.TYPE
     *
     * @mbggenerated
     */
    private String type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TECH_SHARING.TITLE
     *
     * @mbggenerated
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TECH_SHARING.COMMENTS
     *
     * @mbggenerated
     */
    private String comments;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TECH_SHARING.CREATE_DATETIME
     *
     * @mbggenerated
     */
    private String createDatetime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TECH_SHARING.CUSTOM1
     *
     * @mbggenerated
     */
    private String custom1;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TECH_SHARING.CUSTOM2
     *
     * @mbggenerated
     */
    private String custom2;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TECH_SHARING.CUSTOM3
     *
     * @mbggenerated
     */
    private String custom3;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TECH_SHARING.CUSTOM4
     *
     * @mbggenerated
     */
    private String custom4;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TECH_SHARING.CUSTOM5
     *
     * @mbggenerated
     */
    private String custom5;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TECH_SHARING.CONTENT
     *
     * @mbggenerated
     */
    private byte[] content;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TECH_SHARING.ID
     *
     * @return the value of TECH_SHARING.ID
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TECH_SHARING.ID
     *
     * @param id the value for TECH_SHARING.ID
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TECH_SHARING.VERSION
     *
     * @return the value of TECH_SHARING.VERSION
     *
     * @mbggenerated
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TECH_SHARING.VERSION
     *
     * @param version the value for TECH_SHARING.VERSION
     *
     * @mbggenerated
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TECH_SHARING.TYPE
     *
     * @return the value of TECH_SHARING.TYPE
     *
     * @mbggenerated
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TECH_SHARING.TYPE
     *
     * @param type the value for TECH_SHARING.TYPE
     *
     * @mbggenerated
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TECH_SHARING.TITLE
     *
     * @return the value of TECH_SHARING.TITLE
     *
     * @mbggenerated
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TECH_SHARING.TITLE
     *
     * @param title the value for TECH_SHARING.TITLE
     *
     * @mbggenerated
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TECH_SHARING.COMMENTS
     *
     * @return the value of TECH_SHARING.COMMENTS
     *
     * @mbggenerated
     */
    public String getComments() {
        return comments;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TECH_SHARING.COMMENTS
     *
     * @param comments the value for TECH_SHARING.COMMENTS
     *
     * @mbggenerated
     */
    public void setComments(String comments) {
        this.comments = comments == null ? null : comments.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TECH_SHARING.CREATE_DATETIME
     *
     * @return the value of TECH_SHARING.CREATE_DATETIME
     *
     * @mbggenerated
     */
    public String getCreateDatetime() {
        return createDatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TECH_SHARING.CREATE_DATETIME
     *
     * @param createDatetime the value for TECH_SHARING.CREATE_DATETIME
     *
     * @mbggenerated
     */
    public void setCreateDatetime(String createDatetime) {
        this.createDatetime = createDatetime == null ? null : createDatetime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TECH_SHARING.CUSTOM1
     *
     * @return the value of TECH_SHARING.CUSTOM1
     *
     * @mbggenerated
     */
    public String getCustom1() {
        return custom1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TECH_SHARING.CUSTOM1
     *
     * @param custom1 the value for TECH_SHARING.CUSTOM1
     *
     * @mbggenerated
     */
    public void setCustom1(String custom1) {
        this.custom1 = custom1 == null ? null : custom1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TECH_SHARING.CUSTOM2
     *
     * @return the value of TECH_SHARING.CUSTOM2
     *
     * @mbggenerated
     */
    public String getCustom2() {
        return custom2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TECH_SHARING.CUSTOM2
     *
     * @param custom2 the value for TECH_SHARING.CUSTOM2
     *
     * @mbggenerated
     */
    public void setCustom2(String custom2) {
        this.custom2 = custom2 == null ? null : custom2.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TECH_SHARING.CUSTOM3
     *
     * @return the value of TECH_SHARING.CUSTOM3
     *
     * @mbggenerated
     */
    public String getCustom3() {
        return custom3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TECH_SHARING.CUSTOM3
     *
     * @param custom3 the value for TECH_SHARING.CUSTOM3
     *
     * @mbggenerated
     */
    public void setCustom3(String custom3) {
        this.custom3 = custom3 == null ? null : custom3.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TECH_SHARING.CUSTOM4
     *
     * @return the value of TECH_SHARING.CUSTOM4
     *
     * @mbggenerated
     */
    public String getCustom4() {
        return custom4;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TECH_SHARING.CUSTOM4
     *
     * @param custom4 the value for TECH_SHARING.CUSTOM4
     *
     * @mbggenerated
     */
    public void setCustom4(String custom4) {
        this.custom4 = custom4 == null ? null : custom4.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TECH_SHARING.CUSTOM5
     *
     * @return the value of TECH_SHARING.CUSTOM5
     *
     * @mbggenerated
     */
    public String getCustom5() {
        return custom5;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TECH_SHARING.CUSTOM5
     *
     * @param custom5 the value for TECH_SHARING.CUSTOM5
     *
     * @mbggenerated
     */
    public void setCustom5(String custom5) {
        this.custom5 = custom5 == null ? null : custom5.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TECH_SHARING.CONTENT
     *
     * @return the value of TECH_SHARING.CONTENT
     *
     * @mbggenerated
     */
    public byte[] getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TECH_SHARING.CONTENT
     *
     * @param content the value for TECH_SHARING.CONTENT
     *
     * @mbggenerated
     */
    public void setContent(byte[] content) {
        this.content = content;
    }

}
