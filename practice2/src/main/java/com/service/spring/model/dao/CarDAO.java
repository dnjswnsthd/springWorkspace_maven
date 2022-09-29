package com.service.spring.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.service.spring.model.Car;
import com.service.spring.model.Us;

public interface CarDAO {
	// 차량 추가
	public int insertCar(Car car) throws SQLException;
	// 차량 조회 
	public ArrayList<Car> selectCar() throws SQLException;
	// 차량 정보 상세 보기
	public Car selectCar(String num) throws SQLException;
	// 차량 삭제
	public int deleteCar(List <String> num) throws SQLException;
	// 차량 수정
	public int updateCar(Car car) throws SQLException;
	// 로그인
	public Us selectUser(Us user) throws SQLException;
}
