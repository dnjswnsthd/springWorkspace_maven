package com.service.spring.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.service.spring.model.Employee;

public interface EmployeeDAO {
	// 사원 추가
	public int insertEmployee(Employee employee) throws SQLException;
	// 사원 목록 조회 
	public ArrayList<Employee> selectEmployee() throws SQLException;
	// 사원 정보 상세 보기
	public Employee selectEmployeeByNum(int num) throws SQLException;
	// 사원 삭제
	public int deleteEmployee(int num) throws SQLException;
	// 사원 수정
	public int updateEmployee(Employee employee) throws SQLException;
}
