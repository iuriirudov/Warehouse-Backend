package com.example.Inventory.services;

import com.example.Inventory.entities.Item;
import com.example.Inventory.entities.User;
import com.example.Inventory.repositories.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired private UserRespository userRespository;

    // Create operation
    @Override
    public User saveUser(User user) {
        return userRespository.save(user);
    }

    // Read operation
    @Override
    public User findUserById(Long id) {
        return userRespository.findById(id).get();
    }

    @Override
    public Set<Item> fetchCartByUserId(Long id) {
        return userRespository.findById(id).get().getItems();
    }

    // Update operation
    @Override
    public User updateUser(User user, Long id) {
        User userDB = userRespository.findById(id).get();
        userDB.setName(user.getName());
        return userRespository.save(userDB);
    }

    // Delete operation
    @Override
    public void deleteUserById(Long id) {
        userRespository.deleteById(id);
    }
}
