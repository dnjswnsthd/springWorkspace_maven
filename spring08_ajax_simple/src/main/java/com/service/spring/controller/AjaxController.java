package com.service.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.spring.domain.Person;

@Controller
public class AjaxController {
	@RequestMapping("/") //http://127.0.0.1:8888/spring
	public String index() {
		System.out.println("context path request... /...");
		return "redirect:index.jsp"; //interResourceResolver 랑 beanNameResolver랑 상관없음 그래서 확장자까지 써줘야한다.
	}
	
	@RequestMapping("synchro")
	public String synchro(Model model) {
		System.out.println("synchro...request...");
		model.addAttribute("info", "wha");
		
		return "synchro_result";
	}
	
	@RequestMapping("asynch")
	public String asynch(Model model) {
		System.out.println("asynch...request...");
		
		model.addAttribute("person", new Person("송원준", "부산시"));
		return "JsonView"; //beanNamewViewResovler
	} 
	
}
