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
		
		//product의 replycnt올리기 //^^? 왜 안돼...? : 왜냐면 replycnt가 null이니까 0으로 맞춰줘라
		Optional<Product> p = productRepository.findById(comment.getProduct().getItemid());
		p.get().setReplycnt(p.get().getReplycnt()+1);
		
		
		//commentRepository.save(comment);
		
		//JPQL
		commentRepository.commentInsert(
				comment.getContent(), 
				comment.getProduct().getItemid(), 
				comment.getUser().getId()
				);
		
	}
	
	@Transactional
	public List<Comment> list(Long itemid) {
		return commentRepository.findByItemid(itemid);
		
	}
	
	

}
