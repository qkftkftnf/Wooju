package com.wooju.dto.response;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 유저 로그인 API ([POST] /api/v1/auth) 요청에 대한 응답값 정의.
 */
@Getter
@Setter
@ApiModel("UserLoginPostResponse")
public class FirstLoginResponseDto extends BaseResponseDto{
	
	@ApiModelProperty(name="유저의 이메일", example="ssafy@ssafy.com")
	String userEmail;
	String userType;
	
	public static FirstLoginResponseDto of(Integer statusCode, String message, String userEmail, String userType) {
		FirstLoginResponseDto res = new FirstLoginResponseDto(statusCode, message, userEmail, userType);
		return res;
	}

	public FirstLoginResponseDto(Integer statusCode, String message, String userEmail, String userType) {
		super(statusCode, message);
		this.userEmail = userEmail;
		this.userType = userType;
	}
}
