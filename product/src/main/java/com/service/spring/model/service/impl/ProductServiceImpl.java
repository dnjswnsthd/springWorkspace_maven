package com.service.spring.model.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.model.Car;
import com.service.spring.model.Product;
import com.service.spring.model.UserInfo;
import com.service.spring.model.dao.ProductDAO;
import com.service.spring.model.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDAO productDAO;

	@Override
	public int insertProduct(Product product) throws SQLException {
		return productDAO.insertProduct(product);
	}

	@Override
	public ArrayList<Product> selectProduct() throws SQLException {
		return productDAO.selectProduct();
	}

	@Override
	public int deleteProduct(String code) throws SQLException {
		return productDAO.deleteProduct(code);
	}

	@Override
	public int updateCar(Car product) throws SQLException {
		return productDAO.updateCar(product);
	}

	@Override
	public UserInfo selectUser(UserInfo user) throws SQLException {
		return productDAO.selectUser(user);
	}

	@Override
	public int signup(UserInfo user) throws SQLException {
		return productDAO.signup(user);
	}

	@Override
	public ArrayList<Product> selectProduct(Product product) throws SQLException {
		return productDAO.selectProduct(product);
	}

}
