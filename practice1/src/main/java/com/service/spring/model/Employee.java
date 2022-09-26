package com.service.spring.model;

public class Employee {
	private int num;
	private String name;
	private String dept;

	public Employee() {
		super();
	}

	public Employee(int num, String name, String dept) {
		super();
		this.num = num;
		this.name = name;
		this.dept = dept;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee [num=" + num + ", name=" + name + ", dept=" + dept + "]";
	}

}
