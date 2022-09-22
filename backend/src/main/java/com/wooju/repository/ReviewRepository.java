package com.wooju.repository;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wooju.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer>{	
	ArrayList<Review> findTop3ByOrderByProductIdDesc();
	ArrayList<Review> findTop3ByTimeOrderByLikeDesc(LocalDate time);
	ArrayList<Review> findTop3ByUserGosuOrderByIdDesc(boolean gosu);
	Long countByUserId(int user);
}
