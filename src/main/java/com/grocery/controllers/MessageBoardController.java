package com.grocery.controllers;

import com.grocery.domain.Message;
import com.grocery.services.MessageBoardService;
import com.grocery.utilities.PackingInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Jason on 15/10/2017.
 */

@Controller
@RequestMapping("/messageBoard")
public class MessageBoardController {

    @Autowired
    private MessageBoardService messageBoardService;

    @PostMapping("/leaveMessage")
    public void sendMessage(HttpSession session, String replyMessage, HttpServletResponse response) throws IOException {
        messageBoardService.sendMessage(session, replyMessage);

        response.sendRedirect("/messageBoard/1");
    }

    @PostMapping("/loadReplyDetail")
    @ResponseBody
    public Message loadReplyDetail(String messageBoardId, String messageBoardUserId, HttpSession session) {
        return PackingInfo.changeData2Message(messageBoardService.firstLoadDetailReply(messageBoardId, messageBoardUserId, session));
    }

}
