package com.mobileprogramming.luxurygirl;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.mobileprogramming.luxurygirl.model.Motel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by italo on 12/06/2017.
 */

public class MotelHttp {

    public static final String MOTEIS_URL_JSON = "http://localhost:8080/C:/Users/italo/Desktop/moteis.json";

    private static HttpURLConnection connectar(String urlArquivo) throws IOException{
        final int SEGUNDOS = 1000;
        URL url = new URL(urlArquivo);
        HttpURLConnection mConexao = (HttpURLConnection)url.openConnection();
        mConexao.setReadTimeout(10 * SEGUNDOS);
        mConexao.setConnectTimeout(15 * SEGUNDOS);
        mConexao.setRequestMethod("GET");
        mConexao.setDoInput(true);
        mConexao.setDoOutput(false);
        mConexao.connect();

        return mConexao;
    }

    public static boolean temConexao(Context ctx){
        ConnectivityManager cm = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();

        return (info != null && info.isConnected());
    }

    public static List<Motel> carregarMotelJson(){
        try{
            HttpURLConnection conexao = connectar(MOTEIS_URL_JSON);

            int resposta = conexao.getResponseCode();
            if(resposta == HttpURLConnection.HTTP_OK){
                InputStream is = conexao.getInputStream();
                JSONObject json = new JSONObject(bytesParaString(is));

                return LerJsonMotel(json);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static List<Motel> LerJsonMotel(JSONObject json) throws JSONException{
        List<Motel> listaDeMoteis = new ArrayList<Motel>();

        JSONArray jsonMoteis = json.getJSONArray("Moteis");
        for (int i = 0;i < jsonMoteis.length(); i++){
            JSONObject jsonMotel = jsonMoteis.getJSONObject(i);

            Motel mMotel = new Motel(jsonMotel.getString("Name"),jsonMotel.getString("Address"));

            listaDeMoteis.add(mMotel);
        }

        return listaDeMoteis;
    }

    private static String bytesParaString(InputStream is) throws IOException{
        byte[] buffer = new byte[1024];

        //BUFFER QUE VAI ARMAZENAR TODOS OS BYTES LIDOS
        ByteArrayOutputStream bufferzao = new ByteArrayOutputStream();

        //VARIAVÉL PRA SABER QUANTOS BYTES FORAM LIDOS
        int bytesLidos;

        //LENDO 1KB POR VEZ
        while ((bytesLidos = is.read(buffer)) != -1){

            //QUANTIDADE DE BYTES LIDOS DO BUFFER PARA O BUFFERZAO
            bufferzao.write(buffer, 0, bytesLidos);
        }

        return new String(bufferzao.toByteArray(), "UTF-8");
    }
}
