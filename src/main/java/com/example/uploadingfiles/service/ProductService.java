package com.example.uploadingfiles.service;

import java.util.List;

import com.example.uploadingfiles.model.Product;
import com.example.uploadingfiles.util.ProductBrandList;
import com.example.uploadingfiles.util.ProductModelList;

public interface ProductService {
	public List<Product> findAll();
	
	//select distinct product_name from products.product;
	//select count(brand),product_name,brand from products.product group by brand ;
	//select count(model),product_name,brand,model from products.product group by model ;
	
	public List<String> findDistinctProductname();
	
	public List<ProductBrandList> findProductsbyBrand();
	
	public List<ProductModelList> findProductsByModel();



}
