package com.mysoft.b2b.demo.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mysoft.b2b.demo.api.model.User;

/**
 * 用户信息的Mapper
 * 
 * @author subh
 * 
 */
@Component("userMapper")
public interface UserMapper {
	/**
	 * 保存用户信息
	 * 
	 * @param user
	 */
	public void saveUser(User user);

	/**
	 * 获取用户信息
	 * 
	 * @param userId
	 * @return
	 */
	public User getUser(String userId);

	/**
	 * 获取用户列表信息
	 * 
	 * @return
	 */
	public List<User> getUserList();
}
