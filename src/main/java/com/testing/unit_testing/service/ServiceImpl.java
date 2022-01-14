package com.testing.unit_testing.service;

import java.util.Arrays;


public class ServiceImpl {

    SomeDataService someDataService;

    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }

    public int calculateSum(int[] array) {
        return Arrays.stream(array).reduce(Integer::sum).orElse(0);
    }

    public int calculateSumUsingDataService() {
        int sum = 0;
        int[] data = someDataService.retrieveAllData();
        for (int value : data) {
            sum += value;
        }
        return sum;
    }
}
