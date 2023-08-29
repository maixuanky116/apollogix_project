package com.ecommerce.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Embeddable
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	private String productName;
	private double price;
	private String description;
	private String image;

	@ManyToOne(cascade = CascadeType.ALL)
	private Color color;

	@ManyToOne(cascade = CascadeType.ALL)
	private Category category;
}
