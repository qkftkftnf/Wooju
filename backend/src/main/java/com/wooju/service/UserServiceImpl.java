package com.wooju.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wooju.dto.ProfileDto;
import com.wooju.dto.request.SignUpRequestDto;
import com.wooju.entity.LikeProduct;
import com.wooju.entity.Product;
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
				.img(signUpInfo.getImg())
				.usertype(signUpInfo.getUsertype())
				.nickname(signUpInfo.getNickname())
				.birthdate(signUpInfo.getBirthdate())
				.gender(signUpInfo.getGender())
				.build();
		userRepository.save(user);
	}

	@Override
	public User getUserById(int id) {
		Optional<User> user = userRepository.findById(id);
		return user.get();
	}

	@Override
	public ProfileDto getProfile(int id) {
		Optional<User> usertemp=userRepository.findById(id);
		User user=usertemp.get();
		ProfileDto dto= ProfileDto.builder()
				.email(user.getEmail())
				.nickname(user.getNickname())
				.gender(user.getGender())
				.img(user.getImg())
				.birthdate(user.getBirthdate())
				.build();
		dto.setLikeList(new ArrayList<Product>());
		for(LikeProduct likeProduct:user.getLikeproducts()) {
			dto.getLikeList().add(likeProduct.getProduct());
		}
		return dto;
	}

}
