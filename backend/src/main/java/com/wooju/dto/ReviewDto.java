package com.wooju.dto;

import java.time.LocalDate;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@ApiModel("ReviewDto")
public class ReviewDto {
	
	@ApiModelProperty(name="id")
	int id;
	@ApiModelProperty(name="user_id")
	int user_id;
	@ApiModelProperty(name="user_id")
	String user_nickname;
	@ApiModelProperty(name="user_id")
	boolean gosu;
	@ApiModelProperty(name="product_id")
	int product_id;
	@ApiModelProperty(name="user_id")
	String product_name;
	@ApiModelProperty(name="리뷰 제목")
	String title;
	@ApiModelProperty(name="사진")
	String img;
	@ApiModelProperty(name="리뷰 내용")
	String content;
	@ApiModelProperty(name="작성 시간")
	LocalDate time;
	@ApiModelProperty(name="평점")
	double star;
	@ApiModelProperty(name="좋아요 수")
	int like;
}
