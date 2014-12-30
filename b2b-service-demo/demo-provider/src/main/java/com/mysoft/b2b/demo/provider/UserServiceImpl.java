package com.mysoft.b2b.demo.provider;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mysoft.b2b.demo.api.UserService;
import com.mysoft.b2b.demo.api.exception.UserServiceException;
import com.mysoft.b2b.demo.api.model.User;
import com.mysoft.b2b.demo.mapper.CompanyMapper;
import com.mysoft.b2b.demo.mapper.UserMapper;

/**
 * UserService接口的实现类,提供用户相关服务
 * 
 * @author subh
 * 
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
	@Autowired
	private UserMapper userMapper;

	@Autowired
	private CompanyMapper companyMapper;

	/**
	 * 保存用户信息
	 */
	@Transactional
	public boolean saveUser(User user) throws UserServiceException {
		logger.info("saveUser===>user:" + user.toString());
		try {
			companyMapper.saveCompany(user.getCompany());
			userMapper.saveUser(user);
			return true;
		} catch (Exception ex) {
			throw new UserServiceException("保存用户信息失败", ex);
		}
	}

	/**
	 * 获取用户信息
	 */
	public User getUser(String userId) throws UserServiceException {
		try {
			User user = userMapper.getUser(userId);
			return user;
		} catch (Exception ex) {
			throw new UserServiceException("获取用户信息失败", ex);
		}
	}

	/**
	 * 获取用户列表信息
	 */
	public List<User> getUserList() throws UserServiceException {
		return userMapper.getUserList();
	}
}