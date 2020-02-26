package com.example.uploadingfiles.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.uploadingfiles.model.Product;
import com.example.uploadingfiles.util.ProductBrandList;
import com.example.uploadingfiles.util.ProductModelList;

public interface ProductRepository extends CrudRepository<Product, Integer> {

	Page<Product> findAll(Pageable pageable);

	//select distinct product_name from products.product;
	//select count(brand),product_name,brand from products.product group by brand ;
	//select count(model),product_name,brand,model from products.product group by model ;
	//select count(p.brand),p.productName,p.brand from Product p group by p.brand
	//select count(p.model),p.productName,p.brand,p.model from Product p group by p.model
	//select p.productName from Product p
	//select new com.example.uploadingfiles.util.ProductItemsResult(p.productName) from Product p


	@Query(value = "select distinct p.productName from Product p", nativeQuery = false )
	List<String> findDistinctProductname();
	
	@Query(value = "select new com.example.uploadingfiles.util.ProductBrandList(count(p.brand) as brandcount, p.productName as productName,p.brand as brand,p.model as model) from Product p group by p.brand", nativeQuery = false )
	List<ProductBrandList> findProductsbyBrand();

	@Query(value = "select new com.example.uploadingfiles.util.ProductModelList(count(p.model) as modelcount, p.productName as productName,p.brand as brand,p.model as model) from Product p group by p.model", nativeQuery = false )
	List<ProductModelList> findProductsByModel();
	
	
	
}
