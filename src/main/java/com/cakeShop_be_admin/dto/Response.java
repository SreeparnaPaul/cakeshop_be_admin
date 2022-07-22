package com.cakeShop_be_admin.dto;

import lombok.Data;

@Data
public class Response {
	private Boolean status;
	private String message;
	private Object data;
	
	
}
