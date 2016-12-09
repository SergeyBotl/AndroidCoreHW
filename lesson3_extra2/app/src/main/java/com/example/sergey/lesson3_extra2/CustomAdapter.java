package com.example.sergey.lesson3_extra2;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<String> {

    List<String> list = new ArrayList<>();
    private Context context;


    public CustomAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
        this.context = context;
        list = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // ViewHolder holder;
        String text = getItem(position);
        TextView textView = null;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.custom_layout, null);
            // holder= new ViewHolder();
            textView = (TextView) convertView.findViewById(R.id.textView);
            // holder.textView = (TextView) convertView.findViewById(R.id.textView);
            //convertView.setTag(holder);
        } else {
            //  holder=(ViewHolder)convertView.getTag();
        }
        final int i = position;
        // holder.textView.setText(text.toString());
        textView.setText(text.toString());

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("tag", "position " + i);
            }
        });

        return convertView;
    }

   /* private class ViewHolder {
        TextView textView;
    }*/
}
