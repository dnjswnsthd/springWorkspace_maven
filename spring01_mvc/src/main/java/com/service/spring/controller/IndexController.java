package com.service.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class IndexController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * 1. 폼값 받아서
		 * 2. vo 생성
		 * 3. DAO 주입
		 * 4. DAO 메소드 호출...
		 * 5. 결과값 바인딩
		 * 6. ModelAndView 리턴
		 */
		return new ModelAndView("result", "message", "Hello Spring Maven~!!");
	}

}
