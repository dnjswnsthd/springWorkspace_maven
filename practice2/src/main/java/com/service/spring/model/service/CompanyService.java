package com.service.spring.model.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.service.spring.model.Company;

public interface CompanyService {
	public ArrayList<Company> selectCompany() throws SQLException;
	
	public String selectVcode(String vendor);
}
