package com.cos.danguen.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="file")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Files {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long fno;
	private String filename;
	private String fileOriName;
	private String fileUrl;
	
	@ManyToOne
	@JoinColumn(name="item_id")
	private Product product;

}
