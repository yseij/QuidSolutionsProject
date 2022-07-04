package com.example.quidsolutionsproject.controller;

import com.example.quidsolutionsproject.model.Question;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

@Controller
public class MainController {

    ArrayList<Question> questionsForIndex = new ArrayList<>();
    private ArrayList<Question> questionsForControl = new ArrayList<>();

    @GetMapping("/questions")
    public String index(Model model) throws IOException, JSONException{
        ArrayList<Question> questions = new ArrayList<>();

        URL url = new URL("https://opentdb.com/api.php?amount=5");
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        if(conn.getResponseCode() == 200) {
            Scanner scan = new Scanner(url.openStream());
            while(scan.hasNext()) {
                String temp = scan.nextLine();
                JSONObject jsonObject = new JSONObject(temp);
                JSONArray results = (JSONArray) jsonObject.get("results");
                for (int i = 0; i < 5; i++){
                    Gson gson= new Gson();
                    Question obj = gson.fromJson(results.getString(i),Question.class);
                    questions.add(obj);
                }
            }
        }
        for (int counter = 0; counter < questions.size(); counter++){
            Question question = new Question();
            question.setName("question" + counter);
            question.setQuestion(questions.get(counter).getQuestion());
            question.setCategory(questions.get(counter).getCategory());
            question.setDifficulty(questions.get(counter).getDifficulty());
            question.setCorrect_answer(questions.get(counter).getCorrect_answer());
            question.setIncorrect_answers(questions.get(counter).getIncorrect_answers());
            questionsForControl.add(question);
            question.setAnswers();
            questionsForIndex.add(question);
            System.out.println(question.getAnswers());
            System.out.println(question.getCorrect_answer());
        }
        model.addAttribute("questions", questionsForIndex);
        return "index";
    }

    @PostMapping(value = "/checkanswer")
    @ResponseBody
    public String checkAnswer(HttpServletRequest request){
        System.out.println("---------------------------");
        for (int i=0; i<questionsForIndex.size(); i++)
        {
            String getRequest = "question" + i;
            String answer = questionsForIndex.get(i).getAnswers().get(Integer.parseInt(request.getParameter(getRequest)));
            if (Objects.equals(questionsForControl.get(i).getCorrect_answer(), answer)){
                System.out.println("test");
            }
        }
        return "index";
    }
}
