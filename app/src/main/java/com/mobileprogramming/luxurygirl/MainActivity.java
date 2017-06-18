package com.mobileprogramming.luxurygirl;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by italo on 23/05/2017.
 */

public class MainActivity extends AppCompatActivity {

    ImageButton mImageButtonEnter;
    ImageButton mImageButtonGirlsNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mImageButtonEnter = (ImageButton) findViewById(R.id.imageButtonEnter);
        mImageButtonEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iGirlsList = new Intent(MainActivity.this, ActitvityPageView.class);
                startActivity(iGirlsList);
            }
        });

        mImageButtonGirlsNew = (ImageButton) findViewById(R.id.imageButtonGirlsNew);
        mImageButtonGirlsNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iGirlsList = new Intent(MainActivity.this, ActivityGirlsRegister.class);
                startActivity(iGirlsList);
            }
        });


        //public void onClick(View view){
        //    switch (view.getId()){
        //        case R.id.imageButtonEnter:
        //           Intent iGirlsList = new Intent(MainActivity.this, ActivityGirlsList.class);
        //            startActivity(iGirlsList);
        //           break;
        //        case R.id.imageButtonGirlsNew:
        //           Intent iNewGirls = new Intent(MainActivity.this, ActivityGirlsRegister.class);
        //           startActivity(iNewGirls);
        //          break;
        //  }
    }


 /*
        *Pegar Referência  do ListView e Button
            //ListView X PageView-> lvCompanions = (ListView) view.findViewById(R.id.listViewCompanions);

            Button buttonAdd = (Button) view.findViewById(R.id.buttonAdd);

            loadGirls();



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
        }*/
}