package com.yogesh.coding.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.yogesh.coding.dao.CategoryRepo;
import com.yogesh.coding.entities.Category;
import com.yogesh.coding.entities.Product;
import com.yogesh.coding.exceptions.ResourceNotFoundException;
import com.yogesh.coding.payloads.ApiResponse;
import com.yogesh.coding.payloads.CategoryDto;
import com.yogesh.coding.payloads.ProductDTO;
import com.yogesh.coding.payloads.Response;
import com.yogesh.coding.services.FileService;
import com.yogesh.coding.services.ProductService;
import com.yogesh.coding.services.StorageService;

@RequestMapping("/api/v1")
@RestController
public class ProductController {	
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private StorageService  storageService;  
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private FileService fileService;
	

@PostMapping("/category/{categoryId}/products")
public ResponseEntity<ProductDTO> createProduct(
        @PathVariable Long categoryId,
        @RequestBody ProductDTO productDto,
        @RequestParam("image") MultipartFile image
) {
    try {
        // Call ProductService to create the product and handle image upload
        ProductDTO createdProduct = productService.createProduct(productDto, categoryId, image);
        
        // Return the created product DTO in the response
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    } catch (Exception e) {
        // Handle the exception, for example, return an error response
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}


}
