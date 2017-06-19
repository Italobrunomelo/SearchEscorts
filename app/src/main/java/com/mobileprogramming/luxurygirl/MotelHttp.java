package com.mobileprogramming.luxurygirl;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mobileprogramming.luxurygirl.model.Motel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by italo on 12/06/2017.
 */

public class MotelHttp {

    public static final String MOTEIS_URL_JSON = "http://10.0.2.2/moteis.json";
    public static final int SEGUNDOS = 1000;

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
        List<Motel> moteis = null;
        try{
            URL url = new URL(MOTEIS_URL_JSON);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();;
            connection.setReadTimeout(10 * SEGUNDOS);
            connection.setConnectTimeout(15 * SEGUNDOS);
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.setDoOutput(false);
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

        return moteis;



            /*HttpURLConnection conexao = connectar(MOTEIS_URL_JSON);

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

        return null;*/
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
