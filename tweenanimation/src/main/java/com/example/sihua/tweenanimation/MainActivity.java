package com.example.sihua.tweenanimation;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Button btn_start;
    private ImageView iv_anim;
    private Animation anim_flower;
    private Animation anim_reverseflower;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what==0x123){
                iv_anim.startAnimation(anim_reverseflower);
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_start= (Button) findViewById(R.id.btn_start);
        iv_anim= (ImageView) findViewById(R.id.iv_anim);
        anim_flower=AnimationUtils.loadAnimation(this,R.anim.anim_flower);
        anim_reverseflower=AnimationUtils.loadAnimation(this,R.anim.anim_reverseflower);
        anim_flower.setFillAfter(true);
        anim_flower.setDuration(3000);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_anim.startAnimation(anim_flower);
                Message msg=new Message();
                msg.what=0x123;
                handler.sendMessageDelayed(msg,3000);
            }
        });
    }
}
