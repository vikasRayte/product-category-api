package com.ProductCategory.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ProductCategory.Entity.Category;
import com.ProductCategory.Service.CategoryService;

@RestController
@RequestMapping("/api")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	// Save operation
		@PostMapping("/categories")
		public Category saveCategory(@Validated @RequestBody Category category) {
			return categoryService.saveCategory(category);
		}

		// Read operation
		@GetMapping("/categoriesAll")
		public List<Category> getAllCategory() {
			return categoryService.getAllCategory();
		}
		
		@GetMapping("/categories")
		public Page<Category> getAllPages(@RequestParam(defaultValue="0") int page,@RequestParam(defaultValue="5") int size) {
			Pageable pageable=PageRequest.of(page, size,Sort.by(Direction.DESC, "categoryId"));
			return categoryService.getAllPage(pageable);
		}

		// Update operation
		@PutMapping("/categories/{categoryId}")
		public Category updateProduct(@RequestBody Category category, @PathVariable("categoryId") Integer categoryId) {
			return categoryService.updateCategory(category, categoryId);
		}

		// Delete operation
		@DeleteMapping("/categories/{categoryId}")
		public String delectProductById(@PathVariable("categoryId") Integer categoryId) {
			categoryService.delectCategoryById(categoryId);
			return "Deleted Successfully";
		}
		
		// Update operation
		@GetMapping("/categories/{categoryId}")
			public Optional<Category> findById(@PathVariable("categoryId") Integer categoryId) {
				return categoryService.findById(categoryId);
			}

}
