package com.example.sergey.lesson6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ArrayAdapter<User> adapter;
    UserDAO dao = UserDAO.getUserDAO();
    List<User> list = new ArrayList<>(dao.getUser());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                User user=(User)adapterView.getItemAtPosition(i);
                Intent intent=new Intent(MainActivity.this,DetailsActivity.class);
                intent.putExtra("id",user.getId());
                intent.putExtra("tel",user.getTel());
                intent.putExtra("age",user.getAge());
                startActivity(intent);
                Log.i("tag", "int " +user + " long " + user.getId());
            }
        });

    }

}
