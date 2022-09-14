package com.wooju.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wooju.dto.response.BaseResponseDto;
import com.wooju.dto.response.FirstLoginResponseDto;
import com.wooju.dto.response.LoginResponseDto;
import com.wooju.entity.User;
import com.wooju.service.OauthService;
import com.wooju.service.UserService;
import com.wooju.util.JwtTokenUtil;

import io.swagger.annotations.Api;

@Api(value = "유저 API", tags = {"User"})
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	OauthService oauthService;

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
	
	
}
