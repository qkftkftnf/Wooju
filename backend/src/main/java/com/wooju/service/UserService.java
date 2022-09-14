package com.wooju.service;

import com.wooju.entity.User;



public interface UserService {

	User getUserByEmail(String email, String usertype) throws Exception;

}
