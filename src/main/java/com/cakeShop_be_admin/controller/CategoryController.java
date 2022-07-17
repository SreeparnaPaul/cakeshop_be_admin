package com.cakeShop_be_admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cakeShop_be_admin.entites.Category;
import com.cakeShop_be_admin.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/getCategoryById/{id}")
	public Category getCategoryById(@PathVariable Long id) {
		return categoryService.getCategoryById(id);	
	}
	
	@GetMapping("/getAllCategory")
	public List getAllCategory(){
		return categoryService.getAllCategory();
	}
	
	@PostMapping("/addCategory")
	public Category addCategory(@RequestBody Category category) {
		return categoryService.addCategory(category);
		
	}
	
	@PutMapping("/updateCategory/{id}")
	public Category updateCategory(@PathVariable Long id,@RequestBody Category category) {
		return this.categoryService.updateCategory(id, category);
		
	}
	
	@DeleteMapping("/deleteCategory/{id}")
	public String deleteCategory(@PathVariable Long id) {
		categoryService.deleteCategory(id);
		return "deleted";
	}
}
