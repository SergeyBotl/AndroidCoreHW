package com.example.sergey.lesson7_system_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


import com.example.sergey.lesson7_system_test.dao.*;
import com.example.sergey.lesson7_system_test.entity.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import java.util.List;


public class TestActivity extends AppCompatActivity {


    TestDao testDao = new TestDao();
    Button save, next;
    RadioButton btn1, btn2, btn3, btn4;
    RadioGroup radioGroup;
    ImageView imageView;
    TextView numQuestion, questionTV;
    Test test;
    List<QuestionBody> questionBodyList = new ArrayList<>();
    List<Answers> answersList = new ArrayList<>();
    static int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        String nameTest = getIntent().getStringExtra("nameTest");

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(nameTest);

        numQuestion = (TextView) findViewById(R.id.numQuestion);
        questionTV = (TextView) findViewById(R.id.questionBody);
        imageView = (ImageView) findViewById(R.id.imageView);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        save = (Button) findViewById(R.id.save);
        next = (Button) findViewById(R.id.next);
        btn1 = (RadioButton) findViewById(R.id.btn1);
        btn2 = (RadioButton) findViewById(R.id.btn2);
        btn3 = (RadioButton) findViewById(R.id.btn3);
        btn4 = (RadioButton) findViewById(R.id.btn4);

        test = testDao.findTest(nameTest);
        questionBodyList = test.getNameTest().getBody();
        answersList = testDao.getAnswearByQuestion(nameTest);

        Collections.sort(questionBodyList, new Comparator<QuestionBody>() {
            @Override
            public int compare(QuestionBody questionBody, QuestionBody t1) {
                return (int) (questionBody.getId() - t1.getId());
            }
        });

        fillFields(getQuestionBodyItem());

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (hashNext()) {
                    next.setEnabled(true);
                    radioGroup.setEnabled(false);
                } else {
                    save.setEnabled(true);
                }
                QuestionBody q = getQuestionBodyItem();

                String answer = null;

                switch (checkedId) {
                    case R.id.btn1:
                        answer = q.getOption1();
                        break;
                    case R.id.btn2:
                        answer = q.getOption2();
                        break;
                    case R.id.btn3:
                        answer = q.getOption2();
                        break;
                    case R.id.btn4:
                        answer = q.getOption2();
                        break;

                    default:
                        break;
                }
                answersList.add(new Answers(answersList.size() + 1, q.getId(), answer));
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioGroup.clearCheck();
                if (hashNext()) {
                    position++;
                    Log.d("tag", "btn next");
                    next.setEnabled(false);
                }
                fillFields(getQuestionBodyItem());


            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                test.setAnswers(answersList);
                finish();
                position=0;
            }
        });
    }


    boolean hashNext() {
        Log.d("tag", "hashNext position:"+position+" size: "+questionBodyList.size());
        return (position < questionBodyList.size()-1);
    }

    QuestionBody getQuestionBodyItem() {
        return
                questionBodyList
                        .get(position);
    }

    void fillFields(QuestionBody qb) {
        Log.d("tag", "fillFields");
        int i = position;
        numQuestion.setText("Question: " + (i + 1));
        questionTV.setText(qb.getTextQuestion());
        btn1.setText(qb.getOption1());
        btn2.setText(qb.getOption2());
        btn3.setText(qb.getOption3());
        btn4.setText(qb.getOption4());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // getMenuInflater().inflate(R.menu.add_test, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                position = 0;
                finish();
                return true;
            default:
                return true;
        }
    }
}

