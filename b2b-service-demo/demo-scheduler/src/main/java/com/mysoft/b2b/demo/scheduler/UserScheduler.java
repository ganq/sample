package com.mysoft.b2b.demo.scheduler;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.mysoft.b2b.demo.api.UserService;
import com.mysoft.b2b.demo.api.exception.UserServiceException;
import com.mysoft.b2b.demo.api.model.Company;
import com.mysoft.b2b.demo.api.model.User;

public class UserScheduler {
	private static final Logger logger = Logger.getLogger(UserScheduler.class);
	@Autowired
	private UserService userService;

	private Lock lock = new ReentrantLock();

	// 定时调度的方法
	public void saveUserScheduler() {
		if (lock.tryLock()) {
			logger.warn("================开始执行调度任务================");
			try {
				userService.saveUser(dumpUser());
				logger.warn("================执行调度任务结束================");
			} catch (UserServiceException ex) {
				logger.error("调度任务发生异常，异常原因：" + ex.getMessage(), ex);
			} finally {
				lock.unlock();
			}
		} else {
			logger.warn("================定时调度任务正在运行================");
		}
	}

	// 测试数据
	private User dumpUser() {
		String userId = UUID.randomUUID().toString();
		String userName = "schedulerUser" + String.format("%4d", new Random().nextInt(10000));
		String mobile = "138" + String.format("%08d", new Random().nextInt(100000000));
		String address = "schedulerUser address";

		String companyId = UUID.randomUUID().toString();
		String companyName = "schedulerUser companyName";
		String companyAddress = "schedulerUser companyAddress";

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

		logger.info("================scheduler add user data:" + user.toString());

		return user;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}