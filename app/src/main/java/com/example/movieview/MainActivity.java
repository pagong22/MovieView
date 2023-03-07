package com.example.movieview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.accountbtn);
        button = findViewById(R.id.homebtn);
        button = findViewById(R.id.reviewbutton);
        button = findViewById(R.id.searchbtn);
    }
}