package com.ifba.tcc_app.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.ifba.tcc_app.R;
import com.ifba.tcc_app.model.Usuario;

public class TelaAcessoRelatorioActivity extends AppCompatActivity {
    private Button btnRelatorioGrafico;
    private Button btnRelatorioCalendario;
    private ImageButton btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acticity_tela_acesso_relatorios);

        btnRelatorioCalendario = findViewById(R.id.btnRelatorioCalendario);
        btnRelatorioCalendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuario usuario = getIntent().getParcelableExtra("usuario");
                Intent intent = new Intent(TelaAcessoRelatorioActivity.this, TelaRelatorioCalendarioActivity.class);
                intent.putExtra("usuario", usuario);
                startActivity(intent);
            }
        });

        btnRelatorioGrafico = findViewById(R.id.btnRelatorioGrafico);
        btnRelatorioGrafico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuario usuario = getIntent().getParcelableExtra("usuario");
                Intent intent = new Intent(TelaAcessoRelatorioActivity.this, TelaRelatorioGraficoActivity.class);
                intent.putExtra("usuario", usuario);
                startActivity(intent);
            }
        });

        btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuario usuario = getIntent().getParcelableExtra("usuario");
                Intent intent = new Intent(TelaAcessoRelatorioActivity.this, TelaPerfilActivity.class);
                intent.putExtra("usuario", usuario);
                startActivity(intent);
            }
        });
    }

}
