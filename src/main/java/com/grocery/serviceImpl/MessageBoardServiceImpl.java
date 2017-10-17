package com.grocery.serviceImpl;

import com.grocery.dao.MessageBoardMapper;
import com.grocery.dao.PersonalInfoMapper;
import com.grocery.domain.MessageBoard;
import com.grocery.domain.SystemUser;
import com.grocery.services.MessageBoardService;
import com.grocery.utilities.DateUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private PersonalInfoMapper personalInfoMapper;

    @Override
    public List<MessageBoard> getMessageBoardByPaging(Integer pageNum, Integer pageSize) {
        return messageBoardMapper.selectPaging((pageNum - 1) * pageSize,pageSize);
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
}
