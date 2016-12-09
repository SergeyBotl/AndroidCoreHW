package com.example.sergey.lesson3_extra2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdapterActivity extends AppCompatActivity {

    String[] s = {"a", "s", "d", "f", "g", "h", "j", "k", "l", "z", "x"};
    List<String> list = new ArrayList<>(Arrays.asList(s));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter);
        Log.i("tag","on ");
        ListView listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
        listView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("tag","int "+i+" long "+l);
                //не работает
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Log.i("tag","onNothingSelected ");
            }
        });
    }
}
