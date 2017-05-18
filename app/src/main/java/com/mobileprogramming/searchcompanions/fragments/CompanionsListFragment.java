package com.mobileprogramming.searchcompanions.fragments;

import android.content.Intent;
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
import android.widget.Button;
import android.widget.ListView;

import com.mobileprogramming.searchcompanions.Companions;
import com.mobileprogramming.searchcompanions.InformationActivity;
import com.mobileprogramming.searchcompanions.R;
import com.mobileprogramming.searchcompanions.dao.CompanionsDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by italo on 17/05/2017.
 */

public class CompanionsListFragment extends Fragment {

    List<Companions> companions = new ArrayList<Companions>();
    private ArrayAdapter<String> adapter;
    private ListView lvCompanions;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_companions_list, container, false );
        /*
        *Pegar Referência  do ListView e Button
        */

        //ListView X PageView-> lvCompanions = (ListView) view.findViewById(R.id.listViewCompanions);

        Button buttonAdd = (Button) view.findViewById(R.id.buttonAdd);

        loadCompanions();

        /*
        //ListView X PageView-> lvCompanions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                loadCompanionsForm(companions.get(position));
            }
        });
        */

        /*
        *COMPORTAMENTO DO BOTÃO buttonAdd
        */
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isLandScape()){
                    loadCompanionsForm(null);
                }else{
                    Intent it = new Intent(getActivity(), InformationActivity.class);
                    startActivity(it);
                }
            }
        });
        return view;
    }

    /*
    *CONFIGURAÇÃO SE LANDSCAPE
    */
    public boolean isLandScape(){
        Configuration configuration = getResources().getConfiguration();
        if(configuration.orientation == Configuration.ORIENTATION_LANDSCAPE)
            return true;
        return false;
    }

    private void loadCompanionsForm(Companions companions) {
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction tx = manager.beginTransaction();
        Fragment fragment = new CompanionsListFragment();
        if(companions != null){
            Bundle bundle = new Bundle();
            bundle.putSerializable("companions", companions);
            fragment.setArguments(bundle);
        }
        tx.replace(R.id.fragment_companions_list, fragment);
        tx.addToBackStack(null);
        tx.commit();
    }

    public void loadCompanions() {

        CompanionsDAO dao = new CompanionsDAO(getActivity());
        companions = dao.getAllCompanions();

        List<String> companionsNames = new ArrayList<String>();

        for (Companions companions : this.companions) {
            companionsNames.add(companions.getmName());
        }

        adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1,companionsNames);
        lvCompanions.setAdapter(adapter);
    }


    @Override
    public void onStart() {
        super.onStart();
        loadCompanions();
    }
}
