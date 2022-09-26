package com.service.spring.model.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.service.spring.model.Employee;
import com.service.spring.model.dao.EmployeeDAO;

@Component
public class EmployeeDAOImpl implements EmployeeDAO {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insertEmployee(Employee employee) throws SQLException {
		return sqlSession.getMapper(EmployeeDAO.class).insertEmployee(employee);
	}

	@Override
	public ArrayList<Employee> selectEmployee() throws SQLException {
		return sqlSession.getMapper(EmployeeDAO.class).selectEmployee();
	}

	@Override
	public Employee selectEmployeeByNum(int num) throws SQLException {
		return sqlSession.getMapper(EmployeeDAO.class).selectEmployeeByNum(num);
	}

	@Override
	public int deleteEmployee(int num) throws SQLException {
		return sqlSession.getMapper(EmployeeDAO.class).deleteEmployee(num);
	}

	@Override
	public int updateEmployee(Employee employee) throws SQLException {
		return sqlSession.getMapper(EmployeeDAO.class).updateEmployee(employee);
	}

}
