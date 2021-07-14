package com.cos.danguen.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cos.danguen.config.auth.PrincipalDetails;

import com.cos.danguen.dto.CMRespDTO;

import com.cos.danguen.model.Product;
import com.cos.danguen.repository.ProductRepository;
import com.cos.danguen.service.ProductService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/product/*")
public class ProductController {

	private final ProductRepository productRepository;
	private final ProductService productService;
	
	@CrossOrigin
	@GetMapping("list")
	public CMRespDTO<?> findAll(){
		return new CMRespDTO<>(1,"ok",productRepository.findAll());
	}

	@CrossOrigin
	@PostMapping("/insert")
	public CMRespDTO<?> insert(@RequestBody Product product, @AuthenticationPrincipal PrincipalDetails principal) {
		return new CMRespDTO<>(1, "ok", productService.insert(product, principal.getUser());
	}

	@CrossOrigin
	@GetMapping("/view/{id}")
	public CMRespDTO<?> view(@PathVariable Long id) {
		return new CMRespDTO<>(1, "ok", productService.findById(id));
	}

	@CrossOrigin
	@DeleteMapping("/delete/{id}")
	public CMRespDTO<?> delete(@PathVariable Long id) {
		productRepository.deleteById(id);
		return new CMRespDTO<>(1, "ok", null);
	}
	

	@CrossOrigin
	@PutMapping("/update/{id}")
	public CMRespDTO<?> update(@PathVariable Long id, @RequestBody Product product) {

		
		System.out.println("update 실행되냐");//controller 타는지 확인
		Product productEntity = productRepository.findById(id).get();
		
		productEntity.setItemname(product.getItemname());
		productEntity.setContent(product.getContent());
		productEntity.setPrice(product.getPrice());
		
		return new CMRespDTO<>(1, "ok", productRepository.save(productEntity));
	}
	

}
