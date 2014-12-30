package com.mysoft.b2b.demo.provider;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mysoft.b2b.demo.api.UserService;
import com.mysoft.b2b.demo.api.exception.UserServiceException;
import com.mysoft.b2b.demo.api.model.Company;
import com.mysoft.b2b.demo.api.model.User;
import com.mysoft.b2b.demo.test.BaseTestCase;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest extends BaseTestCase {
	private static final Logger logger = Logger.getLogger(UserServiceTest.class);

	@Autowired
	private UserService userService;

	@Test
	public void testGetUserList() throws UserServiceException {
		List<User> userList = userService.getUserList();
		for (User user : userList) {
			logger.info("========>" + user.toString());
		}
	}

	@Test
	public void testSaveUser() {
		logger.info("================testSaveUser()=======================");
		String userId = UUID.randomUUID().toString();
		String userName = "testUser";
		String mobile = "138" + String.format("%08d", new Random().nextInt(100000000));
		String address = "address";

		String companyId = UUID.randomUUID().toString();
		String companyName = "companyName";
		String companyAddress = "companyAddress";

		// 用户
		User user = new User();
		user.setUserId(userId);
		user.setUserName(userName);
		user.setMobile(mobile);
		user.setAddress(address);

		// 用户公司
		Company company = new Company();
		company.setCompanyId(companyId);
		company.setCompanyName(companyName);
		company.setAddress(companyAddress);

		// 设置用户公司
		user.setCompany(company);

		logger.info("================" + user.toString());

		try {
			userService.saveUser(user);
			Assert.assertTrue(true);
			logger.info("保存用户成功!");
		} catch (UserServiceException ex) {
			ex.printStackTrace();
			Assert.assertTrue(false);
			logger.error("保存用户失败!");
		}
	}
}
