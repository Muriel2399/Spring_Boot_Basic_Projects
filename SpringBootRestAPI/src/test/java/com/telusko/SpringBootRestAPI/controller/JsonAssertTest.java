package com.telusko.SpringBootRestAPI.controller;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {
    @Test
    void retrieveASurveyQuestion_basicScenario() throws JSONException {
        String expected=    """
                {"id":"Question1",
                "description":"Most Popular Cloud Platform Today",
                "options":["AWS","Azure","Google Cloud","Oracle Cloud"],
                "answer":"AWS"}
                """;
        String actual=    """
                   {"id":"Question1",  "description":"Most Popular Cloud Platform Today","options":["AWS","Azure","Google Cloud","Oracle Cloud"],"answer":"AWS"}
                """;

        JSONAssert.assertEquals(expected, actual, true);
    }

}
