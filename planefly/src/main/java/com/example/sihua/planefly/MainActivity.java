package com.example.sihua.planefly;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));
    }

    class MyView extends View{
        final int BACK_HEIGHT=1700;
        private int WIDTH=640;
        private int HEIGHT=880;
        private Bitmap plane;
        private Bitmap back;
        private Matrix matrix=new Matrix();
        private float scale=0;
        private int startY=BACK_HEIGHT-HEIGHT;
        public MyView(Context context) {
            super(context);
            DisplayMetrics metrics=new DisplayMetrics();
            Display display = getWindowManager().getDefaultDisplay();
            display.getMetrics(metrics);
            int widthPixels = metrics.widthPixels;
            scale=widthPixels/WIDTH;
            matrix.setScale(scale,scale);
            back= BitmapFactory.decodeResource(context.getResources(),R.drawable.back_img);
            plane=BitmapFactory.decodeResource(context.getResources(), R.drawable.plane);
            final Handler handler=new Handler(){
                @Override
                public void handleMessage(Message msg) {
                    if(msg.what==0x123){
                        if(startY<=3){
                            startY=BACK_HEIGHT-HEIGHT;
                        }else{
                            startY-=3;
                        }
                        invalidate();
                    }
                }
            };
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    Message msg=new Message();
                    msg.what=0x123;
                    handler.sendMessage(msg);

                }
            },0,100);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Bitmap bitmap=Bitmap.createBitmap(back,0,startY,WIDTH,HEIGHT,matrix,false);
            canvas.drawBitmap(bitmap,0,0,null);
            canvas.drawBitmap(plane,320,700,null);
        }
    }
}
