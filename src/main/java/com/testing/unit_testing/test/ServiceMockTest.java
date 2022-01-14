package com.testing.unit_testing.test;

import com.testing.unit_testing.service.ServiceImpl;
import com.testing.unit_testing.service.SomeDataService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ServiceMockTest {
    @InjectMocks
    ServiceImpl newService = new ServiceImpl();
    @Mock
    SomeDataService dataServiceMock;

    @Before
    public void before() {
        newService.setSomeDataService(dataServiceMock);
    }

    @Test
    public void calculateSumUsingData_basic() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{1, 2, 3});
        assertEquals(6, newService.calculateSumUsingDataService());
    }

    @Test
    public void calculateSumUsingData_empty() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{});
        assertEquals(0, newService.calculateSumUsingDataService());
    }

    @Test
    public void calculateSumUsingData_oneValue() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{5});
        assertEquals(5, newService.calculateSumUsingDataService());
    }
}
