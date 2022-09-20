package com.wooju.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wooju.entity.LikeProduct;
import com.wooju.entity.LikeReview;

@Repository
public interface LikeReviewRepository extends JpaRepository<LikeReview, Integer>{	


}
