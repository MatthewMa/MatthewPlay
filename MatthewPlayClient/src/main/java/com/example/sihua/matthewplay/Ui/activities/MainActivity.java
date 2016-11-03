package com.example.sihua.matthewplay.Ui.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sihua.matthewplay.R;
import com.example.sihua.matthewplay.Ui.Fragments.FragmentFactory;
import com.example.sihua.matthewplay.Ui.widget.PagerTab;
import com.example.sihua.matthewplay.Utils.UIUtils;

public class MainActivity extends BaseActivity {

    private PagerTab mPageTab;
    private ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPageTab= (PagerTab) findViewById(R.id.pagertab);
        mViewPager= (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        //将viewpager和页签自定义控件关联在一起
        mPageTab.setViewPager(mViewPager);//此方法必须在viewpager设置完数据后调用，否则会出现问题
    }

    /**
     * Viewpager适配器
     */
    class MyAdapter extends FragmentPagerAdapter{

        private String[] mTabNames;

        public MyAdapter(FragmentManager fm) {
            super(fm);
            mTabNames =  UIUtils.getStringArray(R.array.tab_names);

        }

        //返回对应fragment
        @Override
        public Fragment getItem(int position) {
            Fragment fragment = FragmentFactory.createFragment(position);
            return fragment;
        }

        //返回总数
        @Override
        public int getCount() {
            return mTabNames.length;
        }

        //获取页面标题(pagertab显示标题专用)
        @Override
        public CharSequence getPageTitle(int position) {
            return mTabNames[position];
        }
    }
}
