package com.wooju.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wooju.dto.request.SignUpRequestDto;
import com.wooju.entity.User;
import com.wooju.repository.UserRepository;


@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User getUserByEmail(String email, String usertype) throws Exception {
		Optional<User> user =userRepository.findByEmailAndUsertype(email, usertype);
		return user.get();
	}

	@Override
	public void SignupUser(SignUpRequestDto signUpInfo) {
		User user=User.builder()
				.email(signUpInfo.getEmail())
				.usertype(signUpInfo.getUsertype())
				.nickname(signUpInfo.getNickname())
				.birthdate(signUpInfo.getBirthdate())
				.gender(signUpInfo.getGender())
				.build();
		userRepository.save(user);
	}

}