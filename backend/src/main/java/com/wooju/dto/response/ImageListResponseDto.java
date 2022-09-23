package com.wooju.dto.response;


import java.util.ArrayList;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 유저 로그인 API ([POST] /api/v1/auth) 요청에 대한 응답값 정의.
 */
@Getter
@Setter
@ApiModel("ImageResponse")
public class ImageListResponseDto extends BaseResponseDto{
	
	@ApiModelProperty(name="img url", example="http://wooju-bucket/...")
	ArrayList<String> imgs;
	
	public static ImageListResponseDto of(Integer statusCode, String message, ArrayList<String> imgs) {
		ImageListResponseDto res = new ImageListResponseDto(statusCode, message, imgs);
		return res;
	}

	public ImageListResponseDto(Integer statusCode, String message, ArrayList<String> imgs) {
		super(statusCode, message);
		this.imgs = imgs;
	}
}
