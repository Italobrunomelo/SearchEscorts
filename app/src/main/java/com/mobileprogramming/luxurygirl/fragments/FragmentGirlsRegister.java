package com.mobileprogramming.luxurygirl.fragments;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.mobileprogramming.luxurygirl.R;
import com.mobileprogramming.luxurygirl.dao.GirlsDAO;
import com.mobileprogramming.luxurygirl.model.Girls;

/**
 * Created by italo on 17/05/2017.
 */

public class FragmentGirlsRegister extends Fragment {
    private static final int SELECT_PICTURE = 1;
    private String mSelectedImagePath;

    private AlertDialog mAlertDialogImage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_girls_register, container, false);

        final EditText mEditTextName = (EditText) view.findViewById(R.id.editTextName);
        final EditText mEditTextInformation = (EditText) view.findViewById(R.id.editTextInformation);
        final EditText mEditTextPhone = (EditText) view.findViewById(R.id.editTextPhone);
        final EditText mEditTextAge = (EditText) view.findViewById(R.id.editTextAge);
        final EditText mEditTextLocation = (EditText) view.findViewById(R.id.editTextLocation);
        final Switch mSwitchStatus = (Switch) view.findViewById(R.id.switchStatus);

        TextView mTextViewUploadPhoto = (TextView) view.findViewById(R.id.textViewUploadPhoto);
        Button mButtonLocationGirl = (Button) view.findViewById(R.id.buttonLocationEscort);
        Button mButtonSaveGirl = (Button) view.findViewById(R.id.buttonSaveEscort);

        ImageView mImageViewPhoto = (ImageView) view.findViewById(R.id.imageViewPhoto);

        Bundle bundle = getArguments();
        if (bundle != null) {
            Girls mGirl = (Girls) bundle.getSerializable("dbLuxuryGirls");
            mEditTextName.setText(mGirl.getmName());
            mEditTextInformation.setText(mGirl.getmInformation());
            mEditTextPhone.setText(mGirl.getmContact());
            mEditTextAge.setText(mGirl.getmAge());
            mEditTextLocation.setText(mGirl.getmLocation());
            mSwitchStatus.setChecked(true);
        }

        mTextViewUploadPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //CHAMADA DA CAMERA
                //Intent mTakePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                //startActivityForResult(mTakePictureIntent, 5678);
                Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(takePicture, 0);//zero can be replaced with any action code

                //SELECIONAR IMAGEM DA GALERIA
                //Intent mIntentGaleria = new Intent();
                //mIntentGaleria.setType("image/*");
                //mIntentGaleria.setAction(Intent.ACTION_GET_CONTENT);
                //startActivityForResult(Intent.createChooser(mIntentGaleria, "Select Picture"), SELECT_PICTURE);
                Intent pickPhoto = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(pickPhoto, 1);//one can be replaced with any action code


            }
        });

        mButtonLocationGirl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mButtonSaveGirl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GirlsDAO mGirlDAO = new GirlsDAO(getActivity());
                Girls mGirls = new Girls();

                mGirls.setmName(mEditTextName.getText().toString());
                mGirls.setmInformation(mEditTextInformation.getText().toString());
                mGirls.setmContact(mEditTextPhone.getText().toString());
                mGirls.setmAge(mEditTextAge.getText().toString());
                mGirls.setmLocation(mEditTextLocation.getText().toString());
                if (mSwitchStatus.isChecked()) {
                    mGirls.setmStatus("true");
                } else {
                    mGirls.setmStatus("false");
                }

                mGirlDAO.insert(mGirls);

                /*
                OnRefreshFormOK activity = (OnRefreshFormOK) getActivity();
                activity.refresh();*/

                if (!isLandScape())
                    getActivity().finish();

                Toast.makeText(getActivity(), R.string.mensage_added_girl, Toast.LENGTH_LONG).show();

            }
        });


        return view;
    }

    public boolean isLandScape() {
        Configuration configuration = getResources().getConfiguration();
        if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE)
            return true;
        return false;
    }
/*
    public interface OnRefreshFormOK {
        public void refresh();
    }*/
}
