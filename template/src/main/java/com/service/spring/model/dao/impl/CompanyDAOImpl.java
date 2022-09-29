package com.service.spring.model.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.model.Company;
import com.service.spring.model.dao.TempDAO;
import com.service.spring.model.dao.CompanyDAO;

@Repository
public class CompanyDAOImpl implements CompanyDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public ArrayList<Company> selectCompany() throws SQLException {
		return sqlSession.getMapper(CompanyDAO.class).selectCompany();
	}

}
