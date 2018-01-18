package com.grocery.services;

import com.grocery.dto.SimpleEmail;
import org.junit.Test;

import static org.junit.Assert.*;

public class SendEmailTest {
    @Test
    public void sendSimpleEmail() throws Exception {

        SimpleEmail simpleEmail = new SimpleEmail();
        simpleEmail.setSendFrom("jasonliupm@163.com");
        simpleEmail.setSendTo("1034928615@qq.com");
        simpleEmail.setSubject("测试");
        simpleEmail.setContent("测试");

        SendEmail.sendSimpleEmail(simpleEmail);

    }

    @Test
    public void sendHtmlEmail() throws Exception {
    }

}