package com.cos.danguen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cos.danguen.service.ProductService;

@Controller
@RequestMapping("/hello/*")
@CrossOrigin
public class GreetingController {

	private ProductService productService;

	
	@RequestMapping("/chat")
	public ModelAndView greet() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("chat");
		return mv;
	}
	
}
