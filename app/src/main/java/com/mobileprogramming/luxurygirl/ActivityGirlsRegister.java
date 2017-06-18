package com.mobileprogramming.luxurygirl;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Serializable;

public class ActivityGirlsRegister extends AppCompatActivity {

    private GirlsDAO mGirlDAO;
    private Girls mGirls;

    EditText mEditTextEmail, mEditTextName, mEditTextInformation, mEditTextPhone, mEditTextAge;
    Switch mSwitchStatus;
    Button mButtonSaveGirl,buttonAlterGirl;
    TextView mTextViewUploadPhoto;
    private ImageView mImageViewPhoto;
    private Bitmap mImagemGaleria;

    private final int SELECT_PICTURE = 1;
    private final int PERMISSAO_REQUEST = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_girls_register);

        Intent intent = getIntent();

        //PERMISSÃO PARA O APP ACESSAR AS FOTOS
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, PERMISSAO_REQUEST);
            }
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mGirlDAO = new GirlsDAO(this);
        mGirls = new Girls();

        mEditTextEmail = (EditText) findViewById(R.id.editTextEmail);
        mEditTextName = (EditText) findViewById(R.id.editTextName);
        mEditTextInformation = (EditText) findViewById(R.id.editTextInformation);
        mEditTextPhone = (EditText) findViewById(R.id.editTextPhone);
        mEditTextAge = (EditText) findViewById(R.id.editTextAge);
        mSwitchStatus = (Switch) findViewById(R.id.switchStatus);
        mImageViewPhoto = (ImageView) findViewById(R.id.imageViewPhoto);
        buttonAlterGirl = (Button) findViewById(R.id.buttonAlterGirl);
        mButtonSaveGirl = (Button) findViewById(R.id.buttonSaveGirl);
        mTextViewUploadPhoto = (TextView) findViewById(R.id.textViewUploadPhoto);

        mTextViewUploadPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, SELECT_PICTURE);
            }
        });

        buttonAlterGirl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mEditTextEmail == null){
                    Toast.makeText(getBaseContext(), "Favor inserir email", Toast.LENGTH_LONG).show();
                }else {
                    mGirls = mGirlDAO.getGirl(mEditTextEmail.toString());

                    mEditTextName.setText(mGirls.getmName());
                    mEditTextAge.setText(mGirls.getmAge());
                    mEditTextInformation.setText(mGirls.getmInformation());
                    mEditTextPhone.setText(mGirls.getmContact());
                    if(mGirls.getmStatus() == "true"){
                        mSwitchStatus.isChecked();
                    }
                    byte[] outImagem = mGirls.getmImagem();
                    ByteArrayInputStream imageStream = new ByteArrayInputStream(outImagem);
                    Bitmap imageBitmap = BitmapFactory.decodeStream(imageStream);
                    mImageViewPhoto.setImageBitmap(imageBitmap);
                }
            }
        });

        mButtonSaveGirl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGirls.setmEmail(mEditTextEmail.getText().toString());
                mGirls.setmName(mEditTextName.getText().toString());
                mGirls.setmInformation(mEditTextInformation.getText().toString());
                mGirls.setmContact(mEditTextPhone.getText().toString());
                mGirls.setmAge(mEditTextAge.getText().toString());
                if (mSwitchStatus.isChecked()) {
                    mGirls.setmStatus("true");
                } else {
                    mGirls.setmStatus("false");
                }

                //INSERINDO IMAGEM NA BASE
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                mImagemGaleria.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                mGirls.setmImagem(stream.toByteArray());

                Girls verificaGirl = mGirlDAO.getGirl(mGirls.getmEmail());
                if (verificaGirl == null) {
                    mGirlDAO.insert(mGirls);
                    Toast.makeText(getBaseContext(), R.string.mensage_added_girl, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getBaseContext(), R.string.mensage_not_added_girl, Toast.LENGTH_LONG).show();
                }


                //OnRefreshFormOK activity = (OnRefreshFormOK) getActivity();
                //activity.refresh();

                //if (!isLandScape())
                //   getActivity().finish();
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Uri selectedImage = data.getData();
            String[] filePath = {MediaStore.Images.Media.DATA};
            Cursor c = getContentResolver().query(selectedImage, filePath, null, null, null);
            c.moveToFirst();

            int columnIndex = c.getColumnIndex(filePath[0]);
            String picturePath = c.getString(columnIndex);
            c.close();

            mImagemGaleria = (BitmapFactory.decodeFile(picturePath));
            mImageViewPhoto.setImageBitmap(mImagemGaleria);
        }
    }

    //PERMISSÃO OK OU NEGADA
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        if (requestCode == PERMISSAO_REQUEST) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // A permissão foi concedida. Pode continuar
            }
        } else {
            // A permissão foi negada. Precisa ver o que deve ser desabilitado
        }
        return;
    }

}

/*
    public interface OnRefreshFormOK {
        public void refresh();
    }*/

