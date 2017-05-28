package com.mobileprogramming.escortsearch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mobileprogramming.escortsearch.fragments.FragmentEscortsInformations;

public class ActivityEscortsInformations extends AppCompatActivity {

    FragmentEscortsInformations fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escorts_informations);
        fragmentList = (FragmentEscortsInformations) getSupportFragmentManager().findFragmentById(R.id.fragment_escorts_informations);
    }

    public void loadStudents() {
        fragmentList.loadCompanions();
    }
}
