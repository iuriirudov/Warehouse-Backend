package com.example.Inventory.controllers;

import com.example.Inventory.entities.Item;
import com.example.Inventory.entities.User;
import com.example.Inventory.services.ItemService;
import com.example.Inventory.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/items")
public class ItemControllerApi {

    @Autowired private ItemService itemService;
    @Autowired private UserService userService;

    // Create Operation
    @PostMapping
    public Item saveItem(@Valid @RequestBody Item item) {
        return itemService.saveItem(item);
    }

    // Read Operation
    @GetMapping
    public List<Item> fetchItemList() {
        return itemService.fetchItemList();
    }

    @GetMapping("category/{id}")
    public List<Item> fetchItemListByCategoryId(@PathVariable("id") Long id) {
        return itemService.fetchItemListByCategory(id);
    }

    @GetMapping("{id}")
    public Item fetchItem(@PathVariable("id") Long id) {
        return itemService.findItemById(id);
    }

    @PostMapping("{id}")
    public String addItemToCart(@PathVariable("id") Long id, @RequestParam Long userId) {
        Item item = itemService.findItemById(id);
        User user = userService.findUserById(userId);
        if(user.getItems().add(item)) {
            userService.saveUser(user);
            return "Added to cart";
        }
        return "Failed to add to cart";
    }

    // Update Operation
    @PutMapping("{id}")
    public Item updateItem(@Valid @RequestBody Item item, @PathVariable("id") Long id) {
        return itemService.updateItem(item, id);
    }

    // Delete Operation
    @DeleteMapping("{id}")
    public Item deleteItemById(@PathVariable("id") Long id) {
        Item item = itemService.findItemById(id);
        itemService.deleteItemById(id);
        return item;
    }

}
