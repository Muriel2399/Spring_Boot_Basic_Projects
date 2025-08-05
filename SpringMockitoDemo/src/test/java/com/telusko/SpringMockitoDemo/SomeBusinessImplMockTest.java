package com.telusko.SpringMockitoDemo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SomeBusinessImplMockTest {

    @Mock
    private DataService dataServiceMock ;
    @InjectMocks
    private SomeBusinessImpl business;

    @Test
    void test1() {
       when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{1, 2, 3});
        assertEquals(3, business.findTheGreatestFromAllData());

    }
    @Test
    void test2() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{35});
       assertEquals(35, business.findTheGreatestFromAllData());

    }
    @Test
    void test3() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{});
        assertEquals(0, business.findTheGreatestFromAllData());

    }

}