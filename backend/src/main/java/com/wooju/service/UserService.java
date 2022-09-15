package com.wooju.service;

import com.wooju.dto.request.SignUpRequestDto;
import com.wooju.entity.User;



public interface UserService {

	User getUserByEmail(String email, String usertype) throws Exception;
	void SignupUser(SignUpRequestDto signUpInfo);
	User getUserById(int id);

}
