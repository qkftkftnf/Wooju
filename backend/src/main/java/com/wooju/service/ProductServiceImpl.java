package com.wooju.service;

import java.util.ArrayList;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.wooju.dto.ProductReviewDto;
import com.wooju.dto.request.ProductListRequestDto;
import com.wooju.entity.LikeProduct;
import com.wooju.entity.Product;
import com.wooju.entity.Review;
import com.wooju.entity.User;
import com.wooju.repository.LikeProductRepository;
import com.wooju.repository.ProductRepository;
import com.wooju.repository.ReviewRepository;

@Service
public class ProductServiceImpl implements ProductService{
	@Value("${cloud.fastapi.address}")
    private String address;
	
	@Autowired
	LikeProductRepository likeProductRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	ReviewRepository reviewRepository;
	
	@Override
	@Transactional
	public void addLike(int product_id, User user) throws Exception {
		long check =likeProductRepository.countByProductIdAndUserId(product_id, user.getId());
		if(check != 0) throw new Exception();
		Optional<Product> product= productRepository.findById(product_id);
		if(!product.isPresent()) throw new Exception();
		LikeProduct likeproduct= LikeProduct.builder()
					.user(user)
					.product(product.get())
					.build();
		likeProductRepository.save(likeproduct);
		long num=likeProductRepository.countByProductId(product_id);
		product.get().setLike((int)num);
		
	}

	@Override
	@Transactional
	public void deleteLike(int product_id, User user) throws Exception {
		long check = likeProductRepository.countByProductIdAndUserId(product_id, user.getId());
		if(check == 0 )throw new Exception();
		Optional<Product> product= productRepository.findById(product_id);
		if(!product.isPresent()) throw new Exception();
		likeProductRepository.deleteByProductIdAndUserId(product_id, user.getId());
		long num=likeProductRepository.countByProductId(product_id);
		product.get().setLike((int)num);
		
	}

	@Override
	public Object getlist(ProductListRequestDto dto) {
		WebClient webclient = WebClient.builder()
				.baseUrl(address)
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.build();
		
		ResponseEntity<Object> result=webclient.get().
				uri(uriBuilder-> uriBuilder
					    .path("/product/")
					    .queryParam("types", dto.getTypes())
					    .queryParam("alcohol", dto.getAlcohol())
					    .queryParam("isAward", dto.isAward())
					    .queryParam("page", dto.getPage())
					    .queryParam("size", dto.getSize())
					    .build())
				.retrieve()
				.toEntity(Object.class)
				.block();
		return (result.getBody());
		
	}

	@Override
	public Object getdetail(int id) {
		WebClient webclient = WebClient.builder()
				.baseUrl(address)
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.build();
		
		ResponseEntity<Object> result=webclient.get().
				uri("/product/"+id)
				.retrieve()
				.toEntity(Object.class)
				.block();
		
		
		
		return (result.getBody());
	}

	@Override
	public ArrayList<ProductReviewDto> getReviewList(int id) {
		ArrayList<Review> reviewTemp= reviewRepository.findByProductId(id);
		
		ArrayList<ProductReviewDto> list=new ArrayList<ProductReviewDto>();
		
		for(Review review:reviewTemp) {
			ProductReviewDto dto= ProductReviewDto.builder()
					.id(review.getId())
					.nickname(review.getUser().getNickname())
					.title(review.getTitle())
					.content(review.getContent())
					.star(review.getStar())
					.time(review.getTime())
					.like(review.getLike())
					.build();
			list.add(dto);
		}
		return list;
	}



}
