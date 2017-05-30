package com.mobileprogramming.luxuryescort;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mobileprogramming.luxuryescort.fragments.FragmentMain;

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
