package com.service.spring.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.service.spring.model.Company;

public interface CompanyDAO {
	public ArrayList<Company> selectCompany() throws SQLException;
	
	public String selectVcode(String vendor);
}
