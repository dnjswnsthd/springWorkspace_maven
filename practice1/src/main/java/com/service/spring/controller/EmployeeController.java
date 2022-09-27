package com.service.spring.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.service.spring.model.Employee;
import com.service.spring.model.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/moveEmployee")
	public String moveEmployee() {
		return "/employee/insert_employee";
	}
	
	
	
	@GetMapping("/moveEmployeeList")
	public String moveEmployeeList(Model model) {
		try {
			ArrayList<Employee> al = employeeService.selectEmployee();
			model.addAttribute("employee", al);
			return "/employee/select_employee";
		} catch (SQLException e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	@PostMapping("insertEmployee.do")
	public String insertEmployee(Model model, HttpServletRequest request) {
		Employee employee = new Employee(Integer.parseInt(request.getParameter("num")), request.getParameter("name"), request.getParameter("dept"));
		try {
			employeeService.insertEmployee(employee);
			model.addAttribute("num", employee.getNum());
			return "/employee/insert_success";
		} catch (SQLException e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	@GetMapping("detail.do")
	public String doDetail(Model model, Employee emp) {
		try {
			Employee employee = employeeService.selectEmployeeByNum(emp.getNum());
			model.addAttribute("employee", employee);
			return "/employee/detail_employee";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "error";
		}
	}
	
	@PostMapping("deleteEmployee.do")
	public String deleteEmployee(Model model, HttpServletRequest request) {
		int num = Integer.parseInt(request.getParameter("num"));
		try {
			employeeService.deleteEmployee(num);
			model.addAttribute("num", num);
			return "/employee/delete_success";
		} catch (SQLException e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	@PostMapping("updateEmployee.do")
	public String updateEmployee(Model model, HttpServletRequest request) {
		Employee employee = new Employee(Integer.parseInt(request.getParameter("num")), request.getParameter("name"), request.getParameter("dept"));
		int num = Integer.parseInt(request.getParameter("num"));
		try {
			employeeService.updateEmployee(employee);
			model.addAttribute("num", num);
			return "/employee/update_success";
		} catch (SQLException e) {
			e.printStackTrace();
			return "error";
		}
	}
}
