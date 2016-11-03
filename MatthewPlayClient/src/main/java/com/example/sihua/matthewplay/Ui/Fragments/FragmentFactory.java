package com.example.sihua.matthewplay.Ui.Fragments;

import android.support.v4.app.Fragment;

import java.util.HashMap;

/**
 * Created by Sihua on 2016/6/7.
 */
public class FragmentFactory {

     //保存fragment集合，方便复用
     private static HashMap<Integer,BaseFragment> mFragmentMap=new HashMap<Integer, BaseFragment>();
     public static Fragment createFragment(int pos){

         BaseFragment fragment=mFragmentMap.get(pos);
         if(fragment==null) {
             switch (pos) {
                 case 0:
                     fragment = new HomeFragment();
                     break;
                 case 1:
                     fragment = new AppFragment();
                     break;
                 case 2:
                     fragment = new GameFragment();
                     break;
                 case 3:
                     fragment = new SubjectFragment();
                     break;
                 case 4:
                     fragment = new RecommandFragment();
                     break;
                 case 5:
                     fragment = new CategoryFragment();
                     break;
                 case 6:
                     fragment = new HotFragment();
                     break;
                 default:
                     break;
             }
             mFragmentMap.put(pos,fragment);
         }
         return fragment;
     }
}
