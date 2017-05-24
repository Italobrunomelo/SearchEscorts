package com.mobileprogramming.searchcompanions;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mobileprogramming.searchcompanions.fragments.FragmentCompanionsInformations;

public class ActivityCompanionsInformations extends AppCompatActivity {

    FragmentCompanionsInformations fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_companions_Informations);
        fragmentList = (FragmentCompanionsInformations) getSupportFragmentManager().findFragmentById(R.id.fragment_companions_Informations);
    }

    public void loadStudents() {
        fragmentList.loadCompanions();
    }
}
