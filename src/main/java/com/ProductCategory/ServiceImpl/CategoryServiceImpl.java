package com.ProductCategory.ServiceImpl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ProductCategory.Entity.Category;
import com.ProductCategory.Repository.CategoryRepository;
import com.ProductCategory.Service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public Category saveCategory(Category category) {
		// TODO Auto-generated method stub
		return categoryRepository.save(category);
	}

	@Override
	public Category updateCategory(Category category, Integer categoryId) {
		// TODO Auto-generated method stub
		Category categories = categoryRepository.findById(categoryId).get();

		if (Objects.nonNull(category.getCategoryName()) && !"".equalsIgnoreCase(category.getCategoryName())) {
			categories.setCategoryName(category.getCategoryName());
		}
		
		if (Objects.nonNull(category.getCategoryType()) && !"".equalsIgnoreCase(category.getCategoryType())) {
			categories.setCategoryType(category.getCategoryType());
		}

		return categoryRepository.save(categories);
	}

	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return (List<Category>) categoryRepository.findAll();
	}

	@Override
	public void delectCategoryById(Integer categoryId) {
		// TODO Auto-generated method stub
		categoryRepository.deleteById(categoryId);
	}

	@Override
	public Optional<Category> findById(Integer categoryId) {
		// TODO Auto-generated method stub
		return categoryRepository.findById(categoryId);
	}

	@Override
	public Page<Category> getAllPage(Pageable pageable) {
		// TODO Auto-generated method stub
		return categoryRepository.findAll(pageable);
	}

}
