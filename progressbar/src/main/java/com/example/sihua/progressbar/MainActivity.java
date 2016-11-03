package com.example.sihua.progressbar;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private int[] nums=new int[100];
    private int status=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ProgressBar pb_mybar= (ProgressBar) findViewById(R.id.pb_mybar);
        final Handler handler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                if(msg.what==0x123){
                    pb_mybar.setProgress(status);
                }
            }
        };
        new Thread(){
            @Override
            public void run() {
                while(status<100){
                    status=dowork();
                    handler.sendEmptyMessage(0x123);
                }
            }
        }.start();

    }

    /**
     * make a random number
     * @return int
     */
    private int dowork(){
        nums[status++]=(int)(Math.random()*100);
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return status;
    }
}
