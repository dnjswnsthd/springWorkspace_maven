package com.service.spring.model.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.model.Car;
import com.service.spring.model.Product;
import com.service.spring.model.UserInfo;
import com.service.spring.model.dao.ProductDAO;

@Repository
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insertProduct(Product product) throws SQLException {
		return sqlSession.getMapper(ProductDAO.class).insertProduct(product);
	}

	@Override
	public ArrayList<Product> selectProduct() throws SQLException {
		return sqlSession.getMapper(ProductDAO.class).selectProduct();
	}

	@Override
	public int deleteProduct(String code) throws SQLException {
		return sqlSession.getMapper(ProductDAO.class).deleteProduct(code);
	}

	@Override
	public int updateCar(Car car) throws SQLException {
		return sqlSession.getMapper(ProductDAO.class).updateCar(car);
	}

	@Override
	public UserInfo selectUser(UserInfo user) throws SQLException {
		return sqlSession.getMapper(ProductDAO.class).selectUser(user);
	}

	@Override
	public int signup(UserInfo user) throws SQLException {
		return sqlSession.getMapper(ProductDAO.class).signup(user);
	}

	@Override
	public ArrayList<Product> selectProduct(Product product) throws SQLException {
		return sqlSession.getMapper(ProductDAO.class).selectProduct(product);
	}

}
