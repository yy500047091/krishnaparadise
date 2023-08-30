package com.yogesh.coding.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.yogesh.coding.entities.Product;
import com.yogesh.coding.payloads.ProductDTO;

public interface ProductRepo extends JpaRepository<Product, Long>{

    @Query("SELECT p FROM Product p INNER JOIN p.category c WHERE c.name = :categoryName")
	List<ProductDTO> findByCategoryName(String categoryName);
}
