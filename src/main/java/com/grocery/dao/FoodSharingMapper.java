package com.grocery.dao;

import com.grocery.domain.FoodSharing;

public interface FoodSharingMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FOOD_SHARING
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FOOD_SHARING
     *
     * @mbggenerated
     */
    int insert(FoodSharing record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FOOD_SHARING
     *
     * @mbggenerated
     */
    int insertSelective(FoodSharing record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FOOD_SHARING
     *
     * @mbggenerated
     */
    FoodSharing selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FOOD_SHARING
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(FoodSharing record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FOOD_SHARING
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(FoodSharing record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FOOD_SHARING
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(FoodSharing record);
}