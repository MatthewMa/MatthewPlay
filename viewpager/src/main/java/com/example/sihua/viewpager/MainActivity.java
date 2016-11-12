package com.example.sihua.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements  ActionBar.TabListener {

    private ActionBar actionBar;
    private FragmentPagerAdapter adapter;
    private ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionBar=getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        vp = (ViewPager) findViewById(R.id.pager);
        adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                DummyFragment fragment=new DummyFragment();
                Bundle bundle=new Bundle();
                bundle.putInt(DummyFragment.SELECTED_ITEM,position+1);
                fragment.setArguments(bundle);
                return fragment;
            }

            @Override
            public int getCount() {
                return 3;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                String title="";
                switch (position){
                    case 0:
                        title="First Page";
                        break;
                    case 1:
                        title="Second Page";
                        break;
                    case 2:
                        title="Third Page";
                        break;
                }
                return title;
            }
        };
        vp.setAdapter(adapter);
        for (int i=0;i<adapter.getCount();i++){
            actionBar.addTab(actionBar.newTab().setText(adapter.getPageTitle(i)).setTabListener
                    (MainActivity.this));
        }
        vp.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }
        });


    }


    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        vp.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
