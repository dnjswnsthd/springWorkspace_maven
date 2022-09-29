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

import com.service.spring.model.Car;
import com.service.spring.model.Company;
import com.service.spring.model.Us;
import com.service.spring.model.service.CarService;
import com.service.spring.model.service.CompanyService;
@Controller
public class CarController {
	@Autowired
	private CarService carService;
	@Autowired
	private CompanyService companyService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/moveCar")
	public String moveCar(Model model) throws Exception {
		try {
			ArrayList <Company> al = companyService.selectCompany();
			model.addAttribute("list", al);
			return "/car/insert_car";
		} catch (Exception e) {
			throw new Exception("회사 목록 조회에 실패했습니다.");
		}
	}
	
	@GetMapping("/moveCarList")
	public String moveCarList(Model model) throws Exception {
		try {
			ArrayList<Car> al = carService.selectCar();
			model.addAttribute("car", al);
			return "/car/select_car";
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
	
	@PostMapping("insertCar.do")
	public String insertCar(Model model, Car car, RedirectAttributes ra) throws Exception {
		try {
			carService.insertCar(car);
			ra.addAttribute("title", "추가 성공");
			ra.addAttribute("num", car.getNum());
			return "redirect:/success";
		} catch (Exception e) {
			throw new Exception("차량 추가에 실패했습니다.(중복 or 데이터 누락)");
		}
	}
	
	@GetMapping("/success")
	public String moveInsertSuccess(@RequestParam("num") String num, @RequestParam("title") String title, Model model) {
		model.addAttribute("title", title);
		model.addAttribute("num", num);
		return "/car/success";
	}
	
	@PostMapping("deleteCar.do")
	@ResponseBody
	public String deleteCar(@RequestParam List<String> num, Model model) throws Exception {
		List <String> temp = new ArrayList<String>();
		try {
			for(String n : num) temp.add(n);
			carService.deleteCar(temp);
			return "";
		} catch (Exception e) {
			throw new Exception("차량 삭제에 실패했습니다.");
		}
	}
	
	// 동적 쿼리로 수정
	@GetMapping("detail.do")
	public String detailCar(Model model, Car car) throws Exception {
		/* try { */
			System.out.println(car);
			ArrayList <Company> al = companyService.selectCompany();
			model.addAttribute("list", al);
			model.addAttribute("car", carService.selectCar(car).get(0)); 
		 
			return "/car/detail_car";
/*		} catch (Exception e) {
			throw new Exception("차량 상세 조회에 실패했습니다.");
		}*/
	}
	
	@PostMapping("updateCar.do")
	public String updateCar(Model model, Car car, RedirectAttributes ra) throws Exception {
		try {
			carService.updateCar(car);
			ra.addAttribute("title", "수정 성공");
			ra.addAttribute("num", car.getNum());
			return "redirect:/success";
		} catch (Exception e) {
			throw new Exception("차량 정보 수정에 실패했습니다.");
		}
	}
	
	@PostMapping("search.do")
	public String searchCar(Model model, String contentKey, String contentValue) throws Exception {
		try {
			System.out.println(contentKey);
			System.out.println(contentValue);
			Car car = new Car();
			if(contentKey.equals("num")) car.setNum(contentValue);
			else if(contentKey.equals("model")) car.setModel(contentValue);
			else if(contentKey.equals("vendor")) car.setVcode(companyService.selectVcode(contentValue));
			ArrayList<Car> al = carService.selectCar(car);
			model.addAttribute("car", al);
			return "/car/select_car";
		}catch(Exception e) { 
			throw new Exception("차량 검색에 실패했습니다.");
		}
	}
	
	@PostMapping("login.do")
	public String doLogin(Us user, Model model, HttpSession session) throws Exception {
		try {
			Us tmp = carService.selectUser(user);
			if(tmp != null) {
				session.setAttribute("user", user);
				return "redirect:/moveCarList";
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
			carService.signup(user);
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
