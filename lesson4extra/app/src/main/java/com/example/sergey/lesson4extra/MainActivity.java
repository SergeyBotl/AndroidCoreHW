package com.example.sergey.lesson4extra;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CurrentUser currentUser = new CurrentUser();
    DAOuser daOuser = new DAOuser();
    TextView textInfo;
    EditText textLogIn, textPass;
    Button buttonlogin, buttonRegistri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textInfo = (TextView) findViewById(R.id.textInfo);
        textLogIn = (EditText) findViewById(R.id.log_inET);
        textPass = (EditText) findViewById(R.id.passET);

        buttonlogin = (Button) findViewById(R.id.buttonLogIn);
        buttonRegistri = (Button) findViewById(R.id.buttonRegistri);

        final User user = new User(textLogIn.toString(), textPass.toString());


        buttonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentUser.logIn(user)) {
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    startActivity(intent);
                    textLogIn.setText("");
                    textPass.setText("");
                    textLogIn.requestFocus();
                    textInfo.setText("");
                } else {
                    textInfo.setTextColor(getResources().getColor(R.color.colorRed));
                    textInfo.setText("Нет такого пользователя");
                }

            }
        });

        buttonRegistri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                daOuser.save(user);
                textInfo.setTextColor(getResources().getColor(R.color.colorGreen));
                textInfo.setText("Регистрация успешна");

            }
        });
    }


}
