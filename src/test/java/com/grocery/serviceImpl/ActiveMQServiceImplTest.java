package com.grocery.serviceImpl;

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

        activeMQService.sendMessage("topic","test");

    }

    @Test
    public void sendMessage1() throws Exception {
    }

}