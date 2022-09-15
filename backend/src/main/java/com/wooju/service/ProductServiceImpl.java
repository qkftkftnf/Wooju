package com.wooju.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wooju.entity.LikeProduct;
import com.wooju.entity.Product;
import com.wooju.entity.User;
import com.wooju.repository.LikeProductRepository;
import com.wooju.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	LikeProductRepository likeProductRepository;
	@Autowired
	ProductRepository productRepository;
	
	@Override
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
	}



}
