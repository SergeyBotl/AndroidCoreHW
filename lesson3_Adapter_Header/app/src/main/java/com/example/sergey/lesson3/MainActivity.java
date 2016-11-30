package com.example.sergey.lesson3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    static Set<String> set = new HashSet<>();
    static int count = 0;
    static int countUnique = 0;
    View header;
    ListView listView;
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("TAG", "onCreate");

        listView = (ListView) findViewById(R.id.lv);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<>(set));
        header = createHeader("Одинаковых строк: " + count + "  Уникальных строк: " + countUnique);

        listView.addHeaderView(header);
        listView.setAdapter(adapter);
  }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_save:
                Log.i("TAG", "2");
                if (!set.add(((EditText) header.findViewById(R.id.editText)).getText().toString())) {
                    count++;
                } else
                    countUnique++;
                recreate();
                break;
            default:
                break;

        }
        return true;
    }

    View createHeader(String text) {
        Log.i("TAG", "1");
        View v = getLayoutInflater().inflate(R.layout.header, null);
        ((TextView) v.findViewById(R.id.textView)).setText(text);
        return v;
    }
}
