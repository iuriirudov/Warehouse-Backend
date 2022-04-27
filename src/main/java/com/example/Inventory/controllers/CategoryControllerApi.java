package com.example.Inventory.controllers;

import com.example.Inventory.entities.Category;
import com.example.Inventory.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/categories")
public class CategoryControllerApi {

    @Autowired private CategoryService categoryService;

    // Create Operation
    @PostMapping
    public Category saveCategory(@Valid @RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    // Read Operations
    @GetMapping
    public List<Category> fetchCategoryList() {
        return categoryService.fetchAllCategories();
    }

    // Update Operation
    @PutMapping("{id}")
    public Category updateCategory(@Valid @RequestBody Category category, @PathVariable("id") Long id) {
        return categoryService.updateCategory(category, id);
    }

    // Delete Operation
    @DeleteMapping("{id}")
    public Category deleteCategoryById(@PathVariable("id") Long id) {
        Category category = categoryService.findCategoryById(id);
        categoryService.deleteCategoryById(id);
        return category;
    }

}
