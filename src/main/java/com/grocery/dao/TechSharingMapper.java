package com.grocery.dao;

import com.grocery.domain.TechSharing;

public interface TechSharingMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TECH_SHARING
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TECH_SHARING
     *
     * @mbggenerated
     */
    int insert(TechSharing record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TECH_SHARING
     *
     * @mbggenerated
     */
    int insertSelective(TechSharing record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TECH_SHARING
     *
     * @mbggenerated
     */
    TechSharing selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TECH_SHARING
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(TechSharing record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TECH_SHARING
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(TechSharing record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TECH_SHARING
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(TechSharing record);
}