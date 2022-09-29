package com.service.spring.model.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.model.Company;
import com.service.spring.model.dao.CompanyDAO;
import com.service.spring.model.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyDAO companyDAO;
	
	@Override
	public ArrayList<Company> selectCompany() throws SQLException {
		return companyDAO.selectCompany();
	}

	@Override
	public String selectVcode(String vendor) {
		return companyDAO.selectVcode(vendor);
	}
}
