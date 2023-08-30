package com.yogesh.coding.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;


import com.yogesh.coding.payloads.ProductDTO;

public interface ProductService {
	
	List<ProductDTO> getAllProducts();
	//GET LIST OF PRODUCTS BY CATEGORY NAME 
	List<ProductDTO> getProductsByCategoryName(String categoryName);

	void deleteProd(Long id);

	ProductDTO getProductDetails(Long productId);


	


	ProductDTO createProduct( ProductDTO productDto,Long categoryId, MultipartFile image);


}
