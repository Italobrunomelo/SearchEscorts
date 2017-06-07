package com.mobileprogramming.luxurygirl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mobileprogramming.luxurygirl.fragments.FragmentGirlsInformations;

public class ActivityGirlsInformations extends AppCompatActivity {

    FragmentGirlsInformations fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_girls_informations);
        fragmentList = (FragmentGirlsInformations) getSupportFragmentManager().findFragmentById(R.id.fragment_girls_informations);
    }
/*
    public void loadGirls() {
        fragmentList.loadGirls();
    }*/
}
