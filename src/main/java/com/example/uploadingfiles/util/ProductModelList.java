package com.example.uploadingfiles.util;

public class ProductModelList {
	
	private long modelcount;
	private String productName;
	private String brand;
	private String model;
	
	public ProductModelList(long modelcount, String productName, String brand, String model) {
		this.modelcount = modelcount;
		this.productName = productName;
		this.brand = brand;
		this.model = model;
	}

	public long getModelcount() {
		return modelcount;
	}

	public void setModelcount(long modelcount) {
		this.modelcount = modelcount;
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
