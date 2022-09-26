package com.wooju.service;

import com.wooju.dto.request.ProductListRequestDto;
import com.wooju.entity.User;

public interface ProductService {

	void addLike(int product_id,User user) throws Exception;
	void deleteLike(int product_id, User user) throws Exception;
	Object getlist(ProductListRequestDto dto);
	Object getdetail(int id);

}
