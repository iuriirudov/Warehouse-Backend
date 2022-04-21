package com.example.Restaurant.services;

import com.example.Restaurant.entities.Item;
import com.example.Restaurant.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired private ItemRepository itemRepository;

    // Create operation
    @Override
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    // Read operation
    @Override
    public List<Item> fetchItemList() {
        return (List<Item>) itemRepository.findAll();
    }

    @Override
    public List<Item> fetchItemListByCategory(Long id) {
        return itemRepository.findAllByCategoryId(id);
    }

    @Override
    public Item findItemById(Long id) {
        return itemRepository.findById(id).get();
    }

    // Update operation
    @Override
    public Item updateItem(Item item, Long id) {
        Item itemDB = itemRepository.findById(id).get();
        itemDB.setName(item.getName());
        itemDB.setDescription(item.getDescription());
        itemDB.setPrice(item.getPrice());
        itemDB.setImage(item.getImage());
        itemDB.setQuantity(item.getQuantity());
        itemDB.setCategory(item.getCategory());

        return itemRepository.save(itemDB);

    }

    // Delete operation
    @Override
    public void deleteItemById(Long id) {
        itemRepository.deleteById(id);
    }

}
