package com.mobileprogramming.luxurygirl;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by italo on 23/05/2017.
 */

public class MainActivity extends AppCompatActivity {

    ImageButton mImageButtonEnter;
    ImageButton mImageButtonGirlsNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mImageButtonEnter = (ImageButton) findViewById(R.id.imageButtonEnter);
        mImageButtonEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iGirlsList = new Intent(MainActivity.this, ActitvityPageView.class);
                startActivity(iGirlsList);
            }
        });

        mImageButtonGirlsNew = (ImageButton) findViewById(R.id.imageButtonGirlsNew);
        mImageButtonGirlsNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iGirlsList = new Intent(MainActivity.this, ActivityGirlsRegister.class);
                startActivity(iGirlsList);
            }
        });
    }
}