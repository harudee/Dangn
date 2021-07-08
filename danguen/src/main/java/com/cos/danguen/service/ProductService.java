package com.cos.danguen.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cos.danguen.model.Product;
import com.cos.danguen.repository.ProductRepository;


@Service
public class ProductService {

	@Autowired
	private ProductRepository productrepository;
	
	@Transactional
	public List<Product> list(){
		return productrepository.findAll();
	}
}
