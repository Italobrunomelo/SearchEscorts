package com.mobileprogramming.luxurygirl;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.renderscript.Type;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.mobileprogramming.luxurygirl.adapter.PageFragmentAdaper;
import com.mobileprogramming.luxurygirl.fragments.PageFragment;
import com.mobileprogramming.luxurygirl.model.Motel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

/**
 * Created by italo on 24/05/2017.
 */

public class ActivityGirlsList extends AppCompatActivity {

    private PageFragmentAdaper mPageFragmentAdaper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_girls_list);

        //setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        ViewPager mViewPager = (ViewPager) findViewById(R.id.pager);
        String[] titles = {"Girls", "Motels"};
        mPageFragmentAdaper = new PageFragmentAdaper(getSupportFragmentManager(), titles);
        mViewPager.setAdapter(mPageFragmentAdaper);

        new AsyncTask<Void, Void, List<Motel>>() {

            public ProgressDialog dialog;

            @Override
            protected void onPreExecute() {
                dialog = ProgressDialog.show(ActivityGirlsList.this, "Aguarde...", "listando pokemons.", true, true);
            }

            @Override
            protected List<Motel> doInBackground(Void... params) {
                //Uma requisição a API Pokemon
                List<Motel> mMotel = null;

                try {
                    URL url = new URL("https://www.dropbox.com/home/PGM/moteis.json");
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                    connection.connect();

                    Scanner scanner = new Scanner(connection.getInputStream());
                    String json = scanner.next();

                    Gson gson = new Gson();
                    JSONObject jsonObject = new JSONObject(json);
                    JSONArray jsonArray = jsonObject.getJSONArray("results");

                    Type type = new TypeToken<List<Motel>>() {
                    }.getType();
                    mMotel = gson.fromJson(jsonArray.toString(), type);


                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return mMotel;
            }

            @Override
            protected void onPostExecute(List<Motel> mMoteis) {
                dialog.dismiss();

                PageFragment fragment1 = (PageFragment) mPageFragmentAdaper.getItem(0);
                PageFragment fragment2 = (PageFragment) mPageFragmentAdaper.getItem(1);
                fragment1.mMotel = mMoteis.subList(0, 10);
                fragment2.mMotel = mMoteis.subList(11, 20);

                mPageFragmentAdaper.notifyDataSetChanged();

                fragment1.arrayAdapter.notifyDataSetChanged();
                fragment2.arrayAdapter.notifyDataSetChanged();

            }
        }.execute();




        /*new AsyncTask<Void, Void, List<Motel>>() {

            public ProgressDialog dialog;

            @Override
            protected void onPreExecute() {
                dialog = ProgressDialog.show(ViewpagerActivity.this, "Aguarde...", "listando pokemons.", true, true);
            }

            @Override
            protected List<Motel> doInBackground(Void... params) {
                //Uma requisição a API Pokemon
                List<Motel> mMotel = null;

                try {
                    URL url = new URL("http://pokeapi.co/api/v2/pokemon");
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                    connection.connect();

                    Scanner scanner = new Scanner(connection.getInputStream());
                    String json = scanner.next();

                    Gson gson = new Gson();
                    JSONObject jsonObject = new JSONObject(json);
                    JSONArray jsonArray = jsonObject.getJSONArray("results");

                    Type type = new TypeToken<List<Motel>>() {
                    }.getType();
                    mMotel = gson.fromJson(jsonArray.toString(), type);


                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return mMotel;
            }

            @Override
            protected void onPostExecute(List<Motel> mMoteis) {
                dialog.dismiss();

                PageFragment fragment1 = (PageFragment) mPageFragmentAdaper.getItem(0);
                PageFragment fragment2 = (PageFragment) mPageFragmentAdaper.getItem(1);
                fragment1.pokemons = mMoteis.subList(0, 10);
                fragment2.pokemons = mMoteis.subList(11, 20);

                mPageFragmentAdaper.notifyDataSetChanged();

                fragment1.arrayAdapter.notifyDataSetChanged();
                fragment2.arrayAdapter.notifyDataSetChanged();

            }
        }.execute();*/
    }

}
