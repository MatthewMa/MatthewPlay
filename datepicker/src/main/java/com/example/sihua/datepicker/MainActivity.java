package com.example.sihua.datepicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private EditText et_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatePicker dp_book= (DatePicker) findViewById(R.id.dp_book);
        TimePicker tp_book= (TimePicker) findViewById(R.id.tp_book);
        et_time = (EditText) findViewById(R.id.et_time);
        Calendar calendar=Calendar.getInstance();
        year=calendar.get(Calendar.YEAR);
        month=calendar.get(Calendar.MONTH);
        day=calendar.get(Calendar.DAY_OF_MONTH);
        hour=calendar.get(Calendar.HOUR);
        minute=calendar.get(Calendar.MINUTE);
        dp_book.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                MainActivity.this.year=year;
                MainActivity.this.month=monthOfYear;
                MainActivity.this.day=dayOfMonth;
                showDate(year,month,day,hour,minute);
            }
        });
        tp_book.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                MainActivity.this.hour=hourOfDay;
                MainActivity.this.minute=minute;
                showDate(year,month,day,hour,minute);
            }
        });

    }

    private void showDate(int year, int month, int day, int hour, int minute) {
        et_time.setText(String.format("You bought the book on %d-%d-%d %d:%d",year,month,day,
                hour,minute));
    }
}
