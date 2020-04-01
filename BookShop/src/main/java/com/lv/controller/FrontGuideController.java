package com.lv.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontGuideController {
	@RequestMapping("/reg")
	public String Regjsp(){
		return "front/register";
	}
	@RequestMapping("/login")
	public String Loginjsp(){
		return "front/login";
	}
	@RequestMapping("/cartPage")
	public String cartPage(){
		return "front/shopping";
	}
	@RequestMapping("/productListPage")
	public String productListPage(){
		return "front/product-list";
	}
	@RequestMapping("/oderPage")
	public String oderPage(){
		return "front/order";
	}
	@RequestMapping("/shoppingResult")
	public String shoppingResult(){
		return "front/shopping-result";
	}
	@RequestMapping("/updatePwdPage")
	public String updatePwdPage(){
		return "front/update-pwd";
	}
}
