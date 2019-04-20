package com.example.lovecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import unirest.HttpResponse;
import unirest.JsonNode;
import unirest.Unirest;


public class MainActivity extends AppCompatActivity {
    HttpResponse<JsonNode> response = Unirest.get("https://love-calculator.p.rapidapi.com/getPercentage?fname=John&sname=Alice")
            .header("X-RapidAPI-Host", "love-calculator.p.rapidapi.com")
            .header("X-RapidAPI-Key", "ddb2ddfd21msh545fdbc2222d20dp1ba2f6jsn6d9725535c4a").asJson();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
