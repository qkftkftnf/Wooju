package com.wooju.dto;

import java.time.LocalDate;
import java.util.ArrayList;

import com.wooju.entity.Product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@ApiModel("ProfileDto")
public class ProfileDto {
	
	@ApiModelProperty(name="이메일")
	String email;
	@ApiModelProperty(name="성별")
	String gender;
	@ApiModelProperty(name="생일")
	LocalDate birthdate;
	@ApiModelProperty(name="별명")
	String nickname;
	@ApiModelProperty(name="프로필 사진")
	String img;
	@ApiModelProperty(name="좋아요")
	ArrayList<Product> likeList;
	@ApiModelProperty(name="리뷰")
	ArrayList<ReviewDto> reviewList;
}
