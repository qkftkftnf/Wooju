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
	ArrayList<Review> findTop3ByTimeOrderByLikeDesc(LocalDate time);
	ArrayList<Review> findTop3ByUserGosuOrderByIdDesc(boolean gosu);
	Optional<Review> findFirstByProductIdOrderByIdDesc(int productid);
	Long countByUserId(int user);
	long countByProductId(int product_id);
}
