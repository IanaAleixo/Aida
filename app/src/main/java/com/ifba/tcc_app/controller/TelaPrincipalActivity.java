package com.ifba.tcc_app.controller;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.ifba.tcc_app.GiphyHttpConexao;
import com.ifba.tcc_app.ParserJsonGif;
import com.ifba.tcc_app.R;
import com.ifba.tcc_app.model.Gif;
import com.ifba.tcc_app.model.Usuario;

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
    public TextView nomeUsuario;
    public String palavraChave;
    private UsuarioDAO dao;
    public SimpleDraweeView gifImageTriste;
    public SimpleDraweeView gifImageFeliz;
    public SimpleDraweeView gifImageAlegre;
    public SimpleDraweeView gifImageAmor;
    public SimpleDraweeView gifImageEsperanca;
    public SimpleDraweeView gifImageMedo;
    public SimpleDraweeView gifImageSolidao;
    public SimpleDraweeView gifImageSono;
    public SimpleDraweeView gifImageRaiva;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_tela_principal);

        gifImageTriste = (SimpleDraweeView) findViewById(R.id.triste);
        gifImageTriste.setController(
                Fresco.newDraweeControllerBuilder()
                        .setUri("https://media.giphy.com/media/i0lZAPw40F212/giphy.gif")
                        .setAutoPlayAnimations(true)
                        .build());

        gifImageAlegre = (SimpleDraweeView) findViewById(R.id.alegre);
        gifImageAlegre.setController(
                Fresco.newDraweeControllerBuilder()
                        .setUri("https://media.giphy.com/media/F6PFPjc3K0CPe/giphy.gif")
                        .setAutoPlayAnimations(true)
                        .build());

        gifImageFeliz = (SimpleDraweeView) findViewById(R.id.feliz);
        gifImageFeliz.setController(
                Fresco.newDraweeControllerBuilder()
                        .setUri("https://media.giphy.com/media/DhstvI3zZ598Nb1rFf/giphy.gif")
                        .setAutoPlayAnimations(true)
                        .build());

        gifImageMedo = (SimpleDraweeView) findViewById(R.id.medo);
        gifImageMedo.setController(
                Fresco.newDraweeControllerBuilder()
                        .setUri("https://media.giphy.com/media/bEVKYB487Lqxy/giphy.gif")
                        .setAutoPlayAnimations(true)
                        .build());

        gifImageSolidao = (SimpleDraweeView) findViewById(R.id.solidao);
        gifImageSolidao.setController(
                Fresco.newDraweeControllerBuilder()
                        .setUri("https://media.giphy.com/media/W0c3xcZ3F1d0EYYb0f/giphy.gif")
                        .setAutoPlayAnimations(true)
                        .build());

        gifImageSono = (SimpleDraweeView) findViewById(R.id.sono);
        gifImageSono.setController(
                Fresco.newDraweeControllerBuilder()
                        .setUri("https://media.giphy.com/media/l378AEZceMwWboAQE/giphy.gif")
                        .setAutoPlayAnimations(true)
                        .build());

        gifImageAmor = (SimpleDraweeView) findViewById(R.id.amor);
        gifImageAmor.setController(
                Fresco.newDraweeControllerBuilder()
                        .setUri("https://media.giphy.com/media/26FLdmIp6wJr91JAI/giphy.gif")
                        .setAutoPlayAnimations(true)
                        .build());

        gifImageEsperanca = (SimpleDraweeView) findViewById(R.id.esperanca);
        gifImageEsperanca.setController(
                Fresco.newDraweeControllerBuilder()
                        .setUri("https://media.giphy.com/media/JULfVYQH3XkCxMV0QP/giphy.gif")
                        .setAutoPlayAnimations(true)
                        .build());

        gifImageRaiva = (SimpleDraweeView) findViewById(R.id.raiva);
        gifImageRaiva.setController(
                Fresco.newDraweeControllerBuilder()
                        .setUri("https://media.giphy.com/media/11tTNkNy1SdXGg/giphy.gif")
                        .setAutoPlayAnimations(true)
                        .build());


        nomeUsuario = findViewById(R.id.nomeUsuarioLabel);
        Usuario usuario = getIntent().getParcelableExtra("usuario");
        String nome = usuario.getNome();
        nomeUsuario.setText(nome);

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
