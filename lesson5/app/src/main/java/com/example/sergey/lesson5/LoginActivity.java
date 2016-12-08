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
                Log.i("TAG", "buttonLogIn");
                if (getUser() != null && userDao.isLogin(getUser())) {
                    editor.putBoolean(NAME_PREFERENCES_IS, true).apply();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    //finish();
                } else {
                    textInfo.setTextColor(getResources().getColor(R.color.colorRed));
                    textInfo.setText("Неверный логин или пароль");
                }
            }
        });

        findViewById(R.id.buttonRegistration).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("TAG", "buttonRegistri");
                getUser();
                if (log.length() > 0 && pas.length() > 0) {
                    userDao.save(getUser());
                    textInfo.setTextColor(getResources().getColor(R.color.colorGreen));
                    textInfo.setText("Регистрация успешна");
                } else {
                    textInfo.setTextColor(getResources().getColor(R.color.colorRed));
                    textInfo.setText("Некоректный логин или пароль");
                }
            }
        });
    }

    private User getUser() {
        log = textLogIn.getText().toString();
        pas = textPass.getText().toString();
        return new User(log, pas);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("login", log);
        outState.putString("pass", pas);
        Log.i("TAG", "onSaveInstanceState");
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.i("TAG", "onRestoreInstanceState");
        textLogIn.setText(savedInstanceState.getString("login"));
        textPass.setText(savedInstanceState.getString("pass"));
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onStart() {
        Log.i("TAG", "onStart");
        mLogin = preferences.getBoolean(NAME_PREFERENCES_IS, false);
        if (mLogin) {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            Log.i("TAG", "MainActivity.class ===========");
            //finish();
        }
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.i("TAG", "onResume");
        super.onResume();
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
