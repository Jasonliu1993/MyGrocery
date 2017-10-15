package com.grocery.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by Jason on 15/10/2017.
 */

@Controller
@RequestMapping("/messageBoard")
public class MessageBoardController {

    @PostMapping("/reply")
    public String sendMessage(HttpSession session, String emailAddress, String replyName, String replyMessage) {
        return "message-board/message_board_index";
    }

}
