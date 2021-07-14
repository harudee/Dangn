package com.cos.danguen.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.cos.danguen.service.ProductService;

@Controller
@RequestMapping("/product/*")
public class ProductController {

	@Autowired
	private ProductService productService;

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
		productService.update(product, id);
		return "success";
		
	}

	
	@GetMapping("detail")
	public String detail() {
		return "/product/detail";
	}
	

}
