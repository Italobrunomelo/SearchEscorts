package com.mobileprogramming.luxurygirl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.mobileprogramming.luxurygirl.fragments.FragmentGirlsInformations;

public class ActivityGirlsInformations extends AppCompatActivity{

    FragmentGirlsInformations mFragmentGirlsInformations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_girls_informations);
        mFragmentGirlsInformations = (FragmentGirlsInformations) getSupportFragmentManager().findFragmentById(R.id.fragment_girls_informations);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    /*@Override
    public void responde(Girls girl) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentGirlsInformations frag = (FragmentGirlsInformations)manager.findFragmentById(R.id.fragment_girls_informations);
        //frag.change(girl);
    }
/*
    public void loadGirls() {
        mFragmentGirlsInformations.loadGirls();
    }*/
}
