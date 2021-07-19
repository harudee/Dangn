package com.cos.danguen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< Updated upstream

//@Controller
public class HomeController {

//	@GetMapping("/")
//	public String index() {
//		return "home";
=======
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

	@GetMapping("/")
	public String home() {
		return "home";
	}
//	
//	@PostMapping("/token")
//	public String token() {
//		return "<h1>TOKEN</h1>";
>>>>>>> Stashed changes
//	}
}
