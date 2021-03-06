package com.cos.danguen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.danguen.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	 public User findByUsername(String username);
	 public void deleteById(Long num);

}
