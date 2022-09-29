package com.service.spring.model.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.model.Temp;
import com.service.spring.model.Us;
import com.service.spring.model.dao.TempDAO;

@Repository
public class TempDAOImpl implements TempDAO {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insertTemp(Temp temp) throws SQLException {
		return sqlSession.getMapper(TempDAO.class).insertTemp(temp);
	}

	@Override
	public ArrayList<Temp> selectTemp() throws SQLException {
		return sqlSession.getMapper(TempDAO.class).selectTemp();
	}

	@Override
	public Temp selectTemp(String num) throws SQLException {
		return sqlSession.getMapper(TempDAO.class).selectTemp(num);
	}

	@Override
	public int deleteTemp(List<String> num) throws SQLException {
		return sqlSession.getMapper(TempDAO.class).deleteTemp(num);
	}

	@Override
	public int updateTemp(Temp temp) throws SQLException {
		return sqlSession.getMapper(TempDAO.class).updateTemp(temp);
	}

	@Override
	public Us selectUser(Us user) throws SQLException {
		return sqlSession.getMapper(TempDAO.class).selectUser(user);
	}

	@Override
	public int signup(Us user) throws SQLException {
		return sqlSession.getMapper(TempDAO.class).signup(user);
	}

}
