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
 * Created by italo on 24/05/2017.
 */

public class FragmentEscortsList extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_escorts_list, container, false);


        return view;
    }
}

/*
    /*AÇÃO DO IMAGE BUTTON PARA LOGIN DO USUÁRIO CADASTRADO
    ImageButton mImageButtonEnter = (ImageButton) view.findViewById(R.id.imageButtonEnter);

        mImageButtonEnter.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
        Intent it = new Intent(getActivity(), ActivityEscortsList.class);
        startActivity(it);
        }
        });

        /*AÇÃO DO TEXT VIEW PARA CADASTRAR NOVO USUÁRIO
        TextView mTextViewUserNew = (TextView) view.findViewById(R.id.textViewUserNew);

        mTextViewUserNew.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
        Intent it = new Intent(getActivity(), ActivityUserRegister.class);
        startActivity(it);
        }
        });

        /*AÇÃO DO IMAGE BUTTON PARA CADASTRO DE NOVA ACOMPANHANTE
        ImageButton mImageButtonEscortNew = (ImageButton) view.findViewById(R.id.imageButtonEscortNew);

        mImageButtonEscortNew.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
        Intent it = new Intent(getActivity(), ActivityEscortsRegister.class);
        startActivity(it);
        }
        });

        /*AÇÃO DO TEXT VIEW PARA LOGIN DE ACOMPANHANTE CADASTRADA
        TextView mtextViewLoginEscort = (TextView) view.findViewById(R.id.textViewLoginEscort);

        mtextViewLoginEscort.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
        Intent it = new Intent(getActivity(), ActivityUserRegister.class);
        startActivity(it);
        }
        });
        */