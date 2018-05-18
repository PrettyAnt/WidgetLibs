package com.example.fangli.myslidelib;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.example.fangli.myslidelib.adapter.ViewPagerAdapter;
import com.example.fangli.myslidelib.fragment.FirstFragment;
import com.example.fangli.myslidelib.fragment.SecondFragment;
import com.example.fangli.myslidelib.fragment.ThridFragment;

import java.util.ArrayList;

/**
 * Created by chenyu.
 * Created on 下午5:19 2018/5/9.
 * Author'github https://github.com/PrettyAnt
 */

public class SecondActivity extends BaseActivity {
    private ArrayList<String> titleList = new ArrayList<>();//标题的集合
    private ArrayList<Fragment> fragList = new ArrayList<>();//fragment的集合

    @Override
    protected void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_act_second);
        setSupportActionBar(toolbar);
        titleList.clear();
        fragList.clear();
        FirstFragment firstFragment = new FirstFragment();
        SecondFragment secondFragment = new SecondFragment();
        ThridFragment thridFragment = new ThridFragment();
        TabLayout tl_fg_title = findViewById(R.id.tl_fg_title);//添加依赖包  'com.android.support:design:23.4.0'
        ViewPager vp_fg = (ViewPager) findViewById(R.id.vp_fg);
        titleList.add("first");
        titleList.add("second");
        titleList.add("thrid");
        fragList.add(firstFragment);
        fragList.add(secondFragment);
        fragList.add(thridFragment);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), fragList, titleList);
        vp_fg.setAdapter(viewPagerAdapter);
        tl_fg_title.setTabMode(TabLayout.GRAVITY_CENTER);
        tl_fg_title.setupWithViewPager(vp_fg);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_second;
    }

    @Override
    public boolean enableSlideClose() {
        return true;
    }
}
