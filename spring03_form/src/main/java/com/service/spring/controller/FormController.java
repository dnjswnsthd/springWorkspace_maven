package com.service.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {
	
	// 폼에 입력된 값이 Controller로 넘어올때 자동으로 바인딩 됨
	@RequestMapping("form.do")
	public ModelAndView form(HttpServletRequest request, String name, String addr) {
		/*
		 * 1. 폼값 받아서
		 * 2. VO 생성
		 * 3. Service 받아와서
		 * 4. service.registerForm() ---> dao.register() --> sqlSession.insert("mapper.addRegister");
		 * 5. ModelAndView 생성
		 */
//		String name = request.getParameter("name");
//		String addr = request.getParameter("addr");
		return new ModelAndView("/WEB-INF/views/form_result.jsp", "info", name + "님이 사는 곳은" + addr);
	}

}
