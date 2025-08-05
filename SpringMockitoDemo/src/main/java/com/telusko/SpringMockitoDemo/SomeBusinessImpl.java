package com.telusko.SpringMockitoDemo;

public class SomeBusinessImpl {

    private DataService dataService;

    public SomeBusinessImpl(DataService dataService) {
        super();
        this.dataService = dataService;
    }


    public int findTheGreatestFromAllData() {
        dataService.retrieveAllData();
        int[] data = dataService.retrieveAllData();
        int theGreatest = 0;
        for (int value : data) {
            if (value > theGreatest) {
                theGreatest = value;
            }
        }
        return theGreatest;
    }

}
interface DataService {
    int[] retrieveAllData();
}