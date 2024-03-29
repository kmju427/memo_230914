package com.memo.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memo.user.entity.UserEntity;
import com.memo.user.repository.UserRepository;

@Service
public class UserBO {

	@Autowired
	private UserRepository userRepository;
	
	// 아이디 중복 조회
	// input : loginId / output : UserEntity(있거나 or null)
	public UserEntity getUserEntityByLoginId(String loginId) {
		return userRepository.findByLoginId(loginId);
	}
	
	// 회원가입
	// input : loginId, password, name, email / output : Integer id(pk)
	public Integer addUser(String loginId, String password, String name, String email) {
		UserEntity userEntity = userRepository.save(
					UserEntity.builder()
						.loginId(loginId)
						.password(password)
						.name(name)
						.email(email)
						.build()
				);
		
		return userEntity == null ? null : userEntity.getId();
	}
	
	// 로그인
	// input : loginId, password / output : UserEntity
	public UserEntity getUserEntityByLoginIdPassword(String loginId, String password) {
		return userRepository.findByLoginIdAndPassword(loginId, password);
	}
	
} // public class UserBO