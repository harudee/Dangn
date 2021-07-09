package com.cos.danguen.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity(name = "comment")
public class Comment {

	// tableName : Comment
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long commentid; // 댓글번호
	
	@ManyToOne
    @JoinColumn(name="id")
	private User user; // 사용자
	private String content; // 내용
	
	@CreationTimestamp
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date regdate; // 날짜
	
	@ManyToOne
    @JoinColumn(name="itemid")
	private Product product; // 등록된 게시글번호
	
	
}
