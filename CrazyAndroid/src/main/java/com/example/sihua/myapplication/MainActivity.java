package com.example.sihua.myapplication;



        import android.app.Activity;
        import android.app.ListActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.AdapterView;
        import android.widget.BaseAdapter;
        import android.widget.ImageView;
        import android.widget.ListView;
        import android.widget.TextView;
        import android.widget.Toast;


public class MainActivity extends Activity {

    public int[] headers=new int[]{R.drawable.libai,R.drawable.tiger,R.drawable.qingzhao,R
            .drawable.nongyu};
    public String[] personnames=new String[]{"Li Bai","Hu Tou","Li Qingzhao","Nong Yu"};
    public String[] descs=new String[]{"Romantic poetry","Dangerous Tiger","Outstanding Writer","A" +
            " " +
            "girl who comes from JiangNan"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qq);
        ListView lv_users = (ListView) findViewById(R.id.lv_users);
        lv_users.setAdapter(new MyAdapter());
        lv_users.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"You have clicked"+personnames[position],Toast
                        .LENGTH_LONG).show();
            }
        });

    }

    class MyAdapter extends BaseAdapter{

        private ImageView iv_header;
        private TextView tv_personname;
        private TextView tv_desc;

        @Override
        public int getCount() {
            return headers.length;
        }

        @Override
        public Object getItem(int position) {
            return headers[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView==null) {
            convertView = View.inflate(MainActivity.this, R.layout.item_user, null);
            iv_header = (ImageView) convertView.findViewById(R.id.iv_header);
            tv_personname = (TextView) convertView.findViewById(R.id.tv_personname);
            tv_desc = (TextView) convertView.findViewById(R.id.tv_desc);
        }
        iv_header.setImageResource(headers[position]);
        tv_personname.setText(personnames[position]);
        tv_desc.setText(descs[position]);
        return convertView;
    }
    }


}

