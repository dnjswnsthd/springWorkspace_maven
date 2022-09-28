package com.service.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.spring.model.Car;
import com.service.spring.model.Company;
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
			for(Company c : al) System.out.println(c);
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
	
	@PostMapping("insertCar.do")
	public String insertCar(Model model, Car car, HttpServletResponse response) throws Exception {
		try {
			carService.insertCar(car);
			model.addAttribute("num", car.getNum());
			return "/car/insert_success";
		} catch (Exception e) {
			throw new Exception("차량 추가에 실패했습니다.(중복 or 데이터 누락)");
		}
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
		try {
			model.addAttribute("car", carService.selectCar(car.getNum()));
			return "/car/detail_car";
		} catch (Exception e) {
			throw new Exception("차량 상세 조회에 실패했습니다.");
		}
	}
	
	@PostMapping("updateCar.do")
	public String updateCar(Model model, Car car) throws Exception {
		try {
			carService.updateCar(car);
			model.addAttribute("num", car.getNum());
			return "/car/update_success";
		} catch (Exception e) {
			throw new Exception("차량 정보 수정에 실패했습니다.");
		}
	}
	
	@ExceptionHandler(Exception.class)
	public String errorHandler(Exception e, Model model) {
		model.addAttribute("e", e);
		return "error";
	}
}	
