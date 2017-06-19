package com.mobileprogramming.luxurygirl;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mobileprogramming.luxurygirl.adapter.AbasPageAdaper;
import com.mobileprogramming.luxurygirl.fragments.FragmentMoteisList;
import com.mobileprogramming.luxurygirl.model.Motel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

/**
 * Created by italo on 14/06/2017.
 */

public class ActivityMoteisList extends AppCompatActivity {

    FragmentMoteisList mFragmentMoteisList;

    public void onCreate(Bundle savedInstanceSate) {
        super.onCreate(savedInstanceSate);
        mFragmentMoteisList = (FragmentMoteisList) getSupportFragmentManager().findFragmentById(R.id.fragment_moteis_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        new AsyncTask<Void, Void, List<Motel>>() {

            public ProgressDialog dialog;

            @Override
            protected void onPreExecute() {
                dialog = ProgressDialog.show(ActivityMoteisList.this, "Aguarde...", "listando moteis.", true, true);
            }

            @Override
            protected List<Motel> doInBackground(Void... params) {
                List<Motel> motel = null;

                try {
                    URL url = new URL("http://10.0.2.2/moteis.json");
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                    connection.connect();

                    Scanner scanner = new Scanner(connection.getInputStream());
                    String json = scanner.next();

                    Gson gson = new Gson();
                    JSONObject jsonObject = new JSONObject(json);
                    JSONArray jsonArray = jsonObject.getJSONArray("results");

                    Type type = new TypeToken<List<Motel>>() {
                    }.getType();
                    motel = gson.fromJson(jsonArray.toString(), type);


                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return motel;
            }

            @Override
            protected void onPostExecute(List<Motel> moteis) {
                dialog.dismiss();

            }
        }.execute();
    }
}

