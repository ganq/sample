package com.mysoft.b2b.demo.mapper;

import org.springframework.stereotype.Component;

import com.mysoft.b2b.demo.api.model.Company;

/**
 * 公司信息Mapper
 * 
 * @author subh
 * 
 */
@Component("companyMapper")
public interface CompanyMapper {
	/**
	 * 保存公司信息
	 * 
	 * @param company
	 */
	public void saveCompany(Company company);
}
