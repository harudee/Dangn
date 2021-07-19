package com.cos.danguen.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cos.danguen.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{
	
	
	
	
//	@Query("SELECT sc FROM comment sc WHERE itemid?1")
//	public List<Comment> findbyItemid(Long itemid);
}
