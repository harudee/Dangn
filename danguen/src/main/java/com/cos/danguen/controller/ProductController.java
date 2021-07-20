package com.cos.danguen.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cos.danguen.config.auth.PrincipalDetails;
import com.cos.danguen.model.Files;
import com.cos.danguen.model.Product;
import com.cos.danguen.repository.ProductRepository;
import com.cos.danguen.service.FilesService;
import com.cos.danguen.service.ProductService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/product/*")
public class ProductController {

	private final ProductRepository productRepository;
	private final ProductService productService;
	private final FilesService fileService;
	
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
	public String insert(Product product, @AuthenticationPrincipal PrincipalDetails principal, @RequestParam("file") MultipartFile files, HttpServletRequest request) throws IOException {

		try {
			//files model 설정 ... 굳이 files VO를 안만들어도 될것 같은걸...?
			String fileOriName = files.getOriginalFilename();
			UUID uuid = UUID.randomUUID();
			String filename = uuid+"_"+fileOriName;
		
			//product table에 파일이름넣어주기
			product.setFileName(filename);
			
			//files 저장경로 정하기
			String savePath = request.getSession().getServletContext().getRealPath("/");
			savePath += "\\resources\\images\\";
			
			if(!new File(savePath).exists()) {
				new File(savePath).mkdir();
			}
			
			String fileUrl = savePath + filename;
			files.transferTo(new File(fileUrl));
			
			//files table에 저장하기 //필요...할까..? 이게...? 
			Files f = new Files();
		
			f.setFileOriName(fileOriName);
			f.setFilename(filename);
			f.setFileUrl(fileUrl);
			
			Long fileid = fileService.saveFile(f);
		
			//product insert
			productService.insert(product, principal.getUser());
			
		}  catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/product/list";
	}

	@GetMapping("view/{id}")
	public String view(@PathVariable Long id, Model model) {
		Product product = productService.findById(id);
		Files file = fileService.getFile(id);
		
		model.addAttribute("product", product);
		model.addAttribute("files", file);
		
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
	

}
