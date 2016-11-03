package com.example.sihua.matthewplay.Ui.Fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sihua.matthewplay.Utils.UIUtils;

/**
 * Created by Sihua on 2016/6/7.
 */
public class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView tv=new TextView(UIUtils.getContext());
        tv.setText(getClass().getSimpleName());
        tv.setTextColor(Color.BLACK);
        return tv;
    }
}
