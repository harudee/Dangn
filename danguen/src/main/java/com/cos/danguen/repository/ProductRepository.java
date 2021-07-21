package com.cos.danguen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cos.danguen.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	@Query(value = "SELECT * FROM product p WHERE p.itemname LIKE %:keyword%", nativeQuery=true)
	public List<Product> findProducts(String keyword);
	
	@Query(value = "SELECT * FROM product p ORDER BY p.hitcount DESC", nativeQuery = true)
	public List<Product> selectAll();
}
