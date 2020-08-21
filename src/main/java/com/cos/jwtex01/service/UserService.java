package com.cos.jwtex01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.jwtex01.model.User;
import com.cos.jwtex01.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public User 회원가입(User user) {	
			user.setRole("ROLE_USER");
			userRepository.save(user);					
			return userRepository.findByUsername(user.getUsername());
	}
	
	@Transactional(readOnly = true) //데이터 변경을 허용하지 않음 (혹시 이 트랜젝션이 끝나기 전에
	//다른 사용자가 데이터를 변경한 내용 때문에 엉키지않게 하려고)=> 정합성을 위해서
		public User 로그인(User user) {
		System.out.println(user);
			return userRepository.login(user);	
	}
	
	@Transactional(readOnly = true) 
	public User 유저찾기(String useranme) {
		System.out.println("유저찾기("+useranme+")");
			return userRepository.findByUsername(useranme);
	}
		

}
