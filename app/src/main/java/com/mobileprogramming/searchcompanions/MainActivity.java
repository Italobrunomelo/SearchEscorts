package com.mobileprogramming.searchcompanions;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mobileprogramming.searchcompanions.fragments.FragmentCompanionsInformations;

/**
 * Created by italo on 23/05/2017.
 */

public class MainActivity extends AppCompatActivity {

    FragmentCompanionsInformations fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentList = (FragmentCompanionsInformations) getSupportFragmentManager().findFragmentById(R.id.fragment_main);

    }
}
