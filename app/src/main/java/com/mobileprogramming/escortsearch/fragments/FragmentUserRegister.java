package com.mobileprogramming.escortsearch.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.mobileprogramming.escortsearch.ActivityEscortsList;
import com.mobileprogramming.escortsearch.ActivityEscortsRegister;
import com.mobileprogramming.escortsearch.ActivityUserRegister;
import com.mobileprogramming.escortsearch.R;

/**
 * Created by italo on 27/05/2017.
 */

public class FragmentUserRegister extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_register, container, false);



        return view;
    }
}
