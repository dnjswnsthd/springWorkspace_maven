package com.service.spring.model.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.model.Employee;
import com.service.spring.model.dao.EmployeeDAO;
import com.service.spring.model.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	public int insertEmployee(Employee employee) throws SQLException {
		return employeeDAO.insertEmployee(employee);
	}

	@Override
	public ArrayList<Employee> selectEmployee() throws SQLException {
		return employeeDAO.selectEmployee();
	}

	@Override
	public Employee selectEmployeeByNum(int num) throws SQLException {
		return employeeDAO.selectEmployeeByNum(num);
	}

	@Override
	public int deleteEmployee(int num) throws SQLException {
		return employeeDAO.deleteEmployee(num);
	}

	@Override
	public int updateEmployee(Employee employee) throws SQLException {
		return employeeDAO.updateEmployee(employee);
	}

}
