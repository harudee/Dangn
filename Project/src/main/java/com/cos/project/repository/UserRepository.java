package com.cos.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.project.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	 User findByUsername(String username);
	 public void deleteById(Long num);
}
