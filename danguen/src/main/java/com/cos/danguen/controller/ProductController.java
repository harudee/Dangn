package com.cos.danguen.controller;

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
<<<<<<< Updated upstream
@RestController
=======
@Controller
>>>>>>> Stashed changes
@RequestMapping("/product/*")
public class ProductController {

	private final ProductRepository productRepository;
	private final ProductService productService;
	
<<<<<<< Updated upstream
	@CrossOrigin
	@GetMapping("list")
	public CMRespDTO<?> findAll(){
		return new CMRespDTO<>(1,"ok",productRepository.findAll());
	}

	@CrossOrigin
	@PostMapping("/insert")
	public CMRespDTO<?> insert(@RequestBody Product product, @AuthenticationPrincipal PrincipalDetails principal, User user) {
		return null;//new CMRespDTO<>(1, "ok", productService.insert(product,user));
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

		Product productEntity = productRepository.findById(id).get();
		
		productEntity.setItemname(product.getItemname());
		productEntity.setContent(product.getContent());
		productEntity.setPrice(product.getPrice());
		
		return new CMRespDTO<>(1, "ok", productRepository.save(productEntity));
	}
=======
	
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
>>>>>>> Stashed changes
	

}
