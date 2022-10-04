package com.wooju.exception.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.wooju.dto.response.BaseResponseDto;
import com.wooju.exception.ExistUserException;
import com.wooju.exception.LikeException;
import com.wooju.exception.ProductNotFoundException;
import com.wooju.exception.ReviewNotFoundException;
import com.wooju.exception.UserNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
    protected ResponseEntity<BaseResponseDto> handleUserNotFoundException(UserNotFoundException e) {
        return ResponseEntity.status(404).body(BaseResponseDto.of(404, "User Not Found"));
    }

	@ExceptionHandler(ReviewNotFoundException.class)
    protected ResponseEntity<BaseResponseDto> handleReviewNotFoundException(ReviewNotFoundException e) {
        return ResponseEntity.status(404).body(BaseResponseDto.of(404, "Review Not Found"));
    }
	
	@ExceptionHandler(ProductNotFoundException.class)
    protected ResponseEntity<BaseResponseDto> handleProductNotFoundException(ProductNotFoundException e) {
        return ResponseEntity.status(404).body(BaseResponseDto.of(404, "Product Not Found"));
    }
	
	@ExceptionHandler(LikeException.class)
    protected ResponseEntity<BaseResponseDto> handleLikeException(LikeException e) {
        return ResponseEntity.status(405).body(BaseResponseDto.of(405, "like error"));
    }
	
	@ExceptionHandler(ExistUserException.class)
    protected ResponseEntity<BaseResponseDto> handleExistUserException(ExistUserException e) {
        return ResponseEntity.status(404).body(BaseResponseDto.of(404, "user exist"));
    }
	
}
