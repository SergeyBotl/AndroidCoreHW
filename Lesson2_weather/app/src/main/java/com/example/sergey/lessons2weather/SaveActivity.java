package com.example.sergey.lessons2weather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class SaveActivity extends AppCompatActivity {
    private EditText speed, temper, oblachnost, osadki;
    private String FILENAME = MainActivity.FILENAME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);

        speed = (EditText) findViewById(R.id.windSpeed);
        temper = (EditText) findViewById(R.id.temperature);
        oblachnost = (EditText) findViewById(R.id.cloudiness);
        osadki = (EditText) findViewById(R.id.precipitation);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.save_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_save:
                writeFile(FILENAME);
                return true;
            case R.id.action_clear:
                clearFile(FILENAME);
                return true;
            default:
                return true;
        }
    }

    public void writeFile(String fileName) {

        try {
            OutputStream outputStream = openFileOutput(fileName, 0);
            OutputStreamWriter osw = new OutputStreamWriter(outputStream);

            osw.write("Скор. ветра: " + speed.getText().toString() + " ms"
                    + "\n Температура: " + temper.getText().toString() + " c"
                    + "\n Облачность:  " + oblachnost.getText().toString() + " %"
                    + "\n Осадки:      " + osadki.getText().toString() + " mm");
            osw.close();
        } catch (Throwable t) {
            Toast.makeText(getApplicationContext(),
                    "Exception: " + t.toString(), Toast.LENGTH_LONG).show();
        }
        finish();
    }

    public void clearFile(String fileName) {
        try {
            OutputStream os = openFileOutput(fileName, 0);
            OutputStreamWriter osw = new OutputStreamWriter(os);
            osw.write("");
            osw.close();

        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), "Exception: " + e.toString(), Toast.LENGTH_LONG).show();
        }
    }
}
