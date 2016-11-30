package com.example.sergey.lesson3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.sergey.lesson3.entity.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static List<Text> list = new ArrayList<>();
    private static int count = 0;
    private static int countUnique = 0;
    private View header;
    private ListView listView;
    private static ArrayAdapter<Text> adapter;
    private TextView mHeaderTV;
    private EditText mHeaderET;
    private int adapterId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapterId = android.R.layout.simple_list_item_1;
        listView = (ListView) findViewById(R.id.lv);

        header = getLayoutInflater().inflate(R.layout.header, null);
        mHeaderTV = (TextView) header.findViewById(R.id.textView);
        mHeaderET = (EditText) header.findViewById(R.id.editText);
        listView.addHeaderView(header);

        createList();
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
                Editable e = mHeaderET.getText();
                if (e.length() != 0) {
                    if (!check(e)) {
                        list.add(new Text(list.size() + 1, e, 0));
                        countUnique++;
                    }
                }

                createList();

                break;
            default:
                break;
        }
        return true;
    }

    void createList() {
        adapter = new ArrayAdapter<>(this, adapterId, list);
        mHeaderTV.setText("Одинаковых строк: " + count + "  Уникальных строк: " + countUnique);
        mHeaderET.setText("");
        listView.setAdapter(adapter);
        mHeaderET.requestFocus();
    }

    boolean check(Editable e) {
        for (Text t : list) {
            if (t.getText().toString().equals(e.toString())) {
                t.setCountSame(t.getCountSame() + 1);
                count++;
                return true;
            }
        }
        return false;
    }
}
