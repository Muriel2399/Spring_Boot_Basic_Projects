package com.telusko.SpringMockitoDemo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeBusinessImplStubTest {

    private DataService dataServiceMock ;

    @Test
    void test1() {
        DataService stub = new DataServiceStub1();
        SomeBusinessImpl business = new SomeBusinessImpl(stub);
        int result = business.findTheGreatestFromAllData();
        assertEquals(3, result);

    }
    @Test
    void test2() {
        DataService stub = new DataServiceStub2();
        SomeBusinessImpl business = new SomeBusinessImpl(stub);
        int result = business.findTheGreatestFromAllData();
        assertEquals(25, result);

    }
}
class DataServiceStub1 implements DataService {
    @Override
    public int[] retrieveAllData() {
        return new int[]{1, 2, 3};
    }
}
class DataServiceStub2 implements DataService {
    @Override
    public int[] retrieveAllData() {
        return new int[]{25};
    }
}