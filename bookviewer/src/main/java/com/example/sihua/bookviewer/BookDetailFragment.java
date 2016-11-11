package com.example.sihua.bookviewer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sihua.bookcontent.BookContent;

public class BookDetailFragment extends android.app.Fragment{
    public static final String ITEM_ID="item_id";
    BookContent.Book book;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments().containsKey(ITEM_ID)){
            book=BookContent.ITEM_MAP.get(getArguments().getInt(ITEM_ID));
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_book_detail,container,false);
        if(book!=null){
            TextView tv_title= (TextView) rootView.findViewById(R.id.book_title);
            TextView tv_desc= (TextView) rootView.findViewById(R.id.book_desc);
            tv_title.setText(book.title);
            tv_desc.setText(book.desc);
        }
        return rootView;
    }
}