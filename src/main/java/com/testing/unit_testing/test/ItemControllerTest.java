package com.testing.unit_testing.test;

import com.testing.unit_testing.model.Item;
import com.testing.unit_testing.service.ItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;


import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(value = com.testing.unit_testing.controller.ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemService itemService;

    public ItemControllerTest() throws Exception {
    }

    @Test
    public void itemBasic() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/item")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().is(200)) //or isOk() if success
                .andExpect(content().json(
                        "{\"id\":1,\"name\":\"Name\",\"price\":10,\"quantity\":100}"))
                .andReturn();

    }

    @Test
    public void itemFromBusinessService() throws Exception {

        when(itemService.retrieveHardcodedItem()).thenReturn(
                new Item(2, "Item", 10, 100,10));

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/item-from-business-service")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().is(200)) //or isOk() if success
                .andExpect(content().json(
                        "{id:2,name:Item,price:10,quantity:100}"))
                .andReturn();

    }

    @Test
    public void retrieveAllItems_basic() throws Exception {

        when(itemService.retrieveAllItems()).thenReturn(
                Arrays.asList(new Item(2, "Item", 10, 100,10),
                        new Item(3,"Item2", 20, 100,10)));

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/all-items-from-database")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().is(200)) //or isOk() if success
                .andExpect(content().json(
                        "[{id:2,name:Item,price:10}, {id:3,name:Item2,price:20}]"))
                .andReturn();

    }

    RequestBuilder requestBuilder = MockMvcRequestBuilders.post(
            "/items")
            .accept(MediaType.APPLICATION_JSON)
            .content("{\"id\": 1, \"name\":\"Ball\",\"price\":10,\"quantity\"100}")
            .contentType(MediaType.APPLICATION_JSON);
    MvcResult result = mockMvc.perform(requestBuilder)
            .andExpect(status().isCreated())
            .andExpect(header().string("location", containsString("/item")))
            .andReturn();
}

