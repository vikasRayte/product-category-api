package com.ProductCategory.ServiceImpl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ProductCategory.Entity.Product;
import com.ProductCategory.Repository.ProductRepository;
import com.ProductCategory.Service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return (List<Product>) productRepository.findAll();
	}

	@Override
	public Product updateProduct(Product product, Integer productId) {
		// TODO Auto-generated method stub
		Product products = productRepository.findById(productId).get();

		if (Objects.nonNull(product.getProductName()) && !"".equalsIgnoreCase(product.getProductName())) {
			products.setProductName(product.getProductName());
		}

		if (Objects.nonNull(product.getProductPrice()) && !"".equalsIgnoreCase(product.getProductPrice())) {
			products.setProductPrice(product.getProductPrice());
		}

		return productRepository.save(products);
	}

	@Override
	public void delectProductById(Integer productId) {
		// TODO Auto-generated method stub
		productRepository.deleteById(productId);
	}

	@Override
	public Optional<Product> findById(Integer productId) {
		// TODO Auto-generated method stub
		return productRepository.findById(productId);
	}

	@Override
	public Page<Product> getAllPage(Pageable pageable) {
		// TODO Auto-generated method stub
		return productRepository.findAll(pageable);
	}

}
