package com.service.spring.model.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.model.Car;
import com.service.spring.model.dao.CarDAO;
import com.service.spring.model.service.CarService;

@Service
public class CarServiceImpl implements CarService {
	@Autowired
	private CarDAO carDAO;

	@Override
	public int insertCar(Car car) throws SQLException {
		return carDAO.insertCar(car);
	}

	@Override
	public ArrayList<Car> selectCar() throws SQLException {
		return carDAO.selectCar();
	}

	@Override
	public Car selectCar(String num) throws SQLException {
		return carDAO.selectCar(num);
	}

	@Override
	public int deleteCar(List<String> num) throws SQLException {
		return carDAO.deleteCar(num);
	}

	@Override
	public int updateCar(Car car) throws SQLException {
		return carDAO.updateCar(car);
	}

}
