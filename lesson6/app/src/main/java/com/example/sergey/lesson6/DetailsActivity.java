package com.example.sergey.lesson6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        final TextView textView = (TextView) findViewById(R.id.textView);
        final EditText editText = (EditText) findViewById(R.id.editText);

        if (getIntent() != null) {
            User entity =
                    getIntent()
                            .getParcelableExtra(ExConstants.INTENT_EXTRA_NAME);
            textView.setText(entity.toString());
        }

            // "Id: " + intent.getLongExtra("id", 0)+ " \nTel: " + intent.getIntExtra("tel", 0)+ " \nAge: " + intent.getIntExtra("age", 0));

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, editText.getText().toString());
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
                editText.setText("");
            }
        });


    }
}
