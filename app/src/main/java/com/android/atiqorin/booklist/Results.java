package com.android.atiqorin.booklist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

/**
 * Created by atiqorin on 7/4/16.
 */
public class Results extends AppCompatActivity {
    String keyword;
    String result;
    private final String URL = "https://www.googleapis.com/books/v1/volumes?q=";

    String Extra = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results_layout);
        Intent intent = getIntent();
        if (intent.getStringExtra("limiter") != null) {
            Extra = "&maxResults=" + intent.getStringExtra("limiter");
        }

        keyword = intent.getStringExtra("Query");

        ResultAsync data = new ResultAsync();
        String finalURL = URL + keyword + Extra;
        Log.i("URL", finalURL);
        try {
            result = data.execute(finalURL).get();
            if (result == "Error") {
                Toast.makeText(Results.this, "Something went wrong !", Toast.LENGTH_SHORT).show();
                finish();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        ListView view = (ListView) findViewById(R.id.resultsList);
        view.setAdapter(new ResultsAdapter(result, this));

    }
}
