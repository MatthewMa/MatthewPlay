package com.example.sihua.stackview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;
import android.widget.StackView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    int[] imageIds = new int[]
            {
                    R.drawable.bomb5 , R.drawable.bomb6 , R.drawable.bomb7
                    , R.drawable.bomb8 , R.drawable.bomb9 , R.drawable.bomb10
                    , R.drawable.bomb11 , R.drawable.bomb12	, R.drawable.bomb13
                    , R.drawable.bomb14 , R.drawable.bomb15 , R.drawable.bomb16
            };
    List<Map<String,Object>> lists;
    private StackView sv_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sv_content = (StackView) findViewById(R.id.sv_content);
        lists=new ArrayList<Map<String,Object>>();
        for (int i = 0; i < imageIds.length; i++) {
            Map<String,Object> list=new HashMap<String,Object>();
            list.put("image",imageIds[i]);
            lists.add(list);
        }
        SimpleAdapter adapter=new SimpleAdapter(this,lists,R.layout.item_image,new
                String[]{"image"},new int[]{R.id.image});
        sv_content.setAdapter(adapter);

    }
    public void pre(View view){
        sv_content.showPrevious();
    }

    public void next(View view){
        sv_content.showNext();
    }
}
