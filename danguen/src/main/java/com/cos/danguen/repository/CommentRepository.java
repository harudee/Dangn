package com.cos.danguen.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cos.danguen.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{
	
	@Modifying
	@Query(value = "insert into comment(content, regdate, itemid, id) values(?1, now(),?2, ?3)",
			nativeQuery = true)
	public void commentInsert(String content, Long itemid, Long id);
	
	@Query("select sc from comment sc where itemid=?1")
	public List<Comment> findByItemid(Long itemid);
	
}
