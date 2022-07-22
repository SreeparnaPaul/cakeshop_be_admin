package com.cakeShop_be_admin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cakeShop_be_admin.dto.Response;
import com.cakeShop_be_admin.dto.categoryDto.CategoryRequestDto;
import com.cakeShop_be_admin.entites.Category;

@Service
public interface CategoryService {
	
	public List<Category> getAllCategory();
	public Response addCategory(CategoryRequestDto categoryRequestDto);
	public Category updateCategory(Long id,Category category);
	public void deleteCategory(Long id);
	public Category getCategoryById(Long id);

}
