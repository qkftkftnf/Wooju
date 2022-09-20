package com.wooju.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wooju.dto.ReviewMainDto;
import com.wooju.dto.response.BaseResponseDto;
import com.wooju.dto.response.ReviewMainResponseDto;
import com.wooju.service.ReviewService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "커뮤니티 API", tags = {"Review"})
@RestController
@RequestMapping("/review")
public class ReviewController {
	@Autowired
	ReviewService reviewService;
	
	
	@GetMapping("")
	@ApiOperation(value="커뮤니티 메인", notes ="커뮤니티 메인 리스트 조회")
	@ApiResponses({
		@ApiResponse(code = 200 , message="성공"),
		@ApiResponse(code = 500 , message="서버오류")
	})
	public ResponseEntity<? extends BaseResponseDto> list(){
		
		ReviewMainDto dto=reviewService.getMainPage();
		
		return ResponseEntity.status(200).body(ReviewMainResponseDto.of(200, "Success",dto));
	}
	
}
