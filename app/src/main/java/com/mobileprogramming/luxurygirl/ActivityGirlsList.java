package com.mobileprogramming.luxurygirl;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.mobileprogramming.luxurygirl.fragments.FragmentGrilsList;

/**
 * Created by italo on 24/05/2017.
 */

public class ActivityGirlsList extends AppCompatActivity {

    PageFragmentAdaper mPageFragmentAdaper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_girls_list);

        //setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        ViewPager mViewPager = (ViewPager) findViewById(R.id.pager);
        String[] titles = {"Girls", "Motels"};
        mPageFragmentAdaper = new PageFragmentAdaper(getSupportFragmentManager(), titles);
        mViewPager.setAdapter(mPageFragmentAdaper);

        /*new AsyncTask<Void, Void, List<Pokemon>>() {

            public ProgressDialog dialog;

            @Override
            protected void onPreExecute() {
                dialog = ProgressDialog.show(ViewpagerActivity.this, "Aguarde...", "listando pokemons.", true, true);
            }

            @Override
            protected List<Pokemon> doInBackground(Void... params) {
                //Uma requisição a API Pokemon
                List<Pokemon> pokemons = null;

                try {
                    URL url = new URL("http://pokeapi.co/api/v2/pokemon");
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                    connection.connect();

                    Scanner scanner = new Scanner(connection.getInputStream());
                    String json = scanner.next();

                    Gson gson = new Gson();
                    JSONObject jsonObject = new JSONObject(json);
                    JSONArray jsonArray = jsonObject.getJSONArray("results");

                    Type type = new TypeToken<List<Pokemon>>() {
                    }.getType();
                    pokemons = gson.fromJson(jsonArray.toString(), type);


                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return pokemons;
            }

            @Override
            protected void onPostExecute(List<Pokemon> pokemons) {
                dialog.dismiss();

                PageFragment fragment1 = (PageFragment) mAdaper.getItem(0);
                PageFragment fragment2 = (PageFragment) mAdaper.getItem(1);
                fragment1.pokemons = pokemons.subList(0, 10);
                fragment2.pokemons = pokemons.subList(11, 20);

                mAdaper.notifyDataSetChanged();

                fragment1.arrayAdapter.notifyDataSetChanged();
                fragment2.arrayAdapter.notifyDataSetChanged();

            }
        }.execute();*/
    }

}
