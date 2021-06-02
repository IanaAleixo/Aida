package com.ifba.tcc_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class TelaPerfilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_perfil);
    }

    public void editarPerfil(View view){
        Intent intent = new Intent(this, EditarPerfilActivity.class);
        startActivity(intent);
    }

    public void verConfiguracao(View view){
        Intent intent = new Intent(this, ConfiguracaoActivity.class);
        startActivity(intent);
    }

    public void verRelatorios(View view){
        Intent intent = new Intent(this, TelaRelatoriosActivity.class);
        startActivity(intent);
    }

    public void fazerLogoff(View view){
        Intent intent = new Intent(this, LogoffActivity.class);
        startActivity(intent);
    }
}
