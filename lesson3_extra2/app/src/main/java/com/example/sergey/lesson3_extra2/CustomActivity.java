package com.example.sergey.lesson3_extra2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomActivity extends AppCompatActivity {
    String[] s = {"a", "s", "d", "f", "g", "h", "j", "k", "l", "z", "x"};
    List<String> list = new ArrayList<>(Arrays.asList(s));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);


        ListView listView = (ListView) findViewById(R.id.listViewCust);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.custom_layout, list);
        listView.setAdapter(adapter);
    }
}
