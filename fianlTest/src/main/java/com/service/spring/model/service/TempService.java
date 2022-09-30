package com.service.spring.model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.service.spring.model.Temp;
import com.service.spring.model.Us;

public interface TempService {
	// 차량 추가
	public int insertTemp(Temp temp) throws SQLException;
	// 차량 조회 
	public ArrayList<Temp> selectTemp() throws SQLException;
	// 차량 정보 상세 보기
	public Temp selectTemp(String num) throws SQLException;
	// 차량 삭제
	public int deleteTemp(List <String> num) throws SQLException;
	// 차량 수정
	public int updateTemp(Temp temp) throws SQLException;
	// 로그인
	public Us selectUser(Us user) throws SQLException;
	// 회원가입
	public int signup(Us user) throws SQLException;
}
