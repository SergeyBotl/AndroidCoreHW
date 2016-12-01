package com.example.sergey.samostiyna;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static com.example.sergey.samostiyna.Thickness.*;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private EditText editText1, editText2, editText3;
    private List<Pizza> list = new ArrayList<>();
    private Button buttonSave, buttonRead;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1 = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        textView = (TextView) findViewById(R.id.textView);
        buttonSave = (Button) findViewById(R.id.buttonSave);
        buttonRead = (Button) findViewById(R.id.buttonRead);
        editText3 = (EditText) findViewById(R.id.editText3);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thickness t;
                if (editText3.getText().toString().equals(thick)) {
                    t = thick;
                } else {
                    t = thin;
                }
                list.add(new Pizza(editText1.getText().toString(), Float.valueOf(editText2.getText().toString()), t));

            }
        });
        buttonRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(list.toString());
            }
        });
    }
}
