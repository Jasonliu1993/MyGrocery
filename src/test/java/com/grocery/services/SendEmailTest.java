package com.grocery.services;

import com.grocery.dto.EmailResponseMessage;
import com.grocery.dto.SimpleEmail;
import com.grocery.messageHandler.SendEmail;
import org.junit.Test;

public class SendEmailTest {
    @Test
    public void sendSimpleEmail() throws Exception {

        SimpleEmail simpleEmail = new SimpleEmail();
        simpleEmail.setSendFrom("jasonliupm@163.com");
        simpleEmail.setSendTo("1034928615@qq.com");
        simpleEmail.setSubject("明天吃饭");
        simpleEmail.setContent("明天吃饭嘛？");


        EmailResponseMessage emailResponseMessage = SendEmail.sendSimpleEmail(simpleEmail);
        System.out.println(emailResponseMessage.getDetailMessage());
        System.out.println(emailResponseMessage.getMessage());
        System.out.println(emailResponseMessage.getData());

    }

    @Test
    public void sendHtmlEmail() throws Exception {

    }

}