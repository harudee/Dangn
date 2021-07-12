package com.cos.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.project.model.User;
import com.cos.project.repository.UserRepository;
import com.cos.project.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder encoder; 
	
	//메인페이지 http://localhost:7777/
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	//회원가입화면 http://localhost:7777/register
	@GetMapping("register")
	public String register() {
		return "/user/register";
	}
	
	//회원가입 실행
	@PostMapping("register")
	@ResponseBody
	public String register(@RequestBody User user) {
		if(userRepository.findByUsername(user.getUsername()) != null)
			return "fail";
		userService.registerUser(user);
		return "success";
	}
	
	//로그인 화면
	@GetMapping("login")
	public String login() {
		return "/user/login";
	}
	
	//회원수정 화면
	@GetMapping("update/{id}")
	public String update(Model model, @PathVariable Long id) {
		model.addAttribute("user", userService.detail(id));
		return "/user/update";
	}
	
	@PutMapping("update/{id}")
	@ResponseBody
	public String update(@RequestBody User user/* ,@PathVariable Long id */) {
//		user.setId(id);
		String rawPassword = user.getPassword();
		System.out.println("입력 비번 : "+rawPassword);
		String encPassord = encoder.encode(rawPassword);
		System.out.println("변경 비번 : "+encPassord);
		user.setPassword(encPassord);
		userService.update(user);
		
		return "success";
	}
	
	@DeleteMapping("delete/{id}")
	@ResponseBody
	public String delete(@PathVariable Long id) {
		userService.delete(id);
		return "success";
	}
}
