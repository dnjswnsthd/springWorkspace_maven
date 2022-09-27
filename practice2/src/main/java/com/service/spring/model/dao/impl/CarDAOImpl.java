package com.service.spring.model.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.model.Car;
import com.service.spring.model.dao.CarDAO;

@Repository
public class CarDAOImpl implements CarDAO {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insertCar(Car car) throws SQLException {
		return sqlSession.getMapper(CarDAO.class).insertCar(car);
	}

	@Override
	public ArrayList<Car> selectCar() throws SQLException {
		return sqlSession.getMapper(CarDAO.class).selectCar();
	}

	@Override
	public Car selectCarByNum(String num) throws SQLException {
		return sqlSession.getMapper(CarDAO.class).selectCarByNum(num);
	}

	@Override
	public int deleteCar(List<String> num) throws SQLException {
		return sqlSession.getMapper(CarDAO.class).deleteCar(num);
	}

	@Override
	public int updateCar(Car car) throws SQLException {
		return sqlSession.getMapper(CarDAO.class).updateCar(car);
	}

}
