package com.mobileprogramming.luxurygirl.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by italo on 07/06/2017.
 */

public class AbasPageAdaper extends FragmentPagerAdapter{

    String[] titulosAbas;
    //List<ActitvityPageView> pages = new ArrayList<ActitvityPageView>();

public AbasPageAdaper (Context ctx, FragmentManager fm){
    super(fm);
    titulosAbas = ctx.getResources().getStringArray(R.array.secoes);
}
    /*public AbasPageAdaper(FragmentManager fm, String[] titulosAbas) {
        super(fm);
        this.titulosAbas = titulosAbas;
        //this.pages.add(new ActitvityPageView());
        //this.pages.add(new ActitvityPageView());
    }*/

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titulosAbas[position];
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public Fragment getItem(int position) {

        return null;
    }
}
