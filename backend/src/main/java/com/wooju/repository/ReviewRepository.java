package com.wooju.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wooju.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer>{	
	ArrayList<Review> findTop3ByOrderByIdDesc();
	ArrayList<Review> findTop10ByOrderByIdDesc();
	
	ArrayList<Review> findTop3ByTimeOrderByLikeDesc(LocalDate time);
	ArrayList<Review> findTop10ByTimeOrderByLikeDesc(LocalDate time);
	
	ArrayList<Review> findTop3ByUserGosuOrderByIdDesc(boolean gosu);
	ArrayList<Review> findTop10ByUserGosuOrderByIdDesc(boolean gosu);
	
	Optional<Review> findFirstByProductIdOrderByIdDesc(int productid);
	
	ArrayList<Review> findByProductId(int productid);
	Long countByUserId(int user);
	long countByProductId(int product_id);
}
