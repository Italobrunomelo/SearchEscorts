package com.mobileprogramming.luxurygirl.fragments;

import android.app.Fragment;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
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

import com.mobileprogramming.luxurygirl.ActivityGirlsRegister;
import com.mobileprogramming.luxurygirl.R;
import com.mobileprogramming.luxurygirl.dao.GirlsDAO;
import com.mobileprogramming.luxurygirl.model.Girls;

import java.io.File;

import static android.app.Activity.RESULT_OK;

/**
 * Created by italo on 17/05/2017.
 */

public class FragmentGirlsRegister extends Fragment {

    private static final int SELECT_PICTURE = 1;
    private ImageView mImageViewPhoto;

    private Uri imageUri;
    private File file;


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
        mImageViewPhoto = (ImageView) view.findViewById(R.id.imageViewPhoto);

        Button mButtonLocationGirl = (Button) view.findViewById(R.id.buttonLocationEscort);
        Button mButtonSaveGirl = (Button) view.findViewById(R.id.buttonSaveEscort);

        final TextView mTextViewUploadPhoto = (TextView) view.findViewById(R.id.textViewUploadPhoto);


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
                selectImageClick();
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

    public void selectImageClick() {
        // CRIA O ARQUIVO PARA IMAGEM
        file = new File(Environment.getExternalStorageDirectory(),
                //System.currentTimeMillis() + R.string.editTextNome + ".jpg");
                System.currentTimeMillis() + "imagem_cortada.jpg");

        // GUARDA A URI DA IMAGEM
        imageUri = Uri.fromFile(file);

        // INTENT DA GALERIA
        Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        /*// HABILITA O CORTE DA IMAGEM
        i.putExtra("crop", "true");*/

        // LOCAL ONDE A IMAGEM SERÁ SALVA
        i.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));

        startActivityForResult(Intent.createChooser(i, "Select the picture"), SELECT_PICTURE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Context applicationContext = ActivityGirlsRegister.getContextOfApplication();

        if (requestCode == SELECT_PICTURE && resultCode == RESULT_OK && null != data) {
            ContentResolver cr = applicationContext.getContentResolver();
            Uri selectedImage = Uri.fromFile(file);
            applicationContext.getContentResolver().notifyChange(selectedImage, null);
            Bitmap bitmap;
            try {
                bitmap = android.provider.MediaStore.Images.Media.getBitmap(
                        cr, selectedImage);
                //bitmap = Bitmap.createBitmap(bitmap, 0, 0, 400, 400);
                ImageView imageView = (ImageView) mImageViewPhoto.findViewById(R.id.imageViewPhoto);
                imageView.setImageBitmap(bitmap);
            } catch (Exception e) {
                Toast.makeText(getActivity(), "Falha ao carregar a imagem",
                        Toast.LENGTH_SHORT).show();
            }

        }

        /*
        RETORNO DA SELEÇÃO DA IMAGEM DA GALERIA

        if (requestCode == SELECT_PICTURE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = imageUri;
            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            Cursor cursor = applicationContext.getContentResolver().query(selectedImage, filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            Bitmap imagemGaleria;
            imagemGaleria = (BitmapFactory.decodeFile(picturePath));
            //imagemGaleria = BitmapFactory.decodeResource(getResources(),columnIndex);
            cursor.close();
            ImageView imageView = (ImageView) mImageViewPhoto.findViewById(R.id.imageViewPhoto);
            //imagemGaleria = BitmapFactory.decodeResource(getResources(), R.drawable.girls);
            imagemGaleria = Bitmap.createBitmap(imagemGaleria, 0, 0, 400, 400);
            imageView.setImageBitmap(imagemGaleria);

            //Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.girls);
            //bm = Bitmap.createBitmap(bm, 0, 0, 400, 400);
            //imageView.setImageBitmap(bm);

            //imageView.setImageBitmap(imagemGaleria);
        }*/
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
