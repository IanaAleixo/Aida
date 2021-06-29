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
import com.ifba.tcc_app.model.Categoria;
import com.ifba.tcc_app.model.Gif;
import com.ifba.tcc_app.model.Status;
import com.ifba.tcc_app.model.Usuario;

import org.json.JSONException;


import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class TelaPrincipalActivity extends AppCompatActivity {
    private TextView nomeUsuario;
    private ImageButton btnVerPerfil;
    private Button btnContatoCVV;
    private UsuarioDAO dao;
    private StatusDAO daoStatus;
    private CategoriaDAO daoCategoria;
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

        daoStatus = new StatusDAO(this);

        nomeUsuario = findViewById(R.id.nomeUsuarioLabel);
        Usuario usuario = getIntent().getParcelableExtra("usuario");
        String nome = usuario.getNome();
        nomeUsuario.setText(nome);


        gifImageFeliz = (SimpleDraweeView) findViewById(R.id.feliz);
        gifImageFeliz.setController(
                Fresco.newDraweeControllerBuilder()
                        .setUri("https://media.giphy.com/media/DhstvI3zZ598Nb1rFf/giphy.gif")
                        .setAutoPlayAnimations(true)
                        .build());


        gifImageFeliz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date data = new Date();
                String dataString = data.toString();

                Categoria categoria = new Categoria(2);

                Status status = new Status();
                status.setSentimento("felicidade");
                status.setData(dataString);
                status.setCategoria(categoria);

                long id = daoStatus.insert(status);

                Toast.makeText(getApplicationContext(), "Status inserido com sucesso! " + id, Toast.LENGTH_SHORT).show();
            }
        });

        gifImageAlegre = (SimpleDraweeView) findViewById(R.id.alegre);
        gifImageAlegre.setController(
                Fresco.newDraweeControllerBuilder()
                        .setUri("https://media.giphy.com/media/F6PFPjc3K0CPe/giphy.gif")
                        .setAutoPlayAnimations(true)
                        .build());

        gifImageAlegre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date data = new Date();
                String dataString = data.toString();

                Categoria categoria = new Categoria(2);

                Status status = new Status();
                status.setSentimento("alegria");
                status.setData(dataString);
                status.setCategoria(categoria);

                long id = daoStatus.insert(status);

                Toast.makeText(getApplicationContext(), "Status inserido com sucesso! " + id, Toast.LENGTH_SHORT).show();
            }
        });


        gifImageAmor = (SimpleDraweeView) findViewById(R.id.amor);
        gifImageAmor.setController(
                Fresco.newDraweeControllerBuilder()
                        .setUri("https://media.giphy.com/media/26FLdmIp6wJr91JAI/giphy.gif")
                        .setAutoPlayAnimations(true)
                        .build());

        gifImageAmor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date data = new Date();
                String dataString = data.toString();

                Categoria categoria = new Categoria(2);

                Status status = new Status();
                status.setSentimento("amor");
                status.setData(dataString);
                status.setCategoria(categoria);

                long id = daoStatus.insert(status);

                Toast.makeText(getApplicationContext(), "Status inserido com sucesso! " + id, Toast.LENGTH_SHORT).show();
            }
        });

        gifImageEsperanca = (SimpleDraweeView) findViewById(R.id.esperanca);
        gifImageEsperanca.setController(
                Fresco.newDraweeControllerBuilder()
                        .setUri("https://media.giphy.com/media/JULfVYQH3XkCxMV0QP/giphy.gif")
                        .setAutoPlayAnimations(true)
                        .build());

        gifImageEsperanca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date data = new Date();
                String dataString = data.toString();

                Categoria categoria = new Categoria(2);

                Status status = new Status();
                status.setSentimento("esperança");
                status.setData(dataString);
                status.setCategoria(categoria);

                long id = daoStatus.insert(status);

                Toast.makeText(getApplicationContext(), "Status inserido com sucesso! " + id, Toast.LENGTH_SHORT).show();
            }
        });

        gifImageTriste = (SimpleDraweeView) findViewById(R.id.triste);
        gifImageTriste.setController(
                Fresco.newDraweeControllerBuilder()
                        .setUri("https://media.giphy.com/media/i0lZAPw40F212/giphy.gif")
                        .setAutoPlayAnimations(true)
                        .build());

        gifImageTriste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date data = new Date();
                String dataString = data.toString();

                Categoria categoria = new Categoria(1);

                Status status = new Status();
                status.setSentimento("tristeza");
                status.setData(dataString);
                status.setCategoria(categoria);

                long id = daoStatus.insert(status);

                Toast.makeText(getApplicationContext(), "Status inserido com sucesso! " + id, Toast.LENGTH_SHORT).show();;
            }
        });

        gifImageMedo = (SimpleDraweeView) findViewById(R.id.medo);
        gifImageMedo.setController(
                Fresco.newDraweeControllerBuilder()
                        .setUri("https://media.giphy.com/media/bEVKYB487Lqxy/giphy.gif")
                        .setAutoPlayAnimations(true)
                        .build());

        gifImageMedo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date data = new Date();
                String dataString = data.toString();

                Categoria categoria = new Categoria(1);

                Status status = new Status();
                status.setSentimento("medo");
                status.setData(dataString);
                status.setCategoria(categoria);

                long id = daoStatus.insert(status);

                Toast.makeText(getApplicationContext(), "Status inserido com sucesso! " + id, Toast.LENGTH_SHORT).show();
            }
        });

        gifImageSolidao = (SimpleDraweeView) findViewById(R.id.solidao);
        gifImageSolidao.setController(
                Fresco.newDraweeControllerBuilder()
                        .setUri("https://media.giphy.com/media/W0c3xcZ3F1d0EYYb0f/giphy.gif")
                        .setAutoPlayAnimations(true)
                        .build());

        gifImageSolidao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date data = new Date();
                String dataString = data.toString();

                Categoria categoria = new Categoria(1);

                Status status = new Status();
                status.setSentimento("solidão");
                status.setData(dataString);
                status.setCategoria(categoria);

                long id = daoStatus.insert(status);

                Toast.makeText(getApplicationContext(), "Status inserido com sucesso! " + id, Toast.LENGTH_SHORT).show();
            }
        });

        gifImageSono = (SimpleDraweeView) findViewById(R.id.sono);
        gifImageSono.setController(
                Fresco.newDraweeControllerBuilder()
                        .setUri("https://media.giphy.com/media/l378AEZceMwWboAQE/giphy.gif")
                        .setAutoPlayAnimations(true)
                        .build());

        gifImageSono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date data = new Date();
                String dataString = data.toString();

                Categoria categoria = new Categoria(1);

                Status status = new Status();
                status.setSentimento("sonolencia");
                status.setData(dataString);
                status.setCategoria(categoria);

                long id = daoStatus.insert(status);

                Toast.makeText(getApplicationContext(), "Status inserido com sucesso! " + id, Toast.LENGTH_SHORT).show();
            }
        });

        gifImageRaiva = (SimpleDraweeView) findViewById(R.id.raiva);
        gifImageRaiva.setController(
                Fresco.newDraweeControllerBuilder()
                        .setUri("https://media.giphy.com/media/11tTNkNy1SdXGg/giphy.gif")
                        .setAutoPlayAnimations(true)
                        .build());

        gifImageRaiva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date data = new Date();
                String dataString = data.toString();

                Categoria categoria = new Categoria(1);

                Status status = new Status();
                status.setSentimento("raiva");
                status.setData(dataString);
                status.setCategoria(categoria);

                long id = daoStatus.insert(status);

                Toast.makeText(getApplicationContext(), "Status inserido com sucesso! " + id, Toast.LENGTH_SHORT).show();
            }
        });

        btnVerPerfil = findViewById(R.id.btnVerPerfil);
        btnVerPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuario usuario = getIntent().getParcelableExtra("usuario");
                Intent intent = new Intent(TelaPrincipalActivity.this, TelaPerfilActivity.class);
                intent.putExtra("usuario", usuario);
                startActivity(intent);
            }
        });

        btnContatoCVV = findViewById(R.id.btnContatoCVV);
        btnContatoCVV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaPrincipalActivity.this, ContatoCVVActivity.class);
                Usuario usuario = getIntent().getParcelableExtra("usuario");
                intent.putExtra("usuario", usuario);
                startActivity(intent);
            }
        });

    }


}
