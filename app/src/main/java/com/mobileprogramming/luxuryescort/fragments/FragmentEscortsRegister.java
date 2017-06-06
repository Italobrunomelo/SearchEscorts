package com.mobileprogramming.luxuryescort.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
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

import com.mobileprogramming.luxuryescort.R;
import com.mobileprogramming.luxuryescort.dao.EscortsDAO;
import com.mobileprogramming.luxuryescort.model.Escorts;

import static android.R.attr.data;
import static android.app.Activity.RESULT_OK;

/**
 * Created by italo on 17/05/2017.
 */

public class FragmentEscortsRegister extends Fragment {
    EscortsDAO mEscortDAO = new EscortsDAO(getActivity());
    Escorts mEscort = new Escorts();

    private static final int SELECT_PICTURE = 1;
    private String mSelectedImagePath;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_escorts_register, container, false);

        final EditText mEditTextName = (EditText) view.findViewById(R.id.editTextName);
        final EditText mEditTextInformation = (EditText) view.findViewById(R.id.editTextInformation);
        final EditText mEditTextPhone = (EditText) view.findViewById(R.id.editTextPhone);
        final EditText mEditTextAge = (EditText) view.findViewById(R.id.editTextAge);
        final EditText mEditTextLocation = (EditText) view.findViewById(R.id.editTextLocation);
        final Switch mSwitchStatus = (Switch) view.findViewById(R.id.switchStatus);

        TextView mTextViewUploadPhoto = (TextView) view.findViewById(R.id.textViewUploadPhoto);
        Button mButtonLocationEscort = (Button) view.findViewById(R.id.buttonLocationEscort);
        Button mButtonSaveEscort = (Button) view.findViewById(R.id.buttonSaveEscort);

        ImageView mImageViewPhoto = (ImageView) view.findViewById(R.id.imageViewPhoto);

        Bundle bundle = getArguments();
        if (bundle != null) {
            Escorts escort = (Escorts) bundle.getSerializable("escort");
            mEditTextName.setText(escort.getmName());
            mEditTextInformation.setText(escort.getmInformation());
            mEditTextPhone.setText(escort.getmContact());
            mEditTextAge.setText(escort.getmAge());
            mEditTextLocation.setText(escort.getmLocation());
            mSwitchStatus.setChecked(true);
        }

        mTextViewUploadPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //CHAMADA DA CAMERA
                Intent mTakePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(mTakePictureIntent, 5678);

                //SELECIONAR IMAGEM DA GALERIA
                Intent mIntentGaleria = new Intent();
                mIntentGaleria.setType("image/*");
                mIntentGaleria.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(mIntentGaleria, "Select Picture"), SELECT_PICTURE);

            }
        });

        mButtonLocationEscort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mButtonSaveEscort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEscort.setmName(mEditTextName.getText().toString());
                mEscort.setmInformation(mEditTextInformation.getText().toString());
                mEscort.setmContact(mEditTextPhone.getText().toString());
                mEscort.setmAge(mEditTextAge.getText().toString());
                mEscort.setmLocation(mEditTextLocation.getText().toString());
                if (mSwitchStatus.isChecked()) {
                    mEscort.setmStatus("true");
                } else {
                    mEscort.setmStatus("false");
                }

                mEscortDAO.insert(mEscort);

                /*
                OnRefreshFormOK activity = (OnRefreshFormOK) getActivity();
                activity.refresh();*/

                if (!isLandScape())
                    getActivity().finish();

                Toast.makeText(getActivity(), "Escort Added successfully!", Toast.LENGTH_LONG).show();

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
