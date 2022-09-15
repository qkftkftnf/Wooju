package com.wooju.service;

import com.wooju.entity.User;

public interface ProductService {

	void addLike(int product_id,User user) throws Exception;
	void deleteLike(int product_id, User user) throws Exception;

}
