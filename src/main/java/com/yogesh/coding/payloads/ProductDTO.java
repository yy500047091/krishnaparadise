package com.yogesh.coding.payloads;

import org.springframework.web.multipart.MultipartFile;

import com.yogesh.coding.entities.Category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
	
	private String productName;
	private String description;
	private MultipartFile thumbnail;
	private float price;
	private int stock;
	private Category category;
	

}
