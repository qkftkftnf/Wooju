package com.wooju.service;

import com.wooju.dto.ReviewDto;
import com.wooju.dto.ReviewMainDto;
import com.wooju.dto.request.ModifyReviewRequestDto;
import com.wooju.dto.request.ReviewRequestDto;
import com.wooju.entity.User;

public interface ReviewService {

	ReviewMainDto getMainPage();
	void createReview(User user, ReviewRequestDto dto);
	ReviewDto getReviewDetail(int id);
	void modifyReview(int user_id, ModifyReviewRequestDto dto);
	void deleteReview(int user_id, int id) throws Exception;
	void addLike(int review_id,User user) throws Exception;
	void deleteLike(int review_id, User user) throws Exception;

}
