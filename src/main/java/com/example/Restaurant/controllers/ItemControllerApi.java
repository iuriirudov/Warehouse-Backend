package com.example.Restaurant.controllers;

import com.example.Restaurant.entities.Item;
import com.example.Restaurant.services.ItemService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/items")
public class ItemControllerApi {

    @Autowired private ItemService itemService;

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
