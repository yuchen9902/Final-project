package com.example.lovecalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;


import unirest.HttpResponse;
import unirest.JsonNode;
import unirest.Unirest;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    HttpResponse<JsonNode> response = Unirest.get("https://love-calculator.p.rapidapi.com/getPercentage?fname=John&sname=Alice")
            .header("X-RapidAPI-Host", "love-calculator.p.rapidapi.com")
            .header("X-RapidAPI-Key", "ddb2ddfd21msh545fdbc2222d20dp1ba2f6jsn6d9725535c4a").asJson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        final TextView textView = (TextView) findViewById(R.id.text);
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://love-calculator.p.rapidapi.com/getPercentage?fname=John&sname=Alice";
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        textView.setText("Response is: "+ response.substring(0,500));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText("That didn't work!");
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("X-RapidAPI-Host", "love-calculator.p.rapidapi.com");
                params.put("X-RapidAPI-Key", "ddb2ddfd21msh545fdbc2222d20dp1ba2f6jsn6d9725535c4a");
                return params;
            }
        };

// Add the request to the RequestQueue.
        queue.add(stringRequest);

        final TextView a = findViewById(R.id.percent);
        TextView b = findViewById(R.id.button2);
        TextView c = findViewById(R.id.button1);
        Button d = findViewById(R.id.start);
    }

    protected void onPause() {
        super.onPause();
    }



    @Override
    public void onClick(View v) {
    }
}
