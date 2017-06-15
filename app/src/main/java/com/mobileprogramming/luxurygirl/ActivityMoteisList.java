package com.mobileprogramming.luxurygirl;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.mobileprogramming.luxurygirl.fragments.FragmentMoteisList;
import com.mobileprogramming.luxurygirl.model.Motel;

import java.util.List;

/**
 * Created by italo on 14/06/2017.
 */

public class ActivityMoteisList extends AppCompatActivity {

    FragmentMoteisList mFragmentMoteisList;

    private PageAdaper mPageAdaper;

    public void onCreate (Bundle savedInstanceSate){
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
                //Uma requisição a API Pokemon
                List<Motel> motel = null;

                /*try {
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
                    motel = gson.fromJson(jsonArray.toString(), type);


                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }*/

                return motel;
            }

            @Override
            protected void onPostExecute(List<Motel> moteis) {
                dialog.dismiss();

                FragmentPageView fragment1 = (FragmentPageView) mPageAdaper.getItem(0);
                FragmentPageView fragment2 = (FragmentPageView) mPageAdaper.getItem(1);
                fragment1.mMotel = moteis.subList(0, 10);
                fragment2.mMotel = moteis.subList(11, 20);

                mPageAdaper.notifyDataSetChanged();

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

                FragmentPageView fragment1 = (FragmentPageView) mPageAdaper.getItem(0);
                FragmentPageView fragment2 = (FragmentPageView) mPageAdaper.getItem(1);
                fragment1.pokemons = mMoteis.subList(0, 10);
                fragment2.pokemons = mMoteis.subList(11, 20);

                mPageAdaper.notifyDataSetChanged();

                fragment1.arrayAdapter.notifyDataSetChanged();
                fragment2.arrayAdapter.notifyDataSetChanged();

            }
        }.execute();*/
    }
}
