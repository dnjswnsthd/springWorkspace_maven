package com.service.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewResolverController {
	// BeanNameViewResolver사용
	@RequestMapping("/findBoard.do")
	public ModelAndView findBoard() {
		System.out.println("findBoard 진입");
		return new ModelAndView("board_result");
//		return new ModelAndView("board/result/find_ok.jsp");
	}

	// BeanNameViewResolver사용
	@RequestMapping("/findProduct.do")
	public ModelAndView findProduct() {
		System.out.println("findProduct 진입");
		return new ModelAndView("product_result");
//		return new ModelAndView("product/result/find_ok.jsp");
	}

	// internalResourceViewResolver 사용
	@RequestMapping("/register.do")
	public ModelAndView register() {
		System.out.println("register 진입");
		return new ModelAndView("response/register_result.jsp", "info", "internal");
	}
}
