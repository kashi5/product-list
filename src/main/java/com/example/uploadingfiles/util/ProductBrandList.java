package com.example.uploadingfiles.util;

public class ProductBrandList {
	
	private long brandcount;
	private String productName;
	private String brand;
	private String model;
	
	
	public ProductBrandList(long brandcount, String productName, String brand, String model) {
		this.brandcount = brandcount;
		this.productName = productName;
		this.brand = brand;
		this.model = model;
	}


	public long getBrandcount() {
		return brandcount;
	}


	public void setBrandcount(long brandcount) {
		this.brandcount = brandcount;
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

	
}
