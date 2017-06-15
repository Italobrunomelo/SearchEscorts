package com.mobileprogramming.luxurygirl.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.mobileprogramming.luxurygirl.GirlAdapter;
import com.mobileprogramming.luxurygirl.R;
import com.mobileprogramming.luxurygirl.dao.GirlsDAO;
import com.mobileprogramming.luxurygirl.model.Girls;

import java.util.ArrayList;

/**
 * Created by italo on 24/05/2017.
 */

public class FragmentGrilsList extends Fragment {

    private ListView mListGirls;
    private ArrayList<Girls> mGirls;
    private ArrayList<Girls> mListGirlDAO;
    private Girls mGirl;
    private GirlsDAO mGirlsDAO;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_girls_list, container, false);
        mGirls = new ArrayList<Girls>();
        mListGirlDAO = new ArrayList<Girls>();
        mGirl = new Girls();
        mGirlsDAO = new GirlsDAO(getActivity());

        mListGirls = (ListView) view.findViewById(R.id.listViewGirls);
        ArrayAdapter adapter = new GirlAdapter(getContext(), addGirl());
        mListGirls.setAdapter(adapter);

        return view;
    }

    private ArrayList<Girls> addGirl() {
        mListGirlDAO = (ArrayList<Girls>) mGirlsDAO.getAllGirls();

        for (int j = 0; j < mListGirlDAO.size(); j++) {
            mGirl.setmName(mListGirlDAO.get(j).getmName());
            mGirl.setmAge(mListGirlDAO.get(j).getmAge());
            mGirls.add(mGirl);
        }

        return mGirls;
    }

}