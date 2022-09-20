package com.wooju.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
public class Review {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	@Column(name = "img")
	private String img;
	
	@Column(name = "content", nullable = false, columnDefinition = "TEXT")
	private String content;
	
	@Column(name ="star_rate", nullable =false)
	private double star;
	

}
