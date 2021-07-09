package com.cos.danguen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.danguen.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
}
