package com.example.sihua.bookviewer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements BookListFragment.CallBacks {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onItemSelected(Integer id) {
        Bundle bundle=new Bundle();
        bundle.putInt(BookDetailFragment.ITEM_ID,id);
        BookDetailFragment fragment=new BookDetailFragment();
        fragment.setArguments(bundle);
        getFragmentManager().beginTransaction().replace(R.id.fl_books,fragment).commit();
    }
}
