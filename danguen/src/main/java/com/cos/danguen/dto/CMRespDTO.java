package com.cos.danguen.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CMRespDTO<T> {
	
	private Integer code;
	private String msg;
	private T data;

}
