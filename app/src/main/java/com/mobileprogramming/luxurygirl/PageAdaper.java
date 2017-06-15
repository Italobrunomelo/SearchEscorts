package com.mobileprogramming.luxurygirl;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import static android.support.v4.view.PagerAdapter.POSITION_NONE;

/**
 * Created by italo on 07/06/2017.
 */

public class PageAdaper {

    String[] titles;
    List<ActitvityPageView> pages = new ArrayList<ActitvityPageView>();


    public PageAdaper(ActitvityPageView fm, String[] titles) {
        super(this);
        this.titles = titles;
        this.pages.add(new ActitvityPageView());
        this.pages.add(new ActitvityPageView());
    }

    @Override
    public Activity getItem(int position) {
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
