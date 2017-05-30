package com.mobileprogramming.luxuryescort.fragments;

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

import com.mobileprogramming.luxuryescort.model.Escorts;
import com.mobileprogramming.luxuryescort.R;
import com.mobileprogramming.luxuryescort.dao.EscortsDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by italo on 17/05/2017.
 */

public class FragmentEscortsInformations extends Fragment {

    List<Escorts> companions = new ArrayList<Escorts>();
    private ArrayAdapter<String> adapter;
    private ListView lvCompanions;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_escorts_informations, container, false );
        /*
        *Pegar Referência  do ListView e Button
        */

        //ListView X PageView-> lvCompanions = (ListView) view.findViewById(R.id.listViewCompanions);

        //Button buttonAdd = (Button) view.findViewById(R.id.buttonAdd);

        loadCompanions();

        /*
        //ListView X PageView-> lvCompanions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                loadCompanionsForm(escorts.get(position));
            }
        });
        */

        /*
        *COMPORTAMENTO DO BOTÃO buttonAdd

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isLandScape()){
                    loadCompanionsForm(null);
                }else{
                    Intent it = new Intent(getActivity(), ActivityEscortsRegister.class);
                    startActivity(it);
                }
            }
        });*/
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

    private void loadCompanionsForm(Escorts escorts) {
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction tx = manager.beginTransaction();
        Fragment fragment = new FragmentEscortsInformations();
        if(escorts != null){
            Bundle bundle = new Bundle();
            bundle.putSerializable("escorts", escorts);
            fragment.setArguments(bundle);
        }
        tx.replace(R.id.fragment_escorts_informations, fragment);
        tx.addToBackStack(null);
        tx.commit();
    }

    public void loadCompanions() {

        EscortsDAO dao = new EscortsDAO(getActivity());
        companions = dao.getAllEscort();

        List<String> companionsNames = new ArrayList<String>();

        for (Escorts escorts : this.companions) {
            companionsNames.add(escorts.getmName());
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
