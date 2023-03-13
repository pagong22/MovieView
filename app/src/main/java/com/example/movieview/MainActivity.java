package com.example.movieview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button accountActivity;
    Button homeActivity;
    Button reviewActivity;
    Button searchActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        accountActivity = findViewById(R.id.accountbtn);
        homeActivity = findViewById(R.id.homebtn);
        reviewActivity = findViewById(R.id.reviewbutton);
        searchActivity = findViewById(R.id.searchbtn);


        accountActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AccountLogin.class);
                startActivity(i);
            }
        });
    }
}