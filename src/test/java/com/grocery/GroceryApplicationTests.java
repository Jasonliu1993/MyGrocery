package com.grocery;

import com.grocery.configuration.CustomProperty;
import com.grocery.dao.NavigatationMenuMapper;
import com.grocery.domain.AdminMenu;
import com.grocery.services.AdminService;
import com.grocery.services.MessageBoardService;
import com.grocery.utilities.EncryptionUtility;
import com.grocery.utilities.PaginationUtility;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GroceryApplicationTests {

	@Autowired
	private MessageBoardService messageBoardService;

	@Autowired
	private AdminService adminService;

	@Autowired
	private CustomProperty customProperty;

	@Test
	public void contextLoads() {
//        System.out.println("http://localhost:8080/error/loginFailed".contains("/error/loginFailed"));
//		messageBoardService.getMessageBoardByPaging(1,15);



//		System.out.println(3/2);
	}

	@Test
	public void testNavDao() {
//		Assert.assertEquals(navigatationMenuMapper.selectAll().get(0).getMenuItemName(),"主页");
//		Assert.assertEquals(navigatationMenuMapper.selectAll().get(0).getInterlinkage(),"/index");
        List<AdminMenu> adminMenus = adminService.getAdminMenu();
        for(AdminMenu adminMenu : adminMenus) {
            System.out.println(adminMenu.getMenuItemName());
        }
	}

	@Test
	public void testMD5() {

//		System.out.println(EncryptionUtility.encrypt4MD5("1"));
	}

	@Test
	public void getProPertise() {
		/*List<String> list = customProperty.getLoginOnly();

		for(String str : list) {
			System.out.println(str);
		}*/
	}

}
