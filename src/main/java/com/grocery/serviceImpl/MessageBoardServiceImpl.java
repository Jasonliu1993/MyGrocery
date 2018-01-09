package com.grocery.serviceImpl;

import com.grocery.messageHandler.CoreSender;
import com.grocery.messageHandler.MessageFromType;
import com.grocery.dao.*;
import com.grocery.domain.MessageBoard;
import com.grocery.domain.MessageBoardSubreply;
import com.grocery.domain.MessageBoardTitleMessage;
import com.grocery.domain.SystemUser;
import com.grocery.configuration.CustomProperty;
import com.grocery.services.MessageBoardService;
import com.grocery.utilities.ApplicationContextUtility;
import com.grocery.utilities.DateUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Jason on 15/10/2017.
 */

@Service
public class MessageBoardServiceImpl implements MessageBoardService{

    @Autowired
    private MessageBoardMapper messageBoardMapper;

    @Autowired
    private MessageBoardSubreplyMapper messageBoardSubreplyMapper;

    @Autowired
    private PersonalInfoMapper personalInfoMapper;

    @Autowired
    private CustomProperty customProperty;

    @Autowired
    private SystemUserMapper systemUserMapper;

    @Autowired
    private MessageBoardTitleMessageMapper messageBoardTitleMessageMapper;

    @Override
    public List<MessageBoard> getMessageBoardByPaging(Integer pageNum, Integer pageSize) {

        List<MessageBoard> messageBoards = messageBoardMapper.selectPaging((pageNum - 1) * pageSize,pageSize);

        for(MessageBoard messageBoard : messageBoards) {
            messageBoard.setAvator(personalInfoMapper.selectByUserId(messageBoard.getUserid()).getAvator());
        }

        return messageBoards;
    }

    @Override
    public Integer getMessageBoardCount() {
        return messageBoardMapper.getCount();
    }

    /**
     * 给留言板留言
     * @param replyMessage 回复内容
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public void sendMessage(HttpSession session, String replyMessage) {
        MessageBoard messageBoard = new MessageBoard();
        SystemUser systemUser = (SystemUser) session.getAttribute("User");

        messageBoard.setVersion(1);
        messageBoard.setAvator(personalInfoMapper.selectByPrimaryKey(systemUser.getId()).getAvator());
        messageBoard.setContent(replyMessage);
        messageBoard.setCreateDatetime(DateUtility.getCurrentDate());
        messageBoard.setEmail(systemUser.getEmail());
        messageBoard.setUserid(systemUser.getId());
        messageBoard.setUserName(systemUser.getUserName());

        messageBoardMapper.insertSelective(messageBoard);
    }

    @Override
    public MessageBoard firstLoadDetailReply(String messageBoardId, String messageBoardUserId, HttpSession session) {
        MessageBoard messageBoard = messageBoardMapper.selectByPrimaryKey(Integer.valueOf(messageBoardId));

        List<MessageBoardSubreply> messageBoardSubreplies = messageBoardSubreplyMapper.selectpaging(0,Integer.valueOf(customProperty.getSubReply()),messageBoardId);

        for (MessageBoardSubreply messageBoardSubreply : messageBoardSubreplies) {
            /**
             * 获取头像的ID
             */
            messageBoardSubreply.setCustom1(personalInfoMapper.selectByPrimaryKey(messageBoardSubreply.getUserid()).getAvator().toString());
        }

        messageBoard.setMessageBoardSubreply(messageBoardSubreplies);
        Integer subReplyCount = messageBoardSubreplyMapper.getCountByMessageBoardId(messageBoardId);
        if ( subReplyCount <= Integer.valueOf(customProperty.getSubReply())) {
            /**
             * 如果自回复的数量小于这个话题下的总数，则不需要显示下一页，则将custom1
             */
            messageBoard.setCustom1("N");
        } else {
            messageBoard.setCustom1("Y");
        }


        return messageBoard;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public MessageBoardSubreply saveMessageBoardSubreply(String messageBoardId4Reply, String replyTo, String messageText, HttpSession session) {
        MessageBoardSubreply messageBoardSubreply = new MessageBoardSubreply();
        SystemUser replyToUser = null;

        messageBoardSubreply.setVersion(1);
        messageBoardSubreply.setUserid(((SystemUser)session.getAttribute("User")).getId());
        messageBoardSubreply.setUserName(((SystemUser)session.getAttribute("User")).getUserName());
        messageBoardSubreply.setEmail(((SystemUser)session.getAttribute("User")).getEmail());
        messageBoardSubreply.setContent(messageText);
        if (!"".equals(replyTo)) {
            messageBoardSubreply.setReplyUserId(Integer.valueOf(replyTo));

            replyToUser = systemUserMapper.selectByPrimaryKey(Integer.valueOf(replyTo));

            messageBoardSubreply.setReplyUserName(replyToUser.getUserName());


        }
        messageBoardSubreply.setParentRefId(Integer.valueOf(messageBoardId4Reply));
        messageBoardSubreply.setCreateDatetime(DateUtility.getCurrentDate());

        messageBoardSubreplyMapper.insertSelective(messageBoardSubreply);

        messageBoardSubreply.setCustom1(personalInfoMapper.selectByPrimaryKey(messageBoardSubreply.getUserid()).getAvator().toString());

        CoreSender coreSender = (CoreSender) ApplicationContextUtility.getBean("coreSender");

        if (replyToUser == null) {
            replyToUser = systemUserMapper.selectByPrimaryKey(messageBoardMapper.selectByPrimaryKey(Integer.valueOf(messageBoardId4Reply)).getUserid());
        }

        coreSender.send((SystemUser)session.getAttribute("User"),replyToUser,messageText, MessageFromType.MESSAGE_BOARD_SUBREPLY);

        return messageBoardSubreply;
    }

    @Override
    public List<MessageBoardSubreply> getMessageBoardSubreplyByPaging(Integer pageIndex, Integer pageSize, String id) {
        List<MessageBoardSubreply> messageBoardSubreplies = messageBoardSubreplyMapper.selectpaging((pageIndex - 1) * pageSize,pageSize,id);

        for (MessageBoardSubreply messageBoardSubreply : messageBoardSubreplies) {
            /**
             * 获取头像的ID
             */
            messageBoardSubreply.setCustom1(personalInfoMapper.selectByPrimaryKey(messageBoardSubreply.getUserid()).getAvator().toString());
        }

        return messageBoardSubreplies;
    }

    @Override
    public Integer getSubReply(Integer pageSize, String id) {

        return messageBoardSubreplyMapper.getCountByMessageBoardId(id) / pageSize + 1;
    }

    @Override
    public List<MessageBoardTitleMessage> getAllMessageBoardTitleMessageByOrder() {
        return messageBoardTitleMessageMapper.selectAllHasOrder();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public void deleteMessageBoardTitleMessageByOrder(Integer id) {
        messageBoardTitleMessageMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public MessageBoardTitleMessage updateMessageBoardTitleMessage(Integer id, String content, Integer orderNum) {

        MessageBoardTitleMessage messageBoardTitleMessage = new MessageBoardTitleMessage();

        messageBoardTitleMessage.setId(id);
        messageBoardTitleMessage.setContent(content);
        messageBoardTitleMessage.setOrderNum(orderNum);
        messageBoardTitleMessage.setCreateDatetime(DateUtility.getCurrentDate());
        messageBoardTitleMessage.setVersion(messageBoardTitleMessageMapper.selectByPrimaryKey(id).getVersion() + 1);

        messageBoardTitleMessageMapper.updateByPrimaryKey(messageBoardTitleMessage);

        return messageBoardTitleMessage;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public MessageBoardTitleMessage insertMessageBoardTitleMessage(String content, Integer orderNum) {

        MessageBoardTitleMessage messageBoardTitleMessage = new MessageBoardTitleMessage();

        messageBoardTitleMessage.setVersion(1);
        messageBoardTitleMessage.setContent(content);
        messageBoardTitleMessage.setOrderNum(orderNum);
        messageBoardTitleMessage.setCreateDatetime(DateUtility.getCurrentDate());

        messageBoardTitleMessageMapper.insertSelective(messageBoardTitleMessage);


        return messageBoardTitleMessage;
    }
}
