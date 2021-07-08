package com.cos.danguen.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	private int price; // 상품가격
	private Long replycnt; // 좋아요수
}
