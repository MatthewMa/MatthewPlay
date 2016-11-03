package com.example.sihua.interview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void click1(View view){
        startActivity(new Intent(this,MainActivity.class));
    }

    public void click2(View view){
        startActivity(new Intent(this,SecondActivity.class));
    }

    @Override
    public void onBackPressed() {
        MyApplication myApplication=new MyApplication();
        myApplication.exit();
    }
}

