package com.example.quidsolutionsproject.model;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question {
    private String category, type, difficulty, question, correct_answer;
    private String[] incorrect_answers;
    private List<String> answers;

    public Question(){
    }

    public Question(String difficulty, String question, String correct_answer,
                    String[] incorrect_answers, String category, String type){
        this.category = category;
        this.type = type;
        this.difficulty = difficulty;
        this.question = question;
        this.correct_answer = correct_answer;
        this.incorrect_answers = incorrect_answers;
    }

    public String getCategory(){
        return category;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
    }

    public String getDifficulty(){
        return difficulty;
    }

    public void setDifficulty(String difficulty){
        this.difficulty = difficulty;
    }

    public String getQuestion(){
        return question;
    }

    public void setQuestion(String question){
        this.question = question;
    }

    public String getCorrect_answer(){
        return correct_answer;
    }

    public void setCorrect_answer(String correct_answer){
        this.correct_answer = correct_answer;
    }

    public String[] getIncorrect_answers(){
        return incorrect_answers;
    }

    public void setIncorrect_answers(String[] incorrect_answers){
        this.incorrect_answers = incorrect_answers;
    }

    public List<String> getAnswers(){
        return answers;
    }

    public void setAnswers(){
        List<String> answers = new ArrayList<>();
        String[] incorrect_answers = getIncorrect_answers();
        if (incorrect_answers != null){
            for (int counter = 0; counter < incorrect_answers.length; counter++){
                answers.add(incorrect_answers[counter]);
            }
            answers.add(getCorrect_answer());
            System.out.println("in klasse" + answers);
        }
        this.answers = answers;
    }
}
