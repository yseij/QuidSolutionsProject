package com.example.quidsolutionsproject.model;

public class Answer {
    private String answer, correct_answer, question;
    private boolean answer_correct;

    public Answer(String answer, String correct_anwser, String question, boolean answer_correct){
        this.answer = answer;
        this.correct_answer = correct_anwser;
        this.question = question;
        this.answer_correct = answer_correct;
    }

    public String getAnswer(){
        return answer;
    }

    public void setAnswer(String answer){
        this.answer = answer;
    }

    public String getCorrect_answer(){
        return correct_answer;
    }

    public void setCorrect_answer(String correct_answer){
        this.correct_answer = correct_answer;
    }

    public String getQuestion(){
        return question;
    }

    public void setQuestion(String question){
        this.question = question;
    }

    public boolean isAnswer_correct(){
        return answer_correct;
    }

    public void setAnswer_correct(boolean answer_correct){
        this.answer_correct = answer_correct;
    }
}
