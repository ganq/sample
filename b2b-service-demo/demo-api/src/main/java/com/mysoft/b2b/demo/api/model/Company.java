package com.mysoft.b2b.demo.api.model;

import java.io.Serializable;

/**
 * 公司--数据模型
 * 
 * @author subh
 * 
 */
public class Company implements Serializable {
	private static final long serialVersionUID = 540864472697999015L;

	// 公司ID
	private String companyId;

	// 公司名字
	private String companyName;

	// 公司地址
	private String address;

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
