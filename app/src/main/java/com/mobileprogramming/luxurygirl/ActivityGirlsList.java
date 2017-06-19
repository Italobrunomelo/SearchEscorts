package com.mobileprogramming.luxurygirl;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.mobileprogramming.luxurygirl.fragments.FragmentGirlsInformations;
import com.mobileprogramming.luxurygirl.fragments.FragmentGrilsList;
import com.mobileprogramming.luxurygirl.interfaces.Comunicador;
import com.mobileprogramming.luxurygirl.model.Girls;

public class ActivityGirlsList extends AppCompatActivity{

    FragmentGrilsList mFragmentGrilsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_girls_list);
        mFragmentGrilsList = (FragmentGrilsList) getSupportFragmentManager().findFragmentById(R.id.fragment_girls_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    /*@Override
    public void responde(Girls girl) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentGirlsInformations frag = (FragmentGirlsInformations)manager.findFragmentById(R.id.fragment_girls_informations);//findFragmentById(R.id.fragment_girls_informations); //(FragmentGirlsInformations)manager.findFragmentById(R.id.fragment_girls_informations);
        //frag.change(girl);

    }*/
}
