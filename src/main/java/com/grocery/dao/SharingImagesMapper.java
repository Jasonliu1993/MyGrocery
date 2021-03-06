package com.grocery.dao;

import com.grocery.domain.SharingImages;
import org.springframework.stereotype.Repository;

@Repository
public interface SharingImagesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SHARING_IMAGES
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SHARING_IMAGES
     *
     * @mbggenerated
     */
    int insert(SharingImages record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SHARING_IMAGES
     *
     * @mbggenerated
     */
    int insertSelective(SharingImages record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SHARING_IMAGES
     *
     * @mbggenerated
     */
    SharingImages selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SHARING_IMAGES
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SharingImages record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SHARING_IMAGES
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(SharingImages record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SHARING_IMAGES
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(SharingImages record);
}