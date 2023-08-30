package com.yogesh.coding.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yogesh.coding.payloads.ApiResponse;
import com.yogesh.coding.payloads.CategoryDto;
import com.yogesh.coding.services.CategoryService;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	//POST
	
	@PostMapping("/add")
	public ResponseEntity<CategoryDto>createCategory(@RequestBody CategoryDto categoryDto){
		
		CategoryDto createCategory = this.categoryService.addCategory(categoryDto);
		return new  ResponseEntity<CategoryDto>(createCategory,HttpStatus.CREATED);
	
		
	}
	
	
	//PUT
	
	@PutMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto,@PathVariable Long categoryId){
		
		CategoryDto updatedCategory = this.categoryService.updateCategoryDetails(categoryDto, categoryId);
		
		
		return new ResponseEntity<CategoryDto>(updatedCategory,HttpStatus.OK);
		
	}
	
	
	//GET
	
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAllCategories(){
		
		List<CategoryDto> listCat =this.categoryService.getAllCategories();
		
		return new ResponseEntity<List<CategoryDto>>(listCat,HttpStatus.OK);
		
	}
	
	@GetMapping("/{catId}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable Long catId) {

		CategoryDto categoryDto = this.categoryService.getCatDetails(catId);

		return new ResponseEntity<CategoryDto>(categoryDto, HttpStatus.OK);

	}
	
	

	//DELETE
	
	@DeleteMapping("/{catId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Long catId) {
		this.categoryService.deleteCategory(catId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("category is deleted successfully !!", true),
				HttpStatus.OK);
	}

}
