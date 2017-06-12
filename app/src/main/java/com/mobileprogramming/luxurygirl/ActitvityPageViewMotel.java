package com.mobileprogramming.luxurygirl;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by italo on 12/06/2017.
 */

public class ActitvityPageViewMotel extends AppCompatActivity{
    AbasPagerAdapter mAbasPagerAdapter;
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pageview_motel);
        setSupportActionBar((Toolbar)findViewById(R.id.toolbar));

        mAbasPagerAdapter = new AbasPagerAdapter(this, getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mAbasPagerAdapter);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
