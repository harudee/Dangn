package com.cos.danguen.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

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
	private Long replycnt; // 댓글 수
	
	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnoreProperties("product")
	private List<Comment> comments;
	
	@ManyToOne
	@JoinColumn(name="username")
	private User user;
	
	@PrePersist
	public void prePersist() { //기본값 0으로 설정!
		this.hitcount = this.hitcount == null ? 0 : this.hitcount;
		this.replycnt = this.replycnt == null ? 0 : this.replycnt;
	}
}
