package com.yogesh.coding.services.Impl;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.yogesh.coding.dao.CategoryRepo;
import com.yogesh.coding.dao.ProductRepo;
import com.yogesh.coding.entities.Category;
import com.yogesh.coding.entities.Product;
import com.yogesh.coding.exceptions.ApiException;
import com.yogesh.coding.exceptions.ResourceNotFoundException;
import com.yogesh.coding.payloads.ProductDTO;
import com.yogesh.coding.services.FileService;
import com.yogesh.coding.services.ProductService;


@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ProductRepo productRepo;
	@Autowired
	private FileService fileService;
	
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<ProductDTO> getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void deleteProd(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProductDTO getProductDetails(Long productId) {
		// TODO Auto-generated method stub
		return null;
	}


    @Value("${disk.upload.basepath}") // Inject the base path from application properties
    private String basePath;

    @Override
    @Transactional
    public ProductDTO createProduct(ProductDTO productDto, Long categoryId, MultipartFile image) {
        try {
            Category category = this.categoryRepo.findById(categoryId)
                    .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));

            // Create a product entity from the DTO
            Product product = modelMapper.map(productDto, Product.class);

            // Set the category for the product
            product.setCategory(category);

            // Save the product entity to the database
            Product savedProduct = productRepo.save(product);

            // Upload and set the image file name using the basePath
            String fileName = fileService.uploadImage(basePath, image);
            savedProduct.setThumbnail(fileName);

            // Update the product with the image file name
            Product updatedProduct = productRepo.save(savedProduct);

            // Map the updated product back to DTO and return
            return modelMapper.map(updatedProduct, ProductDTO.class);
        } catch (ResourceNotFoundException e) {
            // You can throw a custom ApiException here
            throw new ApiException("Resource not found: " + e.getMessage());
        } catch (IOException e) {
            // You can throw a custom ApiException here
            throw new ApiException("IO error occurred: " + e.getMessage());
        }
    }



	@Override
	public List<ProductDTO> getProductsByCategoryName(String categoryName) {
		// TODO Auto-generated method stub
		return null;
	}

}



