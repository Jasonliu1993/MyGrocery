package com.grocery.serviceImpl;

import com.grocery.dao.MessageBoardMapper;
import com.grocery.domain.MessageBoard;
import com.grocery.services.MessageBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jason on 15/10/2017.
 */

@Service
public class MessageBoardServiceImpl implements MessageBoardService{

    @Autowired
    private MessageBoardMapper messageBoardMapper;

    @Override
    public List<MessageBoard> getMessageBoardByPaging(Integer pageNum, Integer pageSize) {
        return messageBoardMapper.selectPaging((pageNum - 1) * pageSize,pageSize);
    }

    @Override
    public Integer getMessageBoardCount() {
        return messageBoardMapper.getCount();
    }
}
