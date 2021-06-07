package com.ifba.tcc_app;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GiphyHttpConexao extends AppCompatActivity {

    private static String BASE_URL = "api.giphy.com/v1/gifs/search";
    private static String apiKey = "NeX14IxYNVOuTILPiKRnSZ38wzOYr0Wu";

    public String getDadosGif(String palavraChave) {
        HttpURLConnection conexao = null ;
        InputStream is = null;

        try {
            conexao = (HttpURLConnection) ( new URL(BASE_URL+"api_key="+apiKey+"&q="+palavraChave)).openConnection();
            conexao.setRequestMethod("GET");
            conexao.setDoInput(true);
            conexao.setDoOutput(true);
            conexao.connect();

            // Let's read the response
            StringBuffer buffer = new StringBuffer();
            is = conexao.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String linha = null;
            while (  (linha = br.readLine()) != null )
                buffer.append(linha + "\r\n");

            is.close();
            conexao.disconnect();
            return buffer.toString();
        }
        catch(Throwable t) {
            t.printStackTrace();
        }
        finally {
            try { is.close(); } catch(Throwable t) {}
            try { conexao.disconnect(); } catch(Throwable t) {}
        }

        return null;

    }

}
