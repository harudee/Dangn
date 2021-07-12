package com.cos.danguen.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cos.danguen.repository.UserRepository;
import com.cos.danguen.model.User;

@Service
public class PrincipalDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("loadUserByUsername");
		User user = userRepository.findByUsername(username);
		System.out.println("user: " + user);
		if (user == null) return null;
		PrincipalDetails puser = new PrincipalDetails(user);
		return puser;
	}
}

