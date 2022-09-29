package com.service.spring.model.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.model.Temp;
import com.service.spring.model.Us;
import com.service.spring.model.dao.TempDAO;
import com.service.spring.model.service.TempService;

@Service
public class TempServiceImpl implements TempService {
	@Autowired
	private TempDAO tempDAO;

	@Override
	public int insertTemp(Temp temp) throws SQLException {
		return tempDAO.insertTemp(temp);
	}

	@Override
	public ArrayList<Temp> selectTemp() throws SQLException {
		return tempDAO.selectTemp();
	}

	@Override
	public Temp selectTemp(String num) throws SQLException {
		return tempDAO.selectTemp(num);
	}

	@Override
	public int deleteTemp(List<String> num) throws SQLException {
		return tempDAO.deleteTemp(num);
	}

	@Override
	public int updateTemp(Temp temp) throws SQLException {
		return tempDAO.updateTemp(temp);
	}

	@Override
	public Us selectUser(Us user) throws SQLException {
		return tempDAO.selectUser(user);
	}

	@Override
	public int signup(Us user) throws SQLException {
		return tempDAO.signup(user);
	}

}
