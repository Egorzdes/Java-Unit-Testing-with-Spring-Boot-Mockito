package com.testing.unit_testing.test;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

public class ListMockTest {

    List<String> mock = mock(List.class);

    @Test
    public void size_basic() {
        when(mock.size()).thenReturn(5);
        assertEquals(5, mock.size());
    }

    @Test
    public void returnDifferentValues() {
        when(mock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5, mock.size());
        assertEquals(10, mock.size());
    }

    @Test
    public void returnWithParameters() {
        when(mock.get(0)).thenReturn("HelloWorld!");
        assertEquals("HelloWorld!", mock.get(0));
    }

    @Test
    public void returnWithGenericParameters() {
        when(mock.get(anyInt())).thenReturn("HelloWorld!");
        assertEquals("HelloWorld!", mock.get(0));
    }

    @Test
    public void verificationBasic() {
        String value = mock.get(0);
        String value2 = mock.get(1);
        verify(mock).get(0);
        verify(mock, times(2)).get(anyInt());
        verify(mock, atLeast(1)).get(anyInt());
        verify(mock, atMost(2)).get(anyInt());
        verify(mock, never()).get(2);
    }

    @Test
    public void argumentCapturing() {
        mock.add("Hello");
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock).add(captor.capture());

        assertEquals("Hello", captor.getValue());

    }

    @Test
    public void multipleArgumentCapturing() {
        mock.add("Hello");
        mock.add("World");
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock, times(2)).add(captor.capture());
        List<String> allValues = captor.getAllValues();
        assertEquals("Hello", allValues.get(0));
        assertEquals("World", allValues.get(1));

    }

    @Test
    public void spying() {
        ArrayList arrayListSpy = spy(ArrayList.class);
        arrayListSpy.add("Test0");
        System.out.println(arrayListSpy.get(0));
        System.out.println(arrayListSpy.size());
        arrayListSpy.add("Test");
        arrayListSpy.add("Test1");
        System.out.println(arrayListSpy.size());
        when(arrayListSpy.size()).thenReturn(5);
        System.out.println(arrayListSpy.size());
        verify(arrayListSpy).add("Test1");
    }
}
