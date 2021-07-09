package com.cos.danguen.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
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
	private String title;
	private String content; // 상품내용
	
	@CreationTimestamp
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date regdate;
	private int price; // 상품가격
	private Long hitcount; //조회수
	private Long replycnt; // 좋아요수
	
	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
	@JsonIgnoreProperties("product")
	private List<Comment> comments;
}
