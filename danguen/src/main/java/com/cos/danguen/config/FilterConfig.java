//package com.cos.danguen.config;
//
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.cos.danguen.filter.MyFilter;
//import com.cos.danguen.filter.MyFilter2;
//
//@Configuration
//public class FilterConfig {
//	
//	@Bean
//	public FilterRegistrationBean<MyFilter> filter1(){
//		FilterRegistrationBean<MyFilter> bean = new FilterRegistrationBean<>(new MyFilter());
//		bean.addUrlPatterns("/*");
//		bean.setOrder(1); 
//		return bean;
//	}
//	
//	@Bean
//	public FilterRegistrationBean<MyFilter2> filter2(){
//		FilterRegistrationBean<MyFilter2> bean = new FilterRegistrationBean<>(new MyFilter2());
//		bean.addUrlPatterns("/*");
//		bean.setOrder(0); // 숫자가 낮은게 필터중에서 먼저 실행됨
//		return bean; 
//	}
//	
//	
//
//}
