package com.ifba.tcc_app.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.ifba.tcc_app.R;

public class ConfiguracaoPart2Activity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_configuracao_parte_2);
    }
    public void salvarConf(View view){
        Intent intent = new Intent(this, TelaPrincipalActivity.class);
        startActivity(intent);
    }
}
