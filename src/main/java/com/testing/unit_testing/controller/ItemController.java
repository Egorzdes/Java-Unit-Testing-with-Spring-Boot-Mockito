package com.testing.unit_testing.controller;

import com.testing.unit_testing.model.Item;
import com.testing.unit_testing.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/item")
    public Item item() {
        return new Item(1, "Name", 10, 100, 10);
    }

    @GetMapping("/item-from-business-service")
    public Item itemFromBusinessService() {
        return itemService.retrieveHardcodedItem();
    }

    @GetMapping("/all-items-from-database")
    public List<Item> retrieveAllItems() {
        return itemService.retrieveAllItems();
    }
}
