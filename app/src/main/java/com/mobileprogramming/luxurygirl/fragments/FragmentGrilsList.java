package com.mobileprogramming.luxurygirl.fragments;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.mobileprogramming.luxurygirl.ActivityGirlsList;
import com.mobileprogramming.luxurygirl.adapter.GirlAdapter;
import com.mobileprogramming.luxurygirl.R;
import com.mobileprogramming.luxurygirl.dao.GirlsDAO;
import com.mobileprogramming.luxurygirl.model.Girls;

import java.util.ArrayList;

public class FragmentGrilsList extends Fragment {

    private ListView mListGirls;
    private ArrayList<Girls> mGirls;
    private ArrayList<Girls> mListGirlDAO;
    private Girls mGirl;
    private GirlsDAO mGirlsDAO;

    ActivityGirlsList comunicador;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_girls_list, container, false);
        mGirls = new ArrayList<Girls>();
        mListGirlDAO = new ArrayList<Girls>();
        mGirl = new Girls();
        mGirlsDAO = new GirlsDAO(getActivity());

        mListGirls = (ListView) view.findViewById(R.id.listViewGirls);

        mGirls = (ArrayList<Girls>) mGirlsDAO.getAllGirls();
        ArrayAdapter adapter = new GirlAdapter(getContext(), mGirls);
        mListGirls.setAdapter(adapter);

        mListGirls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //comunicador.responde(mGirls.get(position));
            }
        });

        return view;
    }

    /*@Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }*/

    private void loadGirlInformation(Girls girl) {
        FragmentManager manager = getActivity().getSupportFragmentManager();
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

    @Override
    public void onStart() {
        super.onStart();
        mGirlsDAO.getAllGirls();
    }

}