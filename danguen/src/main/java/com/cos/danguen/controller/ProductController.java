package com.cos.danguen.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.danguen.config.auth.PrincipalDetails;
import com.cos.danguen.model.Product;
import com.cos.danguen.repository.ProductRepository;
import com.cos.danguen.service.ProductService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/product/*")
public class ProductController {

	private final ProductRepository productRepository;
	private final ProductService productService;

	@GetMapping("list")
	public String list(Model model) {
		model.addAttribute("product", productService.list());
		model.addAttribute("count", productService.count());
		return "/product/list";
	}

	@GetMapping("insert")
	@PreAuthorize("isAuthenticated()")
	public String insert() {
		return "/product/insert";
	}

	@PostMapping("insert")
	public String insert(Product product, @AuthenticationPrincipal PrincipalDetails principal) {

		productService.insert(product, principal.getUser());

		return "redirect:/product/list";
	}

	@GetMapping("view/{id}")
	public String view(@PathVariable Long id, Model model) {
		Product product = productService.findById(id);
		model.addAttribute("product", product);
		return "/product/view";
	}

	@DeleteMapping("delete/{id}")
	@ResponseBody
	public String delete(@PathVariable Long id) {
		productService.delete(id);
		return "success";
	}

	@GetMapping("update/{id}")
	public String update(@PathVariable Long id, Model model) {
		model.addAttribute("product", productService.view(id));
		return "/product/update";

	}
	
	@PutMapping("update/{id}")
	@ResponseBody
	public String update(@PathVariable Long id, @RequestBody Product product) {
		System.out.println("Put Update 불러옴");
		productService.update(product, id);
		return "success";

	}
	
	@GetMapping("detail")
	public String detail() {
		return "/product/detail";
	}
	
	@PostMapping("search")
	public String search(HttpServletRequest request, Model model, String keyword) {
		System.out.println("search Controller 불러옴");
		keyword = request.getParameter("header-search-input");
		System.out.println(keyword);
		model.addAttribute("products",productService.search(keyword));
		System.out.println(productService.search(keyword));
		return "/product/search";
		 
	}
	

//	@GetMapping("list")
//	public String list(Model model) {
//		model.addAttribute("product", productService.list());
//		model.addAttribute("count", productService.count());
//		return "/product/list";
//	}
//	
//	@GetMapping("insert")
//	@PreAuthorize("isAuthenticated()")
//	public String insert() {
//		return "/product/insert";
//	}

//	@GetMapping("/list")
//	public CMRespDTO<?> findAll(){
//		return new CMRespDTO<>(1,"ok",productRepository.findAll());
//	}
//
//
//	
//	@PostMapping("/product/insert")
//	public CMRespDTO<?> insert(@RequestBody Product product) {
//		return new CMRespDTO<>(1, "ok", productRepository.save(product));
//
//	}
//
//	
//	@GetMapping("/view/{id}")
//	public CMRespDTO<?> view(@PathVariable Long id) {
//		return new CMRespDTO<>(1, "ok", productService.findById(id));
//	}
//
//	
//	@DeleteMapping("/product/delete/{id}")
//	public CMRespDTO<?> delete(@PathVariable Long id) {
//		productRepository.deleteById(id);
//		return new CMRespDTO<>(1, "ok", null);
//	}
//	
//
//	@CrossOrigin
//	@PutMapping("product/update/{id}")
//	public CMRespDTO<?> update(@PathVariable Long id, @RequestBody Product product) {
//
//		Product productEntity = productRepository.findById(id).get();
//		
//		productEntity.setItemname(product.getItemname());
//		productEntity.setContent(product.getContent());
//		productEntity.setPrice(product.getPrice());
//		
//		return new CMRespDTO<>(1, "ok", productRepository.save(productEntity));
//	}

}
