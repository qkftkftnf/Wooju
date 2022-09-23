package com.wooju.dto.response;


import java.util.ArrayList;

import com.wooju.dto.ProfileDto;
import com.wooju.dto.ReviewMainDto;
import com.wooju.entity.Product;
import com.wooju.entity.Review;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 유저 로그인 API ([POST] /api/v1/auth) 요청에 대한 응답값 정의.
 */
@Getter
@Setter
@ApiModel("ReviewMainResponse")
public class ReviewMainResponseDto extends BaseResponseDto{
	
	ReviewMainDto dto;
	
	public static ReviewMainResponseDto of(Integer statusCode, String message, ReviewMainDto dto) {
		ReviewMainResponseDto res = new ReviewMainResponseDto(statusCode, message, dto);
		return res;
	}

	public ReviewMainResponseDto(Integer statusCode, String message, ReviewMainDto dto) {
		super(statusCode, message);
		this.dto = dto;
	}
}
