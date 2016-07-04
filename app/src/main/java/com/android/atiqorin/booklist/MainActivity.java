package com.android.atiqorin.booklist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText query;
    EditText resultNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        query = (EditText) findViewById(R.id.keyWord);
        resultNumber = (EditText) findViewById(R.id.resultNumber);
    }
    public void search(View v) {
        if (query.getText() == null || (query.getText().toString().trim()).matches("")) {
            Toast.makeText(MainActivity.this, "Please enter query", Toast.LENGTH_SHORT).show();

        } else {

            Intent intent = new Intent(MainActivity.this, Results.class);
            intent.putExtra("Query", query.getText().toString());
            if ((resultNumber.getText().toString().trim()).matches("") || (resultNumber.getText().toString().trim()) == null) {
                intent.putExtra("limiter", "5");

            } else {
                if (Integer.parseInt(resultNumber.getText().toString().trim()) > 0) {
                    Toast.makeText(MainActivity.this, "" + resultNumber.getText().toString().trim(), Toast.LENGTH_SHORT).show();
                    intent.putExtra("Limiter", resultNumber.getText().toString().trim());
                }
            }

            startActivity(intent);
        }
    }
}
