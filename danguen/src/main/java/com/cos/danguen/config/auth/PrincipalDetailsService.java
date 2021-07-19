package com.cos.danguen.config.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cos.danguen.model.User;
import com.cos.danguen.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {
	// /login 요청이 올때 동작함
	
	private final UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		System.out.println("PrincipalDetailsService의 loadUserByUsername");
		
		User userEntity = userRepository.findByUsername(username);
		return new PrincipalDetails(userEntity);
	}

}
