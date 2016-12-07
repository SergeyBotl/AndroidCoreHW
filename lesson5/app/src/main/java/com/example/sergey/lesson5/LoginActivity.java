package com.example.sergey.lesson5;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    private User user;
    private UserDAO userDao = UserDAO.getUserDAO();
    private TextView textInfo;
    private EditText textLogIn, textPass;
    private SharedPreferences.Editor editor;
    private SharedPreferences preferences;
    private String log, pas;
    private static final String NAME_PREFERENCES = "Current";
    private static final String NAME_PREFERENCES_IS = "isLogin";
    static boolean mLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        preferences = getSharedPreferences(NAME_PREFERENCES, Context.MODE_PRIVATE);
        editor = preferences.edit();


        textInfo = (TextView) findViewById(R.id.textInfo);
        textLogIn = (EditText) findViewById(R.id.log_inET);
        textPass = (EditText) findViewById(R.id.passET);
        Log.i("TAG", "onCreate");

        findViewById(R.id.buttonLogIn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                log = textLogIn.getText().toString();
                pas = textPass.getText().toString();
                user = new User(log, pas);
                Log.i("TAG", "buttonLogIn");

                if (user != null && userDao.isLogin(user)) {
                    editor.putBoolean(NAME_PREFERENCES_IS, true).apply();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {

                    textInfo.setTextColor(getResources().getColor(R.color.colorRed));
                    textInfo.setText("Неверный логин или пароль");
                }
            }
        });

        findViewById(R.id.buttonRegistri).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("TAG", "buttonRegistri");
                if (user != null && log.length() > 0 && pas.length() > 0) {
                    userDao.save(user);
                    textInfo.setTextColor(getResources().getColor(R.color.colorGreen));
                    textInfo.setText("Регистрация успешна");
                }


            }
        });
    }

    @Override
    protected void onStart() {
        Log.i("TAG", "onStart");
        mLogin = preferences.getBoolean(NAME_PREFERENCES_IS, false);
        if (mLogin) {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            Log.i("TAG", "MainActivity.class ===========");
            finish();
        }
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.i("TAG", "onResume");
        super.onResume();
    }

    @Override
    protected void onPostResume() {
        Log.i("TAG", "onPostResume");

        super.onPostResume();
    }

    @Override
    protected void onPause() {
        Log.i("TAG", "onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i("TAG", "onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i("TAG", "onDestroy");
        super.onDestroy();
    }
}
