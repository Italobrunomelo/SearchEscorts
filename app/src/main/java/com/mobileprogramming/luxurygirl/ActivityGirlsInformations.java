package com.mobileprogramming.luxurygirl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.mobileprogramming.luxurygirl.fragments.FragmentGirlsInformations;
import com.mobileprogramming.luxurygirl.model.Girls;

public class ActivityGirlsInformations extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_girls_informations);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
/*
    public void loadGirls() {
        mFragmentGirlsInformations.loadGirls();
    }*/
}
