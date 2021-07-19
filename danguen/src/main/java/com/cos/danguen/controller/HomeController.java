package com.cos.danguen.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping({"/", "/home"})
	public String index() {
		return "<h1>HOME</h1>";
	}
//	
//	@PostMapping("/token")
//	public String token() {
//		return "<h1>TOKEN</h1>";
//	}
//	
//	@PostMapping("/api/v1/user")
//	public String user() {
//		return "user";
//	}
//	
//	@PostMapping("/api/v1/admin")
//	public String admin() {
//		return "admin";
//	}
	
}
