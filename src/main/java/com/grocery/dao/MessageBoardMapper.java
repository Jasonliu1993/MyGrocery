package com.grocery.dao;

import com.grocery.domain.MessageBoard;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageBoardMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MESSAGE_BOARD
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MESSAGE_BOARD
     *
     * @mbggenerated
     */
    int insert(MessageBoard record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MESSAGE_BOARD
     *
     * @mbggenerated
     */
    int insertSelective(MessageBoard record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MESSAGE_BOARD
     *
     * @mbggenerated
     */
    MessageBoard selectByPrimaryKey(Integer id);

    List<MessageBoard> selectPaging(Integer pageIndex, Integer pageSize);

    Integer getCount();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MESSAGE_BOARD
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(MessageBoard record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MESSAGE_BOARD
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(MessageBoard record);
}