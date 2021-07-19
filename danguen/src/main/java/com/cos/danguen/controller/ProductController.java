package com.cos.danguen.controller;

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
import com.cos.danguen.model.User;
import com.cos.danguen.repository.ProductRepository;
import com.cos.danguen.service.ProductService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RestController
@RequestMapping
public class ProductController {

	private final ProductRepository productRepository;
	private final ProductService productService;
	
	
	@GetMapping("/list")
	public CMRespDTO<?> findAll(){
		return new CMRespDTO<>(1,"ok",productRepository.findAll());
	}


	
	@PostMapping("/product/insert")
	public CMRespDTO<?> insert(@RequestBody Product product) {
		return new CMRespDTO<>(1, "ok", productRepository.save(product));

	}

	
	@GetMapping("/view/{id}")
	public CMRespDTO<?> view(@PathVariable Long id) {
		return new CMRespDTO<>(1, "ok", productService.findById(id));
	}

	
	@DeleteMapping("/product/delete/{id}")
	public CMRespDTO<?> delete(@PathVariable Long id) {
		productRepository.deleteById(id);
		return new CMRespDTO<>(1, "ok", null);
	}
	

	@CrossOrigin
	@PutMapping("product/update/{id}")
	public CMRespDTO<?> update(@PathVariable Long id, @RequestBody Product product) {

		Product productEntity = productRepository.findById(id).get();
		
		productEntity.setItemname(product.getItemname());
		productEntity.setContent(product.getContent());
		productEntity.setPrice(product.getPrice());
		
		return new CMRespDTO<>(1, "ok", productRepository.save(productEntity));
	}
	

}
