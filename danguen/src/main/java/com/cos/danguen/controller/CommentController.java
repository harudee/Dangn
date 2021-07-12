package com.cos.danguen.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.danguen.model.Comment;
import com.cos.danguen.service.CommentService;

import lombok.RequiredArgsConstructor;

//@RequiredArgsConstructor
//@Controller
//@RequestMapping("/reply/*")
public class CommentController {
	
//	private final CommentService cService;
//	
//	//댓글추가
//	@PostMapping("insert/{id}")
//	@ResponseBody
//	public String comments(@RequestBody Comment comment) {
//		System.out.println(comment);
//		cService.insert(comment);
//		return "success";
//	}
	
//	//댓글리스트
//	@GetMapping("commentList/{id}")
//	public List<Comment> list(@PathVariable Long itemid){
//		List<Comment> clists = cService.list(itemid);
//		return clists;
//	}
	
	

}
