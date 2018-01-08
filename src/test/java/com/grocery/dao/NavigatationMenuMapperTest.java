package com.grocery.dao;

import com.grocery.GroceryApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(
        classes = GroceryApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT
)
@DirtiesContext
public class NavigatationMenuMapperTest {

    @Autowired
    private NavigatationMenuMapper navigatationMenuMapper;

    @Test
    public void deleteByPrimaryKey1() throws Exception {
    }

    @Test
    public void insert() throws Exception {
    }

    @Test
    public void insertSelective() throws Exception {
    }

    @Test
    public void selectByPrimaryKey() throws Exception {
    }

    @Test
    public void selectAll() throws Exception {

        navigatationMenuMapper.selectAll();

    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {
    }

    @Test
    public void updateByPrimaryKey() throws Exception {
    }

    @Test
    public void deleteByPrimaryKey() throws Exception {
    }

}