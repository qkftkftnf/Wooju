package com.wooju.dto.request;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("ReviewRequestDto")
public class ReviewRequestDto {


	@ApiModelProperty(name="술")
	int product_id;
	
	@ApiModelProperty(name="img")
	String img;
	
	@ApiModelProperty(name="title", example="제목")
	String title;
	
	@ApiModelProperty(name="content", example="내용")
	String content;
	
	@ApiModelProperty(name="별점", example="3.5")
	double star;
}
