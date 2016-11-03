package com.example.sihua.viewswitcher;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
    public final static int NUMBERS_PER_SCREEN=12;
    private ViewSwitcher vs_grid;
    private LayoutInflater inflater;
    public static class DataItem{
        public String dataName;
        public Drawable drawable;
    }
    private ArrayList<DataItem> items=new ArrayList<DataItem>();
    private int screenNum=-1;
    private int screenCount;
    private BaseAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vs_grid = (ViewSwitcher) findViewById(R.id.vs_grid);
        inflater=LayoutInflater.from(this);
        for (int i = 0; i < 40; i++) {
            String label=""+i;
            Drawable d=getResources().getDrawable(R.mipmap.ic_launcher);
            DataItem item=new DataItem();
            item.dataName=label;
            item.drawable=d;
            items.add(item);
        }
        screenCount=items.size()%NUMBERS_PER_SCREEN==0?items.size()/NUMBERS_PER_SCREEN:items.size
                ()/NUMBERS_PER_SCREEN+1;
        vs_grid.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                return inflater.inflate(R.layout.grid_view,null);
            }
        });
        adapter=new BaseAdapter() {
            @Override
            public int getCount() {
                if(screenNum==screenCount-1&&items.size()%NUMBERS_PER_SCREEN!=0){
                    return items.size()%NUMBERS_PER_SCREEN;
                }
                return NUMBERS_PER_SCREEN;
            }

            @Override
            public Object getItem(int position) {
                return items.get(screenNum*NUMBERS_PER_SCREEN+position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view=convertView;
                if(convertView==null){
                    view=inflater.inflate(R.layout.labelicon,null);
                }
                ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
                imageView.setImageDrawable(((DataItem)getItem(position)).drawable);
                TextView textView=(TextView) view.findViewById(R.id.textview);
                textView.setText(((DataItem)getItem(position)).dataName);
                return view;
            }
        };
        next(null);
    }

    public void pre(View v){
        if(screenNum>0){
            screenNum--;
            vs_grid.setInAnimation(this,R.anim.slide_in_left);
            vs_grid.setOutAnimation(this,R.anim.slide_out_right);
            ((GridView)vs_grid.getNextView()).setAdapter(adapter);
            vs_grid.showPrevious();
        }
    }

    public void next(View v){
        if(screenNum<screenCount-1){
            screenNum++;
            vs_grid.setInAnimation(this,R.anim.slide_in_right);
            vs_grid.setOutAnimation(this,R.anim.slide_out_left);
            ((GridView)vs_grid.getNextView()).setAdapter(adapter);
            vs_grid.showNext();
            
        }
    }
}
