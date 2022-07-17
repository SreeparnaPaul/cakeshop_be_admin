package com.cakeShop_be_admin.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Category addCategory(Category category) {
		
		return categoryRepository.save(category);
	}

	@Override
	public Category updateCategory(Long id, Category category) {
		Category existingCategory=categoryRepository.findById(id).get();
		existingCategory.setCategoryName(category.getCategoryName());
		existingCategory.setCategoryDescription(category.getCategoryDescription());
		existingCategory.setCreatedAt(category.getCreatedAt());
		existingCategory.setStatus(category.getStatus());
		existingCategory.setUpdatedAt(category.getUpdatedAt());
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

	
}
