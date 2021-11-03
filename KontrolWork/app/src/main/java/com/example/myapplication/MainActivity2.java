package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    TextView statusView;
    ProgressBar indicatorBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView tx = (TextView) findViewById(R.id.textView13);

        Bundle b = this.getIntent().getExtras();
        String[] SendValues =b.getStringArray("values");

         statusView =(TextView) findViewById(R.id.textView12);
         indicatorBar = findViewById(R.id.progressBar);

        int min = 1;
        int max = 3;
        int diff = max - min;
        Random random = new Random();
        int serd = random.nextInt(diff + 1);
        serd += min;
         int result = serd;

        if (result== 1){
            statusView.setText("Введенные значения соответствуют отсутствию переутомления.");
        }

        else  if (result== 2) {
                statusView.setText("Введенные значения соответствуют небольшому переутомления. Рекомендуется снижение нагрузки.");
            }
        else  if (result== 3){
            statusView.setText("Введенные значения соответствуют высокому уровню переутомления. Рекомендуется снижение нагрузки или отпуск.");
        }
    }
}