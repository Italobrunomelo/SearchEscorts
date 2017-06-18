package com.mobileprogramming.luxurygirl;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.mobileprogramming.luxurygirl.adapter.AbasPageAdaper;

/**
 * Created by italo on 12/06/2017.
 */

public class ActitvityPageView extends AppCompatActivity{
    //AbasPagerAdapter mAbasPagerAdapter;
    ViewPager mViewPager;
    TabLayout mTabLayout;
    private AbasPageAdaper mAbasPageAdaper;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pageview);
        setSupportActionBar((Toolbar)findViewById(R.id.toolbar));

        ViewPager mViewPager = (ViewPager) findViewById(R.id.activityPagerView);
        String[] titles = {"Girls", "Motels"};
        mAbasPageAdaper = new AbasPageAdaper(this, getSupportFragmentManager());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mViewPager = (ViewPager) findViewById(R.id.pager) ;
        mViewPager.setAdapter(mAbasPageAdaper);
        mTabLayout = (TabLayout)findViewById(R.id.tabs);
        mTabLayout.setupWithViewPager(mViewPager);

        //mAbasPagerAdapter = new AbasPagerAdapter(this, getSupportFragmentManager());
        //mViewPager = (ViewPager) findViewById(R.id.activityPagerView);
        //mViewPager.setAdapter(mAbasPagerAdapter);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
