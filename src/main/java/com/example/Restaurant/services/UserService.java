package com.example.Restaurant.services;

import com.example.Restaurant.entities.Item;
import com.example.Restaurant.entities.User;

import java.util.Set;

public interface UserService {

    // Create
    User saveUser(User item);

    // Read
    User findUserById(Long id);
    Set<Item> fetchCartByUserId(Long id);

    // Update
    User updateUser(User item, Long id);

    // Delete
    void deleteUserById(Long id);

}
