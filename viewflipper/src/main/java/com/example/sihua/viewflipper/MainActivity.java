package com.example.sihua.viewflipper;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    int[] images=new int[]{
            R.drawable.shuangzi, R.drawable.shuangyu,
            R.drawable.chunv, R.drawable.tiancheng, R.drawable.tianxie,
            R.drawable.sheshou, R.drawable.juxie, R.drawable.shuiping,
            R.drawable.shizi, R.drawable.baiyang, R.drawable.jinniu,
            R.drawable.mojie
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final AdapterViewFlipper av= (AdapterViewFlipper) findViewById(R.id.flipper);
        Button btn_pre= (Button) findViewById(R.id.pre);
        Button btn_autostart= (Button) findViewById(R.id.autostart);
        Button btn_next= (Button) findViewById(R.id.next);
        BaseAdapter adapter=new BaseAdapter() {
            @Override
            public int getCount() {
                return images.length;
            }

            @Override
            public Object getItem(int position) {
                return images[position];
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ImageView iv=new ImageView(MainActivity.this);
                iv.setImageResource(images[position]);
                iv.setScaleType(ImageView.ScaleType.FIT_XY);
                iv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams
                        .MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                return iv;
            }
        };
        av.setAdapter(adapter);
        btn_pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                av.showPrevious();
                av.stopFlipping();
            }
        });
        btn_autostart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                av.startFlipping();
            }
        });
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                av.showNext();
                av.stopFlipping();
            }
        });
    }
}
