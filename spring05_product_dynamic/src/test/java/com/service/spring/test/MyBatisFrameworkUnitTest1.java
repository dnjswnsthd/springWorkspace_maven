package com.service.spring.test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.service.spring.domain.MyProduct;

public class MyBatisFrameworkUnitTest1 {

	public static void main(String[] args) throws Exception {
		// 1. 설정문서를 DIContainer가 읽어들여야 한다.
		System.out.println("=======111");
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		System.out.println("=======222");
		// 2. r을 SqlSessiongFactory에서
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		System.out.println("=======333");
		// 3. SqlSession
		SqlSession session = factory.openSession();
		
		System.out.println("==== 1. addProduct ====\n");
		
		MyProduct vo = new MyProduct("드럼 세탁기", "대우", 530000);
		
		int result = session.insert("ns.sql.MyProductMapper.addProduct", vo);
		
		session.commit(); // 반드시 잊지말자~!~!
		
		System.out.println(result + " 개 상품 추가 성공^^");
		
	}

}
