package com.ifba.tcc_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class EditarPerfilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_editar_perfil);
    }

    public void editAlterarSenha(View view){
        Intent intent = new Intent(this, TelaAlterarSenhaActivity.class);
        startActivity(intent);
    }

    public void salvarEditPerfil(View view){
        Intent intent = new Intent(this, TelaPerfilActivity.class);
        startActivity(intent);
    }
}
