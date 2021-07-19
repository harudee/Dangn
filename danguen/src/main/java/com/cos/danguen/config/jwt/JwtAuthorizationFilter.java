package com.cos.danguen.config.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.cos.danguen.config.auth.PrincipalDetails;
import com.cos.danguen.model.User;
import com.cos.danguen.repository.UserRepository;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

	private UserRepository userRepository;

	public JwtAuthorizationFilter(AuthenticationManager authenticationManager, UserRepository userRepository) {
		super(authenticationManager);
		this.userRepository = userRepository;
	}
	
	

	// 인증이나 권한 들어가는 주소요청
	// product/**, /user/**
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
//		super.doFilterInternal(request, response, chain);
		System.out.println("인증이나 권한이 필요한 주소 요청이 됨");
		System.out.println("JWT토큰이 유효한지 확인하기 ing");

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		String jwtHeader = req.getHeader(JwtProps.HEADER);// 여기가 null인디....? 왜 못받는겨...?

		System.out.println("토큰 : " + jwtHeader);

		// header가 있는지 확인
		if (jwtHeader == null || !jwtHeader.startsWith(JwtProps.AUTH)) {

			chain.doFilter(request, response);
			return;

		}

		String jwtToken = request.getHeader(JwtProps.HEADER).replace(JwtProps.AUTH, "");
		System.out.println(jwtToken);

		// 토큰 검증 (이게 인증이기 때문에 AuthenticationManager도 필요 없음)
				// 내가 SecurityContext에 집적접근해서 세션을 만들때 자동으로 UserDetailsService에 있는 loadByUsername이 호출됨.
		String username = JWT.require(Algorithm.HMAC512(JwtProps.SECRET)).build().verify(jwtToken).getClaim("username")
				.asString();

		if (username != null) {// Jwt토큰 서명이 정상임ㅇㅇ
			User userEntity = userRepository.findByUsername(username);

			PrincipalDetails principalDetails = new PrincipalDetails(userEntity);

			Authentication authentication = 
					new UsernamePasswordAuthenticationToken(
							principalDetails, 
							null,
							principalDetails.getAuthorities());

			// 강제로 세큐리티 세션에 authentication저장
			SecurityContextHolder.getContext().setAuthentication(authentication);
		}
		
		chain.doFilter(request, response);
	}

}
