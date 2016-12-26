package com.example.sergey.lesson7_system_test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sergey.lesson7_system_test.dao.QuestionDao;
import com.example.sergey.lesson7_system_test.entity.Question;
import com.example.sergey.lesson7_system_test.entity.QuestionBody;
import com.example.sergey.lesson7_system_test.entity.Test;

import java.util.ArrayList;
import java.util.List;

public class ChooseTestActivity extends AppCompatActivity {
    QuestionDao dao = new QuestionDao();
    ArrayAdapter<Question> adapter;
    ListView listView;
    QuestionBody questionBody;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_test);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.choose_test));

        listView = (ListView) findViewById(R.id.listView);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, (List<Question>) dao.getAll());

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Question q = (Question) adapterView.getItemAtPosition(i);
                if(q.getBody()==null){
                    Toast.makeText(ChooseTestActivity.this,"The test is not filled",Toast.LENGTH_SHORT).show();
                   return;
                }else {
                    Intent intent = new Intent(ChooseTestActivity.this, TestActivity.class);
                    intent.putExtra("nameTest", q.getNameTestQuestion());
                    startActivity(intent);
                    finish();

                }

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // getMenuInflater().inflate(R.menu.add_test, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                finish();
                return true;
            default:
                return true;
        }
    }
}
