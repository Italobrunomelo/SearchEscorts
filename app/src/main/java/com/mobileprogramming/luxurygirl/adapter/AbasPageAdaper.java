package com.mobileprogramming.luxurygirl.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.mobileprogramming.luxurygirl.fragments.FragmentGirlsInformations;
import com.mobileprogramming.luxurygirl.fragments.FragmentGrilsList;
import com.mobileprogramming.luxurygirl.fragments.FragmentMoteisList;

/**
 * Created by italo on 07/06/2017.
 */

public class AbasPageAdaper extends FragmentPagerAdapter {

    private String[] mTabTitles;


    public AbasPageAdaper(FragmentManager fm, String[] mTabTitles) {
        super(fm);
        this.mTabTitles = mTabTitles;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new FragmentGrilsList();
            case 1:
                return new FragmentMoteisList();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mTabTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return this.mTabTitles[position];
    }
}
