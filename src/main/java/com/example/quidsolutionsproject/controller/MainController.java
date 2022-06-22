package com.example.quidsolutionsproject.controller;

import com.example.quidsolutionsproject.model.Question;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

@Controller
public class MainController {

    @RequestMapping("/questions")
    public String index() throws IOException, JSONException{
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
                    System.out.println(results.get(i));
                    Gson gson= new Gson();
                    Question obj = gson.fromJson(results.getString(i),Question.class);
                    questions.add(obj);
                }
                System.out.println(questions.get(2));
            }
        }
        return "index";
    }
}
