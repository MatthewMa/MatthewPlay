package com.example.sihua.bombplane;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {

    private AnimationDrawable anim;
    private MediaPlayer mediaPlayer;
    private MyView myView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FrameLayout frameLayout=new FrameLayout(this);
        setContentView(frameLayout);
        myView=new MyView(this);
        //hide the view
        myView.setVisibility(View.INVISIBLE);
        frameLayout.addView(myView);
        myView.setBackgroundResource(R.anim.anim_bomb);
        mediaPlayer=MediaPlayer.create(this,R.raw.bomb);
        anim=(AnimationDrawable) (myView.getBackground());
        frameLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    anim.stop();
                    mediaPlayer.stop();
                    float x=event.getX();
                    float y=event.getY();
                    myView.setLocation((int)y-40,(int)x-20);
                    myView.setVisibility(View.VISIBLE);
                    anim.start();
                    mediaPlayer.start();
                }
                return false;
            }
        });
    }

    class MyView extends ImageView{

        public MyView(Context context) {
            super(context);
        }

        public void setLocation(int top,int left){
            this.setFrame(top,left,top+40,left+40);
        }

        /**
         * check if it is last frame
         * @param canvas
         */
        @Override
        protected void onDraw(Canvas canvas) {
            try
            {
                Field field = AnimationDrawable.class
                        .getDeclaredField("mCurFrame");
                field.setAccessible(true);
                // 获取anim动画的当前帧
                int curFrame = field.getInt(anim);
                // 如果已经到了最后一帧
                if (curFrame == anim.getNumberOfFrames() - 1)
                {
                    // 让该View隐藏
                    setVisibility(View.INVISIBLE);
                }
            }
            catch (Exception e)
            {
            }
            super.onDraw(canvas);
        }
    }
}
