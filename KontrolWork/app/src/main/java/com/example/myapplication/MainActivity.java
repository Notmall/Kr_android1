package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity{

    Spinner save_day, save_mounth, save_year,save_sex;
    EditText editText_puls, editText_puls2;
    Button button_next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> days = new ArrayList<String>();
        for (int i = 1; i <= 31; i++) {
            days.add(Integer.toString(i));
        }

        ArrayList<String> years = new ArrayList<String>();
        int thisYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 1900; i <= thisYear; i++) {
            years.add(Integer.toString(i));
        }

        String[] Months = new String[] { "Январь", "Февраль",
                "Март", "Апрель", "Мая", "Июнь", "Июль", "Август", "Сентябрь",
                "Октябрь", "Ноябрь", "Декабрь" };

        String[] Pol = new String[] { "Муж", "ЖЕн" };

        save_day = (Spinner) findViewById(R.id.spinner_day);
        save_mounth = (Spinner) findViewById(R.id.spinner_month);
        save_year = (Spinner) findViewById(R.id.spinner_year);
        save_sex = (Spinner) findViewById(R.id.spinner_pol);

         editText_puls = (EditText) findViewById(R.id.editText_puls);
         editText_puls2 = (EditText) findViewById(R.id.editText_puls2);

        button_next = (Button) findViewById(R.id.button_next);
        button_next.setOnClickListener(this::OnClick);

        ArrayAdapter<String> adapter_day = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, days);
        adapter_day.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adapter_month = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, Months);
        adapter_month.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adapter_year = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, years);
        adapter_year.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adapter_pol = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, Pol);
        adapter_pol.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        save_day.setAdapter(adapter_day);
        save_mounth.setAdapter(adapter_month);
        save_year.setAdapter(adapter_year);
        save_sex.setAdapter(adapter_pol);

        save_day.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

        save_mounth.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

        save_year.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

        save_sex.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });
    }

    public void OnClick(View v){
        Intent intent = new Intent(this, MainActivity2.class);
        /*Object[] SendValues = new Object[]{ editText_puls.getText(), editText_puls2.getText(), s_day.getSelectedItem().toString(),
                s_month.getSelectedItem().toString(), s_year.getSelectedItem().toString(), s_year.getSelectedItem().toString()
        };*/
        if( editText_puls.getText().toString().equals("") || editText_puls2.getText().toString().equals("")){
            Toast toast =  Toast.makeText(MainActivity.this,
                    "УМЕЮТСЯ ПУСТЫЕ ПОЛЯ!!!", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            }
        else{
        Bundle b = new Bundle();
        b.putStringArray("values", new String[]{editText_puls.getText().toString(), editText_puls2.getText().toString()});
        intent.putExtras(b);
        startActivity(intent);}
    }


}