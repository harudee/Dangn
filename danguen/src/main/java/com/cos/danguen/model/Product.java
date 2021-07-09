package com.cos.danguen.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity(name = "product")
public class Product {
	
	// tablename : Product
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long itemid; // 상품id
	private String itemname; // 상품명
	private String content; // 상품내용
	private Integer price; // 상품가격
	private Long hitcount; //조회수
	private Long replycnt; // 좋아요수
	
	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
	@JsonIgnoreProperties("product")
	private List<Comment> comments;
}
