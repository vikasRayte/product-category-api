package com.ProductCategory.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ProductCategory.Entity.Product;

public interface ProductService{
	
	//save Product
	
	Product saveProduct(Product product);
	
	//Get All Product

	List<Product> getAllProduct();
	
	//Update By Id
	
	Product updateProduct(Product product, Integer productId);
	
	//Delete Product By Id

	void delectProductById(Integer productId);
	
	//get by Id
	
	Optional<Product> findById(Integer productId);
	
	//Pagination Product
	
	Page<Product> getAllPage(Pageable pageable);
 	

}
