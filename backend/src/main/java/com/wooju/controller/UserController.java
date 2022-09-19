package com.wooju.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.wooju.auth.SsafyUserDetails;
import com.wooju.dto.request.SignUpRequestDto;
import com.wooju.dto.response.BaseResponseDto;
import com.wooju.dto.response.FirstLoginResponseDto;
import com.wooju.dto.response.LoginResponseDto;
import com.wooju.entity.User;
import com.wooju.service.OauthService;
import com.wooju.service.S3upload;
import com.wooju.service.UserService;
import com.wooju.util.JwtTokenUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;

@Api(value = "유저 API", tags = {"User"})
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	OauthService oauthService;
	
	@Autowired
	S3upload s3upload;

	@GetMapping("/login-google")
    public ResponseEntity<? extends BaseResponseDto> googleCallback(@RequestParam String code) throws IOException {
       String accessToken = oauthService.getGoogleAccessToken(code);
       String email = oauthService.createGoogleUser(accessToken);
       try {
    	   User user = userService.getUserByEmail(email,"google");
    	   System.out.println(user.getEmail());
    	   return ResponseEntity.status(200).body(LoginResponseDto.of(200, "Success", JwtTokenUtil.getToken(user)));
       } catch (Exception e) {
    	   System.out.println("Failed "+email);
    	   return ResponseEntity.status(201).body(FirstLoginResponseDto.of(201, "Signup Required", email, "google"));
       }
    }
	
	@GetMapping("/login-naver")
    public ResponseEntity<? extends BaseResponseDto> naverCallback(@RequestParam String code) throws IOException {
       String accessToken = oauthService.getNaverAccessToken(code);
       String email = oauthService.createNaverUser(accessToken);
       try {
    	   User user = userService.getUserByEmail(email,"naver");
    	   System.out.println(user.getEmail());
    	   return ResponseEntity.status(200).body(LoginResponseDto.of(200, "Success", JwtTokenUtil.getToken(user)));
       } catch (Exception e) {
    	   System.out.println("Failed "+email);
    	   return ResponseEntity.status(201).body(FirstLoginResponseDto.of(201, "Signup Required", email, "naver"));
       }
    }
	
	@PostMapping("/signup")
	@ApiOperation(value="회원 가입", notes ="신규 유저 회원 가입")
	@ApiResponses({
		@ApiResponse(code = 200 , message="성공"),
		@ApiResponse(code = 500 , message="서버오류")
	})
	public ResponseEntity<BaseResponseDto> SignUp(@RequestBody  @ApiParam(value="회원 정보", required=true)SignUpRequestDto signUpInfo) throws IOException{
		userService.SignupUser(signUpInfo);
		return ResponseEntity.status(200).body(BaseResponseDto.of(200, "Success"));
	}
	
	@GetMapping("/profile")
	@ApiOperation(value="회원 정보", notes ="내 정보 확인")
	@ApiResponses({
		@ApiResponse(code = 200 , message="성공"),
		@ApiResponse(code = 500 , message="서버오류")
	})
	public ResponseEntity<? extends BaseResponseDto> myprofile(@ApiIgnore Authentication authentication) throws IOException{
		if(authentication == null) return ResponseEntity.status(401).body(BaseResponseDto.of(401,"failed"));
		SsafyUserDetails userDetails=(SsafyUserDetails) authentication.getDetails();
		User user=userDetails.getUser();
		
		
		return ResponseEntity.status(200).body(BaseResponseDto.of(200, "Success"));
	}
	
}
