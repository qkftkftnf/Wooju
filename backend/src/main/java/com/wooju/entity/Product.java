package com.wooju.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
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
public class Product {
	@Id
    private int id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "subtext", nullable = false)
	private String subtext;
	
	@Column(name = "price", nullable = false)
	private int price;
	
	@Column(name = "image")
	private String image;
	
	@Column(name = "type", nullable = false)
	private String type;
	
	@Column(name = "fruit_category", nullable = true)
	private int fruit_category;
	
	@Column(name = "flower_category", nullable = true)
	private int flower_category;
	
	@Column(name = "nut_category", nullable = true)
	private int nut_category;
	
	@Column(name = "herb_category", nullable = true)
	private int herb_category;
	
	@Column(name = "other_category", nullable = true)
	private int other_category;
	
	@Column(name = "situation_category", nullable = true)
	private int situation_category;
	
	@Column(name = "ingredient", nullable = false)
	private String ingredient;
	
	@Column(name = "alcohol", nullable = false)
	private double alcohol;
	
	@Column(name = "award", nullable = true)
	private String award;
	
	@Column(name = "volume", nullable = false)
	private String volume;
	
	@Column(name = "taste_standard", nullable = false)
	private String taste_standard;
	
	@Column(name = "cutted_img", nullable = false)
	private String cutted_img;
	
	@Column(name = "taste_note", nullable = false)
	private String taste_note;
	
	@Column(name = "anju_note", nullable = false)
	private String anju_note;
	
	@Column(name = "storage_note", nullable = false)
	private String storage_note;
	
	@Column(name = "other_note", nullable = false)
	private String other_note;
	
	@Column(name = "distinction", nullable = false)
	private String distinction;
	
	@Column(name = "sweet", nullable = false)
	private int sweet;
	
	@Column(name = "weight", nullable = false)
	private int weight;
	
	@Column(name = "carbonic", nullable = false)
	private int carbonic;
	
	@Column(name = "plain", nullable = false)
	private int plain;
	
	@Column(name = "acidity", nullable = false)
	private int acidity;
	
	@Column(name = "body", nullable = false)
	private int body;
	
	@Column(name = "tannin", nullable = false)
	private int tannin;
	
	@Column(name = "nutty", nullable = false)
	private int nutty;
	
	@Column(name = "richness", nullable = false)
	private int richness;
	
	@Column(name = "spicy", nullable = false)
	private int spicy;
	
	@Column(name = "bitter", nullable = false)
	private int bitter;
	
	@Column(name = "flavor", nullable = false)
	private int flavor;
	
	@Column(name = "keyword", nullable = false)
	private String keyword;
	
	@Column(name="like_num", nullable = true)
	private int like;
	
	@Column(name="review_num", nullable = false)
	private int review;
	
}
