package com.mobileprogramming.searchcompanions;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mobileprogramming.searchcompanions.fragments.FragmentEscortsInformations;

/**
 * Created by italo on 23/05/2017.
 */

public class MainActivity extends AppCompatActivity {

    FragmentEscortsInformations fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentList = (FragmentEscortsInformations) getSupportFragmentManager().findFragmentById(R.id.fragment_main);

    }
}
