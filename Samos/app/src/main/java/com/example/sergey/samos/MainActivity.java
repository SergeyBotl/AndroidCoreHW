package com.example.sergey.samos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText editText1, editText2;
    List<Value> list = new ArrayList<>();
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1 = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float a = Float.valueOf(editText1.getText().toString());
                float b = Float.valueOf(editText2.getText().toString());
                list.clear();
                multiplication(a, b);
                division(a, b);
                sum(a, b);
                subtraction(a, b);

                textView.setText(list.toString());
            }
        });
    }


    public void multiplication(float a, float b) {
        double c = (a * b);
        list.add(new Value(a, b, c, " * "));

    }

    public void division(float a, float b) {
        double c = (a / b);
        list.add(new Value(a, b, c, " / "));

    }

    public void sum(float a, float b) {
        double c = (a + b);
        list.add(new Value(a, b, c, " + "));

    }

    public void subtraction(float a, float b) {
        double c = (a - b);
        list.add(new Value(a, b, c, " - "));

    }


}
