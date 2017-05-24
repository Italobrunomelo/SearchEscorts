package com.mobileprogramming.searchcompanions.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobileprogramming.searchcompanions.R;

/**
 * Created by italo on 22/05/2017.
 */

public class FragmentMain extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        /*
        *AÇÃO DO BOTAO LOGIN
        *
        Button buttonLogin = (Button) view.findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getActivity(), ActivityCompanionsRegister.class);
                startActivity(it);
            }
        });*/

        return view;
    }
}

        /*
        *Pegar Referência  do ListView e Button
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

                buttonAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if(isLandScape()){
                            loadCompanionsForm(null);
                        }else{
                            Intent it = new Intent(getActivity(), ActivityCompanionsRegister.class);
                            startActivity(it);
                        }
                    }
                });
            return view;
        }

        /*
        *CONFIGURAÇÃO SE LANDSCAPE

        public boolean isLandScape(){
            Configuration configuration = getResources().getConfiguration();
            if(configuration.orientation == Configuration.ORIENTATION_LANDSCAPE)
                return true;
            return false;
        }

        private void loadCompanionsForm(Companions companions) {
            FragmentManager manager = getActivity().getSupportFragmentManager();
            FragmentTransaction tx = manager.beginTransaction();
            Fragment fragment = new com.mobileprogramming.searchcompanions.fragments.FragmentCompanionsInformations();
            if(companions != null){
                Bundle bundle = new Bundle();
                bundle.putSerializable("companions", companions);
                fragment.setArguments(bundle);
            }
            tx.replace(R.id.fragment_companions_Informations, fragment);
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

}*/