package com.yogesh.coding.services.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yogesh.coding.dao.CategoryRepo;
import com.yogesh.coding.entities.Category;
import com.yogesh.coding.entities.User;
import com.yogesh.coding.exceptions.ResourceNotFoundException;
import com.yogesh.coding.payloads.CategoryDto;
import com.yogesh.coding.payloads.UserDto;
import com.yogesh.coding.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<CategoryDto> getAllCategories() {
		 List<Category> categories = this.categoryRepo.findAll();
		 List<CategoryDto> categoryDtos = categories.stream().
				 map((cat) -> this.modelMapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
		 
		 
		return categoryDtos;
	}

	@Override
	public void deleteCategory(Long categoryId) {
		 Category category = this.categoryRepo.findById(categoryId)
				  .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId",categoryId ));
		     
        this.categoryRepo.delete(category);
	}



	@Override
	public CategoryDto addCategory(CategoryDto categoryDto) {
		Category category = this.modelMapper.map(categoryDto, Category.class);
		
	    Category categorysaved= this.categoryRepo.save(category);
	    
	    return this.modelMapper.map(categorysaved, CategoryDto.class);
	}

	@Override
	public CategoryDto getCatDetails(Long categoryId) {
		 Category category = this.categoryRepo.findById(categoryId)
				  .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId",categoryId ));
		     
		 
		return this.modelMapper.map(category, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategoryDetails(CategoryDto categoryDto, Long categoryId) {
		  Category category = this.categoryRepo.findById(categoryId)
				  .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId",categoryId ));
		     
		  
		  category.setName(categoryDto.getName());
		  category.setDescription(categoryDto.getDescription());
		  
		  Category addedCategory = this.categoryRepo.save(category);
		return this.modelMapper.map(addedCategory, CategoryDto.class);
	}
	


}
