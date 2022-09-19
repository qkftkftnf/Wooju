package com.wooju.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@Column(name = "img", nullable = false)
	private String img;
	
	@Column(name = "email", nullable = false, length = 80)
	private String email;
	
	@Column(name = "usertype", nullable = false)
	private String usertype;
	
	@Column(name = "nickname", nullable = false)
	private String nickname;
	
	@Column(name = "birthdate", nullable = false)
	private LocalDate birthdate;
	
	@Column(name = "gender", nullable = false)
	private String gender;
}
