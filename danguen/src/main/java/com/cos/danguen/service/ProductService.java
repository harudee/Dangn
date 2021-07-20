package com.cos.danguen.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cos.danguen.model.Product;
import com.cos.danguen.model.User;
import com.cos.danguen.repository.ProductRepository;


@Service
public class ProductService {

	@Autowired
	private ProductRepository productrepository;
	
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
	public Product findById(Long id) {
	Product product =	productrepository.findById(id).get();
//	product.setReplycnt(product.getReplycnt()+1);
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
