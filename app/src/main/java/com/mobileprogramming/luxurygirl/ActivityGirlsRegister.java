package com.mobileprogramming.luxurygirl;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.mobileprogramming.luxurygirl.dao.GirlsDAO;
import com.mobileprogramming.luxurygirl.model.Girls;

import java.io.File;

import static android.app.PendingIntent.getActivity;

public class ActivityGirlsRegister extends AppCompatActivity {

    EditText mEditTextName, mEditTextInformation, mEditTextPhone, mEditTextAge;
    Switch mSwitchStatus;
    Button mButtonSaveGirl;
    TextView mTextViewUploadPhoto;

    private static final int SELECT_PICTURE = 1;
    private ImageView mImageViewPhoto;

    private Uri imageUri;
    private File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_girls_register);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mEditTextName = (EditText) findViewById(R.id.editTextName);
        mEditTextInformation = (EditText) findViewById(R.id.editTextInformation);
        mEditTextPhone = (EditText) findViewById(R.id.editTextPhone);
        mEditTextAge = (EditText) findViewById(R.id.editTextAge);
        mSwitchStatus = (Switch) findViewById(R.id.switchStatus);
        mImageViewPhoto = (ImageView) findViewById(R.id.imageViewPhoto);
        mButtonSaveGirl = (Button) findViewById(R.id.buttonSaveGirl);
        mTextViewUploadPhoto = (TextView) findViewById(R.id.textViewUploadPhoto);

    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.textViewUploadPhoto:
                ActivityGirlsRegister activityGirlsRegister = new ActivityGirlsRegister();
                activityGirlsRegister.selectImageClick();
                break;

            case R.id.buttonSaveGirl:
                GirlsDAO mGirlDAO = new GirlsDAO(getActivity());
                Girls mGirls = new Girls();

                mGirls.setmName(mEditTextName.getText().toString());
                mGirls.setmInformation(mEditTextInformation.getText().toString());
                mGirls.setmContact(mEditTextPhone.getText().toString());
                mGirls.setmAge(mEditTextAge.getText().toString());
                if (mSwitchStatus.isChecked()) {
                    mGirls.setmStatus("true");
                } else {
                    mGirls.setmStatus("false");
                }

                mGirlDAO.insert(mGirls);

                /*
                OnRefreshFormOK activity = (OnRefreshFormOK) getActivity();
                activity.refresh();*/

                /*if (!isLandScape())
                    getActivity().finish();*/

                Toast.makeText(this, R.string.mensage_added_girl, Toast.LENGTH_LONG).show();

                break;
        }
    }

    public void selectImageClick() {
        // INTENT DA GALERIA
        Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        // CRIA O ARQUIVO PARA IMAGEM
        file = new File(Environment.getExternalStorageDirectory(),
                //System.currentTimeMillis() + R.string.editTextNome + ".jpg");
                System.currentTimeMillis() + ".jpg");

        // GUARDA A URI DA IMAGEM
        imageUri = Uri.fromFile(file);

        /*// HABILITA O CORTE DA IMAGEM
        i.putExtra("crop", "true");*/

        // LOCAL ONDE A IMAGEM SERÁ SALVA
        i.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));

        startActivityForResult(Intent.createChooser(i, "Select the picture"), SELECT_PICTURE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SELECT_PICTURE && resultCode == RESULT_OK && null != data) {
            ContentResolver cr = getContentResolver();
            Uri selectedImage = Uri.fromFile(file);
            getContentResolver().notifyChange(selectedImage, null);
            Bitmap bitmap;
            try {
                bitmap = android.provider.MediaStore.Images.Media.getBitmap(
                        cr, selectedImage);
                //bitmap = Bitmap.createBitmap(bitmap, 0, 0, 600, 600);
                ImageView imageView = (ImageView) mImageViewPhoto.findViewById(R.id.imageViewPhoto);
                imageView.setImageBitmap(bitmap);
            } catch (Exception e) {
                Toast.makeText(this, "Falha ao carregar a imagem",
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

/*
    public interface OnRefreshFormOK {
        public void refresh();
    }*/

}