package com.ifba.tcc_app.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.ifba.tcc_app.GiphyHttpConexao;
import com.ifba.tcc_app.ParserJsonGif;
import com.ifba.tcc_app.R;
import com.ifba.tcc_app.model.Gif;

import org.json.JSONException;


import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;


public class TelaPrincipalActivity extends AppCompatActivity {
    public String palavraChave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);
    }

    public void verPerfil(View view){
        Intent intent = new Intent(this, TelaPerfilActivity.class);
        startActivity(intent);
    }
    public void contatoCVV(View view){
        Intent intent = new Intent(this, ContatoCVVActivity.class);
        startActivity(intent);
    }

}
