package com.grocery.dao;

import com.grocery.domain.MessageBoxMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageBoxMenuMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MESSAGE_BOX_MENU
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MESSAGE_BOX_MENU
     *
     * @mbg.generated
     */
    int insert(MessageBoxMenu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MESSAGE_BOX_MENU
     *
     * @mbg.generated
     */
    int insertSelective(MessageBoxMenu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MESSAGE_BOX_MENU
     *
     * @mbg.generated
     */
    MessageBoxMenu selectByPrimaryKey(Integer id);

    List<MessageBoxMenu> selectMessageBoxMenuOrder();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MESSAGE_BOX_MENU
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(MessageBoxMenu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MESSAGE_BOX_MENU
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(MessageBoxMenu record);
}