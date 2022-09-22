package com.wooju.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wooju.dto.ReviewDto;
import com.wooju.dto.ReviewMainDto;
import com.wooju.dto.request.ModifyReviewRequestDto;
import com.wooju.dto.request.ReviewRequestDto;
import com.wooju.entity.LikeProduct;
import com.wooju.entity.LikeReview;
import com.wooju.entity.Product;
import com.wooju.entity.Review;
import com.wooju.entity.User;
import com.wooju.repository.LikeProductRepository;
import com.wooju.repository.LikeReviewRepository;
import com.wooju.repository.ProductRepository;
import com.wooju.repository.ReviewRepository;
import com.wooju.repository.UserRepository;

@Service
public class ReviewServiceImpl implements ReviewService{

	@Autowired
	ReviewRepository reviewRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	LikeProductRepository likeProductRepository;
	
	@Autowired
	LikeReviewRepository likeReviewRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public ReviewMainDto getMainPage() {
		ReviewMainDto dto =ReviewMainDto.builder().build();
		
		
		dto.setHotreview(new ArrayList<ReviewDto>());
		ArrayList<Review> hotreview = reviewRepository.findTop5ByOrderByLikeDesc();
		for(Review review: hotreview) {			
			ReviewDto info = ReviewDto.builder()
						.id(review.getId())
						.user_id(review.getUser().getId())
						.user_nickname(review.getUser().getNickname())
						.product_id(review.getProduct().getId())
						.product_name(review.getProduct().getName())
						.title(review.getTitle())
						.img(review.getImg())
						.content(review.getContent())
						.time(review.getTime())
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
	@Transactional
	@Override
	public void createReview(User user, ReviewRequestDto dto) {
		Product product = productRepository.findById(dto.getProduct_id()).get();
		Review review = Review.builder()
				.user(user)
				.product(product)
				.img(dto.getImg())
				.title(dto.getTitle())
				.content(dto.getContent())
				.time(LocalDate.now())
				.star(dto.getStar())
				.like(0)
				.build();
		reviewRepository.save(review);
		long count =reviewRepository.countByUserId(user.getId());
		user.setReview_count((int)count);
		if(count>5) user.setGosu(true);
		userRepository.save(user);
		
	}
	
	@Override
	public ReviewDto getReviewDetail(int id) {
		Optional<Review> reviewTemp=reviewRepository.findById(id);
		Review review=reviewTemp.get();
		ReviewDto dto=ReviewDto.builder()
				.id(id)
				.user_id(review.getUser().getId())
				.user_nickname(review.getUser().getNickname())
				.product_id(review.getProduct().getId())
				.product_name(review.getProduct().getName())
				.img(review.getImg())
				.title(review.getTitle())
				.content(review.getContent())
				.time(review.getTime())
				.star(review.getStar())
				.like(review.getLike())
				.build();
		return dto;
	}
	
	@Override
	public void modifyReview(int user_id, ModifyReviewRequestDto dto) {
		Optional<Review> reviewTemp =reviewRepository.findById(dto.getId());
		Review review=reviewTemp.get();
			review.setStar(dto.getStar());
			review.setImg(dto.getImg());
			review.setContent(dto.getContent());
			review.setTitle(dto.getTitle());
		reviewRepository.save(review);
	}
	
	@Override
	@Transactional
	public void deleteReview(User user, int id) throws Exception{
		Optional<Review> reviewTemp= reviewRepository.findById(id);
		if(!reviewTemp.isPresent()) throw new Exception();
		Review review = reviewTemp.get();
		if(review.getUser().getId() != user.getId()) throw new Exception();
		reviewRepository.deleteById(id);
		long count =reviewRepository.countByUserId(user.getId());
		user.setReview_count((int)count);
		if(count<=5) user.setGosu(false);
		userRepository.save(user);
	}
	
	@Override
	@Transactional
	public void addLike(int review_id, User user) throws Exception {
		long check =likeReviewRepository.countByReviewIdAndUserId(review_id, user.getId());
		if(check != 0) throw new Exception();
		Optional<Review> review= reviewRepository.findById(review_id);
		if(!review.isPresent()) throw new Exception();
		LikeReview likeReview=LikeReview.builder()
					.user(user)
					.review(review.get())
					.build();
		likeReviewRepository.save(likeReview);
		long num=likeReviewRepository.countByReviewId(review_id);
		review.get().setLike((int)num);
		
	}

	@Override
	@Transactional
	public void deleteLike(int review_id, User user) throws Exception {
		long check =likeReviewRepository.countByReviewIdAndUserId(review_id, user.getId());
		if(check != 0) throw new Exception();
		Optional<Review> review= reviewRepository.findById(review_id);
		if(!review.isPresent()) throw new Exception();
		likeReviewRepository.deleteByReviewIdAndUserId(review_id, user.getId());
		long num=likeReviewRepository.countByReviewId(review_id);
		review.get().setLike((int)num);
		
	}

}
