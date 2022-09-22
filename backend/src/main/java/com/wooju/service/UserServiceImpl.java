package com.wooju.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wooju.dto.ProfileDto;
import com.wooju.dto.ReviewDto;
import com.wooju.dto.request.ModifyProfileRequestDto;
import com.wooju.dto.request.SignUpRequestDto;
import com.wooju.entity.LikeProduct;
import com.wooju.entity.Product;
import com.wooju.entity.Review;
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
				.question1(-1)
				.question2(-1)
				.question3(-1)
				.question4(-1)
				.question5(-1)
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
				.review_count(user.getReview_count())
				.gosu(user.isGosu())
				.build();
		dto.setLikeList(new ArrayList<Product>());
		for(LikeProduct likeProduct:user.getLikeproducts()) {
			dto.getLikeList().add(likeProduct.getProduct());
		}
		dto.setReviewList(new ArrayList<ReviewDto>());
		for(Review review:user.getReviews()) {
			ReviewDto info = ReviewDto.builder()
						.id(review.getId())
						.product_id(review.getProduct().getId())
						.title(review.getTitle())
						.img(review.getImg())
						.content(review.getContent())
						.star(review.getStar())
						.like(review.getLike())
						.build();
			dto.getReviewList().add(info);
		}
		return dto;
	}

	@Override
	public void modifyProfile(ModifyProfileRequestDto dto, int id) {
		Optional<User> userTemp=userRepository.findById(id);
		User user=userTemp.get();

		user.setImg(dto.getImg());
		user.setNickname(dto.getNickname());
		userRepository.save(user);
	}

}
