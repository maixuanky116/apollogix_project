package com.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class Color {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int colorId;
	private String colorName;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "color")
	private List<Product> productList;
	
}
