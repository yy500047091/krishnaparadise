package com.yogesh.coding.services;

import java.util.List;

import com.yogesh.coding.payloads.CategoryDto;

public interface CategoryService {

	List<CategoryDto> getAllCategories();


	void deleteCategory(Long categoryId);

	
	CategoryDto updateCategoryDetails(CategoryDto categoryDto,Long CategoryId);
	
	CategoryDto addCategory(CategoryDto transientCategory);


	CategoryDto getCatDetails(Long categoryId);
}
