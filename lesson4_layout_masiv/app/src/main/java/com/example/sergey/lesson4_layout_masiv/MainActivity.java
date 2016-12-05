package com.example.sergey.lesson4_layout_masiv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private int a[] = {8, 0, -1, 6, -4, 3, -4, 9, 0};
    private int b[] = new int[a.length];
    private int position = 0, index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculation();
        TextView textView = (TextView) findViewById(R.id.textHello);
        textView.setText(Arrays.toString(a)+"\n"+Arrays.toString(b)+"\n"+raznost());

    }

    void calculation() {
        for (int j = 0; j < 3; j++) {
            index++;
            for (int i : a) {
                check(index, i);
            }
        }
    }

    void check(int index, int number) {

        switch (index) {
            case 1:
                if (number < 0) add(number);
                break;
            case 2:
                if (number == 0) add(number);
                break;
            case 3:
                if (number > 0) add(number);
                break;
            default:
                break;
        }
    }

    void add(int nunber) {
        b[position] = nunber;
        position++;
    }
//======================================================
    String raznost() {
        int sum = 0;
        for (int i : a) {
            sum += i;
        }
        int d = sum / a.length;

        for (int i = 0; i < a.length; i++) {
             a[i]-=d;
        }

        int max = a[0];
        for (int aB : a) {
            if (max < aB) {
                max = aB;
            }
        }
        int min = a[0];
        for (int aB : a) {
            if (min > aB) {
                min = aB;
            }
        }
    return "max: "+max+",  min: "+min;
    }
}
