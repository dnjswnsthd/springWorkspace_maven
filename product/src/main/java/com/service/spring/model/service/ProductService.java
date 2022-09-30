package com.service.spring.model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.service.spring.model.Car;
import com.service.spring.model.Product;
import com.service.spring.model.UserInfo;

public interface ProductService {
	// 상품 추가
	public int insertProduct(Product product) throws SQLException;
	// 차량 조회 
	public ArrayList<Product> selectProduct() throws SQLException;
	// 차량 삭제
	public int deleteProduct(String code) throws SQLException;
	// 차량 수정
	public int updateCar(Car car) throws SQLException;
	// 로그인
	public UserInfo selectUser(UserInfo user) throws SQLException;
	// 회원가입
	public int signup(UserInfo user) throws SQLException;
	// 검색
	public ArrayList<Product> selectProduct(Product product) throws SQLException;
}
