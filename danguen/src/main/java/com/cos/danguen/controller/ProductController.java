package com.cos.danguen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cos.danguen.service.ProductService;

@Controller
@RequestMapping("/product/*")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("list")
	public String list(Model model) {
		//model.addAttribute("product",productService.list());
		return "/product/list";
	}
	
	@GetMapping("detail")
	public String detail() {
		return "/product/detail";
	}
	
}
