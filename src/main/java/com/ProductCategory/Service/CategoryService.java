package com.ProductCategory.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ProductCategory.Entity.Category;

public interface CategoryService {
	
	//save category
	
	Category saveCategory(Category category);
	
	//Update By Id
	
	Category updateCategory(Category category, Integer categoryId);
		
	//Get All category

	List<Category> getAllCategory();
		
    //Delete category By Id

	void delectCategoryById(Integer categoryId);
		
	//get by Id
		
	Optional<Category> findById(Integer categoryId);
		
    //Pagination Of Category
	
	Page<Category> getAllPage(Pageable pageable);


}
