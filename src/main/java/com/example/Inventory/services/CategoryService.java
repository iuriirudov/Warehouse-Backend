package com.example.Inventory.services;

import com.example.Inventory.entities.Category;

import java.util.List;

public interface CategoryService {

    // Create
    Category saveCategory(Category category);

    // Read
    Category findCategoryById(Long id);
    List<Category> fetchAllCategories();

    // Update
    Category updateCategory(Category category, Long id);

    // Delete
    void deleteCategoryById(Long id);

}
