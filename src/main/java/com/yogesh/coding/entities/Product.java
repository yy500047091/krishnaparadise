package com.yogesh.coding.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="products")
public class Product  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	@Column(name="productname")
	private String productName;
	private String description;
	private float price;
	private int stock;
	
	private String thumbnail;
	

	
	@ManyToOne 
	@JoinColumn(name="fk_category_id")
	private Category category;

	public void setThumbnail(String thumbnail1) {
		// TODO Auto-generated method stub
		
	}
	
	

	
	
	
	
}
