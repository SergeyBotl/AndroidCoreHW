package com.example.sergey.lesson4extra;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        View header;
        header = getLayoutInflater().inflate(R.layout.hrader, null);
        TextView tvHeader = (TextView) header.findViewById(R.id.textHeader);
        tvHeader.setText("Table");
        ListView listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, multiply());
        listView.addHeaderView(header);
        listView.setAdapter(adapter);
    }

    List<String> multiply() {
        List<String> list = new ArrayList<>();
        int[][] multiplyTab = new int[10][10];
        for (int i = 0; i < 10; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 10; j++) {
                multiplyTab[i][j] = (i + 1) * (j + 1);
                sb.append(multiplyTab[i][j]).append("\t ");
            }
            sb.append("\n");
            list.add(sb.toString());
        }
        return list;
    }

}
