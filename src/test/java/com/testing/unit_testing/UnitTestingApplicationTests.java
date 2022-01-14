package com.testing.unit_testing;

import com.testing.unit_testing.service.ServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.Assert.*;

@SpringBootTest
class UnitTestingApplicationTests {

    @Test
    public void calculateSum_basic() {
        ServiceImpl service = new ServiceImpl();
        int actualResult = service.calculateSum(new int[] {4,5,6});
        int expectedResult = 15;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSum_empty() {
        ServiceImpl service = new ServiceImpl();
        int actualResult = service.calculateSum(new int[] {});
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSum_oneValue() {
        ServiceImpl service = new ServiceImpl();
        int actualResult = service.calculateSum(new int[] {4});
        int expectedResult = 4;
        assertEquals(expectedResult, actualResult);
    }

}
