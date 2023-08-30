package com.yogesh.coding.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="orders")
public class Orders  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderid;
	

	private Date orderDate;
	private float totalAmount;
	
	@Enumerated(EnumType.STRING)
	private TransactionStatus status; 
	
	@ManyToOne
	@JoinColumn(name="fk_userId")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="fk_address_id")
	private Address address;
	
	@ManyToOne
	@JoinColumn(name="fk_product_id")
	private Product product;
}
