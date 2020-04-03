package com.lv.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lv
 */
@Controller
public class FrontGuideController {
	@RequestMapping("/regjsp")
	public String Regjsp(){
		return "front/register";
	}
	@RequestMapping("/frontLogin")
	public String Loginjsp(){
		return "front/login";
	}
	@RequestMapping("/cartPage")
	public String cartPage(){
		return "front/cart";
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
		return "front/result";
	}
	@RequestMapping("/updatePwdPage")
	public String updatePwdPage(){
		return "front/update-pwd";
	}
}
