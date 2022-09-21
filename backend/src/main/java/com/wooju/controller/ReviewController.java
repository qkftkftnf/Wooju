package com.wooju.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wooju.auth.SsafyUserDetails;
import com.wooju.dto.ReviewDto;
import com.wooju.dto.ReviewMainDto;
import com.wooju.dto.request.ModifyReviewRequestDto;
import com.wooju.dto.request.ReviewRequestDto;
import com.wooju.dto.request.SignUpRequestDto;
import com.wooju.dto.response.BaseResponseDto;
import com.wooju.dto.response.ReviewDetailResponseDto;
import com.wooju.dto.response.ReviewMainResponseDto;
import com.wooju.entity.User;
import com.wooju.service.ReviewService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;

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
	
	
	@PostMapping("")
	@ApiOperation(value="리뷰 작성", notes ="리뷰 작성")
	@ApiResponses({
		@ApiResponse(code = 200 , message="성공"),
		@ApiResponse(code = 500 , message="서버오류")
	})
	public ResponseEntity<? extends BaseResponseDto> review(@ApiIgnore Authentication authentication,
			@RequestBody @ApiParam(value="리뷰 내용", required=true)ReviewRequestDto dto){
		
		if(authentication == null) return ResponseEntity.status(401).body(BaseResponseDto.of(401,"failed"));
		SsafyUserDetails userDetails=(SsafyUserDetails) authentication.getDetails();
		User user=userDetails.getUser();
		
		reviewService.createReview(user,dto);
		
		return ResponseEntity.status(200).body(BaseResponseDto.of(200, "success"));
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "리뷰 상세 조회", notes = "해당 리뷰의 상세 정보를 조회한다.") 
    @ApiResponses({
        @ApiResponse(code = 200, message = "성공"),
        @ApiResponse(code = 500, message = "서버 오류")
    })
	public ResponseEntity<? extends BaseResponseDto> getReviewDetail(@ApiIgnore Authentication authentication,
			@PathVariable("id") int id) throws Exception {
		ReviewDto review = reviewService.getReviewDetail(id);
		return ResponseEntity.status(200).body(ReviewDetailResponseDto.of(200, "Success", review));
	}

	@PutMapping("")
	@ApiOperation(value = "리뷰 수정", notes = "해당 리뷰의  정보를 수정한다.") 
    @ApiResponses({
        @ApiResponse(code = 200, message = "성공"),
        @ApiResponse(code = 500, message = "서버 오류")
    })
	public ResponseEntity<? extends BaseResponseDto> getReviewDetail(@ApiIgnore Authentication authentication,
			@RequestBody @ApiParam(value="리뷰 내용", required=true)ModifyReviewRequestDto dto) throws Exception {
		
		if(authentication == null) return ResponseEntity.status(401).body(BaseResponseDto.of(401,"failed"));
		SsafyUserDetails userDetails=(SsafyUserDetails) authentication.getDetails();
		int id=userDetails.getUserId();
		
		reviewService.modifyReview(id,dto);
		return ResponseEntity.status(200).body(BaseResponseDto.of(200, "Success"));
	}
	
	@DeleteMapping("/{review_id}")
	@ApiOperation(value = "리뷰 수정", notes = "해당 리뷰의  정보를 수정한다.") 
    @ApiResponses({
        @ApiResponse(code = 200, message = "성공"),
        @ApiResponse(code = 500, message = "서버 오류")
    })
	public ResponseEntity<? extends BaseResponseDto> delete(@ApiIgnore Authentication authentication,
			@PathVariable("review_id") int id) throws Exception {
		
		if(authentication == null) return ResponseEntity.status(401).body(BaseResponseDto.of(401,"failed"));
		SsafyUserDetails userDetails=(SsafyUserDetails) authentication.getDetails();
		int user_id=userDetails.getUserId();
		
		reviewService.deleteReview(user_id,id);
		return ResponseEntity.status(200).body(BaseResponseDto.of(200, "Success"));
	}
}
