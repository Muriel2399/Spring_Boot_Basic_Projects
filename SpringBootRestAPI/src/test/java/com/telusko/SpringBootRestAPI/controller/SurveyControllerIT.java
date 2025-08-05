package com.telusko.SpringBootRestAPI.controller;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SurveyControllerIT {
    @Autowired
    private TestRestTemplate restTemplate ;
    String str= """
            {
                "id": "Question2",
                "description": "Most Popular Growing Cloud Platform",
                "options": [
                    "AWS",
                    "Azure",
                    "Google Cloud",
                    "Oracle Cloud"
                ],
                "answer": "Azure"
            }
            """;
     private static String url= "/surveys/Survey1/questions/Question1";
    //http://localhost:RANDOM_PORT/surveys/Survey1/questions/Question1

    @Test
    void retrieveASurveyQuestion_basicScenario() throws JSONException {
        ResponseEntity<String> response=  restTemplate.getForEntity(url,String.class);
        String expected=    """
                {"id":"Question1",
                "description":"Most Popular Cloud Platform Today",
                "options":["AWS","Azure","Google Cloud","Oracle Cloud"],
                "answer":"AWS"}
                """;
        //assertEquals(expected.trim(),response.getBody());

        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertEquals( "application/json",response.getHeaders().get("Content-Type").get(0));


        JSONAssert.assertEquals(expected, response.getBody(), true);
//        System.out.println(response.getBody());
//        System.out.println(response.getHeaders());
//        System.out.println(response.getStatusCode());
    }
}
