//package com.example.Restaurant.controllers;
//
//import com.example.Restaurant.entities.Item;
//import com.example.Restaurant.repositories.UserRespository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Set;
//
//@RestController
//@RequestMapping("/api/cart")
//public class CartControllerApi {
//
//    @Autowired private UserRespository userRespository;
//
//    // Create Operation
////    @PostMapping
////    public Category saveCategory(@Valid @RequestBody Category category) {
////        return categoryService.saveCategory(category);
////    }
//
//    // Read Operations
//    @GetMapping
//    public Set<Item> fetchCartItems(Long id) {
//        return userRespository.findById(id).get().getItems();
//    }
//
//    // Update Operation
////    @PutMapping("{id}")
////    public Category updateCategory(@Valid @RequestBody Category category, @PathVariable("id") Long id) {
////        return categoryService.updateCategory(category, id);
////    }
////
////    // Delete Operation
////    @DeleteMapping("{id}")
////    public Category deleteCategoryById(@PathVariable("id") Long id) {
////        Category category = categoryService.findCategoryById(id);
////        categoryService.deleteCategoryById(id);
////        return category;
////    }
//}
