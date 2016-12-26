package com.example.sergey.lesson7_system_test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.sergey.lesson7_system_test.dao.QuestionDao;
import com.example.sergey.lesson7_system_test.entity.Question;

import java.util.ArrayList;
import java.util.List;

public class AddTestActivity extends AppCompatActivity {

    QuestionDao dao=new QuestionDao();

    EditText nameTest;
    Spinner spinner;
    ArrayAdapter<?> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_test);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.add_test_activity));

        nameTest = (EditText) findViewById(R.id.nameTest);

        spinner = (Spinner) findViewById(R.id.spinner);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, (List<Question>) dao.getAll());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_test, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save:
                dao.save(new Question( nameTest.getText().toString()));
                spinner.setSelection(adapter.getCount());
                adapter.notifyDataSetChanged();
                Log.d("tag","save");
                nameTest.setText("");
                return true;
            case android.R.id.home:
                finish();
                return true;
            case R.id.add_question:
                Intent intent=new Intent(this, CreateQuestionsActivity.class);
                intent.putExtra("nameTest",spinner.getSelectedItem().toString());
                startActivity(intent);
                finish();
                return true;
            default:
                return true;
        }
    }

}
