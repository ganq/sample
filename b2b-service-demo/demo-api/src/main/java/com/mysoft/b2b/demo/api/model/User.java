package com.mysoft.b2b.demo.api.model;

import java.io.Serializable;

/**
 * 用户--数据模型
 * 
 * @author subh
 * 
 */
public class User implements Serializable {
	private static final long serialVersionUID = -5706703858155292985L;

	// 用户ID
	private String userId;

	// 用户名字
	private String userName;

	// 手机号
	private String mobile;

	// 地址
	private String address;

	// 用户所属公司
	private Company company;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String toString() {
		String userInfo = String.format("user: [userId=>%s, userName=>%s, mobile=>%s, address=>%s]", userId, userName,
				mobile, address);

		String companyInfo = null;
		if (this.getCompany() != null) {
			companyInfo = String.format("userCompany: [companyId=>%s,  companyName=>%s, address=>%s]", getCompany()
					.getCompanyId(), getCompany().getCompanyName(), getCompany().getAddress());
		} else {
			companyInfo = "userCompany: [null]";
		}

		return userInfo + companyInfo;
	}
}
