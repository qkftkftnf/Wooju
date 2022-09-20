package com.wooju.dto;

import java.util.ArrayList;

import com.wooju.entity.Product;
import com.wooju.entity.Review;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@ApiModel("ReviewMainDto")
public class ReviewMainDto {
	@ApiModelProperty(name="HotReview")
	ArrayList<ReviewDto> Hotreview;
	
	@ApiModelProperty(name="HotProduct")
	ArrayList<Product> Hotproduct;
	
	@ApiModelProperty(name="GosuReview")
	ArrayList<ReviewDto> Gosureview;
	
	@ApiModelProperty(name="RecentProduct")
	ArrayList<Product> Recentproduct;
}
