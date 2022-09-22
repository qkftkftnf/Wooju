package com.wooju.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wooju.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer>{	
	ArrayList<Review> findTop5ByOrderByProductIdDesc();
	ArrayList<Review> findTop5ByOrderByLikeDesc();
	Long countByUserId(int user);
}
