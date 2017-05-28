package com.mobileprogramming.escortsearch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mobileprogramming.escortsearch.fragments.FragmentEscortsInformations;
import com.mobileprogramming.escortsearch.fragments.FragmentMain;

/**
 * Created by italo on 23/05/2017.
 */

public class MainActivity extends AppCompatActivity {

    FragmentMain fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentList = (FragmentMain) getSupportFragmentManager().findFragmentById(R.id.fragment_main);
    }
}
