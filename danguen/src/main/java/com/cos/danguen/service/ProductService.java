package com.cos.danguen.service;

import java.io.FileReader;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cos.danguen.model.Files;
import com.cos.danguen.model.Product;
import com.cos.danguen.model.User;
import com.cos.danguen.repository.FileRepository;
import com.cos.danguen.repository.ProductRepository;


@Service
public class ProductService {

	@Autowired
	private ProductRepository productrepository;
	@Autowired
	private FileRepository fileRepository;
	
	@Transactional
	public List<Product> list(){
		return productrepository.findAll();
	}
	
	@Transactional
	public Long count() {
		return productrepository.count();
	}
	
	@Transactional
	public void insert(Product product, User user) {
		product.setUser(user);
		productrepository.save(product);
	}
	
	@Transactional
	public void save(Files files) {
		Files f = new Files();
		f.setFilename(files.getFilename());
		f.setFileOriName(files.getFileOriName());
		f.setFileUrl(files.getFileUrl());
		
		fileRepository.save(f);
	}
	
	
	@Transactional
	public Product findById(Long id) {
	Product product =	productrepository.findById(id).get();
	//조회수 증가
	product.setHitcount(product.getHitcount()+1);
	
	return product;
	}
	
	@Transactional
	public void delete(Long id) {
		productrepository.deleteById(id);
	}
	
	@Transactional
	public Product view(Long id) {
		Product product =	productrepository.findById(id).get();
	 return product;
	}
	
	@Transactional 
	public void update(Product product, Long id) {
		Product p = productrepository.findById(id).get();
		p.setItemname(product.getItemname());
		p.setContent(product.getContent());
		p.setPrice(product.getPrice());
	}
	
	@Transactional
	public List<Product> search(String keyword) {
		return productrepository.findProducts(keyword);
		
	}
	

}
