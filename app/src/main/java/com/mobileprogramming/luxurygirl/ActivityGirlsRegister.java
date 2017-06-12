package com.mobileprogramming.luxurygirl;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ActivityGirlsRegister extends AppCompatActivity {

    //private static final int PERMISSAO_REQUEST = 2;
    public static Context contextOfApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_girls_register);

        contextOfApplication = getApplicationContext();

        /*
        //PERMISSÃO PARA O APP ACESSE A GALERIA
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, PERMISSAO_REQUEST);
            }
        }*/

    }

    /*
    //CONDIÇÃO DA PERMISSÃO DO APP ACESSAR A GALERIA
    public void onRequestPermissionResult(int requestCode, String permission[], int[] grantResults) {
        if (requestCode == PERMISSAO_REQUEST) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            } else {
            }
            return;
        }
    }*/

    public static Context getContextOfApplication()
    {
        return contextOfApplication;
    }

}
