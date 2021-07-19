package com.cos.danguen.controller;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.danguen.dto.CMRespDTO;
import com.cos.danguen.dto.LoginReqDTO;
import com.cos.danguen.model.User;
import com.cos.danguen.model.UserRole;
import com.cos.danguen.repository.UserRepository;
import com.cos.danguen.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping
public class UserController {
	
	private final UserService userService;
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	private final HttpSession session;
	
	//findbyId
	@GetMapping("/user/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		System.out.println("login findByid 나 실행"); //리액트에서 실행안됨
		User user = userRepository.findById(id).get();
		
		return new ResponseEntity<>(new CMRespDTO<User>(1,"login success", user),HttpStatus.OK);
	}
	
	//회원가입 실행
	@PostMapping("/register")
	public CMRespDTO<?> register(@RequestBody User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRole("ROLE_USER");
		
		return new CMRespDTO<User>(1, "join ok", userRepository.save(user));
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginReqDTO loginReqDTO){
		System.out.println(loginReqDTO);
		
		User user = userRepository.findByUsername(loginReqDTO.getUsername());
		
		System.out.println(user);
		
		if(!loginReqDTO.getUsername().equals(user.getUsername())&&
				!loginReqDTO.getPassword().equals(user.getPassword())) {
			
			return null;
		}
		
		session.setAttribute("principal", user);
		return new ResponseEntity<>(new CMRespDTO<User>(1, "login success", user), HttpStatus.OK);
	}
	

	
//	//회원수정 화면
//	@GetMapping("update/{id}")
//	public String update(Model model, @PathVariable Long id) {
//		model.addAttribute("user", userService.detail(id));
//		return "/user/update";
//	}
	
	//회원수정
	@PutMapping("/user/update/{id}")
	public CMRespDTO<?> update(@RequestBody User user, @PathVariable Long id) {

		User userEntity = userRepository.findById(id).get();
		userEntity.setUsername(user.getUsername());
		userEntity.setPassword(user.getPassword());
		userEntity.setAddress(user.getAddress());
		
		return new CMRespDTO<User>(1, "ok", userRepository.save(userEntity));
	}
	
	//회원삭제
	@DeleteMapping("/user/delete/{id}")
	public CMRespDTO<?> delete(@PathVariable Long id) {

    //main
// 	//회원수정 화면
// 	@GetMapping("update/{id}")
// 	public String update(Model model, @PathVariable Long id) {
		
// 		model.addAttribute("user", userService.detail(id));
// 		return "/user/update";
// 	}
	
// 	@PutMapping("update/{id}")
// 	@ResponseBody
// 	public String update(@RequestBody User user ,@PathVariable Long id ,String password) {
// 		String rawPassword = user.getPassword();
// 		String encPassord = encoder.encode(rawPassword);
// 		user.setPassword(encPassord);
// 		userService.update(user);
// 		return "success";
// 	}
	
// 	@DeleteMapping("delete/{id}")
// 	@ResponseBody
// 	public String delete(@PathVariable Long id) {
		

// 		userService.delete(id);
// 		return new CMRespDTO<User>(1, "delete ok", null);
// 	}
}
