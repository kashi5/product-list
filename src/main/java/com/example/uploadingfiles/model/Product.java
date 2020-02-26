package com.example.uploadingfiles.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
	//@Column(name="id")
	private int id;
	
	//@Column(name="product_name")
	private String productName;
	
	//@Column(name="brand")
	private String brand;
	
	//@Column(name="model")
	private String model;
	
	//@Column(name="price")
	private int price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", brand=" + brand + ", model=" + model
				+ ", price=" + price + "]";
	}
	
	
	
	

	
}
