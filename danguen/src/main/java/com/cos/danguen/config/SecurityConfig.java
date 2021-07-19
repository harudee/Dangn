package com.cos.danguen.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
<<<<<<< Updated upstream

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
=======

import com.cos.danguen.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter{

//	private final CorsConfig corsConfig;
	private final UserRepository userRepository;
	
>>>>>>> Stashed changes
	@Bean
	public BCryptPasswordEncoder encodePwd() {
		return new BCryptPasswordEncoder();
	}
	@Override
<<<<<<< Updated upstream
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
=======
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
//		http.addFilterBefore(new MyFilter3(), SecurityContextPersistenceFilter.class);
//		http.csrf().disable();
//		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) //세션을 사용하지 않겠음
//		.and()
//		.addFilter(corsConfig.corsFilter()) //@CrossOrigin(인증X), 세큐리티 필터에 등록 인증(O)
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

>>>>>>> Stashed changes
}


