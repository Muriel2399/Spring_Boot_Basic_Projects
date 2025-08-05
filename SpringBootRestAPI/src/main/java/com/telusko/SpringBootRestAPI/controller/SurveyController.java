package com.telusko.SpringBootRestAPI.controller;

import com.telusko.SpringBootRestAPI.model.Question;
import com.telusko.SpringBootRestAPI.model.Survey;
import com.telusko.SpringBootRestAPI.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.math.BigInteger;
import java.net.URI;
import java.security.SecureRandom;
import java.util.List;

@RestController
public class SurveyController {
    @Autowired
    private SurveyService SurveyService;

    @GetMapping("/surveys")
    public List<Survey> retrieveAllSurveys() {
        return SurveyService.allSurveys();
    }

    @GetMapping("/surveys/{surveyId}")
    public Survey retrieveASurvey(@PathVariable String surveyId) {
        Survey survey= SurveyService.findSurvey(surveyId);
        if(survey==null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return survey;
    }
    @GetMapping("/surveys/{surveyId}/questions")
    public List<Question> retrieveAllSurveyQuestions(@PathVariable String surveyId) {
        List<Question> questions= SurveyService.retrieveAllSurveyQuestions(surveyId);
        System.out.println(questions);
        if(questions==null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return questions;
    }

    @GetMapping("/surveys/{surveyId}/questions/{questionId}")
    public Question retrieveASurveyQuestion(@PathVariable String questionId, @PathVariable String surveyId) {
        Question question= SurveyService.retrieveASurveyQuestion(questionId,surveyId);
        if(question==null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return question;
    }

    @DeleteMapping("/surveys/{surveyId}/questions/{questionId}")
    public ResponseEntity<Object> deleteASurveyQuestion(@PathVariable String questionId, @PathVariable String surveyId) {
       SurveyService.deleteASurveyQuestion(questionId,surveyId);
        return ResponseEntity.noContent().build();

    }

    @PutMapping("/surveys/{surveyId}/questions/{questionId}")
    public ResponseEntity<Object> updateSurveyQuestion(@PathVariable String questionId, @PathVariable String surveyId, @RequestBody Question question) {
        SurveyService.updateASurveyQuestion(questionId,surveyId,question);
        return ResponseEntity.created(null).build();

    }
    private static String getRandomNumber() {
        SecureRandom random = new SecureRandom();
        String randomId= new BigInteger(32, random).toString();
        return randomId;
    }

    @PostMapping("/surveys/{surveyId}/question")
    public ResponseEntity<Object> addQuestion(@RequestBody Question question, @PathVariable String surveyId) {
        question.setId(getRandomNumber());
        String questionId=SurveyService.addQuestion(question,surveyId);
        //URI location = URI.create("/surveys/" + surveyId + "/questions/" + question.getId());
       // URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{questionId}").buildAndExpand(questionId).toUri();
        return ResponseEntity.created(null).build();

    }
}