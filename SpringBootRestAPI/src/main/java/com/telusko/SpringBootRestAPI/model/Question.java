package com.telusko.SpringBootRestAPI.model;

import java.util.List;

public class Question {
    private String id;
    private String description;
    private List<String> options;
    private String answer;

    public Question(String id, String description, List<String> options, String answer) {
        this.id = id;
        this.description = description;
        this.options = options;
        this.answer = answer;
    }

    public Question() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getOptions() {
        return options;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", options=" + options +
                ", answer='" + answer + '\'' +
                '}';
    }
}
