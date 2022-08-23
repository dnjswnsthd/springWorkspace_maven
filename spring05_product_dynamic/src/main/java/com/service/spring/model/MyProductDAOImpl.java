package com.service.spring.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.MyProduct;

@Repository
public class MyProductDAOImpl implements MyProductDAO{
	
	public final static String NS = "ns.sql.MyProductMapper.";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int addProduct(MyProduct vo) throws Exception {
		int result = sqlSession.insert(NS+"addProduct", vo);
		return result;
	}

	@Override
	public List<MyProduct> findProductByName(String name) throws Exception {
		Map <String, String> map = new HashMap<String, String>(); 
		map.put("name", name);
		return sqlSession.selectList(NS+"findProducts", map);
		
	}

	@Override
	public List<MyProduct> findProductByMaker(String maker) throws Exception {
		Map <String, String> map = new HashMap<String, String>(); 
		map.put("maker", maker);
		return sqlSession.selectList(NS+"findProducts", map);
	}

	@Override
	public List<MyProduct> findProducts() throws Exception {
		Map <String, String> map = new HashMap<String, String>(); 
		return sqlSession.selectList(NS+"findProducts", map);
	}

	
	
}
