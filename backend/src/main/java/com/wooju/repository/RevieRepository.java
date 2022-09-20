package com.wooju.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wooju.entity.Review;

@Repository
public interface RevieRepository extends JpaRepository<Review, Integer>{	


}
