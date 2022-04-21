package com.example.Restaurant.services;

import com.example.Restaurant.entities.Category;
import com.example.Restaurant.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired private CategoryRepository categoryRepository;

    // Create operation
    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    // Read operation
    @Override
    public List<Category> fetchAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findCategoryById(Long id) {
        return categoryRepository.findById(id).get();
    }

    // Update operation
    @Override
    public Category updateCategory(Category category, Long id) {
        Category dbCategory = categoryRepository.findById(id).get();
        dbCategory.setName(category.getName());

        return categoryRepository.save(dbCategory);

    }

    // Delete operation
    @Override
    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }

}
