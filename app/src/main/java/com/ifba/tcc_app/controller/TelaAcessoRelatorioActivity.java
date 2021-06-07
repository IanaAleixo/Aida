package com.ifba.tcc_app.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.ifba.tcc_app.R;

public class TelaAcessoRelatorioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acticity_tela_acesso_relatorios);
    }

    public void acessoRelatorioGrafico(View view){
        Intent intent = new Intent(this, TelaRelatorioGraficoActivity.class);
        startActivity(intent);
    }

    public void acessoRelatorioCalendario(View view){
        Intent intent = new Intent(this, TelaRelatorioCalendarioActivity.class);
        startActivity(intent);
    }
}
