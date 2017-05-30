package com.mobileprogramming.luxuryescort.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobileprogramming.luxuryescort.R;

/**
 * Created by italo on 17/05/2017.
 */

public class FragmentEscortsRegister extends Fragment {



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_escorts_register, container, false);


        return view;
    }
}
