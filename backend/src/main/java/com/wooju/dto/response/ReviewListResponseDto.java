package com.wooju.dto.response;


import java.util.ArrayList;

import com.wooju.dto.ReviewDto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 유저 로그인 API ([POST] /api/v1/auth) 요청에 대한 응답값 정의.
 */
@Getter
@Setter
@ApiModel("ReviewResponse")
public class ReviewListResponseDto extends BaseResponseDto{
	
	@ApiModelProperty(name="review")
	ArrayList<ReviewDto> review;
	
	public static ReviewListResponseDto of(Integer statusCode, String message, ArrayList<ReviewDto> review) {
		ReviewListResponseDto res = new ReviewListResponseDto(statusCode, message, review);
		return res;
	}

	public ReviewListResponseDto(Integer statusCode, String message, ArrayList<ReviewDto> review) {
		super(statusCode, message);
		this.review = review;
	}
}
