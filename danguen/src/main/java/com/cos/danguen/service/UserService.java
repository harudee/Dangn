package com.cos.danguen.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cos.danguen.model.User;
import com.cos.danguen.repository.UserRepository;


@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	//회원가입
	@Transactional
	public void registerUser(User user) {
		userRepository.save(user);
	}
	
	//회원정보수정화면
	@Transactional
	public User detail(Long id) {
		User user = userRepository.findById(id).get();
		return user;
	}
	//회원정보수정
	@Transactional
	public void update(User user) {
		User u = userRepository.findById(user.getId()).get();
		u.setPassword(user.getPassword());
		u.setAddress(user.getAddress());
	}
	
	//회원삭제
	@Transactional
	public void delete(Long id) {
		userRepository.deleteById(id);
	}
}
