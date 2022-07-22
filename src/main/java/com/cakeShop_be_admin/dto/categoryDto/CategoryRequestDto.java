package com.cakeShop_be_admin.dto.categoryDto;

import lombok.Data;

@Data
public class CategoryRequestDto {
	
	private String categoryName;
	private String categoryDescription;
	private Integer status;
	
}
