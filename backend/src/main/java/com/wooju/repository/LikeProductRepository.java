package com.wooju.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wooju.entity.LikeProduct;

@Repository
public interface LikeProductRepository extends JpaRepository<LikeProduct, Integer>{	
	Long countByProductIdAndUserId(int productid,int userid);

}
