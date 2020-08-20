package com.cos.jwtex01.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.cos.jwtex01.config.jwt.JwtProperties;
import com.cos.jwtex01.config.oauth.provider.GoogleUser;
import com.cos.jwtex01.config.oauth.provider.OAuth2UserInfo;
import com.cos.jwtex01.model.User;
import com.cos.jwtex01.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class JwtCreateController {
	
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Transactional
	@PostMapping("/oauth/jwt/google") //구글 페이스북 다 따로 할거면 따로 만들고 공통으로 할거면 공통으로
	public String createJwt(@RequestBody Map<String, Object> data) { //json문자열 그대로 받을 예정
		System.out.println("jwtCreate 실행됨");
		System.out.println(data.get("profileObj"));
		OAuth2UserInfo googleUser = new GoogleUser((Map<String, Object>)data.get("profileObj"));
		System.out.println(googleUser.getName());
		
		User userEntity = userRepository.findByUsername(googleUser.getProvider()+"_"+googleUser.getProviderId());
		if(userEntity == null) {
			User userRequest = User.builder()
					.username(googleUser.getProvider()+"_"+googleUser.getProviderId())
					.password(bCryptPasswordEncoder.encode("겟인데어"))
					.email(googleUser.getEmail())
					.provider(googleUser.getProvider())
					.providerId(googleUser.getProviderId())
					.role("ROLE_USER")
					.build();
			userEntity = userRepository.save(userRequest);
		}
				
		String jwtToken = JWT.create()
				.withSubject(googleUser.getProvider() + googleUser.getProviderId())
				.withExpiresAt(new Date(System.currentTimeMillis()+JwtProperties.EXPIRATION_TIME))
				.withClaim("id", userEntity.getId())
				.withClaim("username", userEntity.getUsername())
				.sign(Algorithm.HMAC512(JwtProperties.SECRET));
		
		System.out.println(googleUser.getName());
		return jwtToken;
	}

}
