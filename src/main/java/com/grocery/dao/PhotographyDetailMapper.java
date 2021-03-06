package com.grocery.dao;

import com.grocery.domain.PhotographyDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotographyDetailMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PHOTOGRAPHY_DETAIL
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PHOTOGRAPHY_DETAIL
     *
     * @mbggenerated
     */
    int insert(PhotographyDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PHOTOGRAPHY_DETAIL
     *
     * @mbggenerated
     */
    int insertSelective(PhotographyDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PHOTOGRAPHY_DETAIL
     *
     * @mbggenerated
     */
    PhotographyDetail selectByPrimaryKey(Integer id);

    List<PhotographyDetail> selectPaging(Integer pageIndex, Integer pageSize);

    Integer getCount();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PHOTOGRAPHY_DETAIL
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(PhotographyDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PHOTOGRAPHY_DETAIL
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(PhotographyDetail record);

    int updatePhotoRefIdByKey(Integer id);
}