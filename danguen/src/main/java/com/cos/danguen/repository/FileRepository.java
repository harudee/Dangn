package com.cos.danguen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.danguen.model.Files;

public interface FileRepository extends JpaRepository<Files, Long>{

}
