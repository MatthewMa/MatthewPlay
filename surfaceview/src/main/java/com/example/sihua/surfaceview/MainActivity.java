package com.example.sihua.surfaceview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MainActivity extends AppCompatActivity {

    private MyView mv_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mv_view=new MyView(this);
        setContentView(mv_view);

    }

    class MyView extends SurfaceView implements SurfaceHolder.Callback{

        private SurfaceHolder surfaceHolder;
        private MyThread myThread;
        public MyView(Context context) {
            super(context);
            surfaceHolder=this.getHolder();
            surfaceHolder.addCallback(this);
            myThread=new MyThread(surfaceHolder);
        }

        @Override
        public void surfaceCreated(SurfaceHolder holder) {
            myThread.isRun=true;
            myThread.start();
        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {
            myThread.isRun=false;
        }
    }

    private class MyThread extends Thread{
        private SurfaceHolder holder;
        public boolean isRun ;

        public MyThread(SurfaceHolder holder) {
            this.holder = holder;
            isRun=true;
        }

        @Override
        public void run() {
            int count=0;
            while(isRun){
                Canvas c=null;
                try {
                    synchronized (holder) {
                        c = holder.lockCanvas();
                        c.drawColor(Color.BLUE);
                        Paint p = new Paint();
                        p.setColor(Color.GREEN);
                        p.setStyle(Paint.Style.FILL);
                        p.setTextSize(30);
                        Rect rect = new Rect(100, 50, 300, 250);
                        c.drawRect(rect, p);
                        c.drawText("This is " + (count++) + " s", 100, 310, p);
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    holder.unlockCanvasAndPost(c);
                }
            }
        }
    }
}
