package com.ifba.tcc_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);
    }

    public void efetuarLogin(View view){
        Intent intent = new Intent(this, TelaPrincipalActivity.class);
        startActivity(intent);
    }

    public void esqueceuSenha(View view){
        Intent intent = new Intent(this, TelaEsqueceuSenhaActivity.class);
        startActivity(intent);
    }

}
