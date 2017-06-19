package com.mobileprogramming.luxurygirl.fragments;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mobileprogramming.luxurygirl.dao.GirlsDAO;
import com.mobileprogramming.luxurygirl.model.Girls;
import com.mobileprogramming.luxurygirl.R;

import java.io.ByteArrayInputStream;

public class FragmentGirlsInformations extends Fragment {

    private Girls mGirl;
    private GirlsDAO mGirlsDAO;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_girls_informations,container,false);

        TextView textViewNameInformation = (TextView) view.findViewById(R.id.textViewNameInformation);
        TextView textViewAgeInformation = (TextView) view.findViewById(R.id.textViewAgeInformation);
        TextView textViewInformationInformation = (TextView) view.findViewById(R.id.textViewInformationInformation);
        TextView textViewContactInformation = (TextView) view.findViewById(R.id.textViewContactInformation);
        ImageView imageViewPhoto = (ImageView) view.findViewById(R.id.imageViewPhoto);
        Button buttonRemoveGirl = (Button) view.findViewById(R.id.buttonRemoveGirl);

        buttonRemoveGirl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailDeletado = mGirlsDAO.delete(mGirl.getmEmail());
                Toast.makeText(getActivity(), emailDeletado + " " + R.string.email_deleted, Toast.LENGTH_LONG).show();
            }
        });

        Bundle bundle = getArguments();
            Girls girl = (Girls) bundle.getSerializable("girl");
        textViewNameInformation.setText(girl.getmName());
        textViewAgeInformation.setText(girl.getmAge());
        textViewInformationInformation.setText(girl.getmInformation());
        textViewContactInformation.setText(girl.getmContact());
        byte[] outImagem = girl.getmImagem();
        ByteArrayInputStream imageStream = new ByteArrayInputStream(outImagem);
        Bitmap imageBitmap = BitmapFactory.decodeStream(imageStream);
        imageViewPhoto.setImageBitmap(imageBitmap);

        return view;
    }
}
