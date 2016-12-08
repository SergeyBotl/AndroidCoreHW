package com.example.sergey.lesson2_speed_string;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {
    int i = 0;
    long mSart = 0, mFinish = 0, mSart1 = 0, mFinish1 = 0;
    StringBuilder sb = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spliter();
        stringToken();
        ((TextView) findViewById(R.id.textView)).setText(sb.toString());
        ((TextView) findViewById(R.id.textView2)).setText("Split: " + (mFinish - mSart) + "mls.   StringTokenizer: " + (mFinish1 - mSart1));
    }

    void spliter() {

        mSart = System.currentTimeMillis();
        for (String s : Text.text.split(" ")) {
            Log.i("TEG", "Count: " + i++);
            sb.append(s);
            sb.append(" ");
        }
        mFinish = System.currentTimeMillis();
    }

    void stringToken() {
        StringTokenizer st = new StringTokenizer(Text.text, " ");
        sb.append("\n \n");
        mSart1 = System.currentTimeMillis();
        while (st.hasMoreTokens()) {
            sb.append(st.nextToken());
            sb.append(" ");
        }
        mFinish1 = System.currentTimeMillis();
    }
}
