package com.example.sergey.lesson3extra;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

   static String[] text = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

   static List<String>list=new ArrayList<>(Arrays.asList(text));
    Spinner spinner;
    String s;
    EditText editText;
    ArrayAdapter<?> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=(EditText)findViewById(R.id.editText);
        spinner = (Spinner) findViewById(R.id.spinner);
         adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
        // adapter = ArrayAdapter.createFromResource(this, R.array.catlist, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

       // spinner.setSelection(4);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                adapter.notifyDataSetChanged();
                s = spinner.getSelectedItem().toString();
                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_save:
                list.add(editText.getText().toString());
                adapter.notifyDataSetChanged();
                spinner.setAdapter(adapter);
                spinner.setSelection(list.size()-1);
                editText.setText("");
                break;
            default:break;
        }

        return super.onOptionsItemSelected(item);
    }
}
