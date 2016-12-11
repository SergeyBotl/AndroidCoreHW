package com.example.sergey.lesson6;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //private ArrayAdapter<User> adapter;
    private UserDAO dao = UserDAO.getUserDAO();
    private List<User> list = new ArrayList<>(dao.getUser());
    private CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);

        adapter = new CustomAdapter(this, R.layout.custom, list);

        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final User user = (User) adapterView.getItemAtPosition(i);
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra(ExConstants.INTENT_EXTRA_NAME, user);
                startActivity(intent);
                Log.i("tag", "int " + user + " long " + user.getId());
            }
        });

    }

    private class CustomAdapter extends ArrayAdapter<User> {

        private Context context;
        private ArrayList<User> list;

        public CustomAdapter(Context context, int resource, List<User> objects) {
            super(context, resource, objects);
            this.context = context;
            list = new ArrayList<>(objects);
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            User user = list.get(position);
            TextView textView=null;
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.custom, null);
                 textView = (TextView) convertView.findViewById(R.id.textView3);
            }
                  textView.setText(user.getFirstName() + " " + user.getLastName());

            return convertView;
        }
    }

}
