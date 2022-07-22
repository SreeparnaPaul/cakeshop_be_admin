package com.cakeShop_be_admin.serviceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cakeShop_be_admin.dto.Response;
import com.cakeShop_be_admin.dto.categoryDto.CategoryRequestDto;
import com.cakeShop_be_admin.entites.Category;
import com.cakeShop_be_admin.repository.CategoryRepository;
import com.cakeShop_be_admin.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> getAllCategory() {
		List<Category> categories=new ArrayList<>();
		categoryRepository.findAll().forEach(categories::add);
		return categories;
	}

	@Override
	public Category updateCategory(Long id, Category category) {
		Category existingCategory=categoryRepository.findById(id).get();
		existingCategory.setCategoryName(category.getCategoryName());
		existingCategory.setCategoryDescription(category.getCategoryDescription());
		existingCategory.setStatus(category.getStatus());
		existingCategory.setUpdatedAt(LocalDateTime.now());
		categoryRepository.save(existingCategory);
		return existingCategory;
	}

	@Override
	public void deleteCategory(Long id) {
		categoryRepository.deleteById(id);
		
	}

	@Override
	public Category getCategoryById(Long id) {
		return categoryRepository.findById(id).get();
	}

	@Override
	public Response addCategory(CategoryRequestDto categoryRequestDto) {
		Response response =new Response();
	    Category category = convertRequestDtoToEntity(categoryRequestDto);
	    category.setCreatedAt(LocalDateTime.now());
	    Category savedCategory = categoryRepository.save(category);
	    if (!Objects.isNull(savedCategory)) {
			response.setStatus(true);
			response.setMessage("Success");
			response.setData("Category added successfully");
		} else {
			response.setStatus(false);
			response.setMessage("Failed");
			response.setData("Something went wrong!");
		}
		return response;
	}

	public Category convertRequestDtoToEntity(CategoryRequestDto categoryRequestDto) {
		Category category =new Category();
		category.setCategoryDescription(categoryRequestDto.getCategoryDescription());
		category.setCategoryName(categoryRequestDto.getCategoryName());
		category.setStatus(categoryRequestDto.getStatus());
		return category;
	}
}
