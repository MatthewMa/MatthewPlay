package com.example.sihua.searchview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String[] array=new String[]{"Alpha","Basket","Captain","Duck"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        android.widget.SearchView sv_word= (android.widget.SearchView) findViewById(R.id.sv_content);
        final ListView lv_content= (ListView) findViewById(R.id.lv_content);
        sv_word.setQueryHint("Please input your keyword:");
        sv_word.setIconified(true);
        sv_word.setSubmitButtonEnabled(true);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout
                .simple_list_item_single_choice,array);
        lv_content.setTextFilterEnabled(true);
        lv_content.setAdapter(adapter);
        sv_word.setOnQueryTextListener(new android.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(MainActivity.this,"You are searching "+query,Toast.LENGTH_LONG).show();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(TextUtils.isEmpty(newText)){
                    lv_content.clearTextFilter();
                }else{
                    lv_content.setFilterText(newText);
                }
                return true;
            }
        });
    }
}
