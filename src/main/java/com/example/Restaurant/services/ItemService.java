package com.example.Restaurant.services;

import com.example.Restaurant.entities.Item;

import java.util.List;

public interface ItemService {

    // Create
    Item saveItem(Item item);

    // Read
    List<Item> fetchItemList();
    List<Item> fetchItemListByCategory(Long id);
    Item findItemById(Long id);

    // Update
    Item updateItem(Item item, Long id);

    // Delete
    void deleteItemById(Long id);

}
