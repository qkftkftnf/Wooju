package com.wooju.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wooju.entity.User;
import com.wooju.repository.UserRepository;


@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User getUserByEmail(String email, String usertype) throws Exception {
		Optional<User> user =userRepository.findByEmailAndUserType(email, usertype);
		return user.get();
	}

}
