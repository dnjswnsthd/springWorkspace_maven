package com.service.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.spring.domain.Phone;
import com.service.spring.domain.UserInfo;
import com.service.spring.model.PhoneService;

@Controller
public class PhoneController {
	@Autowired
	private PhoneService phoneService;
	
	@GetMapping("/")
	public String index() {
		return "redirect:index.jsp";
	}
	
	@GetMapping("regPhone.do")
	public String getRegPhone(Model model) {
		model.addAttribute("title", "핸드폰 관리 - 핸드폰 등록 폼");
		return "PhoneReg";
	}

	@PostMapping("savePhone.do")
	public String doRegPhone(Model model, Phone phone) {
		try {
			// 성공 페이지
			phoneService.insert(phone);
			model.addAttribute("title", "핸드폰 저장 성공");
			return "Result";
		} catch (Exception e) {
			// 에러 페이지
			model.addAttribute("title", "핸드폰 저장 실패");
			return "Error";
		}
	}

	@GetMapping("searchPhone.do")
	public String doList(Model model) {
		try {
			List<Phone> list = phoneService.select();
			model.addAttribute("title", "핸드폰 목록 불러오기 성공");
			model.addAttribute("phones", list);
			return "PhoneList";
		} catch (Exception e) {
			model.addAttribute("title", "핸드폰 목록 불러오기 실패");
			model.addAttribute("message", "문제 내용 - 폰 목록 조회중 에러 발생");
			return "Error";
		}
	}

	@GetMapping("detail.do")
	public String doDetail(Model model, Phone phone) {
		try {
			Phone selected = phoneService.select(phone);
			model.addAttribute("title", "핸드폰 상세조회");
			model.addAttribute("phone", selected);
			return "PhoneView";
		} catch (Exception e) {
			model.addAttribute("title", "핸드폰 목록 불러오기 실패");
			model.addAttribute("message", "문제 내용 - 폰 상세 조회중 에러 발생");
			return "Error";
		}
	}
	
	@PostMapping("deleteAjax.do")
	@ResponseBody
	public String doAjaxDelete(@RequestParam List<String> num, Model model) {
		List <String> temp = new ArrayList<String>();
		try {
			// 성공 페이지
			for(String n : num) temp.add(n);
			phoneService.delete(temp);
			return "";
		} catch (Exception e) {
			// 에러 페이지
			model.addAttribute("title", "핸드폰 관리 - 에러");
			model.addAttribute("message", "문제 내용 - 폰 삭제 중 에러 발생");
			return "Error";
		}
	}
	
	@GetMapping("login.do")
	public String getLoginForm() {
		return "Login";
	}
	
	@PostMapping("login.do")
	public String doLogin(UserInfo user, Model model, HttpSession session) {
		try {
			UserInfo selected = phoneService.select(user);
			if(selected != null) {
				session.setAttribute("loginUser", selected);
				return "redirect:searchPhone.do";
			}else {
				return "login";
			}
		}catch(Exception e) {
			model.addAttribute("title", "로그인 - 에러");
			model.addAttribute("message", "문제 내용 - 로그인 중 에러 발생");
			return "Error";
		}
	}
}
