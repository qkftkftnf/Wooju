package com.wooju.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wooju.dto.ReviewDto;
import com.wooju.dto.ReviewMainDto;
import com.wooju.entity.Product;
import com.wooju.entity.Review;
import com.wooju.repository.LikeProductRepository;
import com.wooju.repository.ProductRepository;
import com.wooju.repository.ReviewRepository;

@Service
public class ReviewServiceImpl implements ReviewService{

	@Autowired
	ReviewRepository reviewRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	LikeProductRepository likeProductRepository;
	@Override
	public ReviewMainDto getMainPage() {
		ReviewMainDto dto =ReviewMainDto.builder().build();
		
		
		dto.setHotreview(new ArrayList<ReviewDto>());
		ArrayList<Review> hotreview = reviewRepository.findTop5ByOrderByLikeDesc();
		for(Review review: hotreview) {			
			ReviewDto info = ReviewDto.builder()
						.id(review.getId())
						.user_id(review.getUser().getId())
						.product_id(review.getProduct().getId())
						.title(review.getTitle())
						.img(review.getImg())
						.content(review.getContent())
						.star(review.getStar())
						.like(review.getLike())
						.build();
			dto.getHotreview().add(info);
		}
		
		
		ArrayList<Product> hotproduct =productRepository.findTop5ByOrderByLikeDesc();
		dto.setHotproduct(hotproduct);
		
		dto.setRecentproduct(new ArrayList<Product>());
		ArrayList<Review> recent =reviewRepository.findTop5ByOrderByProductIdDesc();
		for(Review review: recent) {
			dto.getRecentproduct().add(review.getProduct());
		}
		
		return dto;
	}

}
