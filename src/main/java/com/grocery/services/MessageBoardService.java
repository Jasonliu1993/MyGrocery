package com.grocery.services;

import com.grocery.domain.MessageBoard;
import com.grocery.domain.MessageBoardSubreply;
import com.grocery.domain.MessageBoardTitleMessage;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Jason on 15/10/2017.
 */
public interface MessageBoardService {
    List<MessageBoard> getMessageBoardByPaging(Integer pageNum, Integer pageSize);
    Integer getMessageBoardCount();
    void sendMessage(HttpSession session, String replyMessage);
    MessageBoard firstLoadDetailReply(String messageBoardId, String messageBoardUserId, HttpSession session);
    MessageBoardSubreply saveMessageBoardSubreply(String messageBoardId4Reply, String replyTo, String messageText, HttpSession session);
    List<MessageBoardSubreply> getMessageBoardSubreplyByPaging(Integer pageIndex, Integer pageSize,String id);
    Integer getSubReply(Integer pageSize,String id);
    List<MessageBoardTitleMessage> getAllMessageBoardTitleMessageByOrder();
}
