package com.grocery;

import com.grocery.dao.NavigatationMenuMapper;
import com.grocery.utilities.EncryptionUtility;
import com.grocery.utilities.PaginationUtility;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GroceryApplicationTests {

	@Autowired
	private NavigatationMenuMapper navigatationMenuMapper;

	@Test
	public void contextLoads() {
        System.out.println("http://localhost:8080/error/loginFailed".contains("/error/loginFailed"));

	}

	@Test
	public void testNavDao() {
//		Assert.assertEquals(navigatationMenuMapper.selectAll().get(0).getMenuItemName(),"主页");
//		Assert.assertEquals(navigatationMenuMapper.selectAll().get(0).getInterlinkage(),"/index");

	}

	@Test
	public void testMD5() {

//		System.out.println(EncryptionUtility.encrypt4MD5("1"));
	}

}
