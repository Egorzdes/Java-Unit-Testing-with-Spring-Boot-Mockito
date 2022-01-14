package com.testing.unit_testing.test;

import com.testing.unit_testing.model.Item;
import com.testing.unit_testing.repository.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

import java.util.List;

@DataJpaTest
@RunWith(SpringRunner.class)
public class ItemRepositoryTest {


    @Autowired
    private ItemRepository repository;

    @Test
    public void findAll() {
        List<Item> items = repository.findAll();
        assertEquals(3, items.size());
    }
}
