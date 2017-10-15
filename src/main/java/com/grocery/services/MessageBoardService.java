package com.grocery.services;

import com.grocery.domain.MessageBoard;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Jason on 15/10/2017.
 */
public interface MessageBoardService {
    List<MessageBoard> getMessageBoardByPaging(Integer pageNum, Integer pageSize);
    Integer getMessageBoardCount();
    void sendMessage(HttpSession session, String emailAddress, String replyName, String replyMessage);
}
