package com.example.fangli.myslidelib.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 *  Created by chenyu on 2018/5/14.
 * 导航栏
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

//    private int PAGE_COUNT=3;

    private ArrayList<Fragment> mFragmentArrays;
    private ArrayList<String> mTabTitles;

    public ViewPagerAdapter(FragmentManager fm, ArrayList<Fragment> mFragmentArrays, ArrayList<String> mTabTitles) {
        super(fm);
        this.mFragmentArrays = mFragmentArrays;
        this.mTabTitles = mTabTitles;
    }

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentArrays.get(position);
    }


    @Override
    public int getCount() {
        return mTabTitles.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTabTitles.get(position);

    }
}
