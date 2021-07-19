package com.cos.danguen.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.danguen.config.auth.PrincipalDetails;
import com.cos.danguen.model.Comment;
import com.cos.danguen.model.Product;
import com.cos.danguen.service.CommentService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/reply/*")
public class CommentController {
	
	private final CommentService cService;
	
	//댓글추가
	@PostMapping("insert/{itemid}")
	@ResponseBody
	public ResponseEntity<String> comments(@PathVariable Long itemid, @RequestBody Comment comment, @AuthenticationPrincipal PrincipalDetails principal) {
		
		Product p = new Product();
		p.setItemid(itemid);
		
		System.out.println(principal.getUser());
		
		comment.setUser(principal.getUser());
		
		
		System.out.println(comment);
		
		cService.insert(comment);
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
//	//댓글리스트
//	@GetMapping("commentList/{itemid}")
//	public List<Comment> list(@PathVariable Long itemid){
//		List<Comment> clists = cService.list(itemid);
//		return clists;
//	}
	
	

}
