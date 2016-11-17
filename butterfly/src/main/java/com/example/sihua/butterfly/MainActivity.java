package com.example.sihua.butterfly;

import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private Button btn_start;
    private ImageView iv_butterfly;
    private AnimationDrawable animationDrawable;
    private float currX=0;
    private float currY=30;
    private float nextX=0;
    private float nextY=0;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what==0x123){
                if(nextX>320){
                    currX=nextX=0;
                }else
                    nextX+=8;
                nextY=currY+(float) (Math.random()*10-5);
                TranslateAnimation animation=new TranslateAnimation(currX,nextX,currY,nextY);
                currX=nextX;
                currY=nextY;
                animation.setDuration(200);
                animation.setFillAfter(true);
                iv_butterfly.startAnimation(animation);
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_start= (Button) findViewById(R.id.btn_start);
        iv_butterfly= (ImageView) findViewById(R.id.iv_butterfly);
        animationDrawable=(AnimationDrawable) iv_butterfly.getBackground();
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animationDrawable.start();
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        handler.sendEmptyMessage(0x123);
                    }
                },0,200);
            }
        });

    }
}
