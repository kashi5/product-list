package com.example.uploadingfiles.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.uploadingfiles.model.Product;
import com.example.uploadingfiles.service.ProductService;
import com.example.uploadingfiles.util.ProductBrandList;
import com.example.uploadingfiles.util.ProductModelList;

@Controller
@RequestMapping("/product")
public class ProductController {

	private ProductService productservice;

	public ProductController(ProductService lProductService) {
		productservice = lProductService;
	}

	// add mapping for "/list"

		@RequestMapping("/list")
		public String listProducts(Model theModel) {
			
			// get products from db
			List<Product> theProducts = productservice.findAll();
	
			
			// add to the spring model
			theModel.addAttribute("products", theProducts);
			
			return "list-products";
		}
		
		@GetMapping("/details")
		public String listProductsDetail(Model theModel) {
			
			// get products from db
			List<String> productItems = productservice.findDistinctProductname();
			
			List<ProductBrandList> brandItems = productservice.findProductsbyBrand();
			
			List<ProductModelList> modelItems = productservice.findProductsByModel();
			
		
			// add to the spring model
			theModel.addAttribute("productitems", productItems);
			theModel.addAttribute("branditems", brandItems);
			theModel.addAttribute("modeltitems", modelItems);
			
			
			return "details";
		}
		
		

	
}
