package com.mobileprogramming.searchcompanions;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mobileprogramming.searchcompanions.fragments.CompanionsListFragment;

public class MainActivity extends AppCompatActivity {

    CompanionsListFragment fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_companions_list);
        fragmentList = (CompanionsListFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_companions_list);

    }

    public void loadStudents() {
        fragmentList.loadCompanions();
    }
}
