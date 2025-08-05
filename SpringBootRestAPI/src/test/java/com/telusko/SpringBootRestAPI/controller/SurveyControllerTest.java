package com.telusko.SpringBootRestAPI.controller;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.Base64;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SurveyControllerTest {
    @Autowired
    private TestRestTemplate restTemplate ;
    private static String url= "/surveys/Survey1/questions";
    private static String url_post= "/surveys/Survey1/question";
    @Test
    void retrieveAllSurveyQuestions_basicScenario() throws JSONException {
        HttpHeaders headers = createHttpContentTypeAndBasicAuth();
        HttpEntity<String> requestEntity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response=  restTemplate.exchange(url, HttpMethod.GET, requestEntity,String.class);
       // ResponseEntity<String> response=  restTemplate.getForEntity(url,String.class);
        String expected=    """
               
                [
                   {
                       "id": "Question1",
                       "description": "Most Popular Cloud Platform Today",
                       "options": [
                           "AWS",
                           "Azure",
                           "Google Cloud",
                           "Oracle Cloud"
                       ],
                       "answer": "AWS"
                   },
                   {
                       "id": "Question2",
                       "description": "Fastest Growing Cloud Platform",
                       "options": [
                           "AWS",
                           "Azure",
                           "Google Cloud",
                           "Oracle Cloud"
                       ],
                       "answer": "Google Cloud"
                   },
                   {
                       "id": "Question3",
                       "description": "Most Popular DevOps Tool",
                       "options": [
                           "Kubernetes",
                           "Docker",
                           "Terraform",
                           "Azure DevOps"
                       ],
                       "answer": "Kubernetes"
                   }
               ]
                """;

        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertEquals( "application/json",response.getHeaders().get("Content-Type").get(0));

        JSONAssert.assertEquals(expected, response.getBody(), true);

    }

    @Test
    void addQuestion_basicScenario() throws JSONException {

        String requestbody= """
                {
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

        HttpHeaders headers = createHttpContentTypeAndBasicAuth();
    HttpEntity<String> requestEntity = new HttpEntity<String>(requestbody, headers);
        ResponseEntity<String> response=  restTemplate.exchange(url_post, HttpMethod.POST, requestEntity,String.class);

        System.out.println(response.getBody());
        System.out.println(response.getHeaders());

//        assertTrue(response.getStatusCode().is2xxSuccessful());
//        assertEquals( "application/json",response.getHeaders().get("Content-Type").get(0));
//
//        JSONAssert.assertEquals(expected, response.getBody(), true);

    }

    private HttpHeaders createHttpContentTypeAndBasicAuth() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        //encoded userid and passwordYWxhZGRpbjpPcGVuIHNlc2FtZQ==
        headers.add("Authorization", "Basic "+performBasicAuthEncoding("admin", "password"));
        return headers;
    }

    public String performBasicAuthEncoding(String username, String password) {
        String combinedString = username + ":" + password;
        byte[] encodedString = Base64.getEncoder().encode(combinedString.getBytes());
        return new String(encodedString);

    }
}
