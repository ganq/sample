package com.mysoft.b2b.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mysoft.b2b.demo.api.UserService;
import com.mysoft.b2b.demo.api.model.User;

@Controller
@RequestMapping("/user")
public class UserController {
	private static final Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/list", params = "format=html")
	public ModelAndView list() {
		List<User> userList = new ArrayList<User>();
		try {
			userList = userService.getUserList();
			for (User u : userList) {
				logger.info(u.toString());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("user/list");
		mav.addObject("userList", userList);
		return mav;
	}

	@RequestMapping(value = "/list", params = "format=json")
	@ResponseBody
	public List<User> listOneJson() throws Exception {
		return userService.getUserList();
	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Boolean> saveUsers(@RequestBody User user) {
		Map<String, Boolean> result = new HashMap<String, Boolean>();
		try {
			logger.info("save user data: " + user);
			userService.saveUser(user);
			result.put("success", true);
		} catch (Exception ex) {
			logger.error("fail message: " + ex.getMessage(), ex);
			result.put("success", false);
		}
		return result;
	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.GET)
	public ModelAndView saveUser() throws Exception {
		ModelAndView mav = new ModelAndView("user/form");
		mav.addObject("user", new User());
		return mav;
	}
}
