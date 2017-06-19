package com.mobileprogramming.luxurygirl.fragments;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.mobileprogramming.luxurygirl.MotelHttp;
import com.mobileprogramming.luxurygirl.R;
import com.mobileprogramming.luxurygirl.model.Motel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by italo on 12/06/2017.
 */

public class FragmentMoteisList extends Fragment {
    MoteisTask mTask;
    List<Motel> mMoteis;
    ListView mListView;
    TextView mTextMensagem;
    ProgressBar mProgressBar;
    ArrayAdapter<Motel> mAdapter;
    ProgressDialog dialog;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View layout = inflater.inflate(R.layout.fragment_moteis_list,null);
        mTextMensagem = (TextView)layout.findViewById(R.id.empty);
        mProgressBar = (ProgressBar)layout.findViewById(R.id.progressBar);
        mListView = (ListView)layout.findViewById(R.id.listMoteis);
        mListView.setEmptyView(mTextMensagem);

        return layout;
    }

    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        if(mMoteis == null){
            mMoteis = new ArrayList<Motel>();
        }

        mAdapter = new ArrayAdapter<Motel>(getActivity(),android.R.layout.simple_list_item_1, mMoteis);
        mListView.setAdapter(mAdapter);

        if(mTask == null){
            if(MotelHttp.temConexao(getActivity())){
                iniciarDownload();
            }else {
                mTextMensagem.setText(R.string.no_connection);
            }
        }else if (mTask.getStatus() == AsyncTask.Status.RUNNING){
            exibirProgress(true);
        }
    }

    public void exibirProgress(boolean exibir){
        if(exibir){
            dialog = ProgressDialog.show(getActivity(), "Aguarde...", "listando moteis", true, true);
        }

        mProgressBar.setVisibility(exibir ? View.VISIBLE : View.GONE);
    }

    public void iniciarDownload(){
        if (mTask == null || mTask.getStatus() != AsyncTask.Status.RUNNING){
            mTask = new MoteisTask();
            mTask.execute();
        }
    }

    class MoteisTask extends AsyncTask<Void, Void, List<Motel>>{

        @Override
        protected void onPreExecute(){
            super.onPreExecute();

            //dialog = ProgressDialog.show(getActivity(), "Aguarde...", "listando moteis", true, true);

            exibirProgress(true);

            /*if(true){
                mTextMensagem.setText(R.string.downloading_motel_information);
            }

            mTextMensagem.setVisibility(true ? View.VISIBLE : View.GONE);
            mProgressBar.setVisibility(true ? View.VISIBLE : View.GONE);*/
        }

        @Override
        protected List<Motel> doInBackground(Void... params){
            return MotelHttp.carregarMotelJson();



            //Uma requisição a API Pokemon
            /*List<Motel> moteis = null;

            try {
                URL url = new URL("http://10.0.2.2/moteis.json");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                connection.connect();

                Scanner scanner = new Scanner(connection.getInputStream());
                String json = scanner.next();

                Gson gson = new Gson();
                JSONObject jsonObject = new JSONObject(json);
                JSONArray jsonArray = jsonObject.getJSONArray("results");

                Type type = new TypeToken<List<Motel>>(){}.getType();
                moteis = gson.fromJson(jsonArray.toString(),type);



            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return moteis*/
        }

        @Override
        protected void onPostExecute(List<Motel> moteis){
            super.onPostExecute(moteis);
            exibirProgress(false);

            if(moteis != null){
                mMoteis.clear();
                mMoteis.addAll(moteis);
                mAdapter.notifyDataSetChanged();
            }else {
                mTextMensagem.setText(R.string.failed_to_get_motels);
            }
        }
    }
}
