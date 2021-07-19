package com.cos.danguen.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.cos.danguen.model.Comment;
import com.cos.danguen.model.Product;
import com.cos.danguen.repository.CommentRepository;
import com.cos.danguen.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CommentService {
	
	private final CommentRepository commentRepository;
	private final ProductRepository productRepository;
	
	@Transactional
	public void insert(Comment comment) {
		
//		Optional<Product> p = productRepository.findById(comment.getProduct().getItemid());
//		p.get().setReplycnt(p.get().getReplycnt()+1);
		
		commentRepository.save(comment);
	}
	
//	
//	@Transactional
//	public List<Comment> list(Long itemid) {
//		return commentRepository.findbyItemid(itemid);
//		
//	}
	
	

}
