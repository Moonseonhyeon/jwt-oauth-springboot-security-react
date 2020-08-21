package com.cos.jwtex01.config.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cos.jwtex01.model.User;
import com.cos.jwtex01.repository.UserRepository;
import com.cos.jwtex01.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService{

	private final UserRepository userRepository;
	private final UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("PrincipalDetailsService : 진입");
		User user = userService.유저찾기(username);
				//userRepository.findByUsername(username);

		// session.setAttribute("loginUser", user);
		return new PrincipalDetails(user);
	}
}
