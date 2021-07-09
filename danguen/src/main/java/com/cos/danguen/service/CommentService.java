package com.cos.danguen.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cos.danguen.model.Comment;
import com.cos.danguen.repository.CommentRepository;
import com.cos.danguen.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CommentService {
	
	private final CommentRepository commentRepository;
	private final ProductRepository productRepository;
	
	//댓글추가
	public void insert(Comment comment) {
		commentRepository.save(comment);
	}
	
//	//댓글리스트
//	public List<Comment> list(Long itemid) {
//		return commentRepository.findById(itemid);
//		
//	}
	


}
