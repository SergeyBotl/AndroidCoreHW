package com.example.sergey.lesson7_system_test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.sergey.lesson7_system_test.dao.QuestionDao;
import com.example.sergey.lesson7_system_test.entity.Question;
import com.example.sergey.lesson7_system_test.entity.QuestionBody;


import java.util.HashSet;
import java.util.Set;

public class CreateQuestionsActivity extends AppCompatActivity {
    QuestionDao dao = new QuestionDao();
    EditText question, option1, option2, option3, option4;
    ImageView imageView;
    Set<QuestionBody> questionList = new HashSet<>();
    Intent intent;
    TextView nameTest;
    String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_questions);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.add_questions_activity));

        imageView = (ImageView) findViewById(R.id.imageView3);
        nameTest = (TextView) findViewById(R.id.nameTest);
        question = (EditText) findViewById(R.id.question);
        option1 = (EditText) findViewById(R.id.editText2);
        option2 = (EditText) findViewById(R.id.editText3);
        option3 = (EditText) findViewById(R.id.editText4);
        option4 = (EditText) findViewById(R.id.editText5);

        intent = getIntent();
        s = intent.getStringExtra("nameTest");
        questionList = dao.findBodyByNameTest(s);
        nameTest.setText(s);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_question, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save:
                questionList
                        .add(new QuestionBody(questionList.size()+1,
                                (R.drawable.image),
                                question.getText().toString(),
                                option1.getText().toString(),
                                option2.getText().toString(),
                                option3.getText().toString(),
                                option4.getText().toString()));

                dao.saveBodyQuestion(s, questionList);
                clear();
                return true;
            case android.R.id.home:
                finish();
                return true;
            default:
                return true;
        }
    }

    void clear() {
        question.setText("");
        option1.setText("");
        option2.setText("");
        option3.setText("");
        option4.setText("");
    }
}
