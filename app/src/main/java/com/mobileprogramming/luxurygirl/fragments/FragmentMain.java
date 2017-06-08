package com.mobileprogramming.luxurygirl.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.mobileprogramming.luxurygirl.ActivityGirlsInformations;
import com.mobileprogramming.luxurygirl.ActivityGirlsList;
import com.mobileprogramming.luxurygirl.ActivityGirlsRegister;
import com.mobileprogramming.luxurygirl.ActivityUserRegister;
import com.mobileprogramming.luxurygirl.R;

/**
 * Created by italo on 22/05/2017.
 */

public class FragmentMain extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        /*AÇÃO DO IMAGE BUTTON PARA LOGIN DO USUÁRIO CADASTRADO*/
        ImageButton mImageButtonEnter = (ImageButton) view.findViewById(R.id.imageButtonEnter);

        mImageButtonEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getActivity(), ActivityGirlsList.class);
                startActivity(it);
            }
        });

        /*AÇÃO DO TEXT VIEW PARA CADASTRAR NOVO USUÁRIO*/
        TextView mTextViewUserNew = (TextView) view.findViewById(R.id.textViewUserNew);

        mTextViewUserNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getActivity(), ActivityUserRegister.class);
                startActivity(it);
            }
        });

        /*AÇÃO DO IMAGE BUTTON PARA CADASTRO DE NOVA ACOMPANHANTE*/
        ImageButton mImageButtonEscortNew = (ImageButton) view.findViewById(R.id.imageButtonEscortNew);

        mImageButtonEscortNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getActivity(), ActivityGirlsRegister.class);
                startActivity(it);
            }
        });

        /*AÇÃO DO TEXT VIEW PARA LOGIN DE ACOMPANHANTE CADASTRADA*/
        TextView mtextViewLoginEscort = (TextView) view.findViewById(R.id.textViewLoginEscort);

        mtextViewLoginEscort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getActivity(), ActivityGirlsRegister.class);
                startActivity(it);
            }
        });

        return view;
    }
}


        /*
        *Pegar Referência  do ListView e Button
            //ListView X PageView-> lvCompanions = (ListView) view.findViewById(R.id.listViewCompanions);

            Button buttonAdd = (Button) view.findViewById(R.id.buttonAdd);

            loadGirls();

        /*
        //ListView X PageView-> lvCompanions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                loadCompanionsForm(mGirls.get(position));
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
                            Intent it = new Intent(getActivity(), ActivityGirlsRegister.class);
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

        private void loadCompanionsForm(Girls mGirls) {
            FragmentManager manager = getActivity().getSupportFragmentManager();
            FragmentTransaction tx = manager.beginTransaction();
            Fragment fragment = new com.mobileprogramming.luxurygirl.fragments.FragmentGirlsInformations();
            if(mGirls != null){
                Bundle bundle = new Bundle();
                bundle.putSerializable("mGirls", mGirls);
                fragment.setArguments(bundle);
            }
            tx.replace(R.id.fragment_girls_informations, fragment);
            tx.addToBackStack(null);
            tx.commit();
        }

        public void loadGirls() {

            GirlsDAO dao = new GirlsDAO(getActivity());
            mGirls = dao.getAllCompanions();

            List<String> companionsNames = new ArrayList<String>();

            for (Girls mGirls : this.mGirls) {
                companionsNames.add(mGirls.getmName());
            }

            adapter = new ArrayAdapter<String>(getActivity(),
                    android.R.layout.simple_list_item_1,companionsNames);
            lvCompanions.setAdapter(adapter);
        }


        @Override
        public void onStart() {
            super.onStart();
            loadGirls();
        }
    }

}*/