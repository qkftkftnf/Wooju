package com.wooju.dto.response;


import com.wooju.dto.ProfileDto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 유저 로그인 API ([POST] /api/v1/auth) 요청에 대한 응답값 정의.
 */
@Getter
@Setter
@ApiModel("LoginResponse")
public class ProfileResponseDto extends BaseResponseDto{
	
	@ApiModelProperty(name="profile")
	ProfileDto profile;
	
	public static ProfileResponseDto of(Integer statusCode, String message, ProfileDto profile) {
		ProfileResponseDto res = new ProfileResponseDto(statusCode, message, profile);
		return res;
	}

	public ProfileResponseDto(Integer statusCode, String message, ProfileDto profile) {
		super(statusCode, message);
		this.profile = profile;
	}
}
