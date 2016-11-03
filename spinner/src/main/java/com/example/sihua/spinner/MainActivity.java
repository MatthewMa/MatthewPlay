package com.example.sihua.spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner= (Spinner) findViewById(R.id.spinner);
        String[] contents=new String[]{"Sunwukong","Zhubajie","Shaseng"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout
                .simple_list_item_multiple_choice,contents);
        spinner.setAdapter(adapter);

    }
}
