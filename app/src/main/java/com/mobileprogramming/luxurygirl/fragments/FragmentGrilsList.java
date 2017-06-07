package com.mobileprogramming.luxurygirl.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.mobileprogramming.luxurygirl.R;

/**
 * Created by italo on 24/05/2017.
 */

public class FragmentGrilsList extends Fragment {

    private ListView mListGirls;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_girls_list, container, false);


        return view;
    }

}

/*
    /*AÇÃO DO IMAGE BUTTON PARA LOGIN DO USUÁRIO CADASTRADO
    ImageButton mImageButtonEnter = (ImageButton) view.findViewById(R.id.imageButtonEnter);

        mImageButtonEnter.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
        Intent it = new Intent(getActivity(), ActivityGirlsList.class);
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
        Intent it = new Intent(getActivity(), ActivityGirlsRegister.class);
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