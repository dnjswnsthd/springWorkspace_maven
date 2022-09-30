package com.service.spring.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.service.spring.model.Car;
import com.service.spring.model.Product;
import com.service.spring.model.UserInfo;
import com.service.spring.model.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/moveProduct")
	public String moveProduct(Model model) throws Exception {
		return "/product/insert_product";
	}

	@GetMapping("/moveMenu")
	public String moveMenu() {
		return "menu";
	}

	@GetMapping("/moveProductList")
	public String moveProductList(Model model) throws Exception {
		try {
			ArrayList<Product> al = productService.selectProduct();
			model.addAttribute("product", al);
			return "/product/select_product";
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
	public String insertCar(Model model, Product product, RedirectAttributes ra) throws Exception {
		try {
			ra.addAttribute("title", "추가 성공");
			ra.addAttribute("num", product.getCode());
			productService.insertProduct(product);

			return "redirect:/success";
		} catch (Exception e) {
			/* throw new Exception("차량 추가에 실패했습니다.(중복 or 데이터 누락)"); */
			return "error";
		}
	}

	@GetMapping("/success")
	public String moveInsertSuccess(@RequestParam("num") String num, @RequestParam("title") String title, Model model) {
		model.addAttribute("title", title);
		model.addAttribute("num", num);
		return "/product/success";
	}

	@PostMapping("deleteProduct.do")
	public String deleteProduct(Product product, Model model, RedirectAttributes ra) throws Exception {
		try {
			productService.deleteProduct(product.getCode());
			ra.addAttribute("title", "삭제 성공");
			ra.addAttribute("num", product.getCode());
			return "redirect:/success";
		} catch (Exception e) {
			throw new Exception("차량 삭제에 실패했습니다.");
		}
	}

	// 동적 쿼리로 수정
	@GetMapping("detail.do")
	public String detailCar(Model model, Product product) throws Exception {
		try {

			model.addAttribute("product", productService.selectProduct(product).get(0));

			return "/product/detail_product";
		} catch (Exception e) {
			throw new Exception("차량 상세 조회에 실패했습니다.");
		}
	}

	@PostMapping("search.do")
	public String searchCar(Model model, String contentKey, String contentValue) throws Exception {
		try {
			Product product = new Product();
			if (contentKey.equals("title")) {
				product.setTitle(contentValue);
			}else if(contentKey.equals("category")) {
				product.setCategory(contentValue);
			}
			ArrayList<Product> al = productService.selectProduct(product);
			model.addAttribute("product", al);
			return "/product/select_product";
		} catch (Exception e) {
			throw new Exception("차량 검색에 실패했습니다.");
		}
	}

	@PostMapping("login.do")
	public String doLogin(UserInfo user, Model model, HttpSession session) throws Exception {
		try {
			System.out.println(user);
			UserInfo tmp = productService.selectUser(user);
			if (tmp != null) {
				session.setAttribute("user", user);
				return "redirect:/moveMenu";
			} else {
				model.addAttribute("msg", "로그인에 실패하였습니다.");
				return "login";
			}
		} catch (Exception e) {
			throw new Exception("로그인 실패");
		}
	}

	@GetMapping("logout.do")
	public String doLogout(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:/";
	}

	@PostMapping("signup.do")
	public String doSignup(UserInfo user) throws Exception {
		try {
			productService.signup(user);
			return "redirect:/moveLogin";
		} catch (Exception e) {
			throw new Exception("회원가입 실패(id 중복)");
		}
	}

	@ExceptionHandler(Exception.class)
	public String errorHandler(Exception e, Model model) {
		model.addAttribute("e", e);
		return "error";
	}
}
