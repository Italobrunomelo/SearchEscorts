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
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.mobileprogramming.luxurygirl.dao.GirlsDAO;
import com.mobileprogramming.luxurygirl.model.Girls;
import com.mobileprogramming.luxurygirl.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by italo on 17/05/2017.
 */

public class FragmentGirlsInformations extends Fragment {
/*
    List<Girls> mListGirl = new ArrayList<Girls>();
    private ArrayAdapter<String> mAdapter;
    private ListView lvCompanions;
*/
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_girls_informations, container, false );
        /*
        *Pegar Referência  do ListView e Button
        */

        //ListView X PageView-> lvCompanions = (ListView) view.findViewById(R.id.listViewCompanions);

        //Button buttonAdd = (Button) view.findViewById(R.id.buttonAdd);

        //loadGirls();

        /*
        //ListView X PageView-> lvCompanions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                loadGirlsForm(girls.get(position));
            }
        });
        */

        /*
        *COMPORTAMENTO DO BOTÃO buttonAdd

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isLandScape()){
                    loadGirlsForm(null);
                }else{
                    Intent it = new Intent(getActivity(), ActivityGirlsRegister.class);
                    startActivity(it);
                }
            }
        });*/
        return view;
    }

    /*
    //CONFIGURAÇÃO SE LANDSCAPE
    public boolean isLandScape(){
        Configuration configuration = getResources().getConfiguration();
        if(configuration.orientation == Configuration.ORIENTATION_LANDSCAPE)
            return true;
        return false;
    }

    private void loadGirlsForm(Girls girls) {
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction tx = manager.beginTransaction();
        Fragment fragment = new FragmentGirlsInformations();
        if(girls != null){
            Bundle bundle = new Bundle();
            bundle.putSerializable("girls", girls);
            fragment.setArguments(bundle);
        }
        tx.replace(R.id.fragment_girls_informations, fragment);
        tx.addToBackStack(null);
        tx.commit();
    }

    public void loadGirls() {

        GirlsDAO dao = new GirlsDAO(getActivity());
        mListGirl = dao.getAllGirls();

        List<String> mGirlsNames = new ArrayList<String>();

        for (Girls girls : this.mListGirl) {
            mGirlsNames.add(girls.getmName());
        }

        mAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1,mGirlsNames);
        lvCompanions.setAdapter(mAdapter);
    }


    @Override
    public void onStart() {
        super.onStart();
        loadGirls();
    }*/
}
