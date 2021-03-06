package com.grocery.dao;

import com.grocery.domain.MessageBoardTitleMessage;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageBoardTitleMessageMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MESSAGE_BOARD_TITLE_MESSAGE
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MESSAGE_BOARD_TITLE_MESSAGE
     *
     * @mbggenerated
     */
    int insert(MessageBoardTitleMessage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MESSAGE_BOARD_TITLE_MESSAGE
     *
     * @mbggenerated
     */
    int insertSelective(MessageBoardTitleMessage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MESSAGE_BOARD_TITLE_MESSAGE
     *
     * @mbggenerated
     */
    MessageBoardTitleMessage selectByPrimaryKey(Integer id);

    List<MessageBoardTitleMessage> selectAllHasOrder();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MESSAGE_BOARD_TITLE_MESSAGE
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(MessageBoardTitleMessage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MESSAGE_BOARD_TITLE_MESSAGE
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(MessageBoardTitleMessage record);
}