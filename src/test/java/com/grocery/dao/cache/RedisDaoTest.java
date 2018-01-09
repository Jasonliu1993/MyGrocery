package com.grocery.dao.cache;

import com.grocery.configuration.RedisConfiguration;
import com.grocery.dao.NavigatationMenuMapper;
import com.grocery.domain.NavigatationMenu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
/*
@WebAppConfiguration
@ComponentScan(basePackages = {"com.grocery"})
@MapperScan(value = "com.grocery.dao")
@ContextConfiguration(classes = {RedisConfiguration.class})*/
//@TestPropertySource("classpath:application.yml")
public class RedisDaoTest {

    @Autowired
    private NavigatationMenuMapper navigatationMenuMapper;

    @Autowired
    private RedisDao redisDao;

    @Test
    public void putNavigatationMenu() throws Exception {

        List<NavigatationMenu> navigatationMenus = navigatationMenuMapper.selectAll();
        redisDao.putNavigatationMenu(navigatationMenus);

    }

    @Test
    public void getNavigatationMenus() throws Exception {

        System.out.println(redisDao.getNavigatationMenus());

    }

}