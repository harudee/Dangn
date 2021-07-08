package com.cos.danguen.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "user")
public class User {

	// tablename : User
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // 사용자 id
	private String username; // 사용자명
	private int password; // 비밀번호
	private String email; // 이메일
	private int phone; // 휴대폰번호
	private String address; // 거주지 주소
}
