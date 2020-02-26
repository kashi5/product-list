package com.example.uploadingfiles.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.uploadingfiles.dao.ProductRepository;
import com.example.uploadingfiles.model.Product;
import com.example.uploadingfiles.util.ProductBrandList;
import com.example.uploadingfiles.util.ProductModelList;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;
	
	@Autowired
	public ProductServiceImpl(ProductRepository theProductRepository) {
		productRepository = theProductRepository;
	}
	
	@Override
	public List<Product> findAll() {
		return (List<Product>) productRepository.findAll();
	}

	@Override
	public List<String> findDistinctProductname() {
	
		return (List<String>) productRepository.findDistinctProductname();
	}
	
	@Override
	public List<ProductBrandList> findProductsbyBrand() {
	
		return (List<ProductBrandList>) productRepository.findProductsbyBrand();
	}
	
	@Override
	public List<ProductModelList> findProductsByModel() {
	
		return (List<ProductModelList>) productRepository.findProductsByModel();
	}




}