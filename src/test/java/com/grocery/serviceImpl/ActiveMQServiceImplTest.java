package com.grocery.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.grocery.dto.EmailSendType;
import com.grocery.dto.SimpleEmail;
import com.grocery.services.ActiveMQService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ActiveMQServiceImplTest {

    @Autowired
    private ActiveMQService activeMQService;

    @Test
    public void sendMessage() throws Exception {


        SimpleEmail simpleEmail = new SimpleEmail();

        simpleEmail.setSendFrom("jasonliupm@163.com");
        simpleEmail.setSendTo("1034928615@qq.com");
        simpleEmail.setSubject("吃饭");
        simpleEmail.setContent("明天一起吃饭吧！");
        EmailSendType<SimpleEmail> emailEmailSendType = new EmailSendType<>();
        emailEmailSendType.setEmailType("SimplyEmail");
        emailEmailSendType.setIncludAttachment(false);
        emailEmailSendType.setData(simpleEmail);

        activeMQService.sendMessage(ActiveMQType.TOPIC, JSON.toJSONString(emailEmailSendType));

    }

    @Test
    public void sendMessage1() throws Exception {
    }

}