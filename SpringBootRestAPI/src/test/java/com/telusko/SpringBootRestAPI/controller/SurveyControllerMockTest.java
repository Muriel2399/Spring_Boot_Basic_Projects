package com.telusko.SpringBootRestAPI.controller;

import com.telusko.SpringBootRestAPI.model.Question;
import com.telusko.SpringBootRestAPI.service.SurveyService;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@WebMvcTest(controllers = SurveyController.class)
@AutoConfigureMockMvc(addFilters = false)
public class SurveyControllerMockTest {

    @MockBean
    private SurveyService surveyService;

    @Autowired
    private MockMvc mockMvc;
    private static String addUrl= "/surveys/Survey1/question";
    private static String specificUrl= "/surveys/Survey1/questions/Question1";
    @Test
    void retrieveASurveyQuestion_basicScenario() throws Exception {

        Question question = new Question("Question1", "Most Popular Cloud Platform Today", Arrays.asList("AWS", "Azure", "Google Cloud", "Oracle Cloud"), "AWS");
        when(surveyService.retrieveASurveyQuestion("Question1","Survey1")).thenReturn(question);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(specificUrl).accept("application/json");
        MvcResult mVCResult = mockMvc.perform(requestBuilder).andReturn();

        String expected=    """
                {"id":"Question1",
                "description":"Most Popular Cloud Platform Today",
                "options":["AWS","Azure","Google Cloud","Oracle Cloud"],
                "answer":"AWS"}
                """;


        assertEquals(200,mVCResult.getResponse().getStatus());
        JSONAssert.assertEquals(expected, mVCResult.getResponse().getContentAsString(), true);

        System.out.println(mVCResult);
        System.out.println(mVCResult.getResponse().getStatus());
        System.out.println(mVCResult.getResponse().getContentAsString());
    }
    @Test
    void retrieveASurveyQuestion_404Scenario() throws Exception {

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(specificUrl).accept("application/json");
        MvcResult mVCResult = mockMvc.perform(requestBuilder).andReturn();

        assertEquals(404,mVCResult.getResponse().getStatus());

        System.out.println(mVCResult);
        System.out.println(mVCResult.getResponse().getStatus());
        System.out.println(mVCResult.getResponse().getContentAsString());
    }

    @Test
    void addQuestion_basicScenario() throws Exception {
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
        when(surveyService.addQuestion(any(),anyString())).thenReturn("SOME_ID");
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(addUrl).accept("application/json").content(requestbody).contentType("application/json");
        MvcResult mVCResult = mockMvc.perform(requestBuilder).andReturn();
        assertEquals(201,mVCResult.getResponse().getStatus());
        System.out.println(mVCResult.getResponse().getHeader("Location"));
    }

}