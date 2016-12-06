package com.example.sergey.lesson4extra;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class StartActivity extends AppCompatActivity {

    CurrentUser currentUser = new CurrentUser();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);



        Button button = (Button) findViewById(R.id.buttonStart);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentUser.getUserRegistry() == null) {
                   Intent intent= new Intent(StartActivity.this, LoginActivity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(StartActivity.this, TableActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
    @Override
    public void onBackPressed() {
        if (currentUser.getUserRegistry() != null) {
            Intent intent = new Intent(StartActivity.this, TableActivity.class);
            startActivity(intent);
        }
        super.onBackPressed();
    }


}
