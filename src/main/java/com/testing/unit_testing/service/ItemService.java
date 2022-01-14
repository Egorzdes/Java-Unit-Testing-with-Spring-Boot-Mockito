package com.testing.unit_testing.service;

import com.testing.unit_testing.model.Item;
import com.testing.unit_testing.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemService {

    @Autowired
    private ItemRepository repository;

    public Item retrieveHardcodedItem() {
        return new Item(1, "Ball", 10, 100,10);
    }

    public List<Item> retrieveAllItems() {
        List<Item> items = repository.findAll();
        for(Item item:items) {
            item.setValue(item.getPrice() * item.getQuantity());
        }
        return items;
    }
}
