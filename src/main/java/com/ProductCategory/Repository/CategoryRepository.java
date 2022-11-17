package com.ProductCategory.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ProductCategory.Entity.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
