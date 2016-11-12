package com.example.sihua.viewpager;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class DummyFragment extends Fragment {

    public static String SELECTED_ITEM="selected_item";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        int num=getArguments().getInt(SELECTED_ITEM);
        textView.setTextSize(18);
        textView.setTextColor(Color.GREEN);
        textView.setText("This is Page "+num);
        return textView;
    }

}
