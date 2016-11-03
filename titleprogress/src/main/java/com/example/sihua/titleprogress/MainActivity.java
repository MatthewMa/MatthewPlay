package com.example.sihua.titleprogress;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_PROGRESS);
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_main);
        Button btn_show= (Button) findViewById(R.id.btn_show);
        Button btn_hide= (Button) findViewById(R.id.btn_hide);
        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setProgressBarVisibility(true);
                setProgressBarIndeterminateVisibility(true);
            }
        });
        btn_hide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setProgressBarVisibility(false);
                setProgressBarIndeterminateVisibility(false);
            }
        });

    }
}
