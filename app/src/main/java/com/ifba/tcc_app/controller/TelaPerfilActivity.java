package com.ifba.tcc_app.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ifba.tcc_app.R;
import com.ifba.tcc_app.model.Usuario;

public class TelaPerfilActivity extends AppCompatActivity {
    private Button btnEditarPerfil;
    private Button btnVerConfiguracao;
    private Button btnVerRelatorios;
    private Button btnFazerLogoff;
    private ImageButton btnVoltar;
    private TextView nomeUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_perfil);

        nomeUsuario = findViewById(R.id.nomeUsuario);
        Usuario usuario = getIntent().getParcelableExtra("usuario");
        String nome = usuario.getNome();
        nomeUsuario.setText(nome);

        btnEditarPerfil = findViewById(R.id.btnEditarPerfil);
        btnEditarPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaPerfilActivity.this, EditarPerfilActivity.class);
                intent.putExtra("usuario", usuario);
                startActivity(intent);
            }
        });

        btnVerConfiguracao = findViewById(R.id.btnConfiguracao);
        btnVerConfiguracao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaPerfilActivity.this, ConfiguracaoPart1Activity.class);
                intent.putExtra("usuario", usuario);
                startActivity(intent);
            }
        });

        btnVerRelatorios = findViewById(R.id.btnVerRelatorios);
        btnVerRelatorios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaPerfilActivity.this, TelaAcessoRelatorioActivity.class);
                intent.putExtra("usuario", usuario);
                startActivity(intent);
            }
        });

        btnFazerLogoff = findViewById(R.id.btnSair);
        btnFazerLogoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaPerfilActivity.this, LogoffActivity.class);
                startActivity(intent);
            }
        });

        btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuario usuario = getIntent().getParcelableExtra("usuario");
                Intent intent = new Intent(TelaPerfilActivity.this, TelaPrincipalActivity.class);
                intent.putExtra("usuario", usuario);
                startActivity(intent);
            }
        });

    }

}
