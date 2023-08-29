package com.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;
	private LocalDateTime date;
	private String orderStatus;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private Customer customer;

	@ElementCollection
	private List<Product> productList;

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
}
