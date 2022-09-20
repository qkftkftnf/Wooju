package com.wooju.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wooju.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{	
	ArrayList<Product> findTop5ByOrderByLikeDesc();
}
