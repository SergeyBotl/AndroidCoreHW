package com.example.sergey.lesson5;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    DAObesity dao = DAObesity.getDaObesity();

    View header;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        header = getLayoutInflater().inflate(R.layout.header, null);
        ((TextView) header.findViewById(R.id.textView)).setText(" Список мобил");
        ExpandableListView listView = (ExpandableListView) findViewById(R.id.exView);

        ExpListAdapter adapter = new ExpListAdapter(getApplicationContext(), dao.getMobilaList());
        listView.addHeaderView(header);
        listView.setAdapter(adapter);
    }


    @Override
    public void onBackPressed() {

            startActivity(new Intent(MainActivity.this, StartActivity.class));

        super.onBackPressed();
    }

    public class ExpListAdapter extends BaseExpandableListAdapter {

        private List<Mobila> group;
        private Context context;

        ExpListAdapter(Context context, List<Mobila> mGroup) {
            this.group = mGroup;
            this.context = context;
        }

        @Override
        public int getGroupCount() {
            return group.size();
        }

        @Override
        public int getChildrenCount(int i) {
            return group.size();
        }

        @Override
        public Mobila getGroup(int i) {
            return group.get(i);

        }

        @Override
        public Model getChild(int i, int i1) {
            return getGroup(i).getModel().get(i1);
        }

        @Override
        public long getGroupId(int i) {
            return i;
        }

        @Override
        public long getChildId(int i, int i1) {
            return getGroup(i).getModel().get(i1).getModelId();
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
            if (view == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.expandeble_group, null);
            }

            TextView textGroup = (TextView) view.findViewById(R.id.textGroup);
            textGroup.setText(getGroup(i).getMark());
            return view;
        }

        @Override
        public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
            final int j = i + 1, j1 = i1 + 1;
            final boolean bb = b;

            if (view == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.expendable_child, null);
            }


            final TextView textChild = (TextView) view.findViewById(R.id.textChild);
            textChild.setText(getChild(i, i1).getModelName());

            textChild.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "pressrd: group " + j + " child " + j1 + " " + bb, Toast.LENGTH_SHORT).show();
                }
            });

            CheckBox checkBox = (CheckBox) view.findViewById(R.id.chBox);
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    Toast.makeText(context, "Check Box " + b + " \ngroup " + j + " child " + j1 + " " + "\n text  " + textChild.getText(), Toast.LENGTH_SHORT).show();
                }
            });
            return view;
        }

        @Override
        public boolean isChildSelectable(int i, int i1) {
            return false;
        }
    }

}
