package com.mobileprogramming.luxurygirl;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.mobileprogramming.luxurygirl.adapter.AbasPageAdaper;
import com.mobileprogramming.luxurygirl.fragments.FragmentGirlsInformations;
import com.mobileprogramming.luxurygirl.fragments.FragmentGrilsList;
import com.mobileprogramming.luxurygirl.model.Girls;

/**
 * Created by italo on 24/05/2017.
 */

public class ActivityGirlsList extends AppCompatActivity implements FragmentGrilsList.InterfaceInformation {

    FragmentGrilsList mFragmentGrilsList;

    private AbasPageAdaper mAbasPageAdaper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_girls_list);
        mFragmentGrilsList = (FragmentGrilsList) getSupportFragmentManager().findFragmentById(R.id.fragment_girls_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public boolean isLandScape() {
        Configuration configuration = getResources().getConfiguration();
        if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE)
            return true;
        return false;
    }

    @Override
    public void interfaceInformation(Girls girl) {
        FragmentManager manager = this.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        Fragment fragmentGirlsInformations = new FragmentGirlsInformations();
        //fragmentGirlsInformations = FragmentGirlsInformations.newInstance(girl);
        Bundle mBundle = new Bundle();
        mBundle.putSerializable("girl", girl);
        fragmentGirlsInformations.setArguments(mBundle);

        fragmentTransaction.replace(R.id.fragment_girls_informations, fragmentGirlsInformations);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
