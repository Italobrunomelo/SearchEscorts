package com.mobileprogramming.luxurygirl.fragments;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.mobileprogramming.luxurygirl.ActivityGirlsRegister;
import com.mobileprogramming.luxurygirl.dao.GirlsDAO;
import com.mobileprogramming.luxurygirl.model.Girls;
import com.mobileprogramming.luxurygirl.R;

import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by italo on 17/05/2017.
 */

public class FragmentGirlsInformations extends Fragment {

    private Girls mGirl;
    private GirlsDAO mGirlsDAO;

    /*
    List<Girls> mListGirl = new ArrayList<Girls>();
    private ArrayAdapter<String> mAdapter;
    private ListView lvCompanions;
*/


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_girls_informations, container, false);
        mGirlsDAO = new GirlsDAO(getActivity());
        mGirl = new Girls();

        final TextView textViewNameInformation = (TextView) view.findViewById(R.id.textViewNameInformation);
        final TextView textViewAgeInformation = (TextView) view.findViewById(R.id.textViewAgeInformation);
        final TextView textViewInformationInformation = (TextView) view.findViewById(R.id.textViewInformationInformation);
        final TextView textViewContactInformation = (TextView) view.findViewById(R.id.textViewContactInformation);
        final ImageView imageViewPhoto = (ImageView) view.findViewById(R.id.imageViewPhoto);
        final Button buttonRemoveGirl = (Button) view.findViewById(R.id.buttonRemoveGirl);

        Bundle bundle = getArguments();
        mGirl = (Girls) bundle.getSerializable("girl");

        textViewNameInformation.setText(mGirl.getmName());
        textViewAgeInformation.setText(mGirl.getmAge());
        textViewInformationInformation.setText(mGirl.getmInformation());
        textViewContactInformation.setText(mGirl.getmContact());

        byte[] outImagem = mGirl.getmImagem();
        ByteArrayInputStream imageStream = new ByteArrayInputStream(outImagem);
        Bitmap imageBitmap = BitmapFactory.decodeStream(imageStream);
        imageViewPhoto.setImageBitmap(imageBitmap);
        /*if (bundle != null) {
            mGirl = (Girls) bundle.getSerializable("girl");

            textViewNameInformation.setText(mGirl.getmName());
            textViewAgeInformation.setText(mGirl.getmAge());
            textViewInformationInformation.setText(mGirl.getmInformation());
            textViewContactInformation.setText(mGirl.getmContact());

            byte[] outImagem = mGirl.getmImagem();
            ByteArrayInputStream imageStream = new ByteArrayInputStream(outImagem);
            Bitmap imageBitmap = BitmapFactory.decodeStream(imageStream);
            imageViewPhoto.setImageBitmap(imageBitmap);
        }*/

        buttonRemoveGirl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailDeletado = mGirlsDAO.delete(mGirl.getmEmail());
                Toast.makeText(getActivity(), emailDeletado + " " + R.string.email_deleted, Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }
    /*public static FragmentGirlsInformations newInstance(Girls girl) {
        FragmentGirlsInformations fragment = new FragmentGirlsInformations();
        Bundle bundle = new Bundle();
        bundle.putSerializable("girl", girl);
        fragment.setArguments(bundle);

        return fragment;
    }*/

    /*
    //CONFIGURAÇÃO SE LANDSCAPE
    public boolean isLandScape(){
        Configuration configuration = getResources().getConfiguration();
        if(configuration.orientation == Configuration.ORIENTATION_LANDSCAPE)
            return true;
        return false;
    }

    private void loadGirlsForm(Girls mGirls) {
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction tx = manager.beginTransaction();
        Fragment fragment = new FragmentGirlsInformations();
        if(mGirls != null){
            Bundle bundle = new Bundle();
            bundle.putSerializable("mGirls", mGirls);
            fragment.setArguments(bundle);
        }
        tx.replace(R.id.fragment_girls_informations, fragment);
        tx.addToBackStack(null);
        tx.commit();
    }

    @Override
    public void onStart() {
        super.onStart();
        loadGirls();
    }*/
}
