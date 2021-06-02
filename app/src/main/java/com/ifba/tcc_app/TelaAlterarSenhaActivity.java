package com.ifba.tcc_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class TelaAlterarSenhaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_alterar_senha);
    }

    public void alterarSenha(View view){
        Intent intent = new Intent(this, TelaPerfilActivity.class);
        startActivity(intent);
    }
}
