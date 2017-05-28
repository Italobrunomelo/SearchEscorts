package com.mobileprogramming.escortsearch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mobileprogramming.escortsearch.fragments.FragmentUserRegister;

/**
 * Created by italo on 27/05/2017.
 */

public class ActivityUserRegister extends AppCompatActivity {

    FragmentUserRegister user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);
        user = (FragmentUserRegister) getSupportFragmentManager().findFragmentById(R.id.fragment_user_register);

    }
}
