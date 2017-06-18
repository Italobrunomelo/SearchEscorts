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
    ViewPager mViewPager;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pageview);
        setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mViewPager = (ViewPager) findViewById(R.id.pager);
        mTabLayout = (TabLayout)findViewById(R.id.tabs);
        mViewPager.setAdapter(new AbasPageAdaper(getSupportFragmentManager(), getResources().getStringArray(R.array.titles_tab)));
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
