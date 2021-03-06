package com.cos.danguen.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.context.SecurityContextPersistenceFilter;
////import org.springframework.web.filter.CorsFilter;
//import org.springframework.web.filter.CorsFilter;
//
//import com.cos.danguen.config.jwt.JwtAuthenticationFilter;
////import com.cos.danguen.config.jwt.JwtAuthorizationFilter;
//import com.cos.danguen.filter.MyFilter3;
import com.cos.danguen.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter{

//	private final CorsConfig corsConfig;
	private final UserRepository userRepository;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests()
			.antMatchers("/user/**").authenticated()
			.anyRequest()
			.permitAll()
		.and()
			.formLogin()
			.loginPage("/login")
			.loginProcessingUrl("/loginProc")
			.defaultSuccessUrl("/")
		.and()
			.logout()
			.logoutUrl("/logout")
			.logoutSuccessUrl("/")
			.invalidateHttpSession(true);
	}
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		//http.addFilterBefore(new MyFilter3(), SecurityContextPersistenceFilter.class);
//		http.csrf().disable();
//		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) //μΈμμ μ¬μ©νμ§ μκ² μ
//		.and()
//		.addFilter(corsConfig.corsFilter()) //@CrossOrigin(μΈμ¦X), μΈνλ¦¬ν° νν°μ λ±λ‘ μΈμ¦(O)
//		.formLogin().disable()
//		.httpBasic().disable()
//		.addFilter(new JwtAuthenticationFilter(authenticationManager()))
//		.addFilter(new JwtAuthorizationFilter(authenticationManager(), userRepository))
//		.authorizeRequests()
//		.antMatchers("/user/**", "/product/**")
//		.access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
//		.antMatchers("/admin/**")
//		.access("hasRole('ROLE_ADMIN')")
//		.anyRequest().permitAll();
//	}

}
