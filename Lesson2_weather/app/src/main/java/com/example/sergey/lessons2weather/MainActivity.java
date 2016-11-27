package com.example.sergey.lessons2weather;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {
    public final static String FILENAME = "weather.txt"; // имя файла
    private TextView out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        out = (TextView) findViewById(R.id.textView5);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readFile(FILENAME);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_open:
                Intent intent = new Intent(this, SaveActivity.class);
                startActivity(intent);
                return true;
            default:
                return true;
        }
    }

    public String readFile(String fileName) {
        StringBuilder sb = new StringBuilder();
        try {
            InputStream inputStream = openFileInput(fileName);
            if (inputStream != null) {
                InputStreamReader isr = new InputStreamReader(inputStream);
                BufferedReader br = new BufferedReader(isr);
                String line;
                StringTokenizer st;
                line = br.readLine();
                while (line != null) {
                    st = new StringTokenizer(line, " ");
                    while (st.hasMoreTokens()) {
                        sb.append(st.nextToken());
                        sb.append(" ");
                    }
                    sb.append(System.lineSeparator());
                    line = br.readLine();
                }
                inputStream.close();
                out.setText(sb.toString());
            }

        } catch (IOException e) {
            Toast.makeText(getApplicationContext(),
                    "Exception: " + e.toString(), Toast.LENGTH_LONG).show();
        }
        return sb.toString();
    }





/*  void save() {
        if (!Environment.getExternalStorageDirectory().equals(Environment.MEDIA_MOUNTED)) {
            Toast.makeText(MainActivity.this, "SD-карта не доступна: ", Toast.LENGTH_LONG).show();
            return;
        }
        // получаем путь к SD
        File sdPath=Environment.getExternalStorageDirectory();
        // добавляем свой каталог к пути
        sdPath=new File(sdPath.getAbsolutePath()+"/"+DIR_SD);
        // создаем каталог
        sdPath.mkdirs();
        // формируем объект File, который содержит путь к файлу
        File sdFile=new File(sdPath,FILENAME);
        try{
            BufferedWriter bw=new BufferedWriter(new FileWriter(sdFile));
            bw.write("Yes");
            bw.close();
            Toast.makeText(this, "Файл удачно записан",Toast.LENGTH_LONG);
        }catch (IOException e){
            Toast.makeText(this, "Файл не записан",Toast.LENGTH_LONG);
        }
    }*/
}
