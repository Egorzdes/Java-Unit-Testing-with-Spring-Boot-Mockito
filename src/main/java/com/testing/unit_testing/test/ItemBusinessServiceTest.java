package com.testing.unit_testing.test;

import com.testing.unit_testing.model.Item;
import com.testing.unit_testing.repository.ItemRepository;

import com.testing.unit_testing.service.ItemService;
import com.testing.unit_testing.service.ServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
public class ItemBusinessServiceTest {


    @InjectMocks
    private ItemService service;

    @Mock
    private ItemRepository repository;

    @Test
    public void retrieveAllItems_basic() {
        when(repository.findAll()).thenReturn(Arrays.asList(new Item(2, "Item", 10, 10, 100),
                new Item(3, "Item2", 20, 20, 200)));
        List<Item> items = service.retrieveAllItems();
        assertEquals(100, items.get(0).getValue());
        assertEquals(400, items.get(1).getValue());
    }

}
