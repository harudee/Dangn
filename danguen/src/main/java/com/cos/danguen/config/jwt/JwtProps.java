package com.cos.danguen.config.jwt;

public interface JwtProps {

	// final은 대문자로 적어야함 : 약속임
	// interface는 앞에 public static final이 생략되어있어
	public static final String SUBJECT = "cos";
	public static final String SECRET = "busanit";
	public static final String AUTH = "Bearer ";
	public static final String HEADER = "Authorization";
	public static final Long EXPIRESAT = 1000 * 60 * 60L; // 시간바꾸기

}
