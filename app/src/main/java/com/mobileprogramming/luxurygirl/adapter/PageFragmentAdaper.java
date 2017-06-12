package com.mobileprogramming.luxurygirl.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.mobileprogramming.luxurygirl.fragments.PageFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by italo on 07/06/2017.
 */

public class PageFragmentAdaper extends FragmentPagerAdapter {

    String[] titles;
    List<PageFragment> pages = new ArrayList<PageFragment>();


    public PageFragmentAdaper(FragmentManager fm, String[] titles) {
        super(fm);
        this.titles = titles;
        this.pages.add(new PageFragment());
        this.pages.add(new PageFragment());
    }

    @Override
    public Fragment getItem(int position) {
        return pages.get(position);
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
}
