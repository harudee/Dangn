package com.cos.danguen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.danguen.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{
	
}
