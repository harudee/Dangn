package com.cos.danguen.controller;

import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.danguen.model.User;
import com.cos.danguen.repository.UserRepository;
import com.cos.danguen.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping
@Controller
public class UserController {
	
	private final UserService userService;
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder encoder;
	private final HttpSession session;
	

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
		public String update(@RequestBody User user, String password) {
			String rawPassword = user.getPassword();
			String encPassord = encoder.encode(rawPassword);
			user.setPassword(encPassord);
			userService.update(user);
			return "success";
		}
		
		//회원 삭제
		@DeleteMapping("delete/{id}")
		@ResponseBody
		public String delete(@PathVariable Long id) {
			userService.delete(id);
			return "success";
		}

	
	
}
