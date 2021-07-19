//package com.cos.danguen.config.jwt;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.Date;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.cos.danguen.config.auth.PrincipalDetails;
//import com.cos.danguen.dto.CMRespDTO;
//import com.cos.danguen.dto.LoginReqDTO;
//import com.cos.danguen.model.User;
//import com.cos.danguen.repository.UserRepository;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import lombok.RequiredArgsConstructor;
//
//// 스프링 세큐리티에 있음 UsernamePasswordAuthenticationFilter
//
//@RequiredArgsConstructor
//public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
//
//	private final AuthenticationManager authenticationManager;
//
//	// /login으로 요청이 오면 얘가 낚아채서 함수가 실행됨
//	@Override
//	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
//			throws AuthenticationException {
//
//		System.out.println("JwtAuthenticationFilter: 로그인 시도 ing");
//
//		// 2. login 시도 ㄱㄱ authenticationManager loadUserByUsername 실행됨
//		// 3. PrincipalDetails를 세션에 담기(권한관리 필요)
//		// 4. JWT토큰 만들어서 응답
//
//		// 1. username, password 받기
//		// request.getInputStream()에 담겨있음
//		ObjectMapper om = new ObjectMapper();
//		LoginReqDTO loginReqDTO = null;
//
//		try {
//
//			loginReqDTO = om.readValue(request.getInputStream(), LoginReqDTO.class);
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		System.out.println("JwtAuthenticationFilter : " + loginReqDTO);
//
//		// username password 토큰생성
//		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
//				loginReqDTO.getUsername(), loginReqDTO.getPassword());
//
//		System.out.println("JwtAuthenticationFilter : 토큰생성완료");
//
//		// PrincipalDetailsService의 loadUserByUsername함수 실행됨
//		// password는 스프링이 알아서 처리해준대..
//
//		// DB에 있는 username과 password일치하는지 확인 hibernate
//		Authentication authentication = authenticationManager.authenticate(authenticationToken);
//
//		PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
//		System.out.println("Authentication :" + principalDetails.getUser().getUsername()); // =>로그인됨
//
//		// authentication객체가 session에 저장됨( return 될 때)
//		return authentication;
//	}
//
//	
//	@Override
//	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
//			Authentication authResult) throws IOException, ServletException {
//		System.out.println("인증완료: successfulAuthentication실행됨");
//
//		// 여기서 JWT토큰 만들기
//		PrincipalDetails principalDetails = (PrincipalDetails) authResult.getPrincipal();
//
//		System.out.println("3 " + principalDetails);
//
//		// Hash암호방식
//		String jwtToken = JWT.create().withSubject(JwtProps.SUBJECT)
//				.withExpiresAt(new Date(System.currentTimeMillis() + JwtProps.EXPIRESAT))
//				.withClaim("username", principalDetails.getUser().getUsername())
//				.withClaim("role", principalDetails.getUser().getRole()).sign(Algorithm.HMAC512(JwtProps.SECRET));
//
//		response.setHeader(JwtProps.HEADER, JwtProps.AUTH + jwtToken);
//		
//		System.out.println("JWT토큰 만들어짐 : " + jwtToken);
//		
////		response.setContentType("text/plain; charset=UTF-8");
////
////		PrintWriter out = response.getWriter();
////		CMRespDTO<PrincipalDetails> cmRespDTO = new CMRespDTO<PrincipalDetails>(1, "login success", principalDetails);
////		out.print(cmRespDTO.getMsg());// CMrespDto새로 만들어서
////		out.flush();
//
//		
//
//	}
//
//}
