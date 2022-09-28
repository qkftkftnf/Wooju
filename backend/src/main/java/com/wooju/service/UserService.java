package com.wooju.service;

import java.io.IOException;

import com.wooju.dto.ProfileDto;
import com.wooju.dto.SurveyDto;
import com.wooju.dto.request.ModifyProfileRequestDto;
import com.wooju.dto.request.SignUpRequestDto;
import com.wooju.entity.User;



public interface UserService {

	User getUserByEmail(String email, String usertype) throws Exception;
	void SignupUser(SignUpRequestDto signUpInfo);
	User getUserById(int id);
	ProfileDto getProfile(int id);
	void modifyProfile(ModifyProfileRequestDto dto, int id) throws IOException;
	SurveyDto getSurvey(User user);

}
