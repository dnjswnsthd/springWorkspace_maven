package com.service.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.service.spring.model.Temp;
import com.service.spring.model.Company;
import com.service.spring.model.Us;
import com.service.spring.model.service.TempService;
import com.service.spring.model.service.CompanyService;
@Controller
public class TempController {
	@Autowired
	private TempService tempService;
	@Autowired
	private CompanyService companyService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/moveTemp")
	public String moveTemp(Model model) throws Exception {
		try {
			ArrayList <Company> al = companyService.selectCompany();
			model.addAttribute("list", al);
			return "/temp/insert_temp";
		} catch (Exception e) {
			throw new Exception("회사 목록 조회에 실패했습니다.");
		}
	}
	
	@GetMapping("/moveTempList")
	public String moveTempList(Model model) throws Exception {
		try {
			ArrayList<Temp> al = tempService.selectTemp();
			model.addAttribute("temp", al);
			return "/temp/select_temp";
		} catch (Exception e) {
			throw new Exception("차량 목록 조회에 실패했습니다.");
		}
	}
	
	@GetMapping("/moveSignup")
	public String moveSignup() throws Exception {
		return "signup";
	}
	
	@GetMapping("/moveLogin")
	public String moveLogin() throws Exception {
		return "login";
	}
	
	@PostMapping("insertTemp.do")
	public String insertTemp(Model model, Temp temp, RedirectAttributes ra) throws Exception {
		try {
			tempService.insertTemp(temp);
			ra.addAttribute("title", "추가 성공");
			ra.addAttribute("num", temp.getNum());
			return "redirect:/success";
		} catch (Exception e) {
			throw new Exception("차량 추가에 실패했습니다.(중복 or 데이터 누락)");
		}
	}
	
	@GetMapping("/success")
	public String moveInsertSuccess(@RequestParam("num") String num, @RequestParam("title") String title, Model model) {
		model.addAttribute("title", title);
		model.addAttribute("num", num);
		return "/temp/success";
	}
	
	@PostMapping("deleteTemp.do")
	@ResponseBody
	public String deleteTemp(@RequestParam List<String> num, Model model) throws Exception {
		List <String> temp = new ArrayList<String>();
		try {
			for(String n : num) temp.add(n);
			tempService.deleteTemp(temp);
			return "";
		} catch (Exception e) {
			throw new Exception("차량 삭제에 실패했습니다.");
		}
	}
	
	// 동적 쿼리로 수정
	@GetMapping("detail.do")
	public String detailTemp(Model model, Temp temp) throws Exception {
		try {
			ArrayList <Company> al = companyService.selectCompany();
			model.addAttribute("list", al);
			Temp tmp = tempService.selectTemp(temp.getNum());
			model.addAttribute("temp", tmp);
			System.out.println(tmp);
			return "/temp/detail_temp";
		} catch (Exception e) {
			throw new Exception("차량 상세 조회에 실패했습니다.");
		}
	}
	
	@PostMapping("updateTemp.do")
	public String updateTemp(Model model, Temp temp, RedirectAttributes ra) throws Exception {
		try {
			tempService.updateTemp(temp);
			ra.addAttribute("title", "수정 성공");
			ra.addAttribute("num", temp.getNum());
			return "redirect:/success";
		} catch (Exception e) {
			throw new Exception("차량 정보 수정에 실패했습니다.");
		}
	}
	
	@PostMapping("login.do")
	public String doLogin(Us user, Model model, HttpSession session) throws Exception {
		try {
			Us tmp = tempService.selectUser(user);
			if(tmp != null) {
				session.setAttribute("user", user);
				return "redirect:/moveTempList";
			}else {
				return "login";
			}
		}catch(Exception e) {
			throw new Exception("로그인 실패");
		}
	}
	
	@GetMapping("logout.do")
	public String doLogout(HttpSession session) throws Exception{
		session.invalidate();
		return "redirect:/";
	}
	
	@PostMapping("signup.do")
	public String doSignup(Us user) throws Exception {
		try {
			System.out.println(user);
			tempService.signup(user);
			return "redirect:/moveLogin";
		}catch(Exception e) {
			throw new Exception("회원가입 실패(id 중복)");
		}
	}
	
	@ExceptionHandler(Exception.class)
	public String errorHandler(Exception e, Model model) {
		model.addAttribute("e", e);
		return "error";
	}
}	
