package com.example.sihua.fatpo;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btn_play;
    private Button btn_pause;
    private ImageView iv_fatpo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_play= (Button) findViewById(R.id.btn_play);
        btn_pause= (Button) findViewById(R.id.btn_pause);
        iv_fatpo= (ImageView) findViewById(R.id.iv_fatpo);
        final AnimationDrawable animationDrawable=(AnimationDrawable)iv_fatpo.getBackground();
        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animationDrawable.start();
            }
        });
        btn_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animationDrawable.stop();
            }
        });

    }
}
