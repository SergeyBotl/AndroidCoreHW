package com.example.sergey.lesson3_extra2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
          getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
          getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        findViewById(R.id.buttonAdapter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(StartActivity.this,AdapterActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.buttonCustom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(StartActivity.this,CustomActivity.class);
                startActivity(intent);
            }
        });
    }
}
