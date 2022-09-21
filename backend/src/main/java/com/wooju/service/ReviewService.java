package com.wooju.service;

import com.wooju.dto.ReviewMainDto;
import com.wooju.dto.request.ReviewRequestDto;
import com.wooju.entity.User;

public interface ReviewService {

	ReviewMainDto getMainPage();

	void createReview(User user, ReviewRequestDto dto);

}
