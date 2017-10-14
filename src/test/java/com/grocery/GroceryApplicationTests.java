package com.grocery;

import com.grocery.dao.NavigatationMenuMapper;
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
	}

	@Test
	public void testNavDao() {
//		Assert.assertEquals(navigatationMenuMapper.selectAll().get(0).getMenuItemName(),"主页");
//		Assert.assertEquals(navigatationMenuMapper.selectAll().get(0).getInterlinkage(),"/index");

		PaginationUtility paginationUtility = new PaginationUtility("17","4","/photography","17","1");
		paginationUtility.getBarList();
//		System.out.println(paginationUtility);
//		for (int i = 0; i < paginationUtility.getBarList().size();i++) {
//			System.out.println("Size: " + paginationUtility.getBarList().size());
//			System.out.println(paginationUtility.getBarList().get(i));
//		}
//		System.out.println(paginationUtility.getPreButton());
//		System.out.println(paginationUtility.getPostButton());
	}

}
