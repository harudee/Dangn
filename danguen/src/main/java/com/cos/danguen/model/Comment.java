package com.cos.danguen.model;

import java.sql.Date;

public class Comment {

	// tablename : Comment
	private Long commentid; // 댓글번호
	private User user; // 사용자
	private String title; // 제목
	private String content; // 내용
	private Date regdate; // 날짜
	private Product product; // 등록된 게시글번호
	
	
}
