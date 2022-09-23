package com.wooju.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wooju.dto.ProfileProductDto;
import com.wooju.dto.ReviewDto;
import com.wooju.dto.ReviewMainDto;
import com.wooju.dto.request.ModifyReviewRequestDto;
import com.wooju.dto.request.ReviewRequestDto;
import com.wooju.entity.LikeProduct;
import com.wooju.entity.LikeReview;
import com.wooju.entity.Product;
import com.wooju.entity.Review;
import com.wooju.entity.ReviewImg;
import com.wooju.entity.User;
import com.wooju.repository.LikeProductRepository;
import com.wooju.repository.LikeReviewRepository;
import com.wooju.repository.ProductRepository;
import com.wooju.repository.ReviewImgRepository;
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
	
	@Autowired
	ReviewImgRepository reviewImgRepository;
	
	@Override
	public ReviewMainDto getMainPage() {
		ReviewMainDto dto =ReviewMainDto.builder().build();
		
		
		dto.setHotreview(new ArrayList<ReviewDto>());
		ArrayList<Review> hotreview = reviewRepository.findTop3ByTimeOrderByLikeDesc(LocalDate.now().minusDays(1));
		
		for(Review review: hotreview) {			
			ReviewDto info = ReviewDto.builder()
						.id(review.getId())
						.user_id(review.getUser().getId())
						.user_nickname(review.getUser().getNickname())
						.product_id(review.getProduct().getId())
						.product_name(review.getProduct().getName())
						.title(review.getTitle())
						.content(review.getContent())
						.time(review.getTime())
						.star(review.getStar())
						.like(review.getLike())
						.build();
			info.setImg(new ArrayList<String>());
			ArrayList<ReviewImg> imgs= reviewImgRepository.findByUserIdAndReviewId(review.getUser().getId(), review.getId());
			for(ReviewImg img:imgs) {
				info.getImg().add(img.getImg());
			}
			dto.getHotreview().add(info);
		}
		
		dto.setGosureview(new ArrayList<ReviewDto>());
		ArrayList<Review> gosureview =reviewRepository.findTop3ByUserGosuOrderByIdDesc(true);
		for(Review review: gosureview) {			
			ReviewDto info = ReviewDto.builder()
						.id(review.getId())
						.user_id(review.getUser().getId())
						.user_nickname(review.getUser().getNickname())
						.product_id(review.getProduct().getId())
						.product_name(review.getProduct().getName())
						.title(review.getTitle())
						.content(review.getContent())
						.time(review.getTime())
						.star(review.getStar())
						.like(review.getLike())
						.build();
			info.setImg(new ArrayList<String>());
			ArrayList<ReviewImg> imgs= reviewImgRepository.findByUserIdAndReviewId(review.getUser().getId(), review.getId());
			for(ReviewImg img:imgs) {
				info.getImg().add(img.getImg());
			}
			dto.getGosureview().add(info);
		}
		
		dto.setHotproductsreview(new ArrayList<ReviewDto>());
		ArrayList<Product> hotproduct =productRepository.findTop3ByOrderByReviewDesc();
		for(Product product: hotproduct) {
			Optional<Review> reviewTemp=reviewRepository.findFirstByProductIdOrderByIdDesc(product.getId());
			if(!reviewTemp.isPresent())break;
			Review review=reviewTemp.get();
			ReviewDto info= ReviewDto.builder()
					.id(review.getId())
					.user_id(review.getUser().getId())
					.user_nickname(review.getUser().getNickname())
					.product_id(review.getProduct().getId())
					.product_name(review.getProduct().getName())
					.title(review.getTitle())
					.content(review.getContent())
					.time(review.getTime())
					.star(review.getStar())
					.like(review.getLike())
					.build();
			info.setImg(new ArrayList<String>());
			ArrayList<ReviewImg> imgs= reviewImgRepository.findByUserIdAndReviewId(review.getUser().getId(), review.getId());
			for(ReviewImg img:imgs) {
				info.getImg().add(img.getImg());
			}
			dto.getHotproductsreview().add(info);
		}
		
	
		dto.setRecentreview(new ArrayList<ReviewDto>());
		ArrayList<Review> recent =reviewRepository.findTop3ByOrderByIdDesc();
		for(Review review: recent) {
			ReviewDto info= ReviewDto.builder()
					.id(review.getId())
					.user_id(review.getUser().getId())
					.user_nickname(review.getUser().getNickname())
					.product_id(review.getProduct().getId())
					.product_name(review.getProduct().getName())
					.title(review.getTitle())
					.content(review.getContent())
					.time(review.getTime())
					.star(review.getStar())
					.like(review.getLike())
					.build();
			info.setImg(new ArrayList<String>());
			ArrayList<ReviewImg> imgs= reviewImgRepository.findByUserIdAndReviewId(review.getUser().getId(), review.getId());
			for(ReviewImg img:imgs) {
				info.getImg().add(img.getImg());
			}
			dto.getRecentreview().add(info);
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
				.title(dto.getTitle())
				.content(dto.getContent())
				.time(LocalDate.now())
				.star(dto.getStar())
				.like(0)
				.build();
		reviewRepository.save(review);
		for(String st:dto.getImg()) {
		ReviewImg reviewimg=ReviewImg.builder()
				.user(user)
				.img(st)
				.review(review)
				.build();
		reviewImgRepository.save(reviewimg);
		}
		
				
		long count =reviewRepository.countByUserId(user.getId());
		user.setReview_count((int)count);
		if(count>5) user.setGosu(true);
		count=reviewRepository.countByProductId(dto.getProduct_id());
		product.setReview((int)count);
		
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
				.title(review.getTitle())
				.content(review.getContent())
				.time(review.getTime())
				.star(review.getStar())
				.like(review.getLike())
				.build();
		dto.setImg(new ArrayList<String>());
		ArrayList<ReviewImg> imgs= reviewImgRepository.findByUserIdAndReviewId(review.getUser().getId(), review.getId());
		for(ReviewImg img:imgs) {
			dto.getImg().add(img.getImg());
		}
		return dto;
	}
	
	@Override
	public void modifyReview(int user_id, ModifyReviewRequestDto dto) {
		Optional<Review> reviewTemp =reviewRepository.findById(dto.getId());
		Review review=reviewTemp.get();
			review.setStar(dto.getStar());
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
		likeReviewRepository.deleteByReviewIdAndUserId(id,user.getId());
		reviewImgRepository.deleteByUserIdAndReviewId(user.getId(),id);
		reviewRepository.deleteById(id);
		long count =reviewRepository.countByUserId(user.getId());
		user.setReview_count((int)count);
		if(count<=5) user.setGosu(false);
		count=reviewRepository.countByProductId(review.getProduct().getId());
		Product product=productRepository.findById(review.getProduct().getId()).get();
		product.setReview((int)count);
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
	@Override
	public ArrayList<ReviewDto> getmorelistPage(String value) {
		ArrayList<ReviewDto> list= new ArrayList<ReviewDto>();
		if(value.equals("hotreview")) {
			ArrayList<Review> hotreview = reviewRepository.findTop10ByTimeOrderByLikeDesc(LocalDate.now().minusDays(1));
			for(Review review: hotreview) {			
				ReviewDto info = ReviewDto.builder()
							.id(review.getId())
							.user_id(review.getUser().getId())
							.user_nickname(review.getUser().getNickname())
							.product_id(review.getProduct().getId())
							.product_name(review.getProduct().getName())
							.title(review.getTitle())
							.content(review.getContent())
							.time(review.getTime())
							.star(review.getStar())
							.like(review.getLike())
							.build();
				info.setImg(new ArrayList<String>());
				ArrayList<ReviewImg> imgs= reviewImgRepository.findByUserIdAndReviewId(review.getUser().getId(), review.getId());
				for(ReviewImg img:imgs) {
					info.getImg().add(img.getImg());
				}
				list.add(info);
			}
		}else if(value.equals("gosureview")) {
			ArrayList<Review> gosureview =reviewRepository.findTop10ByUserGosuOrderByIdDesc(true);
			for(Review review: gosureview) {			
				ReviewDto info = ReviewDto.builder()
							.id(review.getId())
							.user_id(review.getUser().getId())
							.user_nickname(review.getUser().getNickname())
							.product_id(review.getProduct().getId())
							.product_name(review.getProduct().getName())
							.title(review.getTitle())
							.content(review.getContent())
							.time(review.getTime())
							.star(review.getStar())
							.like(review.getLike())
							.build();
				info.setImg(new ArrayList<String>());
				ArrayList<ReviewImg> imgs= reviewImgRepository.findByUserIdAndReviewId(review.getUser().getId(), review.getId());
				for(ReviewImg img:imgs) {
					info.getImg().add(img.getImg());
				}
				list.add(info);
			}
		}else if(value.equals("recentreview")){
			ArrayList<Review> recent =reviewRepository.findTop10ByOrderByIdDesc();
			for(Review review: recent) {
				ReviewDto info= ReviewDto.builder()
						.id(review.getId())
						.user_id(review.getUser().getId())
						.user_nickname(review.getUser().getNickname())
						.product_id(review.getProduct().getId())
						.product_name(review.getProduct().getName())
						.title(review.getTitle())
						.content(review.getContent())
						.time(review.getTime())
						.star(review.getStar())
						.like(review.getLike())
						.build();
				info.setImg(new ArrayList<String>());
				ArrayList<ReviewImg> imgs= reviewImgRepository.findByUserIdAndReviewId(review.getUser().getId(), review.getId());
				for(ReviewImg img:imgs) {
					info.getImg().add(img.getImg());
				}
				list.add(info);
			}
		}else if(value.equals("Hotproductsreview")){
			ArrayList<Product> hotproduct =productRepository.findTop10ByOrderByReviewDesc();
			for(Product product: hotproduct) {
				Optional<Review> reviewTemp=reviewRepository.findFirstByProductIdOrderByIdDesc(product.getId());
				if(!reviewTemp.isPresent())break;
				Review review=reviewTemp.get();
				ReviewDto info= ReviewDto.builder()
						.id(review.getId())
						.user_id(review.getUser().getId())
						.user_nickname(review.getUser().getNickname())
						.product_id(review.getProduct().getId())
						.product_name(review.getProduct().getName())
						.title(review.getTitle())
						.content(review.getContent())
						.time(review.getTime())
						.star(review.getStar())
						.like(review.getLike())
						.build();
				info.setImg(new ArrayList<String>());
				ArrayList<ReviewImg> imgs= reviewImgRepository.findByUserIdAndReviewId(review.getUser().getId(), review.getId());
				for(ReviewImg img:imgs) {
					info.getImg().add(img.getImg());
				}
				list.add(info);
			}
		}else {
			return null;
		}
		return list;
	}

}
