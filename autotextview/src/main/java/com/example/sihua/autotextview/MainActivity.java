package com.example.sihua.autotextview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    public String[] books=new String[]{"Crazy Java","Crazy PHP","Crazy AJAX","Crazy HTML","Crazy Js"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.ac_book);
        MultiAutoCompleteTextView multiAutoCompleteTextView = (MultiAutoCompleteTextView) findViewById(R.id.mc_book);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout
                .simple_dropdown_item_1line,books);
        autoCompleteTextView.setAdapter(adapter);
        multiAutoCompleteTextView.setAdapter(adapter);
        multiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }
}
