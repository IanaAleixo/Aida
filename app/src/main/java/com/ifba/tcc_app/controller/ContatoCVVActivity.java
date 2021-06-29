package com.ifba.tcc_app.controller;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.ifba.tcc_app.R;
import com.ifba.tcc_app.model.Usuario;

import java.net.URI;

public class ContatoCVVActivity extends AppCompatActivity {

    private Button botaoWeb;
    private Button botaoTelefone;
    private ImageButton btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_contato_cvv);

        botaoWeb = (Button) findViewById(R.id.btnContatoCVVSite);
        botaoTelefone = (Button) findViewById(R.id.btnContatoCVVTelefone);

        botaoWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.cvv.org.br/quero-conversar")));
            }
        });

        botaoTelefone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(ContatoCVVActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(ContatoCVVActivity.this, new String[]{Manifest.permission.CALL_PHONE},1);
                    return;
                }
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+188)));
            }
        });

        btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ContatoCVVActivity.this, TelaAcessoRelatorioActivity.class);
                Usuario usuario = getIntent().getParcelableExtra("usuario");
                intent.putExtra("usuario", usuario);
                startActivity(intent);
            }
        });

    }
}
