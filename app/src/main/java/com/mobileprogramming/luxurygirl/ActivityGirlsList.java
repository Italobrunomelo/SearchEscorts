package com.mobileprogramming.luxurygirl;

import android.app.ProgressDialog;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.mobileprogramming.luxurygirl.fragments.FragmentGrilsList;
import com.mobileprogramming.luxurygirl.fragments.FragmentPageView;
import com.mobileprogramming.luxurygirl.model.Motel;

import java.util.List;

/**
 * Created by italo on 24/05/2017.
 */

public class ActivityGirlsList extends AppCompatActivity {

    FragmentGrilsList mFragmentGrilsList;

    private PageAdaper mPageAdaper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_girls_list);
        mFragmentGrilsList = (FragmentGrilsList) getSupportFragmentManager().findFragmentById(R.id.fragment_girls_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public boolean isLandScape() {
        Configuration configuration = getResources().getConfiguration();
        if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE)
            return true;
        return false;
    }

}
