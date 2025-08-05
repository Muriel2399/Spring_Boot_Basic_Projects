package com.telusko.SpringBootRestAPI.service;
import java.util.Arrays;
import java.util.List;
import com.telusko.SpringBootRestAPI.model.Question;
import com.telusko.SpringBootRestAPI.model.Survey;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
@Service
public class SurveyService {
    private static List<Survey> surveys = new ArrayList<>();

    static {
        Question question1 = new Question("Question1", "Most Popular Cloud Platform Today", Arrays.asList("AWS", "Azure", "Google Cloud", "Oracle Cloud"), "AWS");
        Question question2 = new Question("Question2", "Fastest Growing Cloud Platform", Arrays.asList("AWS", "Azure", "Google Cloud", "Oracle Cloud"), "Google Cloud");
        Question question3 = new Question("Question3", "Most Popular DevOps Tool", Arrays.asList("Kubernetes", "Docker", "Terraform", "Azure DevOps"), "Kubernetes");
        List<Question> questions = new ArrayList<>(Arrays.asList(question1, question2, question3));
        Survey survey1 = new Survey("Survey1", "My First Survey", "Description of the First Survey", questions);
        Survey survey2 = new Survey("Survey2", "My Second Survey", "Description of the Second Survey", questions);
        surveys.add(survey1);
        surveys.add(survey2);
    }

    public List<Survey> allSurveys() {

        return surveys;
    }

    public Survey findSurvey(String surveyId) {

        for (Survey survey : surveys) {
            if (survey.getId().equals(surveyId)) {
                return survey;
            }
        }
        return null;
    }

    public List<Question> retrieveAllSurveyQuestions(String surveyId) {

        for (Survey survey : surveys) {
            if (survey.getId().equals(surveyId)) {
                return survey.getQuestions();
            }
        }
        return null;
    }

    public Question retrieveASurveyQuestion(String questionId, String surveyId) {
        for (Survey survey : surveys) {
            if (survey.getId().equals(surveyId)) {
                for (Question question : survey.getQuestions()) {
                    if (question.getId().equals(questionId)) {
                        return question;
                    }
                }
            }
        }
        return null;
    }

    public String addQuestion(Question question, String surveyId) {
       List<Question> questions = retrieveAllSurveyQuestions(surveyId);
        questions.add(question);
        return question.getId();
    }

    public void deleteASurveyQuestion(String questionId, String surveyId) {
        List<Question> questions = retrieveAllSurveyQuestions(surveyId);
        if(questions!=null) {
            for (int i = 0; i < questions.size(); i++) {
                if (questions.get(i).getId().equals(questionId)) {
                    questions.remove(i);
                }
            }
        }
    }

    public void updateASurveyQuestion(String questionId, String surveyId, Question question) {
        List<Question> questions = retrieveAllSurveyQuestions(surveyId);
        if(questions!=null) {
            for (int i = 0; i < questions.size(); i++) {
                if (questions.get(i).getId().equals(questionId)) {
                    questions.remove(i);
                    questions.add(i, question);
                }
            }
        }
    }
}
