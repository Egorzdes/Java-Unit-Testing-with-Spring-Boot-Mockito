package com.testing.unit_testing.test;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.*;

public class JsonAssertTest {
    String actualResponse = "{\"id\":1,\"name\":\"Name\",\"price\":10,\"quantity\":100}";

    @Test
    public void jsonAssert_StrictTrue_ExactMatchExceptForSpaces() throws JSONException {
        String expectedResponse = "{\"id\":1,\"name\":\"Name\",\"price\":10,\"quantity\":100}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, true); // if strict is true it checks all parameters
    }


    @Test
    public void jsonAssert_StrictFalse() throws JSONException {
        String expectedResponse = "{\"id\":1,\"name\":\"Name\",\"price\":10}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
    }
}
